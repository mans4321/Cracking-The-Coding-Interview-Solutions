package cci.ch.recursion8dynamicProgramming;

import java.awt.*;
import java.util.Arrays;

public class PaintFill
{
/*
      Paint Fill:

        Implement the "paint fill" function that one might see on many image editing programs.
        That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
        fill in the surrounding area until the color changes from the original color.

      Hints: #364, #382*/

    public static void main(String[] args)
    {
        String[][] matrix = {
                { "red", "red", "red", "white" },
                { "red", "white", "red", "white" },
                { "white", "red", "white", "white" },
                { "red", "white", "red", "white" }
        };

        solution(matrix, 1, 0, "black");
        print(matrix);
    }

    private static void solution(String[][] matrix, int row, int col, String newColor)
    {
        String oldColor = matrix[row][col];
        solution(matrix, row, col, newColor, oldColor);
    }

    private static void solution(String[][] matrix, int row, int col, String newColor, String oldColor)
    {
        if (row < 0 || row >= matrix.length
                    || col < 0
                    || col >= matrix[row].length)
        {
            return;
        }
        if(matrix[row][col].equalsIgnoreCase(oldColor))
        {
            matrix[row][col] = newColor;
            solution(matrix, row + 1, col, newColor, oldColor);
            solution(matrix, row - 1, col, newColor, oldColor);
            solution(matrix, row, col + 1, newColor, oldColor);
            solution(matrix, row, col - 1, newColor, oldColor);
        }
    }

    private static void print(String[][] matrix)
    {
        System.out.println("{");
        Arrays.stream(matrix).forEach(row -> {
            System.out.println("\t" + Arrays.toString(row));
        });
        System.out.println("}");
    }

    private static void solution(String[][] matrix, Point point, String black)
    {
    }
}
