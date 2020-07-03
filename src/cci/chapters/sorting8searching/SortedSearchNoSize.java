package cci.chapters.sorting8searching;

public class SortedSearchNoSize
{
/*
    Sorted Search, No Size:

        You are given an array-like data structure Listy which lacks a size
        method. It does, however, have an elementAt (i) method that returns the element at index i in
        0(1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
        structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
        find the index at which an element x occurs. If x occurs multiple times, you may return any index.

      Hints: #320, #337, #348
*/

    public static void main(String[] args)
    {
        int[] listy = { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
        int target = 7;
        int index = find(listy, target);
        System.out.println(index);
    }

    private static int find(int[] listy, int target)
    {
        if (elementAt(listy, 0) == -1)
        {
            return -1;
        }
        int high = findLastIndex(listy);
        return binarySearch(listy, high, target);

    }

    private static int binarySearch(int[] listy, int high, int target)
    {
        int low = 0;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            int ele = elementAt(listy, mid);
            if (ele == target)
            {
                return mid;
            }
            else if (target < ele)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int findLastIndex(int[] listy)
    {
        int logN = findLogN(listy);
        return findLastIndex(listy, logN);

    }

    private static int findLastIndex(int[] listy, int logN)
    {
        int low = (int) Math.pow(2, logN - 1);
        int high = (int) Math.pow(2, logN);
        int mid = 0;
        while (low < high)
        {
            mid = (low + high) / 2;
            if (elementAt(listy, mid) == -1)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        System.out.println("last Index" + mid);
        return mid;
    }

    private static int findLogN(int[] listy)
    {
        int pow = 0;
        int currIndex = 0;
        while (elementAt(listy, currIndex) != -1)
        {
            pow++;
            currIndex = (int) Math.pow(2, pow);
        }
        return pow;
    }

    private static int elementAt(int[] listy, int currIndex)
    {
        try
        {
            return listy[currIndex];
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            return -1;
        }
    }
}
