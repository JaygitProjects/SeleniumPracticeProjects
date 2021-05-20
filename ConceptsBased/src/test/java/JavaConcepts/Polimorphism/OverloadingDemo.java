package JavaConcepts.Polimorphism;

import JavaConcepts.Family;

public class OverloadingDemo {
    public void run(){
        System.out.println("I am running");
    }
    public void run(String name){
        System.out.println( name + " is running");
    }
    public void run(String name , int age){
        System.out.println(name + " whose age is " + age + " , is running  ");
    }
    public void run(Family MyFamily){
        System.out.println("My Family :" + MyFamily);

    }
    public static void main(String[] args) {
        OverloadingDemo od = new OverloadingDemo();
        od.run();
        od.run("Jayanthi");
        od.run("Jayanthi",35);

    }
}
