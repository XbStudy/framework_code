import com.dl.mapper.UserMapper;
import com.dl.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void queryAll(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapperImpl",UserMapper.class);
        List<User> list = userMapper.queryAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void deleteUser(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        int i = userMapperImpl.deleteUser(6);
        if (i>0){
            System.out.println("删除成功！");
        }else{
            System.out.println("失败！");
        }
    }
}
