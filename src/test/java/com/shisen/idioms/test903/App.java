package com.shisen.idioms.test903;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/9/3 13:26
 * </pre>
 */
public class App {
	private List<Student> students;

	@Before
	public void before() {

		LocalDate first = LocalDate.of(1992, 1, 1);
		LocalDate sended = LocalDate.of(1994, 1, 1);


		students = Arrays.asList(new Student("彭彭", first, null),
				new Student("施施", sended, null)
		);
	}

	@After
	public void after() {
		Optional.ofNullable(students).ifPresentOrElse(System.out::println, () -> System.out.println("什么都没有的集合"));
	}

	@Test
	public void test_1() {
		students = this.students.stream()
				.map(student -> student.setBirthdayStr(student.getBirthday().toString()))
				.sorted(Comparator.comparing(Student::getBirthday, Comparator.reverseOrder()))
				.collect(Collectors.toList());

	}


}
