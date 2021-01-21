package com.mingshashan.learn.learnhystrix.test01;

/**
 * Hello2Test
 *
 * @author xufj
 */
public class Hello2Test {

    public static void main(String[] args) throws InterruptedException {

//        // 成功
//        v1();

        // v2失败
//        v2();

        for (int i = 0; i < 30; i++) {
            Hello2Command command = new Hello2Command();
            command.setFlag(i);
            String result = command.execute();
            System.out.println("circuit Breaker is open : " + command.isCircuitBreakerOpen());
            if(command.isCircuitBreakerOpen()){
                Thread.currentThread().sleep(500);
            }
        }

    }

    private static void v2() {
        Hello2Command hello2Command = new Hello2Command();
        String successRet = hello2Command.execute();
        System.out.println(successRet);
    }

    private static void v1() {

        Hello2Command hello2Command = new Hello2Command();
        String successRet = hello2Command.execute();
        System.out.println(successRet);
    }

}
