package com.shisen.aobing.threadlocal;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/21 11:21
 * </pre>
 */
public class ThreadLocalTest05 {

    public static void main(String[] args) {
        Student student = init();
        new NameService().getName(student);
        new SexService().getSex(student);
        new ScoreService().getScore(student);
        System.out.println("======");
        new NameService().getName();
        new SexService().getSex();
        new ScoreService().getScore();

    }


    private static Student init(){
        Student student1 = new Student();
        student1.name = "vbcjrj";
        student1.sex = "female";
        student1.score = "100";
        Student student2 = new Student();
        student2.name = "us";
        student2.sex = "male";
        student2.score = "100";
        ThreadLocalProcessor.studentThreadLocal.set(student1);
        ThreadLocalProcessor.studentThreadLocal.set(student2);
        return student1;
    }


}


class ThreadLocalProcessor {
    public static ThreadLocal<Student> studentThreadLocal = new ThreadLocal<>();
}

class Student{
    String name;
    String sex;
    String score;
}

class NameService{

    public void getName(Student student){
        System.out.println("student.name = " + student.name);
    }

    public void getName(){
        System.out.println("student.name = " + ThreadLocalProcessor.studentThreadLocal.get().name);
    }

}

class SexService{

    public void getSex(Student student){
        System.out.println("student.sex = " + student.sex);
    }

    public void getSex(){
        System.out.println("student.sex = " + ThreadLocalProcessor.studentThreadLocal.get().sex);
    }

}

class ScoreService{

    public void getScore(Student student){
        System.out.println("student.score = " + student.score);
    }

    public void getScore(){
        System.out.println("student.score = " + ThreadLocalProcessor.studentThreadLocal.get().score);
    }

}
