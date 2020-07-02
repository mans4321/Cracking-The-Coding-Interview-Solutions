package cci.chapters.recursion8dynamicProgramming;

import java.util.Arrays;

public class RobotInGrid
{
    /*
        Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
        The robot can only move in two directions, right and down, but certain cells are "off limits" such that
        the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
        the bottom right.

        Hints: #331, #360, #388
    */

    final int END = 2;

    final int PATH = 3;

    final int NOT_PATH = 4;

    public int[][] sol1(int matrix[][]) // O(N*M) time O(N + M)
    {
        if (matrix == null || matrix[0] == null)
        {
            throw new IllegalArgumentException();
        }

        findPath(matrix, 0, 0);
        return matrix;
    }

    private boolean findPath(int[][] matrix, int r, int c)
    {
        if (isOutOfBoundary(matrix, r, c))
        {
            return false;
        }

        int curr = matrix[r][c];
        if (isCurrentTerminationPoint(curr))
        {

            return canReachEnd(curr);
        }

        boolean downPath = findPath(matrix, r + 1, c);

        boolean rightPath = false;
        if (!downPath) // just for optimization since we have to find any path not all
        {
            rightPath = findPath(matrix, r, c + 1);
        }

        matrix[r][c] = NOT_PATH;
        if (downPath || rightPath)
        {
            matrix[r][c] = PATH;
        }
        return downPath || rightPath;
    }

    private boolean canReachEnd(int curr)
    {
        return curr == END || curr == PATH;
    }

    private boolean isCurrentTerminationPoint(int curr)
    {

        return curr != 0;
    }

    private boolean isOutOfBoundary(int[][] matrix, int r, int c)
    {
        if (r >= matrix.length || c >= matrix[0].length)
        {
            return true;
        }

        return false;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                { 0, 0, 0, 0 },
                { 0, 1, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 2 }
        };

        new RobotInGrid().sol1(matrix); //O(N*M) time O(N + M)
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            String row = Arrays.toString(matrix[i]);
            System.out.println(row);
        }
    }
}
