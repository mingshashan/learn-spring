package com.mingshashan.learn.learnhystrix.test01;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * Hello2Command
 *
 * @author xufj
 */
public class Hello2Command extends HystrixCommand<String> {

    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Hello2Command() {
//        this(HystrixCommandGroupKey.Factory.asKey("hello2"));
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("test"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        //开启熔断模式
                        .withCircuitBreakerEnabled(true)
                        //出现错误的比率超过30%就开启熔断
                        .withCircuitBreakerErrorThresholdPercentage(30)
                        //至少有10个请求才进行errorThresholdPercentage错误百分比计算
                        .withCircuitBreakerRequestVolumeThreshold(10)
                        //半开试探休眠时间，这里设置为3秒
                        .withCircuitBreakerSleepWindowInMilliseconds(3000)
                        .withFallbackEnabled(true)
                )
        );
    }

    protected Hello2Command(HystrixCommandGroupKey group) {
        super(group);
    }

    /**
     * Implement this method with code to be executed when {@link #execute()} or {@link #queue()} are invoked.
     *
     * @return R response type
     * @throws Exception if command execution fails
     */
    @Override
    protected String run() throws Exception {
        //模拟外部请求需要的时间长度
        System.out.println(flag + "-执行了run方法");
        Thread.sleep(20000);
        return "sucess";
    }

    @Override
    protected String getFallback() {
        //当外部请求超时后，会执行fallback里的业务逻辑
        System.out.println(flag + "-执行了回退方法");
        return "error";
    }
}
