package cci.ch.two.linked_list;

import cci.data.structures.SingleLinkedList;


/*
    Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
    
    Hints: #8, #25, #47, #67, # 726
*/
public class ReturnKthtoLast {

    
    /*
        Solution 1 : calculate the index and get the element 

        S:O(N)
    */

    public Integer solution1(SingleLinkedList<Integer> linkedList, int i)
    {
        int size = linkedList.length();
        int index = size - i - 1;
        if(index < 0)
            throw new IllegalArgumentException("the Kth element is out of bound Kth element must be < " + linkedList.length());
        
        return linkedList.get(index);
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = creatLink();
        Integer num = 
            new ReturnKthtoLast().solution1(linkedList, 5);
        System.out.println(num);
    }

    public static SingleLinkedList<Integer> creatLink()
    {
        SingleLinkedList<Integer> linkedList
                = new SingleLinkedList<>();

        int i = 10;
        while(i >= 0)
        {
            if(i % 2 == 0)
            {
                linkedList.add(i);
            }else
            {
                linkedList.add(i + 1);
            }

            i--;
        }

        return linkedList;
    }
}