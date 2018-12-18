package com.zhentao.review.cracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetPath {
	public static void main(String[] args) {
		boolean[][] maze = new boolean[3][3];
		for (boolean[] row : maze) {
			Arrays.fill(row, true);
		}
		maze[1][0] = false;
		System.out.println(getPath(maze));
	}
	static class Point {
		private int r;
		private int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override 
		public String toString() {
			return "r: " + r + " c: " + c;
		}
	}
	
	public static List<Point> getPath(boolean[][] maze) {
		ArrayList<Point> path = new ArrayList<>();
		if (getPath(maze, maze.length-1, maze[0].length-1, path)) {
			return path;
		}
		return null;
	}

	private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		if (row < 0 || col < 0 || !maze[row][col]) {
			return false;
		}
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		if (isAtOrigin || getPath(maze, row, col-1, path) || getPath(maze, row-1, col, path)) {
			path.add(new Point(row, col));
			return true;
		}
		return false;
	}
}
