package com.courseorder;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseOrderTest {
    private CourseOrder courseOrder = new CourseOrder();

    @Test
    void topologySortTest1() {
        String[][] courses = {{"course1", "course2"}, {"course1", "course3"}, {"course1", "course4"}};
        Object[] ans = courseOrder.courseOrder(courses);
        Object[] expected = {"course1", "course2", "course3", "course4"};
        Assertions.assertArrayEquals(expected, ans);
    }


    @Test
    void topologySortTest2() {
        String[][] courses = {{"course1", "course2"}, {"course1", "course3"}, {"course1", "course4"},
                {"course2", "course5"}, {"course3", "course6"}};
        Object[] ans = courseOrder.courseOrder(courses);
        Object[] expected = {"course1", "course2", "course3", "course4", "course6", "course5"};
        Assertions.assertArrayEquals(expected, ans);
    }

    @Test
    void topologySortTest3() {
        String[][] courses = {{"course1", "course2"}, {"course1", "course3"}, {"course1", "course4"},
                {"course2", "course5"}, {"course3", "course6"}, {"course7", "course1"}};
        Object[] ans = courseOrder.courseOrder(courses);
        Object[] expected = {"course7", "course1", "course2", "course3", "course4", "course6", "course5"};
        Assertions.assertArrayEquals(expected, ans);
    }

    @Test
    void topologySortTest4() {
        String[][] courses = {{"course1", "course2"}, {"course1", "course3"}, {"course1", "course4"},
                {"course2", "course5"}, {"course3", "course6"}, {"course7", "course1"}, {"course8", "course7"}};
        Object[] ans = courseOrder.courseOrder(courses);
        Object[] expected = {"course8", "course7", "course1", "course2", "course3", "course4", "course6", "course5"};
        Assertions.assertArrayEquals(expected, ans);
    }

    @Test
    void topologySortTest5() {
        String[][] courses =
                {{"course1", "course2"}, {"course1", "course3"}, {"course1", "course4"}, {"course2", "course5"},
                        {"course3", "course6"}, {"course7", "course1"}, {"course8", "course7"}, {"course7", "course9"}};
        Object[] ans = courseOrder.courseOrder(courses);
        Object[] expected = {"course8", "course7", "course1", "course2", "course3", "course4", "course6", "course5",
                "course9"};
        Assertions.assertArrayEquals(expected, ans);
    }
}
