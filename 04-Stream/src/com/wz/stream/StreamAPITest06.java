package com.wz.stream;

import com.wz.Employee;
import com.wz.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author 隔壁老王
 * @create 2020-07-12 9:02
 * @微信公众号 隔壁老王说Java
 * @description Stream的终止操作：规约
 */
public class StreamAPITest06 {
    @Test
    public void test01() {
        // reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来 ，得到一个值。返回T
        // 练习：计算1-10的自然数的和
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        System.out.println("*****************");

        // reduce(BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        // 练习：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(e -> e.getSalary()).reduce(Double::sum);
        System.out.println(reduce1);

    }
}
