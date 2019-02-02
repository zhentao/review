package com.zhentao.review.google.high;

import java.util.HashSet;
import java.util.Set;

public class FamilyTree {
    public boolean isRelated(final FamilyNode n1, final FamilyNode n2) {
        if (n1 == n2) {
            return true;
        }
        final Set<FamilyNode> set = new HashSet<>();
        preorder(n1, set);
        
        return isRelated(n2, set);
        
    }
    
    void preorder(final FamilyNode node, final Set<FamilyNode> set) {
        if (node == null) {
            return;
        }
        set.add(node);
        preorder(node.dad, set);
        preorder(node.mom,set);
    }
    
    boolean isRelated(final FamilyNode node, final Set<FamilyNode> set) {
        if (node == null) {
            return false;
        }
        if (set.contains(node)) {
            return true;
        }
        if (isRelated(node.dad, set)) {
            return true;
        }
        if (isRelated(node.mom, set)) {
            return true;
        }
        return false;
    }
}

class FamilyNode {
    String name;
    FamilyNode dad;
    FamilyNode mom;

    FamilyNode(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}