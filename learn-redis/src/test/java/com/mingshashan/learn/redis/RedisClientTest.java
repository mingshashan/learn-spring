package com.mingshashan.learn.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * RedisClientTest
 *
 * @author xufj
 */
public class RedisClientTest {

    @Test
    public void testSetGet() throws Exception {
        RedisURI redisUri = RedisURI.builder()                    // <1> 创建单机连接的连接信息
                .withHost("localhost")
                .withPort(6379)
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();
        RedisClient redisClient = RedisClient.create(redisUri);   // <2> 创建客户端
        StatefulRedisConnection<String, String> connection = redisClient.connect();     // <3> 创建线程安全的连接
        RedisCommands<String, String> redisCommands = connection.sync();                // <4> 创建同步命令
        SetArgs setArgs = SetArgs.Builder.nx().ex(5);
        String result = redisCommands.set("name", "throwable", setArgs);
        Assertions.assertThat(result).isEqualToIgnoringCase("OK");
        result = redisCommands.get("name");
        Assertions.assertThat(result).isEqualTo("throwable");
        // ... 其他操作
        connection.close();   // <5> 关闭连接
        redisClient.shutdown();  // <6> 关闭客户端
    }
}
