package com.mingshashan.learn.redis.service;

import javax.validation.constraints.NotBlank;

/**
 * IRedisService
 *
 * @author xufj
 */
public interface IRedisService {
    void test();

    boolean lock(@NotBlank String key, Long expireTime);
}
