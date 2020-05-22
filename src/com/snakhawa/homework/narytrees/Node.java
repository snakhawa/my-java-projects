package com.snakhawa.homework.narytrees;

import com.snakhawa.homework.linkedlist.State;

import java.util.ArrayList;
import java.util.List;

public class Node {

    List<Node> neighbors;
    int data;
    State state;

    public Node(int data) {
        super();
        this.data = data;
        state = State.NOT_VISITED;
        neighbors = new ArrayList<Node>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void addNeighbor(Node node) {
        neighbors.add(node);
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }
}
