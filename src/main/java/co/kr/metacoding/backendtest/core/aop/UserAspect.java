package co.kr.metacoding.backendtest.core.aop;

import co.kr.metacoding.backendtest.core.error.ex.Exception400;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class UserAspect {

    @Before("execution(* co.kr.metacoding.backendtest.user.UserController.saveUser(..)) || execution(* co.kr.metacoding.backendtest.user.UserController.updateUser(..))")
    public void userValidation(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Errors) {
                Errors errors = (Errors) arg;
                if (errors.hasErrors()) {
                    String errorMessage = errors.getFieldErrors().get(0).getField() + ": " + errors.getFieldErrors().get(0).getDefaultMessage();
                    throw new Exception400(errorMessage);
                }
            }
        }
    }

    @Before("execution(* co.kr.metacoding.backendtest.user.UserController.*(..))")
    public void logUserAgent() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("User-Agent: " + request.getHeader("User-Agent"));
    }
}
