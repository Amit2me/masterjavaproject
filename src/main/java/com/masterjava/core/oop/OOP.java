package com.masterjava.core.oop;

/**
 * Object-Oriented Programming - Core concept
 * Learn: Classes, Objects, Inheritance, Polymorphism
 */
public class OOP {
    
    // Example class
    static class Person {
        String name;
        int age;
        
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        void display() {
            System.out.println("  Person: " + name + ", Age: " + age);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║  Core Java - Object-Oriented Programming               ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("Creating Objects:");
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 30);
        
        p1.display();
        p2.display();
        
        System.out.println("\n✅ Objects created successfully!\n");
    }
}
