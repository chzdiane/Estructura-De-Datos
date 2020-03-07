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
public class ArrayQueue {
    
    private Object[] ArrayQ;
    private int max, head, tail, totalN;

    public ArrayQueue(int n) {
        ArrayQ = new Object[n];
        head = tail = totalN = 0;
        max = n;
    }

    public boolean empty() {
        return totalN == 0;
    }

    public boolean full() {
        return totalN == max;
    }

    public boolean add(Object e) throws Exception {
        if (full()) {
            throw new Exception("Cola llena");
        } else if (tail == max && head != 0) {
            ArrayQ[0] = e;
            tail = 1;
        } else {
            ArrayQ[tail++] = e;
        }
        totalN++;
        return true;
    }

    public Object remove() throws Exception {
        Object dataTemp;
        if (empty()) {
            throw new Exception("Cola vacia");
        } else if (head == max) {
            dataTemp = ArrayQ[0];
            ArrayQ[0] = null;
            head = 1;
        } else {
            dataTemp = ArrayQ[head];
            ArrayQ[head++] = null;
        }
        totalN--;
        return dataTemp;
    }

    public boolean isEmpty() {
        return head == tail && totalN == 0;
    }
}
