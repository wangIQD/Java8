package com.wz.stream;

import com.wz.Employee;
import com.wz.EmployeeData;
import org.junit.Test;

import java.util.List;

/**
 * @author 隔壁老王
 * @create 2020-07-11 10:22
 * @微信公众号 隔壁老王说Java
 * @description Stream的中间操作：筛选与切片
 */
public class StreamAPITest02 {
    @Test
    public void test01() {
        List<Employee> employeesList = EmployeeData.getEmployees();
        // filter(Predicate p)——接收 Lambda，从流中排除某些元素。
        // 查询员工工资大于7000的员工
        employeesList.stream().filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        // limit(n)——截断流，使其元素不超过给定数量。
        // 查询前5名员工
        System.out.println("********************");
        employeesList.stream().limit(5).forEach(System.out::println);

        // skip(n)——跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补。
        // 跳过前三名员工
        System.out.println("********************");
        employeesList.stream().skip(3).forEach(System.out::println);

        // distinct()——筛选，通过流所生成元素的hashCode()和equals()去除重复元素。
        // 去重
        employeesList.add(new Employee(1010,"刘强东",40,8000));
        employeesList.add(new Employee(1010,"刘强东",40,8000));
        employeesList.add(new Employee(1010,"刘强东",40,8000));
        System.out.println("********************");
        employeesList.stream().distinct().forEach(System.out::println);

    }
}
