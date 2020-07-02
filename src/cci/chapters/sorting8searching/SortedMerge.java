package cci.chapters.sorting8searching;

import java.util.Arrays;

public class SortedMerge
{
/*
    Sorted Merge:
        You are given two sorted arrays, A and B, where A has a large enough buffer at the
        end to hold B. Write a method to merge B into A in sorted order.

    Hints: #332
*/

    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 0, 0, 0, 0, 0 };
        int[] B = { 2, 4, 6, 8, 10, 12 };

        //solution1(A, B); // O(A+B) time & O(A+B) Memory
        //solution2(A,B) // O(A+B Log_A+B) just drop all B in A and call sort on A
        //Solution3(A, B)// O(AB) just drop all B in A buffer and bubble sort evey B by swap with left ele if B ele is smaller
        solution4(A, B, 7); // A+B
        System.out.println(Arrays.toString(A));
    }

    private static void solution4(int[] a, int[] b, int aLast)
    {
        int aIndex = aLast;
        int bIndex = b.length - 1;
        int mergeIndex = a.length - 1;

        while (bIndex >= 0)
        {
            if (aIndex >= 0 && a[aIndex] > b[bIndex])
            {
                a[mergeIndex] = a[aIndex];
                aIndex--;
            }
            else
            {
                a[mergeIndex] = b[bIndex];
                bIndex--;
            }
            mergeIndex--;

        }
    }

}
