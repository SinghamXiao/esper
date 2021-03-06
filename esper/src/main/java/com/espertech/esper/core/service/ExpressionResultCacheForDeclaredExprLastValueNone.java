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
package com.espertech.esper.core.service;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.collection.RollingTwoValueBuffer;
import com.espertech.esper.event.EventBeanUtility;

import java.lang.ref.SoftReference;
import java.util.IdentityHashMap;

public class ExpressionResultCacheForDeclaredExprLastValueNone implements ExpressionResultCacheForDeclaredExprLastValue {

    public boolean cacheEnabled() {
        return false;
    }

    public ExpressionResultCacheEntry<EventBean[], Object> getDeclaredExpressionLastValue(Object node, EventBean[] eventsPerStream) {
        return null;
    }

    public void saveDeclaredExpressionLastValue(Object node, EventBean[] eventsPerStream, Object result) {
    }
}
