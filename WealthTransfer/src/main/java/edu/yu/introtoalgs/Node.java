package edu.yu.introtoalgs;

import java.util.*;

public class Node {
    private double minWealth;
    private int id;
    private int percent;
    private boolean squared;
    private List<Node> child = new ArrayList<>();

    public Node(int id, int percent, boolean squared){
        this.id = id;
        this.percent = percent;
        this.squared = squared;
    }

    public void setMinWealth(double minWealth){
        this.minWealth = minWealth;
    }

    public double getMinWealth(){
        return minWealth;
    }

    public int getId(){
        return id;
    }

    public int getPercent(){
        return percent;
    }

    public boolean getSquared(){
        return squared;
    }
    public void addChild(Node child){
        this.child.add(child);
    }

    public List<Node> getChildren(){
        return child;
    }


}
