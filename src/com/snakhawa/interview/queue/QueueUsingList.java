package com.snakhawa.interview.queue;

import java.util.LinkedList;

public class QueueUsingList {

    LinkedList<Integer> list;

    public QueueUsingList(){
        list = new LinkedList<>();
    }


    public void add(int n){
        if(list.isEmpty()){
            list.add(n);
        } else
        {
            list.addLast(n);
        }
    }

    public int remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("No element in the list");
        }
        return list.removeFirst();
    }
}
