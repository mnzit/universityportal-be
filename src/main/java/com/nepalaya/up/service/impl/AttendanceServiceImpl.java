package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.AttendanceBuilder;
import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.exception.DataNotFoundException;
import com.nepalaya.up.exception.SystemException;
import com.nepalaya.up.model.Attendance;
import com.nepalaya.up.model.User;
import com.nepalaya.up.model.enums.AttendanceState;
import com.nepalaya.up.repository.AttendanceRepository;
import com.nepalaya.up.repository.UserRepository;
import com.nepalaya.up.request.AttendanceRequest;
import com.nepalaya.up.service.AttendanceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, UserRepository userRepository) {
        this.attendanceRepository = attendanceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Response submitAttendance(AttendanceRequest request) {
        try {
            User user = userRepository.findByEmailAddress(request.getEmailAddress())
                    .orElseThrow(() -> new DataNotFoundException(String.format("User not found with email %s", request.getEmailAddress())));;
            Attendance attendance = AttendanceBuilder.buildAttendance(user, AttendanceState.PRESENT);
            attendanceRepository.save(attendance);
            return ResponseBuilder.success("Attendance submitted successfully!");
        }
        catch(Exception e){
            throw new SystemException();

        }
    }
}
