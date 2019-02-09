package com.zhentao.review.google.high;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * <pre>
 * void birth(String parent, String name) 父亲名字和孩子名字，生个娃 
 * void death(String name) 此人要死 
 * List<String> getOrder() 返回当前的继承顺序，string array/list
 * 
 * Implement FamilyTree interface. Interface includes 3 functions, 
 * birth(String parent, String child), 
 * death(String person), 
 * List<String> getOrderOfSuccessor().  
 * The last function returns a list of live person IDs, in the 
 * order of "DFS + older child comes first".
 * </pre>
 * 
 * 讨论得知，每个人的名字是唯一的，继承顺序符合如下规律:
 * 假设王有大皇子二皇子三皇子，大皇子有长子次子三子，那么继承顺序是王->大皇子->大皇子长子->大皇子次子->大皇子三子->二皇子->三皇子
 * 死掉的人不能出现在继承顺序里，但是如果上面例子中大皇子死了，只需把大皇子移除，原始继承顺序保持不变：
 * 王->大皇子长子->大皇子次子->大皇子三子->二皇子->三皇子
 * 
 * 三个function会被反复调用，实现function细节。
 * 
 * @author zhentao
 *
 */
public class SuccessorOrder {
    HashMap<String, Family> map = new HashMap<>();
    HashSet<String> dead = new HashSet<>();

    public SuccessorOrder() {
        map.put("king", new Family("king"));
    }

    public void birth(final String parent, final String name) {
        if (!map.containsKey(parent)) {
            throw new IllegalArgumentException("Parent " + parent + " doesn't exist");
        }
        map.get(parent).sons.add(name);
        map.put(name, new Family(name));
    }

    public void death(final String name) {
        dead.add(name);
    }

    public List<String> getOrder() {
        final List<String> order = new ArrayList<>();
        dfs("king", order);
        return order;
    }

    private void dfs(final String current, final List<String> list) {
        if (!dead.contains(current)) {
            list.add(current);
        }
        for (final String son : map.get(current).sons) {
            dfs(son, list);
        }
    }

    class Family {
        String parent;
        ArrayDeque<String> sons;
        String name;

        Family(final String parent) {
            this.name = parent;
            sons = new ArrayDeque<>();
        }
    }
}
