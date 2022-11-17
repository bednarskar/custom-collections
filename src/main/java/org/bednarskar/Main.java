package org.bednarskar;

import org.bednarskar.collections.List;
import org.bednarskar.collections.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Custom stack implementation");
        Stack<String> stack = new Stack<>(5);
        for (int i = 0; i < 10; i++) {
            stack.push("a" + i);
        }
        System.out.println("initial stack: " + stack +
                "\npop element: " + stack.pop() +
                "\nafter pop: " + stack +
                "\npeek element: " + stack.peek() +
                "\nafter peek: " + stack);

        System.out.println("Custom list implementation");
        List<String> list = new List<>();
        for (int j = 0; j < 10; j++) {
            String el = "b" + j;
            list.add(el);
        }
        System.out.println("initial list: " + list);
        list.add("b10");
        System.out.println("after add: " + list);
        list.add(2, "replaced");
        System.out.println("after replace: " + list);
        System.out.println("size: " + list.size());
        list.remove(2);
        System.out.println("after remove: " + list);
        System.out.println("size: " + list.size());
        System.out.println("list[1]: " + list.get(1));
    }
}