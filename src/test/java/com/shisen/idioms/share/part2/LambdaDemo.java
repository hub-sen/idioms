package com.shisen.idioms.share.part2;

import org.junit.Test;

/**
 * <pre>
 * Description  Lambda 表达式
 * </pre>
 */
public class LambdaDemo {

	/**
	 * 普通写法, new一个实现类
	 */
	@Test
	public void test1() {
		IEat eat = new IEatImpl();
		eat.eat();
	}

	/**
	 * 匿名内部类, new接口, 重写方法
	 */
	@Test
	public void test2() {
		IEat eat = new IEat() {
			@Override
			public void eat() {
				System.out.println("eat banana");
			}
		};
		eat.eat();
	}

	/**
	 * 引入Lambda
	 * 不写类名, 方法名
	 *
	 */
	@Test
	public void test3() {
		IEat eat = () -> {System.out.println("eat ice");};
		// 没有参数时, 代码块中只有一句代码
		IEat eat2 = () -> System.out.println("eat ice");
		eat.eat();
		eat2.eat();
	}

	@Test
	public void test4() {
		// 带参数时,使用Lambda
		IEat2 eat = (String food) -> System.out.println("eat... " + food);
		// 参数的类型可以省略
		IEat2 eat2 = (food) -> System.out.println("eat... " + food);
		// 一个参数, 括号都省略了
		IEat2 eat3 = food -> System.out.println("eat... " + food);
		eat.eat("apple");
		eat2.eat("apple");
		eat3.eat("apple");
	}

	@Test
	public void test5() {
		// 多个参数
		IEat3 eat = (food, name) -> System.out.println("eat... " + food + " ... " + name);
		eat.eat("apple", "shishi");

		// 代码块中有多行代码
		IEat3 eat2 = (food, name) -> {
			System.out.println("eat... " + food);
			System.out.println("name = " + name);
		};
		eat2.eat("apple", "shishi");
	}


	@Test
	public void test6() {
		// 带返回值
		IEat4 eat = (food, name) -> {
			System.out.println("eat... " + food);
			return 10;
		};

		// 带返回值的方法中只有一句代码
		IEat4 eat2 = (food, name) -> {return 10;};

		IEat4 eat3 = (food, name) -> /*return*/ 10;

		System.out.println(eat.eat("apple", "shishi"));
	}

	@Test
	public void test7() {
		// 参数带有final 修饰
		IEat5 eat = (food, name) -> null == food ? 0 : 1;
		IEat5 eat2 = (final String food, final String name) -> null == food ? 0 : 1;
	}

}


/**
 * 只有一个抽象方法的接口
 */
@FunctionalInterface
interface IEat {
	// 无参数
	void eat();
}

class IEatImpl implements IEat {

	@Override
	public void eat() {
		System.out.println("eat Apple!");
	}
}

@FunctionalInterface
interface IEat2 {
	// 有一个参数
	void eat(String food);
}

@FunctionalInterface
interface IEat3 {
	// 有多个参数
	void eat(String food, String name);
}

@FunctionalInterface
interface IEat4 {
	int eat(String food, String name);
}

interface IEat5 {
	int eat(final String food, final String name);
}