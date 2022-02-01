package com.nepalaya.up.constant;

import com.nepalaya.up.exception.DataAlreadyExistsException;
import com.nepalaya.up.exception.DataNotFoundException;
import com.nepalaya.up.exception.SystemException;

import java.util.function.Function;
import java.util.function.Supplier;

public interface ExceptionConstant {

    Function<String, Supplier<DataNotFoundException>> DATA_NOT_FOUND = (m) -> () -> new DataNotFoundException(m);
    Function<String, Supplier<DataAlreadyExistsException>> DATA_ALREADY_EXIST = (m) -> () -> new DataAlreadyExistsException(m);
    Function<String, Supplier<SystemException>> SYSTEM_EXCEPTION = (m) -> () -> m == null ? new SystemException() : new SystemException(m);
}
