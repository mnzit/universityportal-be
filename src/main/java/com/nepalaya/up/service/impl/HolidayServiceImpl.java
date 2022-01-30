package com.nepalaya.up.service.impl;

import com.nepalaya.up.builder.ResponseBuilder;
import com.nepalaya.up.dto.Response;
import com.nepalaya.up.exception.SystemException;
import com.nepalaya.up.model.Holiday;
import com.nepalaya.up.repository.HolidayRepository;
import com.nepalaya.up.scrapper.HolidayScrapper;
import com.nepalaya.up.service.HolidayService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {

    private HolidayRepository holidayRepository;

    public HolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public Response scrapHoliday() {
        try {
            List<Holiday> holidays = HolidayScrapper.scrapHoliday();
           for(Holiday holiday: holidays){
               holidayRepository.save(holiday);
           }
           return ResponseBuilder.success("holidays scrapped successfully");
        } catch (Exception exception){
            throw new SystemException(exception.getMessage());
        }
    }

    @Override
    public Response getAllHolidays(long bookDetailId) {
        return null;
    }
}
