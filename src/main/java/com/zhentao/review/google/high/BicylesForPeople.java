package com.zhentao.review.google.high;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import com.google.common.base.Objects;

/**
 * <pre>
 * 1.自行车和人匹配问题 (高频 143次) 
自行车这道题目如果有同学能提供KM算法（匈牙利算法）的实现请直接修改doc

Update time ：【 2018-10-19】
2D平面上，有m个人（P），n辆自行车(B)，还有空白（O）满足以下条件
1.m < n
2.不存在两个人，到同一辆自行车距离相等, 距离用abs(x1-x2) + abs(y1-y2)定义
3.每个人尽量找离自己最近的自行车，一旦某辆自行车被占，其他人只能找别的自行车。
例：
OPOBOOP
OOOOOOO
OOOOOOO
OOOOOOO
BOOBOOB
红色的人(0,1)找到第一行的自行车，距离最近。
蓝色的人(0,6)离第一行自行车最近，但自行车已经被红色人占有，所以他只能找离他第二近的，右下角的自行车。

问：把人和自行车配对，输出vector<pair<int, int>>每个人对应的自行车. {i, j} 是人i对应自行车j
wtcupup 发表于 2018
大米已加， 求问自行车分配问题的思路？
可以搞几个priority_queue<距离，人，车>
然后遍历m个人，n辆车，把m*n个 距离，人，车放入其中。
每次取出距离最小的，看看这个人是否已经分配了自行车
如果没有分配，则可以把这个人和这辆车输出
 * 
 * Editor: 是的 车比人多 enum出所有人车匹配并排序 后从小网大排序输出 用双set去重就好 不是难题
所以这道题跟bfs/dfs没关系，就直接heap不停poll,然后用set来记录bike和people被visited 即可
 * 
 * 
 * </pre>
 * 
 * @author zhentao
 *
 */
public class BicylesForPeople {
    List<Pair> find(final char[][] input) {
        final HashSet<Point> people = new HashSet<>();
        final HashSet<Point> bicycles = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 'P') {
                    people.add(new Point(i, j));
                } else if (input[i][j] == 'B') {
                    bicycles.add(new Point(i, j));
                }
            }
        }
        final PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        for (final Point p : people) {
            for (final Point b : bicycles) {
                final int distance = distance(p,b, input);
                queue.add(new Pair(p, b, distance));
            }
        }
        final ArrayList<Pair> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            final Pair pair = queue.poll();
            if (people.contains(pair.person) && bicycles.contains(pair.bike)) {
                list.add(pair);
                people.remove(pair.person);
                bicycles.remove(pair.bike);
            }
        }
        return list;
    }
    /**
     * update this method for cases with obstacles 
     * use BFS to calculate distance
     * @param p1
     * @param p2
     * @param input
     * @return
     */
    int distance(final Point p1, final Point p2, final char[][] input) {
        return p1.distanceTo(p2);
    }
}

class Pair {
    Point person;
    Point bike;
    int distance;

    Pair(final Point person, final Point bike) {
        this.person = person;
        this.bike = bike;
        distance = person.distanceTo(bike);
    }

    /**
     * if there are obstacles, use this constructor.
     * use BFS to calculate distance first
     * @param person
     * @param bike
     * @param distance
     */
    Pair(final Point person, final Point bike, final int distance) {
        this.person = person;
        this.bike = bike;
        this.distance = distance;
    }
    @Override
    public String toString() {
        return "person: " + person + " bike: " + bike + " distance: " + distance;
    }

    @Override
    public boolean equals(final Object other) {
        final Pair that = (Pair) other;
        return this.person.equals(that.person) && this.bike.equals(that.bike) && this.distance == that.distance;
    }
}

class Point {
    int x;
    int y;

    Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    int distanceTo(final Point other) {
        return Math.abs(x - other.x) + Math.abs(y - other.y);
    }

    @Override
    public String toString() {
        return "x=" + x + " y=" + y;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y);
    }

    @Override
    public boolean equals(final Object other) {
        final Point that = (Point) other;
        return this.x == that.x && this.y == that.y;
    }
}
