package cci.ch.three.stacks8queues;

import cci.data.structures.Node;
import cci.data.structures.Stack;

/*
    Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
    
    Hints: #98, #7 74
*/
public class QueueViaStacks<T>
{

    Stack<T> stack;

    {
        stack = new Stack<>();
    }

    public void push(T ele)
    {   
        stack.add(ele);
    }

    public T remove()
    {
        Stack<T> newStack = new Stack<>();
        copyStack(stack, newStack);
        
        T first = newStack.remove();
        copyStack(newStack, stack);

        return first;
    }

    private void copyStack(Stack<T> src, Stack<T> dest) 
    {
        T ele = src.remove();
        while(ele != null)
        {
            dest.add(ele);
            ele = src.remove();
        }
    }


    private Node<T> createNode(T t)
    {
        return new Node<T>(t);
    }
}