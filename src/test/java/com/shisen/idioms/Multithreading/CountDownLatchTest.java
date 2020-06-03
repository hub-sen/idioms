package com.shisen.idioms.Multithreading;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/6/3 10:07
 * </pre>
 */
public class CountDownLatchTest {


    @Test
    public void startTest() throws InterruptedException, ExecutionException {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "施森1"));
        students.add(new Student(2, "施森2"));
        students.add(new Student(3, "施森3"));
        students.add(new Student(4, "施森4"));
        students.add(new Student(5, "施森5"));

        start(students);


    }


    //开始多线程任务
    public void start(List<Student> list) throws InterruptedException, ExecutionException {
        List<String> tasks1 = tasks(list);

        System.out.println("tasks1 = " + tasks1);

    }


    //执行多线程任务
    public List<String> tasks(List<Student> list) throws InterruptedException, ExecutionException {
        List<String> result = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(30);

        List<Callable<String>> collables = list.stream().<Callable<String>>map(student -> () -> Thread.currentThread()
                .getName() + "--" + student.getNo()).collect(Collectors.toList());

        List<Future<String>> futures = pool.invokeAll(collables);

        for (Future<String> future : futures) {
            String s = future.get();
            result.add(s);
        }

        return result;
    }
}
