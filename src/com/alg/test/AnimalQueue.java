/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.LinkedList;

class Animal {

    String name;
    int order;

    public Animal(String n) {
        name = n;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setOrder(int o) {
        order = o;
    }

    public int getOrder() {
        return order;
    }

    public String toString() {
        return name + "," + order;
    }
}

class Dog extends Animal {

    public Dog(String a) {
        super(a);
    }
}

class Cat extends Animal {

    public Cat(String a) {
        super(a);
    }

}

public class AnimalQueue {

    LinkedList<Cat> cats = new LinkedList<Cat>();
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order++);
        if (a instanceof Dog) {
            //add to dog queue
            dogs.add((Dog)a);
        } else {
            cats.add((Cat)a);
        }
    }

    public Cat dequeueCat() throws Exception {
        if (cats.isEmpty()) {
            throw new Exception("Cat queue is empty");
        }
        return cats.removeFirst();
    }

    public Dog dequeueDog() throws Exception {
        if (dogs.isEmpty()) {
            throw new Exception("Dog queue is empty");
        }
        return dogs.removeFirst();
    }

    public Animal dequeueAny() throws Exception {
        //get the animal with smallest id
        if (cats.isEmpty() && dogs.isEmpty()) {
            throw new Exception("animal queue is empty");
        } else if (cats.isEmpty()) {
            return dogs.removeFirst();
        } else if (dogs.isEmpty()) {
            return cats.removeFirst();
        } else {
            return cats.peek().getOrder() < dogs.peek().getOrder() ? cats.removeFirst() : dogs.removeFirst();
        }
    }

    public static void main(String args[]) throws Exception {

        Cat c1 = new Cat("cat1");
        Cat c2 = new Cat("cat2");
        Cat c3 = new Cat("cat3");
        Dog d1 = new Dog("dog1");
        Dog d2 = new Dog("dog2");
        Dog d3 = new Dog("dog3");
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(c1);
        animals.enqueue(c2);
        animals.enqueue(d1);
        animals.enqueue(d2);
        animals.enqueue(c3);
        animals.enqueue(d3);
        //now lets dequeu the animals
        Animal a = animals.dequeueAny();
        System.out.println("dequeue any:" + a.toString());
        a = animals.dequeueCat();
        System.out.println("dequeue cat:" + a.toString());
        a = animals.dequeueCat();
        System.out.println("dequeue cat:" + a.toString());
        a = animals.dequeueAny();
        System.out.println("dequeue any:" + a.toString());
        a = animals.dequeueAny();
        System.out.println("dequeue any:" + a.toString());

    }

}
