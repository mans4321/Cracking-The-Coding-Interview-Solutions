package cci.chapters.stacks8queues;

import java.util.ArrayList;
import java.util.List;

import cci.dataStructures.Stack;

/*
    Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
    Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
    threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
    composed of several stacks and should create a new stack once the previous one exceeds capacity.
    SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
    (that is, pop ( ) should return the same values as it would if there were just a single stack).
   
    FOLLOW UP
    Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
    Hints: #64, #87
*/
public class StackOfPlates<T>
{

    private final int DEFAULT_THRESHOLD = 10;

    private int threshold;

    private List<Stack<T>> list;

    private Stack<T> curruent;

    private int curruentStackIndex;


    {
        curruentStackIndex = -1;
        threshold = DEFAULT_THRESHOLD;
        list = new ArrayList<>();
        nextStack();
    }

    public StackOfPlates()
    {
    }

    public StackOfPlates(int threashHold)
    {
        this.threshold = threashHold;
    }

    public void popAt(int index)
    {
        if(index > list.size() || index < 0)
            throw new IllegalArgumentException("");
        Stack<T> stack = list.get(index);
        
        if(stack.length() == 0)
            list.remove(index);
    }

    public void push(T ele)
    {
        curruent.add(ele);
        ensureInternalCapacity();
    }
    
    public void pop()
    {
        curruent.remove();
        ensureInternalCapacity();
    }

    private void ensureInternalCapacity() 
    {
        if(curruent.length() == 0)
        {
            System.out.println("previousStack");
            previousStack();
        }
        else if(curruent.length() >= threshold)
        {
            System.out.println("nextStack");
            nextStack();
        }
 
    }

    private void previousStack() 
    {
        list.remove(curruentStackIndex);
        curruent = list.get(--curruentStackIndex);
        System.out.println("previousStack: " + list.size());
    }

    private void nextStack()
    {
        Stack<T> stack = new Stack<>();
        list.add(stack);
        curruent = list.get(++curruentStackIndex);
        System.out.println("nextStack: " + list.size());
    }
    

    public static void main(String[] args) 
    {
        StackOfPlates<Integer> SOP = new StackOfPlates<>(2);
        for (int i = 0; i < 5; i++) 
        {
            System.out.println(i);
            SOP.push(i);
        }

        System.out.println(SOP.list.size());
    }
}