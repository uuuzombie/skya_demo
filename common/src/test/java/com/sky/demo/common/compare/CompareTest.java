package com.sky.demo.common.compare;

import com.sky.demo.common.compare.bean.Student;
import com.sky.demo.common.compare.bean.User;
import com.sky.demo.common.compare.util.UserComparator;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by rg on 15/6/27.
 */
public class CompareTest {

    @Test
    public void test_Student_implements_Comparable(){

        Student[] students = {
                new Student("zhang",22,80),
                new Student("li",23,83),
                new Student("wang",21,80)
        };

        Arrays.sort(students);

        System.out.println(students.toString());
    }

    @Test
    public void test_User_implements_Comparator(){

        User[] users = {
                new User(1,"zhang",10),
                new User(2,"li",8),
                new User(3,"wang",9)
        };

        Arrays.sort(users,new UserComparator());

        System.out.println(users.toString());
    }
}
