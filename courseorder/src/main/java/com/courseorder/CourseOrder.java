package com.courseorder;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class CourseOrder {

    public Object[] courseOrder(String[][] courses) {
        if (courses == null || courses.length == 0) {
            return null;
        }

        Stack<String> stack = new Stack<>();
        Deque<String> order = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();

        for (String[] nextCourse : courses) {
            if (!Boolean.TRUE.equals(visited.get(nextCourse[0]))) {
                stack.push(nextCourse[0]);
                order.addFirst(nextCourse[0]);
                visited.putIfAbsent(nextCourse[0], Boolean.TRUE);
                while (!stack.isEmpty()) {
                    String top = stack.peek();
                    stack.pop();
                    for (String[] next : courses) {
                        if (next[0].equals(top)) {
                            if (!Boolean.TRUE.equals(visited.get(next[1]))) {
                                visited.putIfAbsent(next[1], Boolean.TRUE);
                                stack.push(next[1]);
                                order.addLast(next[1]);
                            }
                        }
                    }
                }
            }
        }
        return order.stream().collect(Collectors.toList()).toArray();
    }

}
