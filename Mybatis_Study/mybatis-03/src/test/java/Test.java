import com.dl.dao.StudentMapper;
import com.dl.dao.TeacherMapper;
import com.dl.pojo.Student;
import com.dl.pojo.Teacher;
import com.dl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

    @org.junit.Test
    public void testStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> list = mapper.getStudent2();
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
    }




}
