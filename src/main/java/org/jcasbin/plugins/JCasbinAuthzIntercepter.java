package org.jcasbin.plugins;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class JCasbinAuthzIntercepter implements Interceptor {
    public void intercept(Invocation inv) {
        System.out.println("Before invoking " + inv.getActionKey());
        inv.invoke();
        System.out.println("After invoking " + inv.getActionKey());
    }
}
