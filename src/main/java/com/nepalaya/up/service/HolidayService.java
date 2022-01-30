package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;

public interface HolidayService {

    Response scrapHoliday();

    Response getAllHolidays(long bookDetailId);
}
