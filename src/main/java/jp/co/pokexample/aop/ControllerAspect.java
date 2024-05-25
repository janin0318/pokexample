package jp.co.pokexample.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class ControllerAspect {

  /**
   * コントローラーの処理前に実施されるAspect
   */
  @Before("execution(* jp.co.pokexample.controller.*.*(..))")
  public void beforeController(JoinPoint joinPoint) {
    log.info("{} 開始：引数 {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
  }
}
