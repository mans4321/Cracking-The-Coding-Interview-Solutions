package cci.chapters.sorting8searching;

import java.util.Arrays;

public class PeaksAndValleys
{
/*
    Peaks and Valleys:
        In an array of integers, a "peak" is an element which is greater than or equal to
        the adjacent integers and a "valley" is an element which is less than or equal to the adjacent inte-
        gers. For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys. Given an array
        of integers, sort the array into an alternating sequence of peaks and valleys.

        Hints: # 196, #219, #231, #253, #277, #292, #316
*/

    public static void main(String[] args)
    {
        int[] arr = { 5, 3, 1, 2, 3 };
        specialSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void specialSort(int[] arr)
    {
        if (arr == null || arr.length == 1)
        {
            return;
        }
        for (int i = 1; i < arr.length - 1; i += 2)
        {
            int largestIndex = maxlndex(arr, i - 1, i, i + 1);
            if (i != largestIndex)
            {
                swap(arr, i, largestIndex);
            }
        }
    }

    private static void swap(int[] arr, int i, int j)
    {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int maxlndex(int[] arr, int a, int b, int c)
    {
        int len = arr. length;

        int aValue = a >= 0 && a < len ? arr[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? arr[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? arr[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));
        if (aValue == max) return a;
        else if (bValue == max) return b;
        else return c;

    }
}
