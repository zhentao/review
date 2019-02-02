package com.zhentao.review.google.high;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FamilyTreeTest {
    @Test
    public void test() {
        final FamilyTree family = new FamilyTree();
        final FamilyNode n1 = new FamilyNode("tom");
        final FamilyNode n2 = new FamilyNode("jack");
        final FamilyNode p1 = new FamilyNode("p1");
        final FamilyNode p2 = new FamilyNode("p2");
        final FamilyNode grandpa = new FamilyNode("g1");
        n1.dad = p1;
        n2.dad = p2;
        n1.dad.dad = grandpa;
        n2.dad.dad = grandpa;

        assertThat(family.isRelated(n1, n2), is(true));
        
        n2.dad.dad = new FamilyNode("g2");
        assertThat(family.isRelated(n1, n2), is(false));
    }
}
