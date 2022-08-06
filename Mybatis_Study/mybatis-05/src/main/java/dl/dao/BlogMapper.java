package dl.dao;

import dl.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //添加数据
    int addBlog(Blog blog);

    //查询
    List<Blog> queryBlog(Map map);

    List<Blog> queryBlogChoose(Map map);

    int updateBlog(Map map);

    //查询1~3号的博客
    List<Blog> queryBlogForeach(Map map);


}
