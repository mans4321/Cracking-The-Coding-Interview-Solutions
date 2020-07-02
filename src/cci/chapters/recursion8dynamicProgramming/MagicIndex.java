package cci.chapters.recursion8dynamicProgramming;

public class MagicIndex
{
/*
    Magic Index: A magic index in an array A [e ... n -1] is defined to be an index such that A[ i] =
    i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.

    FOLLOW UP:
    What if the values are not distinct?
    Hints: # 170, #204, #240, #286, #340
*/

    public int part1(int arr[])
    {
        int start = 0;
        int end = arr.length - 1;
        while (start < end)
        {
            int mid = (start + end) / 2;
            if (mid > arr[mid])
            {
                start = mid + 1;
            }
            else if (mid < arr[mid])
            {
                end = mid - 1;
            }
            else
            {
                return mid;
            }
        }

        return -1;
    }

    //https://stackoverflow.com/questions/13197552/using-binary-search-with-sorted-array-with-duplicates
    public int part2(int arr[], int start, int end)
    {
        if (start < end)
        {
            return -1;
        }

        int mid = (start + end) / 2;
        if (mid == arr[mid])
        {
            return mid;
        }

        int max = Math.max(mid + 1, arr[mid]);
        int left = part2(arr, max, end);

        if (left != -1)
        {
            return left;
        }

        int min = Math.min(mid - 1, arr[mid]);
        int right = part2(arr, start, mid);
        return right;
    }

    public static void main(String[] args)
    {
        int arr[] = { -1, -2, 1, 3, 4, 5, 7 };
        int index = new MagicIndex().part1(arr);
        System.out.println(index);
    }
}
