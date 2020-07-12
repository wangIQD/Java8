package com.wz.stream;

import com.wz.Employee;
import com.wz.EmployeeData;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * @author 隔壁老王
 * @create 2020-07-12 8:34
 * @微信公众号 隔壁老王说Java
 * @description Stream的终止操作：匹配与查找
 */
public class StreamAPITest05 {
    @Test
    public void test01() {
        List<Employee> employees = EmployeeData.getEmployees();
        // allMatch(Predicate p)——检查是否匹配所有元素。
        // 练习:是否所有的员工的年龄都大于18
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);
        System.out.println("**************");

        // anyMatch(Predicate p)——检查是否至少匹配一个元素。
        // 练习:是否存在员工的工资大于1000
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(b1);
        System.out.println("*****************");

        // noneMatch(Predicate p)——检查是否没有匹配的元素。
        // 练习:是否存在员工姓“雷”
        boolean b2 = employees.stream().noneMatch(e -> e.getName().contains("雷"));
        System.out.println(b2);
        System.out.println("*****************");


        // findFirst——返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        System.out.println("*****************");

    }

    @Test
    public void test02() {
        List<Employee> employees = EmployeeData.getEmployees();
        // findAny——返回当前流中的任意元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
        System.out.println("*****************");

        // count——返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getAge() > 30).count();
        System.out.println(count);
        System.out.println("*****************");

        // max(Comparator c)——返回流中最大值
        // 练习:返回最高的工资:
        Optional<Double> max = employees.stream().map(e -> e.getSalary()).max(Double::compareTo);
        System.out.println(max);
        System.out.println("*****************");

        // min(Comparator c)——返回流中最小值
        // 练习:返回最低工资的员工
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);
        System.out.println("*****************");

        // forEach(Consumer c)——内部迭代
        employees.stream().forEach(System.out::println);
    }

}
