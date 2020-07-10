package com.wz.methodreferences;

import com.wz.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author 隔壁老王
 * @create 2020-07-09 11:05
 * @微信公众号 隔壁老王说Java
 * @description 方法引用
 */

/**
 * 1.使用情景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用!
 * 2.方法引用本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用，也是函数式接口的实例。
 * 3.使用格式：类(或对象) :: 方法名
 * 4.分为三种情况：
 * 	 情况一		对象 :: 非静态方法(实例方法)
 * 	 情况二		类 :: 静态方法
 * 	 情况三		类 :: 非静态方法
 * 5.方法引用使用要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同（针对情况一和二）
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> consumer = str -> System.out.println(str);
		consumer.accept("隔壁老王");
		System.out.println("*********************");
		PrintStream ps = System.out;
		Consumer<String> consumer1 = ps::println;
		consumer1.accept("隔壁老王");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee employee = new Employee(1001,"Jack",27,12000);
		Supplier<String> supplier = () -> employee.getName();
		System.out.println(supplier.get());
		System.out.println("*********************");
		Supplier<String> supplier1 = employee::getName;
		System.out.println(supplier1.get());

	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> comparator = (t1,t2) -> Integer.compare(t1,t2);
		System.out.println(comparator.compare(12,30));
		System.out.println("*********************");
		Comparator<Integer> comparator1 = Integer::compare;
		System.out.println(comparator1.compare(50,30));
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double,Long> function = d -> Math.round(d);
		System.out.println(function.apply(18.3));
		System.out.println("*********************");
		Function<Double,Long> function1 = Math::round;
		System.out.println(function.apply(20.6));
	}

	// 情况三：类 :: 实例方法 (较难)
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> comparator = (s1,s2) -> s1.compareTo(s2);
		System.out.println(comparator.compare("Tom","Jack"));
		System.out.println("*********************");
		Comparator<String> comparator1 = String::compareTo;
		System.out.println(comparator1.compare("Tom","Jack"));

	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String,String> predicate = (s1,s2) -> s1.equals(s2);
		System.out.println(predicate.test("Mike","Mike"));
		System.out.println("*********************");
		BiPredicate<String,String> predicate1 = String::equals;
		System.out.println(predicate1.test("Tom","Mike"));

	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee employee = new Employee(1001,"Jack",27,12000);
		Function<Employee,String> function = e -> e.getName();
		System.out.println(function.apply(employee));
		System.out.println("*********************");
		Function<Employee,String> function1 = Employee::getName;
		System.out.println(function1.apply(employee));

	}

}
