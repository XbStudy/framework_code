import com.dl.dao.UserMapper;
import com.dl.pojo.User;
import com.dl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Tset {
    @Test
    public void getUserById(){
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user1 = mapper1.getUserById(1);
        sqlSession1.close();

        User user2 = mapper2.getUserById(1);
        System.out.println(user1 == user2);
        sqlSession2.close();
    }

}
