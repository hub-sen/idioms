package com.shisen.idioms.baldStrong;

import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <pre>
 * Description
 * </pre>
 */
public class OptionalTest {

	private List<Person> people;

	@Before
	public void before() {
		Person person1 = new Person();
		person1.setName("施森1");
		person1.setAge(25);
		Person person2 = new Person();
		person2.setName("施森2");
		person2.setAge(26);
		Person person3 = new Person();
		person3.setName("施森3");
		person3.setAge(27);
		people = new ArrayList<>();
		people.add(person1);
		people.add(person2);
		people.add(person3);
	}


	@Test
	public void fn1() {
		Person person1 = new Person();
		person1.setName("施森1");
		person1.setAge(25);

		Optional.ofNullable(person1).ifPresent(people::add);
		System.out.println("people = " + people);

		List<String> names = new ArrayList<>();

		Optional.ofNullable(this.people).ifPresent(personList -> personList.stream()
				.filter(person -> person.getAge() >= 26)
				.map(Person::getName)
				.forEach(names::add)
		);

		System.out.println("names = " + names);

	}

	@Test
	public void fn2() {
		Person person = new Person();

		Optional.ofNullable(person).orElse(createPerson());
		Optional.ofNullable(person).orElseGet(this::createPerson);
	}

	public Person createPerson() {
		Person person = new Person();
		person.setName("施森");
		System.out.println("person = " + person.getName());
		return person;
	}

	@Data
	class Person {
		private String name;
		private int age;
	}
}
