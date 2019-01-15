package com.sprintboot.Utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 * Spring 封装了 RedisTemplate 对象来进行对redis的各种操作，它支持所有的 redis 原生的 api。
 */
public class RedisUtil {

    /**
     * 如果k-v 都是String类型的可以直接使用StingRedisTemplate
     */
    private StringRedisTemplate template;

    /**
     * 如果k-v 是Object类型的 则需要自定义RedisTemplate
     */
    private RedisTemplate redisTemplate;

    public StringRedisTemplate getRedisTemplate() {
        return this.template;
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public Boolean hasKey(String key) {
        return template.hasKey(key);
    }

    /**
     * 查找匹配的key
     */
    public Set<String> keys(String pattern) {
        return template.keys(pattern);
    }


    /**
     * 添加k,v
     * template.opsForValue();//操作字符串
     * template.opsForHash();//操作hash
     * template.opsForList();//操作list
     * template.opsForSet();//操作set
     * template.opsForZSet();//操作有序set
     */
    public Long sAdd(String key, String... values) {
        return template.opsForSet().add(key, values);
    }

    /**
     * 设置key的失效时间
     * @return
     */
    public Boolean expire(String key, long time) {
        try {
            if (time > 0) {
                template.expire(key, time, TimeUnit.MILLISECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取过期时间
     */
    public long getExpire(String key) {
        return template.getExpire(key, TimeUnit.MILLISECONDS);
    }

    /**
     * 添加元素，有序集合是按照score的值 从小到大排列
     */
    public Boolean zAdd(String key, String value, double score) {
        return template.opsForZSet().add(key, value, score);
    }

    /**
     * 删除key
     */
    public void delete(String key) {
        template.delete(key);
    }

    /**
     * 批量删除key
     */
    public void deletee(Collection<String> keys) {
        template.delete(keys);
    }

    /**
     * 获取集合中的元素 从大到小排列 别返回score
     */
    public Set<String> zReverseRangeWithScores(
            String key, long start, long end) {
        return template.opsForZSet().reverseRange(key, start, end);
    }

    /**
     * 获取集合大小
     */
    public Long zZCard(String key) {
        return template.opsForZSet().zCard(key);
    }

    /**
     * 移除指定索引的元素
     */
    public Long zRemoveRange(String key, long start, long end) {
        return template.opsForZSet().removeRange(key, start, end);
    }

    /**
     * 递增
     */
    public long incr(String key, long delta) {
        return template.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     */
    public long decr(String key, long delta) {
        return template.opsForValue().decrement(key, delta);
    }


    /**
     * 增加元素的score值，并返回增加后的值
     */
    public Double zIncremenetScore(String key, String value, double delta) {
        return template.opsForZSet().incrementScore(key, value, delta);
    }


}
