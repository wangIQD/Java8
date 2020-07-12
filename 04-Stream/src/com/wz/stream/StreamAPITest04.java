package com.wz.stream;

import com.wz.Employee;
import com.wz.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author 隔壁老王
 * @create 2020-07-11 11:56
 * @微信公众号 隔壁老王说Java
 * @description Stream的中间操作：排序
 */
public class StreamAPITest04 {
    @Test
    public void test01() {
        List<Employee> employeesList = EmployeeData.getEmployees();

        // sorted——自然排序：产生一个新流，其中按自然顺序排序
        List<Integer> list = Arrays.asList(23, 12, 45, 89, 10, 2, -5, 0);
        list.stream().sorted().forEach(System.out::println);

        System.out.println("*********************");
        // sorted(Comparator com)——定制排序：产生一个新流，其中按比较器顺序排序
        // 按salary排序，如果相等，就按id排序
        employeesList.stream().sorted((e1,e2) -> {
            int res = Double.compare(e1.getSalary(), e2.getSalary());
            if (res != 0) {
                return res;
            } else {
                return Integer.compare(e1.getId(),e2.getId());
            }
        }).forEach(System.out::println);

    }
}
