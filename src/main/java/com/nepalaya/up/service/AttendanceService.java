package com.nepalaya.up.service;

import com.nepalaya.up.dto.Response;
import com.nepalaya.up.request.AttendanceRequest;

public interface AttendanceService {
    Response submitAttendance(AttendanceRequest request);

}