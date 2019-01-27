package frodez.config.aop.request.checker.impl;

import frodez.config.aop.request.checker.facade.TimeoutChecker;
import frodez.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 自动超时型重复请求检查REDIS实现
 * @author Frodez
 * @date 2019-01-21
 */
@Component("timeoutRedisChecker")
public class TimeoutRedisChecker implements TimeoutChecker {

	/**
	 * redis服务
	 */
	@Autowired
	private RedisService redisService;

	@Override
	public boolean check(String key) {
		return redisService.exists(key);
	}

	@Override
	public void lock(String key, long timeout) {
		if (timeout <= 0) {
			throw new RuntimeException("超时时间必须大于0!");
		}
		redisService.set(key, true, timeout);
	}

}
