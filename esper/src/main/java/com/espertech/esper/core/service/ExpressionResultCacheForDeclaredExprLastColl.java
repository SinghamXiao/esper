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

import java.util.Collection;

/**
 * On the level of expression declaration:
 * a) for non-enum evaluation and for enum-evaluation a separate cache
 * b) The cache is keyed by the prototype-node and verified by a events-per-stream (EventBean[]) that is maintained or rewritten.
 *
 * NOTE: ExpressionResultCacheEntry should not be held onto since the instance returned can be reused.
 */
public interface ExpressionResultCacheForDeclaredExprLastColl {

    ExpressionResultCacheEntry<EventBean[], Collection<EventBean>> getDeclaredExpressionLastColl(Object node, EventBean[] eventsPerStream);
    void saveDeclaredExpressionLastColl(Object node, EventBean[] eventsPerStream, Collection<EventBean> result);
}
