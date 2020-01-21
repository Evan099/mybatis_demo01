import com.damu.entity.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo {

    /**
     *
     * 查询所有
     */
    @Test
    public void testDemo1() throws IOException {
        //初始化mybatis配置环境
        String resource = "mybatis.xml";

        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

//        打开和数据库之间的会话
        SqlSession session = factory.openSession();
        List<Users> ulist = session.selectList("userList");

        for (Users user: ulist){
            System.out.println(user);
        }

        session.close();//关闭资源


    }
    /**
     *查询单个（单参数）
     *
     */

    @Test
    public void testDemo2() throws IOException {
        //初始化mybatis配置环境
        String resource = "mybatis.xml";

        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

//        打开和数据库之间的会话
        SqlSession session = factory.openSession();
        Users users = (Users) session.selectList("userDetails","1");


            System.out.println(users);


        session.close();//关闭资源


    }


}
