package com.hgz.config;

import com.hgz.annotation.Auth;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {


    @Pointcut(value = "@annotation(com.hgz.annotation.Auth)")
    public void pointCut(){

        System.out.println("2021");
    }

    @Before(value = "pointCut() && @annotation(auth)")
    public void before(Auth auth){
        System.out.println("======用在定义的方法之前！！=======");
    }

}
