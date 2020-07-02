package cci.chapters.linkedList;

import cci.dataStructures.SingleLinkedList;

/*
    Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
    the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
    that node.
    
    EXAMPLE
    Input: the node c from the linked list a - >b- >c - >d - >e- >f
    Result: nothing is returned, but the new linked list looks like a - >b- >d - >e- >f
    Hints: #72
*/

public class DeleteMiddleNode 
{


    /*
        Solution 1 : calculate the mid index and delete the element 

        S:O(N)
    */

    public void solution1(SingleLinkedList<Integer> linkedList, int i)
    {
        int size = linkedList.length();
        int index = size /2;
        linkedList.remove(index);
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = creatLink();
        System.out.println(linkedList.get(5));
      
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