package com.shisen.idioms.test1018;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/10/21 11:34
 * </pre>
 */
public class ThreadLocalTest {
	protected static final ThreadLocal<Student> LOCAL_THREAD = new ThreadLocal<>();

	/**
	 * 设置 Page 参数
	 *
	 * @param student
	 */
	protected static void setLocalStudent(Student student) {
		LOCAL_THREAD.set(student);
	}

	/**
	 * 获取 Page 参数
	 *
	 * @return
	 */
	public static Student getLocalStudent() {
		return LOCAL_THREAD.get();
	}

	/**
	 * 移除本地变量
	 */
	public static void clearStudent() {
		LOCAL_THREAD.remove();
	}

	@Test
	public void test_1() {
		Student student = new Student();
		student.setName("施森");
		student.setGender("男");
		student.setClassName("一班");
		student.setStudentNo("88888888");

		setLocalStudent(student);


		Student local_student = getLocalStudent();
		System.out.println("local_student = " + local_student);

		Student student1 = new Student();
		student1.setName("vbcjrj");
		student1.setGender("女");
		student1.setStudentNo("666666");
		student1.setClassName("一班");

		setLocalStudent(student1);

		Student localStudent = getLocalStudent();
		System.out.println("localStudent = " + localStudent);
	}

	@Test
	public void test_2() throws Exception {

		final List<Callable<Integer>> tasks = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			tasks.add(TheadId::get);
		}

		// Use up to 8 concurrent threads to handle the tasks
		final ExecutorService executorService = Executors.newFixedThreadPool(1000);
		final List<Future<Integer>> results = executorService.invokeAll(tasks);

		for (Future<Integer> result : results) {
			System.out.println("result = "+ result.get());
		}
	}


}

