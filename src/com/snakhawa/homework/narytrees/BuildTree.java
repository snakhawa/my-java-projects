package com.snakhawa.homework.narytrees;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {

    public static void main(String[] args) {

        build(11, 10);
    }

    public static Node build(int n, int nodeParent){
        if(n < 1) return null;
        Node root = new Node(1);
        Node ans = null;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);


        int nodeCount = 1;
        int startData = 2;

        while( !q.isEmpty()){
            Node cur = q.remove();
            for(int i =0 ; i < cur.data; i++){
                if(nodeCount == n){
                    emptyQueue(q);
                    break;
                }
                Node neighbor = new Node(startData);
                cur.neighbors.add(neighbor);
                q.add(neighbor);
                if(startData == nodeParent){
                    ans = cur;
                }
                startData++;
                nodeCount++;
            }

        }

        return root;
    }

    public static void emptyQueue(Queue<Node> q){
        while(!q.isEmpty()){
            q.poll();
        }
    }
}
