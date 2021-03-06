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
package com.espertech.esper.epl.core;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.collection.UniformPair;
import com.espertech.esper.core.context.util.AgentInstanceContext;
import com.espertech.esper.epl.agg.service.AggregationService;
import com.espertech.esper.view.Viewable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultSetProcessorRowPerGroupUnboundGroupRepImpl implements ResultSetProcessorRowPerGroupUnboundGroupRep {

    private final Map<Object, EventBean> groupReps = new LinkedHashMap<Object, EventBean>();

    public void put(Object key, EventBean event) {
        groupReps.put(key, event);
    }

    public Iterator<EventBean> valueIterator() {
        return groupReps.values().iterator();
    }

    public void removed(Object key) {
        groupReps.remove(key);
    }

    public void destroy() {
        // no action required
    }
}
