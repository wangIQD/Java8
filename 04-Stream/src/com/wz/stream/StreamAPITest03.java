package com.wz.stream;

import com.wz.Employee;
import com.wz.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 隔壁老王
 * @create 2020-07-11 11:05
 * @微信公众号 隔壁老王说Java
 * @description Stream的中间操作：映射
 */
public class StreamAPITest03 {
    @Test
    public void test01() {
        List<Employee> employeesList = EmployeeData.getEmployees();
        // map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        // 转换成大写
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        System.out.println("*********************");
        // 获取员工姓名长度大于3的员工的姓名。
        employeesList.stream().map(e -> e.getName()).filter(name -> name.length() > 3).forEach(System.out::println);


        // flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        list.stream().flatMap(StreamAPITest03::fromStringToStream).forEach(System.out::println);

    }

    // 将字符串转换成对应的Stream
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }



}
