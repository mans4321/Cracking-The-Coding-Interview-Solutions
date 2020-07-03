package cci.chapters.sorting8searching;

public class FindDuplicates
{

/*
      Find Duplicates:

        You have an array with all the numbers from 1 to N, where N is at most 32,000. The
        array may have duplicate entries and you do not know what N is. With only 4 kilobytes of memory
        available, how would you print all duplicate elements in the array?

      Hints: #289, #315
*/

    public static void main(String[] args)
    {
        int [] arr = {1,2,3,4,5,5,5,5};
        findDuplicates(arr);
    }

    private static void findDuplicates(int[] arr)
    {
        boolean [] map = new boolean[32000];
        for (int num: arr)
        {
            if(map[num - 1])
            {
                System.out.println(num);
            }else
            {
                map[num - 1] = true;
            }
        }
    }

}
