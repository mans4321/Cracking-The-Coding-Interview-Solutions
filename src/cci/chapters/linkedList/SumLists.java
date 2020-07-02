package cci.chapters.linkedList;

import cci.dataStructures.SingleLinkedList;

/*
    Sum Lists: You have two numbers represented by a linked list, where each node contains a single
    digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
    function that adds the two numbers and returns the sum as a linked list.
    
    EXAMPLE
        Input: (7-) 1 -) 6) + (5 -) 9 -) 2) .Thatis,617 + 295.
        Output: 2 -) 1 -) 9. That is, 912.
    
    FOLLOW UP
        Suppose the digits are stored in forward order. Repeat the above problem.
        
        EXAMPLE
            Input: (6 -) 1 -) 7) + (2 -) 9 -) 5) . Thatis,617 + 295 .
            Output: 9 -) 1 -) 2. That is, 912.
    
    Hints: #7, #30, #71, #95, #109


*/
public class SumLists {

    private static SingleLinkedList<Integer> solution1(
            SingleLinkedList<Integer> first,
            SingleLinkedList<Integer> second) 
    {

        SingleLinkedList<Integer> third = new SingleLinkedList<>();
        int X10 = 1; 
        boolean hand = false;
        int i = 0; 
        
        while(i < first.length() && i < second.length() )
        {
            int currSum = first.get(i) + second.get(i);
            if(hand)
            {
                currSum++;
                hand = false;
            }
                
            if(currSum > 9)
            {
                hand = true;
                currSum -= 10;
            }
            
            third.add(currSum);
            X10 *= 10;
            i++;
        }

        while(i < first.length() )
        {
            third.add(first.get(i));
            X10 *= 10;
            i++;
        }

        while(i < second.length() )
        {
            third.add(second.get(i));
            X10 *= 10;
            i++;
        }
		return third;
    }
    
    private static SingleLinkedList<Integer> followUp(
            SingleLinkedList<Integer> first,
            SingleLinkedList<Integer> second) 
    {
        int len = 
            first.length() <= second.length() ? 
                first.length() : second.length();

        int X10 = (int) Math.pow(10, len- 1);
        System.err.println(X10  + " " + len);

        int i = 0;
        SingleLinkedList<Integer> sumList = new SingleLinkedList<>();

        while(i < len)
        {
            int currSum = first.get(i) + second.get(i);
                
            if(currSum > 9)
            {
                if(i == 0)
                {
                    sumList.add(0, 1);
                }else
                {
                    int last = sumList.length() - 1;
                    Integer val = sumList.get(last) + 1;
                    sumList.remove(last);
                    if(val > 9)
                    {
                        sumList.add(1);
                        sumList.add(val - 10);
                    }else
                    {
                        sumList.add(val);
                    }
                    
                }

                //total += X10 * 10;
                currSum -= 10;
            }

            sumList.add(currSum);
            X10 /= 10;
            i++;
        }

        return sumList;
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
        
        SingleLinkedList<Integer> third = solution1(first, second);  

        System.out.println("solution1");
        for (int i = 0; i < third.length(); i++) 
        {
           System.out.println( third.get(i) );    
        }

        System.out.println("FOLLOW UP");
        SingleLinkedList<Integer> foruth = followUp(first, second);
        System.err.println(foruth.length());
        for (int i = 0; i < foruth.length(); i++) 
        {
           System.out.println( foruth.get(i) );    
        }


    }
}