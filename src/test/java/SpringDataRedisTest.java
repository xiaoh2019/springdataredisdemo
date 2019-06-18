import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * @author xiaoH
 * @create 2019-06-18-22:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appContext.xml")
public class SpringDataRedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1(){

        //redisTemplate.boundValueOps("name").set("王二");

        //list类型添加，以从左到右弹出，左压栈后压栈的先弹出，右压栈，后压入的后弹出
        //redisTemplate.boundListOps("name").leftPush("王二","李四");
        //redisTemplate.boundListOps("name").leftPush("张天王");
        //hash类型存值
        redisTemplate.boundHashOps("user").put("name","王二");
        redisTemplate.boundHashOps("user").put("age","12");
        redisTemplate.boundHashOps("user").put("email","wang@qq.com");

    }

    @Test
    public void test2(){
        //Object name = redisTemplate.boundValueOps("name").get();
        //System.out.println(name);
        //list类型获取
        //List list = redisTemplate.boundListOps("name").range(0, 10);
        //System.out.println(list);

        //hash类型取值
        //获取所有key
        Set keys = redisTemplate.boundHashOps("user").keys();
        System.out.println(keys);
        //获取所有值
        List values = redisTemplate.boundHashOps("user").values();
        System.out.println(values);
    }

    @Test
    public void test3(){
        //string删除
        //redisTemplate.delete("name");
        //list类型删除
        //remove方法的第一个参数为删除的个数，第二个是值
        //redisTemplate.boundListOps("name").remove(1,"张无忌");

        //删除hash类型的值
        redisTemplate.boundHashOps("user").delete("age");

    }


}
