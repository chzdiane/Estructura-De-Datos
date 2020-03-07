/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casopracticostack;

/**
 *
 * @author Dianella
 */
public class ArrayStack {
    private Object[] data;
    private int max;
    private int min;
    private int top;
    private int tail;

    public ArrayStack(int n) {
        max = n;
        min = -1;
        top = 0;
        tail = n - 1;
        data = new Object[n];
    }

    public boolean empty() {
        return top == 0 && tail == max - 1;
    }

    public Object peek() {
        return data[top - 1];
    }
    
    public Object pop() {
        if (empty()) {
            return null;
        } else {
            Object dataTemp = data[--top];
            data[top] = null;
            return dataTemp;
        }
    }

    public Object pop1() {
        if (empty()) {
            return null;
        } else if (top == 0) {
            return null;
        } else {
            Object dataTemp = data[--top];
            data[top] = null;
            return dataTemp;
        }
    }

    public Object pop2() {
        if (empty()) {
            return null;
        } else if (tail == max - 1) {
            return null;
        } else {
            Object dataTemp = data[++tail];
            data[tail] = null;
            return dataTemp;
        }
    }

    public Object push(Object item) {

        if (top == max) {
            return null;
        } else {
            data[top++] = item;
            return item;
        }
    }

    public Object push1(Object item) {
        if (isFull()) {
            return null;
        } else if (top == tail && data[top] != null) {
            return null;
        } else {
            data[top++] = item;
            return item;
        }
    }

    public Object push2(Object item) {
        if (isFull()) {
            return null;
        } else if (top == tail && data[top] != null) {
            return null;
        } else {
            data[tail--] = item;
            return item;
        }
    }

    public boolean isFull() {
        if(top == max){
            return true;
        }else if(tail == min){
            return true;
        }else if(top == tail && data[top] != null){
            return true;
        }
        return false;
        //return top - tail == 1;
    }
}
