package com.shisen.idioms.share.part3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import static java.lang.System.out;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.averagingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summarizingLong;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.summingLong;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * collect操作是Stream中最强大的方法了，几乎可以得到任何你想要的结果，collect是收集的意思，这里的作用就是收集归纳，将流中的数据映射为各种结果
 * <p>
 * collect方法有两个重载方法：
 *
 * <R> R collect(Supplier<R> supplier,
 * BiConsumer<R, ? super T> accumulator,
 * BiConsumer<R, R> combiner); // 编号1
 * <p>
 * <R, A> R collect(Collector<? super T, A, R> collector); // 编号2
 * <p>
 * <p>
 * 编号1方法，有三个参数：
 * supplier用于生成一个R类型的结果容器来盛放结果，
 * accumulator累加器用于定义盛放的方式，其中T为一个元素，R为结果容器，
 * combiner的作用是将并行操作的各个结果整合起来。
 * <p>
 * 编号2方法，
 * 它只需要一个Collector类型的参数，这个Collector可以称呼为收集器，我们可以随意组装一个收集器来进行元素归纳。
 * Collector是定义来承载一个收集器，但是JDK提供了一个Collectors工具类，在这个工具类里面预实现了N多的Collector供我们直接使用
 */

@SuppressWarnings("all")
public class Second {
	List<String> lists;

	List<String> result;

	@Before
	public void before() {
		lists = Arrays.asList("12", "345", "aabb", "abcdefg");
	}

	@After
	public void after() {
		Optional.ofNullable(result).ifPresent(out::println);
	}

	@Test
	public void CollectTest_1() {

		/**
		 * 第一个：ArrayList::new表示创建一个新的ArrayList集合，
		 * 第二个 ArrayList::add表示将元素一个一个添加到之前的集合中，
		 * 第三个ArrayList::addAll表示将多个线程的ArrayList集合一个一个的整体添加到第一个集合中，最终整合出一个最终结果并返回。
		 */
		LinkedList<String> collect = lists.stream()
				.limit(3)
				.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

		out.println("collect = " + collect);

		Set<String> collect1 = lists.stream()
				.limit(3)
				.collect(toSet());
		out.println("collect1 = " + collect1);

	}

	/**
	 * toCollection
	 * <p>
	 * 将流中的元素全部放置到一个集合中返回，这里使用Collection，泛指多种集合。
	 */
	@Test
	public void CollectorsTest_1() {
		out.println("collect = " + lists.stream().collect(toCollection(LinkedList::new)));
	}

	/**
	 * toList
	 * <p>
	 * 将流中的元素放置到一个列表集合中去。这个列表默认为ArrayList。
	 * <p>
	 * toSet
	 * 将流中的元素放置到一个无序集set中去。默认为HashSet。
	 */
	@Test
	public void CollectorsTest_2() {
		out.println(lists.stream()
				.collect(toList()));

		out.println(lists.stream()
				.collect(toSet()));
	}

	/**
	 * joining
	 * joining的目的是将流中的元素全部以字符序列的方式连接到一起，可以指定连接符，甚至是结果的前后缀。
	 */
	@Test
	public void CollectorsTest_3() {
		// 无参方法

		out.println(lists.stream()
				.collect(joining()));

		// 指定连接符

		out.println(lists.stream()
				.collect(joining(",")));

		// 指定连接符和后缀
		out.println(lists.stream()
				.collect(joining(",", "[", "]")));
	}


	/**
	 * mapping
	 * <p>
	 * 这个映射是首先对流中的每个元素进行映射，即类型转换，然后再将新元素以给定的Collector进行归纳。
	 */
	@Test
	public void CollectorsTest_4() {
		out.println(lists.stream()
				.limit(2)
				.collect(mapping(Integer::valueOf, toList())));
	}

	/**
	 * collectingAndThen
	 * <p>
	 * 该方法是在归纳动作结束之后，对归纳的结果进行再处理。
	 */
	@Test
	public void CollectorsTest_5() {
		out.println("collect = " + lists.stream()
				.collect(collectingAndThen(toList(), e -> e.size())));
	}

	/**
	 * counting
	 * <p>
	 * 改方法用于计数
	 */
	@Test
	public void CollectorsTest_6() {
		out.println(lists.stream()
				.collect(counting()));
	}

	/**
	 * minBy/maxBy
	 * <p>
	 * 生成一个用于获取最小/最大值的Optional结果的Collector。
	 */
	@Test
	public void CollectorsTest_7() {
		out.println(lists.stream()
				.collect(minBy(Comparator.comparing(String::length))));

		out.println(lists.stream()
				.collect(maxBy(Comparator.comparing(String::length))));
	}

	/**
	 * summingInt/summingLong/summingDouble
	 * <p>
	 * 生成一个用于求元素和的Collector，首先通过给定的mapper将元素转换类型，然后再求和。
	 * <p>
	 * 参数的作用就是将元素转换为指定的类型，最后结果与转换后类型一致。
	 */
	@Test
	public void CollectorsTest_8() {
		out.println(lists.stream()
				.limit(2)
				.collect(summingInt(Integer::valueOf)));

		out.println(lists.stream()
				.limit(2)
				.collect(summingLong(Long::valueOf)));

		out.println(lists.stream()
				.limit(2)
				.collect(summingDouble(Double::valueOf)));
	}

	/**
	 * averagingInt/averagingLong/averagingDouble
	 * <p>
	 * 生成一个用于求元素平均值的Collector，首选通过参数将元素转换为指定的类型。
	 * <p>
	 * 参数的作用就是将元素转换为指定的类型，求平均值涉及到除法操作，结果一律为Double类型。
	 */
	@Test
	public void CollectorsTest_9() {
		out.println(lists.stream()
				.limit(2)
				.collect(averagingInt(Integer::valueOf)));

		out.println(lists.stream()
				.limit(2)
				.collect(averagingLong(Long::valueOf)));

		out.println(lists.stream()
				.limit(2)
				.collect(averagingDouble(Double::valueOf)));
	}

	/**
	 * reducing
	 * <p>
	 * reducing方法有三个重载方法，
	 * 其实是和Stream里的三个reduce方法对应的，二者是可以替换使用的，作用完全一致，
	 * 也是对流中的元素做统计归纳作用。
	 */
	@Test
	public void CollectorsTest_10() {
		out.println(lists.stream()
				.limit(2)
				.map(Integer::valueOf)
				.collect(reducing(Integer::sum)));

		out.println(lists.stream()
				.collect(reducing("", String::concat)));

		out.println(lists.stream()
				.collect(reducing(0, String::length, Integer::sum)));

	}


	/**
	 * groupingBy
	 * <p>
	 * 这个方法是用于生成一个拥有分组功能的Collector，它也有三个重载方法：
	 * <p>
	 * 只需一个分组参数classifier，内部自动将结果保存到一个map中，每个map的键为?类型（即classifier的结果类型），值为一个list，这个list中保存在属于这个组的元素。
	 * public static <T, K> Collector<T, ?, Map<K, List<T>>> groupingBy(
	 * Function<? super T, ? extends K> classifier)
	 * <p>
	 * 在上面方法的基础上增加了对流中元素的处理方式的Collector，比如上面的默认的处理方法就是Collectors.toList()
	 * public static <T, K, A, D>Collector<T, ?, Map<K, D>> groupingBy(
	 * Function<? super T, ? extends K> classifier,Collector<? super T, A, D> downstream)
	 * <p>
	 * <p>
	 * 在第二个方法的基础上再添加了结果Map的生成方法。
	 * public static <T, K, D, A, M extends Map<K, D>>
	 * Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> classifier,
	 * Supplier<M> mapFactory,
	 * Collector<? super T, A, D> downstream)
	 */
	@Test
	public void CollectorsTest_11() {
		out.println(lists.stream()
				.collect(groupingBy(String::length)));

		out.println(lists.stream()
				.collect(groupingBy(String::length, toList())));

		TreeMap<Integer, Set<String>> collect = lists.stream()
				.collect(groupingBy(String::length, TreeMap::new, toSet()));
		out.println("collect = " + collect);
	}

	/**
	 * partitioningBy
	 * <p>
	 * 该方法将流中的元素按照给定的校验规则的结果分为两个部分，放到一个map中返回，
	 * map的键是Boolean类型，值为元素的列表List。
	 * <p>
	 * 只需一个校验参数predicate
	 * public static <T>
	 * Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate)
	 * <p>
	 * 在上面方法的基础上增加了对流中元素的处理方式的Collector，比如上面的默认的处理方法就是Collectors.toList()
	 * public static <T, D, A>
	 * Collector<T, ?, Map<Boolean, D>> partitioningBy(Predicate<? super T> predicate,
	 * Collector<? super T, A, D> downstream)
	 */
	@Test
	public void CollectorsTest_12() {
		Map<Boolean, List<String>> collect = lists.stream()
				.collect(partitioningBy(e -> e.length() < 3));

		out.println("collect = " + collect);

		Map<Boolean, Set<String>> collect1 = lists.stream()
				.collect(partitioningBy(e -> e.length() < 3, toSet()));
		out.println("collect1 = " + collect1);
	}

	/**
	 * toMap
	 * <p>
	 * toMap方法是根据给定的键生成器和值生成器生成的键和值保存到一个map中返回，
	 * 键和值的生成都依赖于元素，可以指定出现重复键时的处理方案和保存结果的map。
	 * <p>
	 *
	 * 指定键和值的生成方式keyMapper和valueMapper
	 * public static <T, K, U>
	 * Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
	 *                                  Function<? super T, ? extends U> valueMapper)
	 *
	 * 在上面方法的基础上增加了对键发生重复时处理方式的mergeFunction，比如上面的默认的处理方法就是抛出异常
	 * public static <T, K, U> Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
	 *                                                          Function<? super T, ? extends U> valueMapper,
	 *                                                          BinaryOperator<U> mergeFunction)
	 *
	 * 在第二个方法的基础上再添加了结果Map的生成方法
	 * public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> toMap(Function<? super T, ? extends K> keyMapper,
	 *                                              Function<? super T, ? extends U> valueMapper,
	 *                                              BinaryOperator<U> mergeFunction,
	 *                                              Supplier<M> mapSupplier)
	 */
	@Test
	public void CollectorsTest_13() {
		Map<Integer, String> collect = lists.stream()
				.collect(toMap(String::length, String::toUpperCase));
		out.println("collect = " + collect);

		Map<Integer, String> collect1 = lists.stream()
				.collect(toMap(String::length, String::toUpperCase, (a, b) -> b));
		out.println("collect1 = " + collect1);

		Map<Integer, String> collect2 = lists.stream()
				.collect(toMap(String::length, String::toUpperCase, (a, b) -> b, LinkedHashMap::new));
		out.println("collect2 = " + collect2);
	}


	/**
	 * summarizingInt/summarizingLong/summarizingDouble
	 *
	 * 这三个方法适用于汇总的，返回值分别是IntSummaryStatistics，LongSummaryStatistics，DoubleSummaryStatistics。
	 *
	 * 在这些返回值中包含有流中元素的指定结果的数量、和、最大值、最小值、平均值。所有仅仅针对数值结果。
	 */
	@Test
	public void CollectorsTest_14() {
		IntSummaryStatistics collect = lists.stream()
				.collect(summarizingInt(String::length));
		out.println("collect = " + collect);

		LongSummaryStatistics collect1 = lists.stream()
				.limit(2)
				.collect(summarizingLong(Long::valueOf));
		out.println("collect1 = " + collect1);

		DoubleSummaryStatistics collect2 = lists.stream()
				.limit(2)
				.collect(summarizingDouble(Double::valueOf));
		out.println("collect2 = " + collect2);
	}
}
































