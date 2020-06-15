package cci.ch.two.linked_list;

import java.util.HashMap;
import java.util.Map;

import cci.data.structures.Node;
import cci.data.structures.SingleLinkedList;

/*
    Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the inter-
    secting node. Note that the intersection is defined based on reference, not value. That is, if the kth
    node of the first linked list is the exact same node (by reference) as the jth node of the second
    linked list, then they are intersecting
    
    Hints:
    #20,#45, #55, #65, #76, #93, #111, #120, #129
*/
public class Intersection 
{



   /*
        Solution 1 : hash & compare 

        S:O(N) // note can not be implement in O(N) in Java Only O(N^2)
    */

    public static <T extends Comparable<? super T>> SingleLinkedList<T> 
        solution1(
                SingleLinkedList<T> first, 
                SingleLinkedList<T> second 
                )
    {

        Map<Integer, Node<T>> hash = new HashMap<Integer, Node<T>>();
        SingleLinkedList<T> intersections = new SingleLinkedList<>();

        SingleLinkedList<T> shortList, longList;
        
        if(first.length() < second.length())
        {
                shortList = first;
                longList = second;
        }
        else
        {
            shortList = second;
            longList = first;
        }
        
        Node<T> curr = shortList.nodeIterator();
        while(curr != null)
        {
            hash.put(System.identityHashCode(curr), curr);
            curr = shortList.next();
        }

        curr = longList.nodeIterator();
        while(curr != null)
        {
            int loc = System.identityHashCode(curr);

            if(hash.containsKey(loc)
                && hash.get(loc) == curr
            )
            {
                intersections.add(curr.getValue());
            }
            curr = longList.next();
        }

        return intersections;
    }

    public static void main(String[] args) 
    {
        SingleLinkedList<Integer> first = new SingleLinkedList<>();
        SingleLinkedList<Integer> second = new SingleLinkedList<>();

        first.add(7);
        first.add(1);
        first.add(6);

        second.add(5);
        second.add(9);
        second.add(2);

        System.out.println(solution1(first, second).length());
    }
}