package com.yao.yz.kubauser.dataSource;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
/**
* 描述：自定义数据源切面
*/
public class DynamicDataSourceAspect {

    private static final Logger logger = Logger.getLogger(DynamicDataSourceAspect.class);

    public void before(JoinPoint point) {
	Object target = point.getTarget();
	String method = point.getSignature().getName();

	Class<?>[] classz = target.getClass().getInterfaces();
	Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
	try {
	    Method m = classz[0].getMethod(method, parameterTypes);
	    if (m != null && m.isAnnotationPresent(DataSource.class)) {
		DataSource data = m.getAnnotation(DataSource.class);
		DynamicDataSourceHolder.setDataSource(data.value());
		logger.debug("Set dataSource of SqlSession : [" + data.value() + "]");
	    }
	} catch (Exception e) {
	    logger.error(e);
	}
    }
}
	