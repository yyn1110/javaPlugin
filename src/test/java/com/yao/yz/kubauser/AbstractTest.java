package com.yao.yz.kubauser;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 描述：测试基类，所有的Dao测试类都必须继承此类
 * @Transactional 引入事务控制
 * @TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) 引入事务控制管理器
 * AbstractTransactionalDataSourceSpringContextTests 继承事务测试基类，避免测试框架带来脏数据，取消事务控制时修改为false
 *
 * Created by wuwenjun on 2015/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kubauser-daoConfig.xml"})
public abstract class AbstractTest {
    
}