/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.epl.datetime.eval;

import com.espertech.esper.util.JavaClassHelper;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DatetimeLongCoercerFactory {

    private final static DatetimeLongCoercerLong datetimeLongCoercerLong = new DatetimeLongCoercerLong();
    private final static DatetimeLongCoercerDate datetimeLongCoercerDate = new DatetimeLongCoercerDate();
    private final static DatetimeLongCoercerCal datetimeLongCoercerCal = new DatetimeLongCoercerCal();
    private final static DatetimeLongCoercerZonedDateTime datetimeLongCoercerZDT = new DatetimeLongCoercerZonedDateTime();

    public static DatetimeLongCoercer getCoercer(Class clazz, TimeZone timeZone) {
        if (JavaClassHelper.isSubclassOrImplementsInterface(clazz, Date.class)) {
            return datetimeLongCoercerDate;
        }
        if (JavaClassHelper.isSubclassOrImplementsInterface(clazz, Calendar.class)) {
            return datetimeLongCoercerCal;
        }
        if (JavaClassHelper.isSubclassOrImplementsInterface(clazz, LocalDateTime.class)) {
            return new DatetimeLongCoercerLocalDateTime(timeZone);
        }
        if (JavaClassHelper.isSubclassOrImplementsInterface(clazz, ZonedDateTime.class)) {
            return datetimeLongCoercerZDT;
        }
        return datetimeLongCoercerLong;
    }
}
