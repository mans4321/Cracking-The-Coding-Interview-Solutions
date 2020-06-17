package cci.ch.recursion8dynamicProgramming;

import java.util.Objects;

public class MagicIndex
{
/*
    Magic Index: A magic index in an array A [e ... n -1] is defined to be an index such that A[ i] =
    i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.

    FOLLOW UP:
    What if the values are not distinct?
    Hints: # 170, #204, #240, #286, #340
*/

    public int part1(int arr[], int start, int end)
    {
        Objects.nonNull(arr);
        if (start > end)
        {
            return -1;
        }

        int middle = (int) Math.ceil((start + end) / 2.0);

        if (arr[middle] == middle)
        {
            return middle;
        }
        else if (arr[middle] < middle)
        {
            return part1(arr, middle + 1, end);
        }
        return part1(arr, start, middle - 1);
    }

    //https://stackoverflow.com/questions/13197552/using-binary-search-with-sorted-array-with-duplicates
    public int part2(int arr[])
    {
        Objects.requireNonNull(arr);
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] == i)
                return i;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int arr[] = { -1, -2, 1, 3, 4, 5, 7 };
        int index = new MagicIndex().part1(arr, 0, arr.length - 1);
        System.out.println(index);
    }
}
