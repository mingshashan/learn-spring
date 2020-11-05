package com.example.demo.test01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PasswordTet
 *
 * @author jasonxu
 */
public class PasswordTest {

    public static void main(String[] args) {
        String regx = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{6,30}";
        Pattern pattern = Pattern.compile(regx);
        String pwd = null;
        Matcher m = pattern.matcher(pwd);
        System.out.println(m.find());
    }

}
