package com.wz.stream;

/**
 * @author 隔壁老王
 * @create 2020-07-11 9:43
 * @微信公众号 隔壁老王说Java
 * @description 测试Stream的实例化
 */

import com.wz.Employee;
import com.wz.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1.Stream关注的是对数据的运算， 与CPU打交道
 *   集合关注的是数据的存储，与内存打交道
 * 2.Stream 自己不会存储元素。
 *   Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 *   Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 * 3.Stream执行流程：①Stream的实例化    ②一系列中间操作    ③终止操作
 * 4.一个中间操作链，对数据源的数据进行处理
 *   一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 */
public class StreamAPITest01 {
    // 创建Stream方式一：通过集合
    @Test
    public void test01() {
        List<Employee> employees = EmployeeData.getEmployees();
        // default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    // 创建Stream方式二：通过数组
    @Test
    public void test02() {
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        // Integer类型
        Integer[] arr = new Integer[]{1,2,3,4,5,6};
        Stream<Integer> stream = Arrays.stream(arr);

        // 泛型
        List<Employee> employeesList = EmployeeData.getEmployees();
        Employee[] employees = employeesList.toArray(new Employee[employeesList.size()]);
        Stream<Employee> employeeStream = Arrays.stream(employees);
    }

    // 创建Stream方式三：通过Stream的of()
    @Test
    public void test03() {
        Stream<String> stream = Stream.of("hello", "java", "hello", "world");
    }

    //创建Stream方式四: 创建无限流
    @Test
    public void test04() {
        // 迭代
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);      // 使用了中间操作和终止操作

        // 生成
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);         // 使用了中间操作和终止操作

    }

}
