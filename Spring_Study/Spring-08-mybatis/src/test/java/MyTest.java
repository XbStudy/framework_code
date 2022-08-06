import com.dl.mapper.UserMapper;
import com.dl.pojo.User;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void  queryAll() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapperImpl = context.getBean("userMapperImpl2", UserMapper.class);
        List<User> list = userMapperImpl.queryAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

}
