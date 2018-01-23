package project

const Redis_Config = `
# Redis settings
redis.host=$(redisHost)$
redis.port=$(redisPort)$
redis.pass=$(redisPassWord)$
redis.maxIdle=200
redis.maxTotal=600
redis.maxWaitMillis=5000
redis.testOnBorrow=true
redis.testOnReturn=true
`

const redis_config = `
	<bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig">
		<property name="maxIdle" value="${redis.maxIdle}" />
        <property name="maxTotal" value="${redis.maxTotal}" />
        <property name="maxWaitMillis" value="${redis.maxWaitMillis}" />
        <property name="testOnBorrow" value="${redis.testOnBorrow}" />
        <property name="testOnReturn" value="${redis.testOnReturn}" />
	</bean>

	<bean id="jedisConnectionFactory" class="org.springframework.data.redis.connection.jedis.JedisConnectionFactory"
		p:host-name="${redis.host}"
		p:port="${redis.port}"
		p:password="${redis.pass}"
		p:use-pool="true"
		p:pool-config-ref="jedisPoolConfig" />

	<bean id="redisTemplate" class="org.springframework.data.redis.core.RedisTemplate">
		<property name="connectionFactory" ref="jedisConnectionFactory" />
		<property name="keySerializer">
            <bean class="org.springframework.data.redis.serializer.StringRedisSerializer"/>
        </property>
        <property name="valueSerializer">
            <bean class="org.springframework.data.redis.serializer.StringRedisSerializer"/>
        </property>
	</bean>

`
const redis_class = `
package $(package)$.dataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {


    private static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);
    @Resource(name = "redisTemplate")
    private RedisTemplate<String,String> redisTemplate;
    private RedisUtils() {}

    private static RedisUtils redisUtils = null;
    @PostConstruct
    public void init() {
        redisUtils = this;

        String ping = redisTemplate.getConnectionFactory().getConnection().ping();
        logger.info("redis ping = "+ping);

    }

    public static void del(String key) {
        redisUtils.redisTemplate.delete(key);
    }

    public static  void  set(String key,String value,long timeout){
        redisUtils.redisTemplate.opsForValue().set(key,value,timeout, TimeUnit.SECONDS);
    }
    public static  String  get(String key){
        return   redisUtils.redisTemplate.opsForValue().get(key);
    }

    public static void expire(String key, long timeout) {
        redisUtils.redisTemplate.expire(key, Long.valueOf(timeout),TimeUnit.SECONDS);
    }
    public static long increment(String key, long increment) {
        long result  = redisUtils.redisTemplate.opsForValue().increment(key, increment);
        return result;
    }
    public static long incr(String key) {
        long result = redisUtils.increment(key, 1l);

        return result;
    }

    // list operation
    public static  void  leftPush(String key,String value){
        redisUtils.redisTemplate.opsForList().leftPush(key,value);
    }

    public static  void  leftPop(String key){
        redisUtils.redisTemplate.opsForList().leftPop(key);
    }

    public static  void  rightPush(String key,String value){
        redisUtils.redisTemplate.opsForList().rightPush(key,value);
    }
    public static  void  rightPop(String key){
        redisUtils.redisTemplate.opsForList().rightPop(key);
    }
    public static  void  size(String key){
        redisUtils.redisTemplate.opsForList().size(key);
    }
    public static List<String> range(String key, long beginIndex, long endIndex){
      return   redisUtils.redisTemplate.opsForList().range(key,beginIndex,endIndex);
    }

    public static  void  rightPopAndLeftPush(String key,String value){
        redisUtils.redisTemplate.opsForList().rightPopAndLeftPush(key,value);
    }


}

`

const redis_test_class = `
package $(package)$;
import $(package)$.dataSource.RedisUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RedisTest extends AbstractTest {
	private static final Logger logger = LoggerFactory.getLogger(RedisTest.class);

	@Test
	public void testRedis(){
		RedisUtils.set("key","value",60);
		logger.info("set redis key = key");
		String value =  RedisUtils.get("key");
		logger.info("get redis key = "+value);
		long result =  RedisUtils.increment("key_c",10);
		logger.info("increment redis key to   "+result);
		 result =RedisUtils.incr("key_c");
		logger.info("increment redis key add 1 and result = "+result);

	}



}

`
