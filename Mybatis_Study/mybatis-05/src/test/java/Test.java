import dl.dao.BlogMapper;
import dl.pojo.Blog;
import dl.utils.IdUtils;
import dl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

public class Test {

    @org.junit.Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        map.put("list",list);

        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }


    @org.junit.Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("author","小白");
        map.put("title","Mybatis学习笔记");
        map.put("id","d3b651295f024b1491acfa33918acb67");
        int i = mapper.updateBlog(map);
        System.out.println(i);
        sqlSession.close();
    }


    @org.junit.Test
    public void queryBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("author","小白");
        map.put("title","Mybatis学习笔记");
        List<Blog> blogs = mapper.queryBlog(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }


    @org.junit.Test
    public void addBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("mybatis学习笔记");
        blog.setAuthor("小白");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        //插入第一条数据
        mapper.addBlog(blog);
        //插入第二条数据
        blog.setId(IdUtils.getId());
        blog.setTitle("spring学习笔记");
        mapper.addBlog(blog);
        //插入第三条数据
        blog.setId(IdUtils.getId());
        blog.setTitle("springMVC学习笔记");
        mapper.addBlog(blog);
        sqlSession.close();
    }
}
