package cci.ch.two.linked_list;

import java.util.HashMap;
import java.util.Map;

import cci.data.structures.Node;
import cci.data.structures.SingleLinkedList;

/*
    Loop Detection: Given a circular linked list, implement an algorithm 
    that returns the node at the beginning of the loop.
    
    DEFINITION
    
        Circular linked list: A (corrupt) linked list in which a node's
        next pointer points to an earlier node, so as to make a loop in the linked list.
    
    EXAMPLE
        Input:
        A -) B -) C -) 0 -) E - ) C[thesameCasearlierl
        
        Output:
        C
    
    Hints: #50, #69, #83, #90
*/
public class LoopDetection 
{
    /*
        can not be implement in O(N) in Java Only O(N^2)
        
        Solution 1 : hash & compare 

        S:O(N) 
    */

    public static <T> Node<T> solution1(SingleLinkedList<T> linkedList)
    {
        Map<Integer, Node<T>> hash = new HashMap<Integer, Node<T>>();
        Node<T> curr = linkedList.nodeIterator();
        
        while(curr != null)
        {
            int loc = System.identityHashCode(curr);
            if(hash.containsKey(loc))
            {
                return curr;
            }else
            {
                hash.put(loc, curr);
            }
             curr = linkedList.next();
        }

        return null;
    }

    public static void main(String[] args) {
        
    }
}