package cci.ch.one.arrays8strings;

/*
    Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
    bytes, write a method to rotate the image by 90 degrees. (an you do this in place?
    
    Hints: #51, #100
*/
public class RotateMatrix
{

    /**
     * follow the algorithm
     *
     */
    public int[][] solution1(int matrix [][])
    {
        int N = matrix.length - 1;

        for (int i = 0; i <= N / 2; i++)
        {
            for (int  j= i; j < N - i; j++)
            {
                int p1 = matrix[i][j];
                int p2 = matrix[j][N -i];
                int p3 = matrix[N -i][N - j];
                int p4 = matrix[N - j][i];

                //Swap values of 4 coordinates
                matrix[j][N - i] = p1;
                matrix[N - i][N - j] = p2;
                matrix[N - j][i] = p3;
                matrix[i][j] = p4;
            }
        }
        return matrix;
    }

    public static void main(String[] args)
    {
        int [][] arr = {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        new RotateMatrix().solution1(arr);

        System.out.println("{");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print('\t');
            System.out.print('[');
            for (int j = 0; j < arr[i].length - 1; j++)
            {
                System.out.print(arr[i][j] + ", " );
            }
            System.out.println(arr[i][ arr.length -1 ] + "]");
        }
        System.out.println("}");
    }
}
