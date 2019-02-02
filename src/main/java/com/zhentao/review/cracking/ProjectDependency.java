package com.zhentao.review.cracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given a list of projects and a list of dependencies (which is a list
 * of pairs of projects, where the second project is dependent on the first
 * project). All of a project's dependencies must be built before the project
 * is. Find a build order that will allow the projects to be built. If there is
 * no valid build order, return an error. EXAMPLE Input: projects: a, b, c, d,
 * e, f dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) Output: f, e, a, b,
 * d, c
 * 
 * @author zhentao
 *
 */
public class ProjectDependency {

    public boolean isBuidable(final String[][] dependencies) {
        final HashSet<String> tasks = new HashSet<>();
        final HashMap<String, HashSet<String>> links = new HashMap<>();
        for (final String[] dep : dependencies) {
            tasks.add(dep[0]);
            tasks.add(dep[1]);
            links.computeIfAbsent(dep[0], k -> new HashSet<>()).add(dep[1]);
            links.computeIfAbsent(dep[1], k -> new HashSet<>());//create an empty dependency link for this task
        }
        final Set<String> visiting = new HashSet<>(); 
        final Set<String> finished = new HashSet<>();
        for(final String task : tasks) {
            if(detectCycle(task, visiting, finished, links)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * DFS to detect cycles in a graph
     * @param task
     * @param visiting
     * @param finished
     * @param links
     * @return true if cycle is detected.
     */
    boolean detectCycle(final String task, final Set<String> visiting, final Set<String> finished,
            final HashMap<String, HashSet<String>> links) {
        if (visiting.contains(task)) {
            return true;
        }
        if (!finished.contains(task)) {
            visiting.add(task);
            for (final String dep : links.get(task)) {
                final boolean result = detectCycle(dep, visiting, finished, links);
                if (result) {
                    return true;
                }
            }
            finished.add(task);
            visiting.remove(task);
        }
        return false;
    }
}
