package org.bednarskar.collections;

import java.util.Arrays;

// push pop peek
public class Stack<T> {

    private T[] stackArray;
    private int size;
    private int topIdx;

    public Stack(int initialSize) {
        this.stackArray = (T[]) new Object[initialSize];
        this.size = initialSize;
        this.topIdx = -1;
    }

    public Stack() {
        this.stackArray = (T[]) new Object[5];
        this.size = 5;
        this.topIdx = -1;
    }

    public void push(T data) {
        if (isFull()) {
            increaseCapacity();
        }
        this.stackArray[++topIdx] = data;
    }

    //TODO implement decreaseSize method to decrease stack size and rebuild the stack on remove
    /**
     * Returns top element and removes it from stack
     *
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            throw  new RuntimeException("Stack underflow");
        }
        this.topIdx = this.topIdx - 1;
        return this.stackArray[this.topIdx + 1];
    }

    /**
     * Returns top element without decreasing the topIdx
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return stackArray[topIdx];
    }

    public boolean isEmpty() {
        return topIdx == -1;
    }
    private void increaseCapacity() {
        int newSize = this.size * 2;
        T[] arrWithIncreasedCapacity = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            arrWithIncreasedCapacity[i] = this.stackArray[i];
        }
        this.stackArray = arrWithIncreasedCapacity;
        this.size = newSize;

    }

    private boolean isFull() {
        return topIdx == size - 1;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0; i<=topIdx; i++) {
            stringBuffer.append(stackArray[i]).append(",");
        }
        return stringBuffer.toString();
    }
}
