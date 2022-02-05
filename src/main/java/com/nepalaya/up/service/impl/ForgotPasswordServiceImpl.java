package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.email.dto.EmailDTO;
import com.nepalaya.up.email.service.EmailService;
import com.nepalaya.up.exception.DataNotFoundException;
import com.nepalaya.up.exception.SystemException;
import com.nepalaya.up.model.User;
import com.nepalaya.up.repository.UserRepository;
import com.nepalaya.up.request.ResetPasswordRequest;
import com.nepalaya.up.service.ForgotPasswordService;
import com.nepalaya.up.util.AESEncryption;
import com.nepalaya.up.util.LogUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;


    public ForgotPasswordServiceImpl(UserRepository userRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Response forgotPassword(String email) {

        try {

            Date issueDate = new Date();
            System.out.println("date : " +  issueDate);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String issuedDate= formatter.format(issueDate);

            Date expiryDate = new Date(issueDate.getTime() + 30 * 60 * 1000);

            User user = userRepository
                    .findByEmailAddress(email)
                    .orElseThrow(() -> new DataNotFoundException(String.format("User not found with email %s", email)));

            String token = AESEncryption.encrypt(user.getId() + ":" + issuedDate);
            System.out.println("token : " +  user.getId() + ":" + issueDate);
            user.setResetPasswordTokenExpiry(expiryDate);
            user.setResetToken(token);

            EmailDTO emailDTO = new EmailDTO();
            emailDTO.setTo(user.getEmailAddress());
            emailDTO.setSubject("Password Reset Request");
            emailDTO.setData("To reset your password, click the link below:\n"
                    + "localhost:8080/resetPassword?token=" + token);
            emailService.send(emailDTO);
            return ResponseBuilder.success("Reset token sent successfully!");

        }
        catch (Exception exception) {
            LogUtil.exception("Failed to send reset password email");
            throw new SystemException();
        }


    }

    @Override
    public Response resetPassword(ResetPasswordRequest request) {
        try {
            Date date = new Date();
            User user = userRepository
                    .findByResetToken(request.getToken())
                    .orElseThrow(() -> new DataNotFoundException(String.format("User not found with token %s", request.getToken())));
            if (date.compareTo(user.getResetPasswordTokenExpiry()) < 0 ){

                user.setPassword(passwordEncoder.encode(request.getNewPassword()));
                userRepository.save(user);

                return ResponseBuilder.success("Password saved successfully!");
            }
            else{
                throw new RuntimeException("Session Expired..");
            }
        }
        catch (Exception exception) {
            throw new SystemException();
        }

    }
}
