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
package com.espertech.esper.supportregression.xml;

import javax.xml.xpath.XPathFunctionResolver;
import javax.xml.xpath.XPathFunction;
import javax.xml.namespace.QName;

public class SupportXPathFunctionResolver implements XPathFunctionResolver
{
    public XPathFunction resolveFunction(QName functionName, int arity) {
        return null;
    }
}