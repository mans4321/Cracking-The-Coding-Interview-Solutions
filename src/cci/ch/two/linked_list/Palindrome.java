package cci.ch.two.linked_list;

import cci.data.structures.SingleLinkedList;

/*
    Palindrome: Implement a function to check if a linked list is a palindrome.

    Hints: #5, #13, #29, #61, #101
*/
public class Palindrome 
{



  /*
        Solution 1 :  store the linked list node in an array and compare first and last

        S:O(N) , M: O(N) 
    */
    public static  <T extends Comparable<? super T>> boolean solution1(final SingleLinkedList<T> linkedList)
    {
        final Object[] arr = new Object[linkedList.length()];

        for (int i = 0; i < linkedList.length(); i++) 
        {
            arr[i] = linkedList.get(i);
        }

        int i = 0;
        int j = linkedList.length() - 1;

        while(i < j)
        {
            final T first = (T) arr[i];
            final T last = (T) arr[j];

            if (first.compareTo(last) != 0)
            {
                return false;
            }
            
            i++;
            j--;
        }

        return true;
    }

    public static void main(final String[] args) {
        final SingleLinkedList<Integer> first = new SingleLinkedList<>();
       
        first.add(7);
        first.add(1);
        first.add(6);
        first.add(1);
        first.add(6);
        first.add(1);
        first.add(7);
        
        System.out.println(solution1(first));
    }

}