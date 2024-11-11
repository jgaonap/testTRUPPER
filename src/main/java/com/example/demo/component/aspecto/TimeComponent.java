package com.example.demo.component.aspecto;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeComponent {
	@Around("@annotation(com.example.demo.component.aspecto.AnotacionEjecucion)")
	public Object grabExecutionTime(ProceedingJoinPoint point) {
		try {
			Long tiempo1 = System.currentTimeMillis();
			Object logicObject = point.proceed();
			Long tiempo2 = System.currentTimeMillis();
			Long total = tiempo2 - tiempo1;
			System.out.println("Tiempo de Ejecucion : " + total);
			return logicObject;
		} catch (Throwable throwable) {
			return null;
		}

	}
}
