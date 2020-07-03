package cci.chapters.sorting8searching;

public class SearchInRotatedArray
{

    public static void main(String[] args)
    {
        int[] arr = {13, 15, 16 , 19, 20, 25, 1, 3, 4, 5, 7, 10};
        int index = specialBinarySearch(arr, 13);
        System.out.println(index);
    }

    private static int specialBinarySearch(int[] arr, int target)
    {

        int low = 0;
        int high = arr.length - 1;

        while (low < high)
        {
            int mid = (low + high) / 2;
            System.out.println(mid);
            if (arr[mid] == target)
            {
                return mid;
            }
            else if (target >= arr[low]  && target < arr[mid])
            {
                high = mid - 1;
            }else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
}
