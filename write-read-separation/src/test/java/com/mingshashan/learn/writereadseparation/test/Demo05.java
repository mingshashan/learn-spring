package com.mingshashan.learn.writereadseparation.test;

public class Demo05 extends Thread {
    //初始状态为true
    private boolean status = true;

    //设置状态
    public void setStatus(boolean status) {
        this.status = status;
        System.out.println("我已经将status的状态改变了");
    }

    //重写run方法
    public void run() {
        System.out.println("进入run方法了。。。");
        while (status) {
        }
        System.out.println("线程停止了。。。");
    }

    public static void main(String[] args) throws InterruptedException {
        //创建一个对象
        Demo05 d = new Demo05();
        d.start();
        //沉睡三秒钟
        Thread.sleep(3000);
        //然后将status的状态设置为false
        d.setStatus(false);
        //然后此时在打印status的状态
        System.out.println("当前的status的状态为：" + d.status);
    }
}