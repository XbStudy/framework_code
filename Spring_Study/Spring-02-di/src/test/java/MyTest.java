import com.dl.pojo.Student;
import com.dl.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
        /*
        Student{
            name='小白',
            address=Address{address='湖南'},
            books=[Java基础, JavaOOP编程, JavaWeb, SSM框架],
            hobbys=[听音乐, 看视频],
            card={身份证=111111111111111111,
            银行卡=1111111111111111111},
            games=[古墓丽影：崛起, 古墓丽影：暗影],
            info={password=111111, username=admin},
            wife='null'
        }
         */
        ApplicationContext context1 = new ClassPathXmlApplicationContext("userBean.xml");
        User user1 = context1.getBean("user1", User.class);
        User user2 = context1.getBean("user2", User.class);
        System.out.println(user1);  // User{name='小白1', age='3'}
        System.out.println(user2);  // User{name='小白2', age='4'}
    }
}
