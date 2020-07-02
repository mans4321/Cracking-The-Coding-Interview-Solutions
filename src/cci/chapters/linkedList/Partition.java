package cci.chapters.linked_list;

import cci.dataStructures.SingleLinkedList;

/*
    Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
    before all nodes greater than or equal to x . lf x is contained within the list, the values of x only need
    to be after the elements less than x (see below) . The partition element x can appear anywhere in the
    "right partition"; it does not need to appear between the left and right partitions.
    
    EXAMPLE
        Input:
        3 -> 5 -> 8 -> 5 - > 10 -> 2 -> 1 [partition = 5)
        Output:
        3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
    
    Hints: #3, #24
*/
public class Partition 
{


    /*
        Solution 1 : throw the element < p to the in front the linkedlist, else throw the element in the end  

        S:O(N)
    */

    public void solution1(SingleLinkedList<Integer> linkedList, Integer p)
    {
        for (int i = 0; i < linkedList.length(); i++) 
        {
            Integer val = linkedList.get(i);
            linkedList.remove(i);
            
            if(p.compareTo(val) <= 0)
            {
                linkedList.add(val);
            }else
            {
                linkedList.add(0, val);
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = creatLink();
        new Partition().solution1(linkedList, 5);
        
        for (int i = 0; i < linkedList.length(); i++) 
        {
            System.out.println(linkedList.get(i));    
        }
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