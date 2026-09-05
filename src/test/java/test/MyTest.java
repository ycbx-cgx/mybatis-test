package test;

import com.ybx.mybatis.entity.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {

    @Test
    void test() {
        try {
            // 读取MyBatis的核心配置文件
            InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
            // 获取SqlSessionFactory，通过他打开数据库会话才可以执行SQL语句
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
            // 打开新会话
            SqlSession sqlSession = sqlSessionFactory.openSession();

            // 执行SQL语句
            Emp e = sqlSession.selectOne("test-mapper.findEmpById");
            System.out.println(e);
        }  catch (IOException e) {
            System.err.println("无法读取MyBatis的核心文件！！");
        }
    }
}
