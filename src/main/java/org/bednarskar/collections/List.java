package org.bednarskar.collections;

import javax.print.attribute.standard.JobKOctets;
import java.util.Arrays;

public class List<T> {

    private T[] array;
    private int size;
    private int capacity;

    public List() {
        this.capacity = 5;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void add(T element) {
        this.size += 1;
        if (isFull()) {
            increaseCapacity();
        }
        array[size - 1] = element;

    }

    public void add(int idx, T element) {
        if (idx > size - 1)  {
            throw new RuntimeException("Array idx out of bounds");
        }
        this.array[idx] = element;
    }

    public T get(int idx) {
        if (idx > size - 1) {
            throw new RuntimeException("Array idx out of bounds");
        }
        return array[idx];
    }

    public void remove(int idx) {
        int newSize = this.size - 1;
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(this.array, 0, newArray, 0, idx);
        System.arraycopy(this.array, idx + 1, newArray, idx, this.size - idx - 1);
        this.size = newSize;
        this.array = newArray;
    }

    public int size() {
        return this.size;
    }
    private boolean isFull() {
        return this.size == this.capacity;
    }
    private void increaseCapacity() {
        this.capacity = capacity * 2;
        T[] newArray = (T[]) new Object[this.capacity];
        for (int i = 0; i< array.length; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0; i < size; i++) {
            stringBuffer.append(array[i]).append(",");
        }
        return stringBuffer.toString();
    }
}
