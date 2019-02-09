package com.zhentao.review.google.high;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * <b>815. Bus Routes</b>
 * 
 * <pre>
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.

Example:
Input: 
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation: 
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
Note:

1 <= routes.length <= 500.
1 <= routes[i].length <= 500.
0 <= routes[i][j] < 10 ^ 6.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class BusRoutes {
    public int numBusesToDestination(final int[][] routes, final int S, final int T) {
        if (S == T) {
            return 0;
        }
        final int length = routes.length;
        final Bus[] buses = new Bus[length];
        final Queue<Bus> queue = new ArrayDeque<>();
        final HashSet<Bus> target = new HashSet<>();
        
        for (int i = 0; i < length; i++) {
            final Bus bus = new Bus(routes[i]);
            buses[i] = bus;
            if (bus.contains(S)) {
                bus.visited=true;
                queue.add(bus);
            }

            if (bus.contains(T)) {
                target.add(bus);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                buses[i].link(buses[j]);
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            answer++;
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final Bus bus = queue.poll();
                if (target.contains(bus)) {
                    return answer;
                }
                for (final Bus neighbor : bus.neighbors) {
                    if (!neighbor.visited) {
                        queue.add(neighbor);
                        neighbor.visited = true;
                    }
                }
            }
        }
        return -1;
    }
}

class Bus {
    HashSet<Integer> routes;
    HashSet<Bus> neighbors;
    boolean visited;

    Bus(final int[] routes) {
        this.neighbors = new HashSet<>();
        this.routes = new HashSet<>();
        for (final int route : routes) {
            this.routes.add(route);
        }
    }

    void link(final Bus other) {
        for (final Integer route : other.routes) {
            if (contains(route)) {
                neighbors.add(other);
                other.neighbors.add(this);
                return;
            }
        }
    }

    boolean contains(final Integer stop) {
        return routes.contains(stop);
    }
}
