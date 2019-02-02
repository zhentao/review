package com.zhentao.review.cracking;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class ProjectDependencyTest {
    @Test
    public void test() {
        final ProjectDependency dependency = new ProjectDependency();
         String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        assertThat(dependency.isBuidable(dependencies ), is(true));
        
        dependencies = new String[][]{{"a", "d"}, {"f", "b"}, {"b", "a"}, {"d", "b"}};
        assertThat(dependency.isBuidable(dependencies ), is(false));
    }
}
