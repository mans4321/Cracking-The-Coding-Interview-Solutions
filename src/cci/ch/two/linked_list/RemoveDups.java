package cci.ch.two.linked_list;

import java.util.HashMap;
import java.util.Map;
import cci.data.structures.SingleLinkedList;

/*
    Remove Dups: Write code to remove duplicates from an unsorted li nked list.
    
    FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed?
    
    Hints: #9, #40
*/
public class RemoveDups {



    /*
        Solution 1 : use  hashMap and check if the keys exists delete node

        S:O(N), M:O(N)
    */

    public SingleLinkedList<Integer> solution1(SingleLinkedList<Integer> linkedList)
    {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        
        int i = 0 ;
        int j = linkedList.length();

        while(i < j)
        {
            Integer val = linkedList.get(i);
            if(!map.containsKey(val))
            {
                map.put(val, true);
                i++;
            }else
            {        
                linkedList.remove(i);
                j--;
            }
        }
       
        return linkedList;
    }

    /*
        Solution 2 : sort & then iterater to find duplicat

        S:O(N), M:O(N)
    */

    public SingleLinkedList<Integer> solution2(SingleLinkedList<Integer> linkedList)
    {
        SingleLinkedList.sort(linkedList);
        
        int i = 1 ;
        int j = linkedList.length();
        Integer temp = linkedList.get(0);

        while(i < j)
        {   
            if(linkedList.get(i).equals(temp))
            {
                linkedList.remove(i);
                j--;
            }else
            {   
                temp = linkedList.get(i); 
                i++;  
            }
        }
        
        return null;
    }

    public static void main(String[] args) 
    {
        SingleLinkedList<Integer> linkedList = creatLink();
        new RemoveDups().solution2(linkedList);

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