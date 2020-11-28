package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Test
 *
 * @author xufj
 */
public class Test {
    @Autowired
    @Qualifier("electricDataSource")
    private DataSource electricDataSource;

//    public void test() {
//        SqlEngine electricSqlEngine = new SqlEngine(electricDataSource);
//        String sqlConfig = "select * from df6100s.e_mp_engy_day_2020 t where t.mped_id='1070'";
//        RowMapper<Map<String, Object>> rowMapper = null;
//        List listConfig = electricSqlEngine.executeQuery(sqlConfig, null, null, null, rowMapper);
//        for (int i = 0; i < listConfig.size(); i++) {
//            System.out.println(listConfig.get(i));
//        }
//    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
