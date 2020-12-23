package com.abel.redisaction.op;

import com.abel.redisaction.RedisActionApplication;
import com.abel.redisaction.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.PostConstruct;

/**
 * @author xufeng
 * @since 2020/12/23
 */
@Slf4j
@SpringBootTest(classes = RedisActionApplication.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String, User> userRedisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test_01() throws JsonProcessingException {
        User user =  new User(18, "abel");
        userRedisTemplate.opsForValue().set(user.getName(), user);
        User userFromRedis = userRedisTemplate.opsForValue().get(user.getName());

        log.info("userRedisTemplate get {} {}", userFromRedis, userFromRedis.getClass());
        log.info("stringRedisTemplate get {} ", stringRedisTemplate.opsForValue().get(user.getName()));
    }
}
