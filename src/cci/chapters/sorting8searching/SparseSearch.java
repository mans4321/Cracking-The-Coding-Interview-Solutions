package cci.chapters.sorting8searching;

public class SparseSearch
{

/*    Sparse Search:

        Given a sorted array of strings that is interspersed with empty strings, write a
        method to find the location of a given string.
    Hints: #256
*/

    public static void main(String[] args)
    {
        String[] strs = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
        String target = "car";
        int res = specialBinarySearch(strs, 0, strs.length - 1, target);
        System.out.println(res);
    }

    private static int specialBinarySearch(String[] strs, int low, int high, String target)
    {
        if (low > high)
        {
            return -1;
        }

        int mid = (low + high) / 2;

        if (strs[mid].isEmpty())
        {
            return lookInBothSides(strs, low, high, mid, target);
        }
        return lookInOneSide(strs, low, high, mid, target);
    }

    private static int lookInOneSide(String[] strs, int low, int high, int mid, String target)
    {
        int compareResult = target.compareTo(strs[mid]);

        if (compareResult > 0)
        {
            return specialBinarySearch(strs, mid + 1, high, target);
        }
        else if(compareResult < 0)
        {
            return specialBinarySearch(strs, low, mid - 1, target);
        }
        return mid;
    }

    private static int lookInBothSides(String[] strs, int low, int high, int mid, String target)
    {
        int left = specialBinarySearch(strs, low, mid - 1, target);
        if (left != -1)
        {
            return left;
        }
        return specialBinarySearch(strs, mid + 1, high, target);
    }

}
