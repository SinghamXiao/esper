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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class represents an observer expression in the evaluation tree representing an pattern expression.
 */
public class EvalObserverNode extends EvalNodeBase
{
    protected final EvalObserverFactoryNode factoryNode;

    public EvalObserverNode(PatternAgentInstanceContext context, EvalObserverFactoryNode factoryNode) {
        super(context);
        this.factoryNode = factoryNode;
    }

    public EvalObserverFactoryNode getFactoryNode() {
        return factoryNode;
    }

    public EvalStateNode newState(Evaluator parentNode,
                                  EvalStateNodeNumber stateNodeNumber, long stateNodeId)
    {
        return new EvalObserverStateNode(parentNode, this);
    }

    private static final Logger log = LoggerFactory.getLogger(EvalObserverNode.class);
}
