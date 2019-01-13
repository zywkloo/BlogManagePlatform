package info.frodez.config.aop.log;

import info.frodez.util.aop.MethodUtil;
import info.frodez.util.json.JSONUtil;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 日志管理AOP切面
 * @author Frodez
 * @date 2019-01-12
 */
@Slf4j
@Aspect
@Component
public class LogAOP {

	/**
	 * 打印参数到日志
	 * @param JoinPoint AOP切点
	 * @author Frodez
	 * @date 2019-01-12
	 */
	@Before("@annotation(info.frodez.config.aop.log.ParamLog)")
	public void printParam(JoinPoint point) {
		Parameter[] parameters = MethodUtil.getParams(point);
		Object[] args = point.getArgs();
		Map<String, String> paramMap = new HashMap<>();
		for (int i = 0; i < parameters.length; i++) {
			paramMap.put(parameters[i].getName(), JSONUtil.toJSONString(args[i]));
		}
		log.info(MethodUtil.getFullName(point) + "请求参数:" + JSONUtil.toJSONString(paramMap));
	}

	/**
	 * 打印返回值到日志
	 * @param JoinPoint AOP切点
	 * @author Frodez
	 * @date 2019-01-12
	 */
	@AfterReturning(value = "@annotation(info.frodez.config.aop.log.ResultLog)", returning = "result")
	public void printResult(JoinPoint point, Object result) {
		log.info(MethodUtil.getFullName(point) + "返回值:" + JSONUtil.toJSONString(result));
	}

}
