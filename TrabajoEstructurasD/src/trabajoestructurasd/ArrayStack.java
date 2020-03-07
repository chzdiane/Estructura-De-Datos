/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoestructurasd;

/**
 *
 * @author Dianella
 */
public class ArrayStack {
    
    private Object[] data;
    private int max;
    private int top;

    public ArrayStack(int n) {
        max = n;
        top = 0;
        data = new Object[n];
    }
    
    public boolean empty() {
        return top == 0;
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
    
    public Object push(Object item) {

        if (top == max) {
            return null;
        } else {
            data[top++] = item;
            return item;
        }
    }
    
}
