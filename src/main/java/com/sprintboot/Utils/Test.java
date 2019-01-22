package com.sprintboot.Utils;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List lst = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');
        System.out.println(getPage(2, 10, lst));

    }

    public static List getPage(Integer page, Integer size, List lst) {
        Integer begin = (page - 1) * size;
        if (lst == null || lst.size() < 1 ||
                page < 1 || begin > lst.size()) {
            return new ArrayList();
        }
        Integer end = page * size;
        if (end >= lst.size()) {
            end = lst.size();
        }
        return lst.subList(begin, end);
    }
}
