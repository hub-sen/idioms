package com.shisen.idioms.eclipseCollections.Test1;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Test;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/6/24 20:23
 * </pre>
 */
public class Test1 {

	private static final Food BANANA = new Food("Banana", Food.FoodType.FRUIT, 50);
	private static final Food APPLE = new Food("Apple", Food.FoodType.FRUIT, 30);
	private static final Food CAKE = new Food("Cake", Food.FoodType.DESSERT, 22);
	private static final Food CEREAL = new Food("Cereal", Food.FoodType.DESSERT, 80);
	private static final Food SPINACH = new Food("Spinach", Food.FoodType.VEGETABLE, 26);
	private static final Food CARROT = new Food("Carrot", Food.FoodType.VEGETABLE, 27);
	private static final Food HAMBURGER = new Food("Hamburger", Food.FoodType.MEAT, 3);

	private static MutableList<Animal> zooAnimals = Lists.mutable.with(
			new Animal("ZigZag", Animal.AnimalType.ZEBRA, Lists.mutable.with(BANANA, APPLE)),
			new Animal("Tony", Animal.AnimalType.TIGER, Lists.mutable.with(CEREAL, HAMBURGER)),
			new Animal("Phil", Animal.AnimalType.GIRAFFE, Lists.mutable.with(CAKE, CARROT)),
			new Animal("Lil", Animal.AnimalType.GIRAFFE, Lists.mutable.with(SPINACH, HAMBURGER)));


	//最受欢迎的食物


	@Test
	public void popularFood() {

		Optional<Map.Entry<Food, Long>> popularFood = zooAnimals.stream()
				.flatMap(animal -> animal.getFavoriteFood().stream())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue());


		popularFood.ifPresent(foodLongEntry -> System.out.print(foodLongEntry.getKey()
				.getName() + ":" + foodLongEntry.getValue()));

	}


	@Test
	public void popularFood2() {
		MutableList<ObjectIntPair<Food>> popularFood = zooAnimals.asLazy()
				.flatCollect(Animal::getFavoriteFood)
				.toBag()
				.topOccurrences(1);

		System.out.println("popularFood = " + popularFood.getOnly().getOne().getName() + ":" + popularFood.getOnly()
				.getTwo());

	}


}
