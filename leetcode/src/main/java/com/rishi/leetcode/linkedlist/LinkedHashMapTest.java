package com.rishi.leetcode.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liuhx
 * @desc TODO
 * @date 2020/03/07
 **/
public class LinkedHashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>(2, 0.75f, true);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.get("2");
        print(map);
    }


    public static void print(Map<String, String> map) {
        map.forEach((k, v) -> System.out.println("k: " + k +", v: " + v));
    }

}
