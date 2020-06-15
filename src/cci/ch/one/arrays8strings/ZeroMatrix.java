package cci.ch.one.arrays8strings;

import java.awt.*;
import java.util.ArrayList;

/*
    Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    column are set to O.
    
    Hints: # 17, #74, #102
*/
public class ZeroMatrix
{

    /**
     * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
     * column are set to O.
     */

    /**
     * solution 1 store points where i,j == 0
     */

    public void solution1(int[][] matrix)
    {
        ArrayList<Point> points = getPointsWithZeroValue(matrix);
        setRow8ColToZero(matrix, points);
    }

    private ArrayList<Point> getPointsWithZeroValue(int[][] matrix)
    {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    points.add(new Point(i, j));
                }
            }
        }
        return points;
    }

    private void setRow8ColToZero(int[][] matrix, ArrayList<Point> points)
    {
        points.forEach(
                p -> {
                    for (int i = 0; i < matrix.length; i++)
                    {
                        matrix[i][p.y] = 0;

                        if (i < matrix[p.x].length)
                        {
                            matrix[p.x][i] = 0;
                        }

                    }
                }
        );
    }
}
