package com.wz.constructorreferences;

import com.wz.Employee;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author 隔壁老王
 * @create 2020-07-09 11:20
 * @微信公众号 隔壁老王说Java
 * @description 构造器引用
 */

/**
 * 1.构造器引用：和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *   抽象方法的返回值类型即为构造器所属的类的类型
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    //Employee的空参构造器: Employee()
    @Test
    public void test1(){
        Supplier<Employee> supplier = () -> new Employee();
        System.out.println(supplier.get());
        System.out.println("******************");
        Supplier<Employee> supplier1 = Employee::new;
        System.out.println(supplier1.get());
	}

	//Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> function = id -> new Employee(id);
        Employee employee = function.apply(1001);
        System.out.println(employee);
        System.out.println("*****************");
        Function<Integer,Employee> function1 = Employee::new;
        Employee employee1 = function1.apply(1002);
        System.out.println(employee1);
    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> biFunction = (id,name) -> new Employee(id,name);
        Employee employee = biFunction.apply(1001,"张三");
        System.out.println(employee);
        System.out.println("*****************");
        BiFunction<Integer,String,Employee> biFunction1 = Employee::new;
        Employee employee1 = biFunction1.apply(1002,"李四");
        System.out.println(employee1);
	}

}
