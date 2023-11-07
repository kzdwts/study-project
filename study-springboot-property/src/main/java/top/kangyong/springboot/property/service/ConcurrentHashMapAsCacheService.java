package top.kangyong.springboot.property.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * test
 *
 * @author Kang Yong
 * @date 2023/10/31
 * @since 1.0.0
 */
@Service
public class ConcurrentHashMapAsCacheService {

    private static ConcurrentHashMap<String, List<String>> cache = new ConcurrentHashMap<>();


    public void put(String key, List<String> dataList) {
        cache.put(key, dataList);
    }



}
