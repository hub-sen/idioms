package com.shisen.idioms.share.part3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.*;
import static java.util.stream.Collectors.toList;

/**
 * <pre>
 * Description  Stream
 * Stream操作简称流操作，这里的流与IO流毫无关系，这里的流指的是流式操作，就是流水线操作。
 *
 * Stream流操作主要包包括三大模块：创建流操作、中间流操作、终结流操作。
 *
 * 其中创建流主要是创建Stream对象。每个Stream对象只能使用一次终结操作。
 *
 * 中间流操作指的是各种中间流操作方法，比如去重、过滤、排序等
 *
 * 终结流操作指的结果操作，终结操作的目的是产生最终结果。
 *
 * </pre>
 */
public class First {

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


	/**
	 * 创建流
	 */
	@Test
	public void creatStream() {
		// 基于数组创建流
		int[] numbers = {1, 2, 3, 4, 5, 6};
		IntStream s1 = Arrays.stream(numbers);
		Stream<String> s2 = Stream.of("111", "222", "333");

		// 通过构建器创建流
		Stream<Object> s3 = Stream.builder().add("111").add("222").add("333").build();

		//基于集合创建流
		List<String> lists = Arrays.asList("111", "222", "333");

		Stream<String> s4 = lists.stream();

		// 并行流
		Stream<String> s5 = lists.parallelStream();

		//空流
		Stream<Object> s6 = Stream.empty();

		// 基于函数创建无限流

		Stream.generate(() -> "number" + new Random().nextInt())
				.limit(10)
				.forEach(out::println);

		Stream.iterate(0, n -> n + 1).limit(10).forEach(out::println);

		IntStream.range(0, 10).forEach(out::println);
	}


	// ---------------------- 中间操作 开始 --------------------


	/**
	 * filter
	 * <p>
	 * filter方法是过滤器方法，针对的是流中所有元素，满足条件的元素将会被保留以组成新的流。
	 * filter方法的参数是Predicate类型，这个函数式接口用于获取一个参数返回一个boolean值，整个参数作为过滤条件。
	 */
	@Test
	public void streamTest_1() {
		result = lists.stream()
				.filter(e -> e.length() >= 4)    // 过滤掉长度小于4的元素
				.peek(out::println)  // 窥视中间流结果
				.collect(toList());
	}

	/**
	 * map
	 * <p>
	 * map方法可以理解为函数，需要针对流中的每个元素执行，然后将执行的结果组成新的流返回。
	 * map方法的参数类型为Function，该函数式接口用于接受一个参数，返回一个结果。
	 * <p>
	 * mapToInt、mapToLong、mapToDouble方法是map方法的扩展，
	 * 其参数分别为ToIntFunction、ToLongFunction、ToDoubleFunction，
	 * 分别接口一个参数，返回指定类型的值，分别为int、long、double，
	 * 那么定义方法的时候就要注意返回值的类型了，必须一致，
	 * 最后组成的新流就是一个int或long或double元素流（IntStream、LongStream、DoubleStream）。
	 */
	@Test
	public void streamTest_2() {
		result = lists.stream()
				.map(e -> "@" + e)
				.peek(out::println)
				.collect(toList());


		// mapToInt

		int[] ints = lists.stream()
				.mapToInt(e -> e.length())
				.peek(out::println)
				.toArray();
		out.println("ints = " + Arrays.toString(ints));
	}


	/**
	 * flatMap
	 * <p>
	 * flatMap和map还是有点关系的，都是针对流中的每一个元素进行操作，将结果组成新流，
	 * 不过flatMap含有一层扩展之意，就是当流中元素包含子元素的时候，
	 * 通过该方法，获取到元素的子元素，并将子元素组成新流返回。
	 */
	@Test
	public void streamTest_3() {
		result = lists.stream()
				.filter(e -> e.length() > 4)
				.peek(out::println)
				// 将每个字符串元素分解为字符串数组
				.map(e -> e.split(""))
				// 将每个字符串数组合并为流
				.flatMap(Arrays::stream)
				.peek(out::println)
				.collect(toList());
	}

	/**
	 * distinct
	 * distinct方法用于去重
	 */
	@Test
	public void streamTest_4() {
		result = lists.stream()
				.filter(e -> 4 <= e.length())
				.peek(out::println)
				.map(e -> e.split(""))
				.peek(e -> out.println(Arrays.toString(e)))
				.flatMap(Arrays::stream)
				.distinct()
				.peek(out::println)
				.collect(toList());
	}


	/**
	 * sorted
	 *
	 * sorted表示对流中的元素进行排序，需要使用Conparable和Comparator
	 * 当调用无参的sorted方法时，采用自然排序法排序，当使用指定比较器的方式时，可以自由指定排序规则
	 */
	@Test
	public void streamTest_5() {
		// 自然顺序
		out.println("自然顺序");
		result = lists.stream()
				.sorted()
				.peek(out::println)
				.collect(toList());

		out.println("result = " + result);
		// 指定顺序
		out.println("指定顺序");
		result = lists.stream()
				.sorted(Comparator.comparingInt(String::length).reversed())
				.peek(out::println)
				.collect(toList());
				
	}


	class MyRunnable implements Runnable{

		@Override
		public void run() {
			out.println("");
		}
	}

	@Test
	public void test() {

		MyRunnable myRunnable = new MyRunnable();


		Thread thread1 = new Thread(myRunnable);


		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {

			}
		});
		thread.start();
	}

	/**
	 * limit
	 * limit可用于从首个元素开始截取N个元素，组成新流返回
	 */
	@Test
	public void streamTest_6() {
		result = lists.stream()
				.limit(2)
				.peek(out::println)
				.collect(toList());
	}

	/**
	 * skip
	 * kip表示放弃N个元素，将剩余元素组成新流返回
	 */
	@Test
	public void streamTest_7() {
		result = lists.stream()
				.skip(2)
				.peek(out::println)
				.collect(toList());
	}

	// ---------------------- 中间操作 结束 --------------------

	// ---------------------- 终结操作 开始 --------------------

	/**
	 * forEach和forEachOrdered
	 *
	 * 二者都是遍历操作，从结果是可以看出来，如果是单线程（也就是不加parallel方法的情况）那么二者结果是一致的，
	 * 但是如果采用并行遍历，那么就有区别了，forEach并行遍历不保证顺序（顺序随机）,forEachOrdered却是保证顺序来进行遍历的。
	 */
	@Test
	public void streamTest_8() {
		lists.stream().forEach(out::println);
		out.println("===========");
		lists.stream().forEachOrdered(out::println);
		out.println("===========");
		lists.stream().parallel().forEach(out::println);
		out.println("===========");
		lists.stream().parallel().forEachOrdered(out::println);
	}

	/**
	 * toArray
	 *
	 * 有两个方法，一个是无参方法，一个有参方法。
	 *
	 * 无参方法返回的只能是Object[]数组类型，而有参方法，可以指定结果数组类型，此乃二者区别。
	 *
	 * 使用有参方法可以直接完成类型转换，一次到位。
	 */
	@Test
	public void streamTest_9() {
		Object[] objects = lists.stream().toArray();
		out.println("objects = " + Arrays.toString(objects));

		String[] array = lists.stream().toArray(String[]::new);
		out.println("Arrays.toString(array) = " + Arrays.toString(array));
	}

	/**
	 * reduce
	 *
	 * Optional<T> reduce(BinaryOperator<T> accumulator); // 编号1
	 * T reduce(T identity, BinaryOperator<T> accumulator); // 编号2
	 * <U> U reduce(U identity,
	 *                  BiFunction<U, ? super T, U> accumulator,
	 *                  BinaryOperator<U> combiner); // 编号3
	 *
	 * 编号1，只有一个参数accumulator，这是一个累加器，
	 * 方法的作用就是将这个累加器作用到流中的每一个元素，
	 * 他需要两个输入参数，有一个输出参数，意思是对两个元素执行某些操作，返回一个结果，
	 * 然后将这个结果与下一个元素作为参数再输入该方法，执行操作后再返回一个新结果，以此类推，
	 * 直到最后一个元素执行完毕，返回的就是最终结果，因为流中的元素我们是不确定的，
	 * 那么我们就无法确定reduce的结果，因为如果流为空，那么将会返回null，
	 * 所以使用Optional作为返回值，妥善处理null值。
	 *
	 * 编号2，在编号1方法的基础上加了一个identity，且不再使用Optional，为什么呢，
	 * 因为新加的identity其实是个初始值，后续的操作都在这个值基础上执行，
	 * 那么也就是说，，如果流中没有元素的话，还有初始值作为结果返回，不会存在null的情况，
	 * 也就不用Optional了。
	 *
	 * 编号3，在编号2方法的基础上又加了一个参数combiner，其实这个方法是用于处理并行流的归纳操作，
	 * 最后的参数combiner用于归纳各个并行的结果，用于得出最终结果。
	 *
	 */
	@Test
	public void streamTest_10() {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Optional<Integer> reduce = integers.stream()
				.reduce(Integer::sum);

		out.println("reduce.get() = " + reduce.get());

		out.println("=============================");

		String reduce1 = integers.stream()
				.map(Object::toString)
				.reduce("", String::concat);
		out.println("reduce1 = " + reduce1);

		out.println("=============================");

		Integer reduce2 = integers.parallelStream().reduce(Integer.MAX_VALUE, Integer::min, Integer::min);
		out.println("reduce2 = " + reduce2);

	}

	/**
	 * max/min
	 *
	 * 通过给定的比较器，得出流中最大\最小的元素，为避免null返回，这里使用Optional来封装返回值。
	 */
	@Test
	public void streamTest_11() {
		Optional<String> max = lists.stream().max(Comparator.comparing(String::length));
		max.ifPresent(out::println);

		Optional<String> min = lists.stream().min(Comparator.comparing(String::length));
		min.ifPresent(out::println);
	}

	/**
	 * count
	 * count是无参方法，用于计数，返回流中元素个数。
	 */
	@Test
	public void stramTest_12() {
		long count = lists.stream().count();
		out.println("count = " + count);
	}

	/**
	 * anyMatch
	 * 该方法需要一个Predicate参数，用于校验流中的元素，只要有一个满足规则，则返回true，全不满足，返回false。
	 *
	 * allMatch
	 * 该方法同样需要一个Predicate参数，用于校验流中的所有元素，只有全部满足规则才能返回true，只要有一个不满足则返回false
	 *
	 * noneMatch
	 * 该方法同样需要一个Predicate参数，用于校验流中的所有元素,只有所有元素都不满足规则的情况下返回true，否则返回false。
	 *
	 */
	@Test
	public void streamTest_13() {
		out.println(lists.stream().anyMatch(e -> e.length() > 10));

		out.println(lists.stream().allMatch(e -> e.length() > 1));

		out.println(lists.stream().noneMatch(e -> e.length() > 10));
	}

	/**
	 * findFirst
	 *
	 * 该方法无参数，主要用于获取流中的第一个元素，如果流无序，那么可能返回任意一个。
	 */
	@Test
	public void streamTest_14() {
		lists.stream()/*.parallel()*/.findFirst().ifPresent(out::println);
	}

	/**
	 * findAny
	 *
	 * 该方法无参数，主要用于获取流中的任一元素。
	 */
	@Test
	public void stramTest_15() {
		lists.stream()/*.parallel()*/.findAny().ifPresent(out::println);
	}




}
