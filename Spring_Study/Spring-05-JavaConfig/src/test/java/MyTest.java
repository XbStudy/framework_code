import com.dl.pojo.User;
import com.dl.utils.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        //如果完全使用了配置类方式去做，我们就只能通过 AnnotationConfigApplicationContext 上下文来获取容器，通过配置类的class对象加载！
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user = context.getBean("getUser", User.class);
        User user1 = context.getBean("getUser", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user == user1);
        System.out.println(user == user2);
        System.out.println(user.getName());

    }

}
