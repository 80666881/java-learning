package com.how2java.interceptor;

import java.util.Date;

import com.how2java.action.ProductAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class DateInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation invocation) throws Exception {
        ProductAction action = (ProductAction)invocation.getAction();
        action.setDate(new Date());
        return invocation.invoke();
    }
}