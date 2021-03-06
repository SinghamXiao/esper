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
package com.espertech.esper.pattern;

import com.espertech.esper.filter.FilterValueSetParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents a filter of events in the evaluation tree representing any event expressions.
 */
public class EvalFilterNode extends EvalNodeBase
{
    protected final EvalFilterFactoryNode factoryNode;
    private final FilterValueSetParam[][] addendumFilters;

    public EvalFilterNode(PatternAgentInstanceContext context, EvalFilterFactoryNode factoryNode) {
        super(context);
        this.factoryNode = factoryNode;
        if (context.getAgentInstanceContext().getAgentInstanceFilterProxy() != null) {
            this.addendumFilters = context.getAgentInstanceContext().getAgentInstanceFilterProxy().getAddendumFilters(factoryNode.getFilterSpec());
        }
        else {
            this.addendumFilters = null;
        }
    }

    public EvalFilterFactoryNode getFactoryNode() {
        return factoryNode;
    }

    public FilterValueSetParam[][] getAddendumFilters() {
        return addendumFilters;
    }

    public EvalStateNode newState(Evaluator parentNode,
                                  EvalStateNodeNumber stateNodeNumber, long stateNodeId)
    {
        if (getContext().getConsumptionHandler() != null) {
            return new EvalFilterStateNodeConsumeImpl(parentNode, this);
        }
        return new EvalFilterStateNode(parentNode, this);
    }

    private static final Logger log = LoggerFactory.getLogger(EvalFilterNode.class);
}
