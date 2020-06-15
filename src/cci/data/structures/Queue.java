package cci.data.structures;

public class Queue<T>
{
    Node<T> head;

    Node<T> tail;

    int size;

    public void add(T t)
    {
        Node<T> newNode = createNode(t);
        if (head == null)
        {
            head = tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T remove()
    {
        if (size == 0)
        {
            return null;
        }

        Node<T> oldHead = head;
        head = head.next;

        if (head == null)
        {
            tail = null;
        }

        size--;
        return oldHead.value;
    }
    
    public int length()
    {
        return size;
    }

    private Node<T> createNode(T t)
    {
        return new Node<T>(t);
    }

    private class Node<V>
    {

        Node<V> next;

        V value;

        Node(V t)
        {
            value = t;
        }

    }
}
