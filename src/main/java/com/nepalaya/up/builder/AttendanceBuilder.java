package com.nepalaya.up.builder;

import com.nepalaya.up.model.Attendance;
import com.nepalaya.up.model.User;
import com.nepalaya.up.model.enums.AttendanceState;

public class AttendanceBuilder {

    public static Attendance buildAttendance(User user , AttendanceState attendanceState){

        Attendance attendance = new Attendance();
        attendance.setUser(user);
        attendance.setState(attendanceState);
        return attendance;
    }
}
