import com.dl.dao.TeacherMapper;
import com.dl.pojo.Teacher;
import com.dl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    @org.junit.Test
    public void testTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> list = mapper.getTeacher2(1);
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

}
