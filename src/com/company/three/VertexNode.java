package com.company.three;

import java.util.HashSet;
import java.util.Set;

public class VertexNode {
    public int id;
    public int cost;
    public Set<VertexNode> children = null;
    public VertexNode parent = null;

    public VertexNode(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    public void addChild(VertexNode child) {
        if (this.children == null) {
            this.children = new HashSet<>();
        }
        this.children.add(child);
    }
}
