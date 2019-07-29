package mvc;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LogAspect {

    //@Pointcut("execution(* *.logEvent(..))")
    public void allLogMethods(){
    }

    //@Before("allLogMethods()")
    public void logBefore(){
        System.err.println("aspects");
    }
}
