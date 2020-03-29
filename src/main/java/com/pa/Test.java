package com.pa;

import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }

        int count = 0;

        while (!linkedList.isEmpty()){
            Integer poll = linkedList.poll();
            count ++;
            if (count % 10 ==0){
                System.out.println(poll);
            }else {
                linkedList.add(poll);
            }
        }
    }
}
