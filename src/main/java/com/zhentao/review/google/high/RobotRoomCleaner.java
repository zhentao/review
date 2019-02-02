package com.zhentao.review.google.high;

import java.util.HashSet;
import java.util.Set;

/**
 * <b>489. Robot Room Cleaner</b>
 * 
 * <pre>
 * Given a robot cleaner in a room modeled as a grid.

Each cell in the grid can be empty or blocked.

The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.

When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.

Design an algorithm to clean the entire room using only the 4 given APIs shown below.

interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}
Example:

Input:
room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3

Explanation:
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.
Notes:

The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
The robot's initial position will always be in an accessible cell.
The initial direction of the robot will be facing up.
All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
Assume all four edges of the grid are all surrounded by wall.
 * </pre>
 * 
 * @author zhentao
 *
 */
public class RobotRoomCleaner {
    public void cleanRoom(final Robot robot) {
        final HashSet<Node> visited = new HashSet<>();
        swipe(robot, visited, 0,0,0);
    }

    public int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    private void swipe(final Robot r, final Set<Node> visited, final int currentDirection, final int row, final int col) {
        Node node = new Node(row, col);
        visited.add(node);
        r.clean();
        for (int i = 0; i < 4; i++) {
            final int direction = (currentDirection + i) % 4;
            final int[] next = directions[i];
            final int nextRow = row + next[0];
            final int nextCol = col + next[1];
            node = new Node(nextRow, nextCol);
            if (!visited.contains(node) && r.move()) {
                swipe(r, visited, direction, nextRow, nextCol);
                r.turnLeft();// 结束上次的扫描，回头
                r.turnLeft();
                r.move();
                r.turnLeft();
                r.turnLeft();// 恢复到上个循环的下次扫描
            } else {
                r.turnRight();// 直接跳到下次扫描
            }
        }
    }
    
    static class Node {
        int row;
        int col;
        public Node(final int row, final int col) {
            this.row = row;
            this.col = col;
        }
    }
}

interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
}
