package com.wz.stream;

import com.wz.Employee;
import com.wz.EmployeeData;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 隔壁老王
 * @create 2020-07-12 9:31
 * @微信公众号 隔壁老王说Java
 * @description Stream的终止操作：收集
 */
public class StreamAPITest07 {
    @Test
    public void test01() {
        // collect(Collector c)——将流转换为其他形式。接收一个Collector接口的实现,用于给Stream中元素做汇总的方法
        // 练习：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("******************");

        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
    }
}
