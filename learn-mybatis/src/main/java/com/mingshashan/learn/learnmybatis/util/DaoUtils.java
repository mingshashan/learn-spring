package com.mingshashan.learn.learnmybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Function;

/**
 * @author mingshashan
 */
public class DaoUtils {
    private static SqlSessionFactory factory;

    static {
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            // 加载完mybatis-config.xml配置文件之后，会根据其中的配置信息创建SqlSessionFactory对象
            factory = new SqlSessionFactoryBuilder()
                    .build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static <R> R execute(Function<SqlSession, R> function) {
        SqlSession sqlSession = factory.openSession();
        try {
            R apply = function.apply(sqlSession);
            sqlSession.commit();
            return apply;
        } catch (Throwable t) {
            sqlSession.rollback();
            System.out.println("execute error");
            throw t;
        } finally {
            // 关闭SqlSession
            sqlSession.close();
        }
    }
}
