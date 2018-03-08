package usertest;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.tectoy.bcloud.model.po.UserBasePO;
import com.tectoy.bcloud.service.api.IUserBaseService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class userbaseTest {

    private static Logger logger = Logger.getLogger(userbaseTest.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private IUserBaseService userbaseServ;
    
    @Test
    public void test1(){
    	UserBasePO userinfo=userbaseServ.getUserBaseInfobyId(1);
    	logger.info(JSON.toJSONString(userinfo));
    }
	
}
