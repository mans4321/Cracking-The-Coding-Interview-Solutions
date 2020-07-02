package cci.dataStructures;

import java.util.List;
import java.util.stream.IntStream;

public class SingleLinkedList<T>
{


    private int size;

    private Node<T> head;

    private Node<T> tail;

    private Node<T> currNodeInIteration;


    public void add(T ele)
    {

        if (head == null)
        {
            head = tail = createNode(ele);
        }
        else
        {
            tail = tail.setNext(createNode(ele));
        }
        size++;
    }


    public void add(int index, T ele)
    {
        checkIndexRangeFprAdd(index);

        if (head == null) // no element in the linkedList
        {
            add(ele);
            return;
        }

        Node<T> prev = index == 0 ? null : getNodeAt(--index);

        if (prev == null)
        {
            Node<T> temp = head;
            head = createNode(ele);
            head.setNext(temp);
        }
        else
        {
            Node<T> newEle = createNode(ele);
            prev.setNext(newEle);
            newEle.setNext(prev.getNext());
        }
        size++;
    }

    public void addAt(final int index, List<T> elements)
    {
        notNull(elements);
        checkIndexRangeFprAdd(index);

        if (elements.isEmpty())
        {
            return;
        }

        IntStream.range(index, index + elements.size())
            .forEach(i -> add(i, elements.get(i - index)));
    }

    public void addAll(List<T> elements)
    {
        notNull(elements);
        for (T ele : elements)
        {
            add(ele);
        }
    }

    public boolean remove(T ele)
    {
        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null)
        {
            if (curr.getValue().equals(ele))
            {
                break;
            }

            prev = curr;
            curr = curr.getNext();
        }

        if (curr == null)
        {
            return false;
        }

        if (prev == null)
        {
            if (tail == head)
            {
                tail = null;
            }
            head = head.getNext();
        }
        else
        {
            prev.setNext(curr.getNext());
        }

        return true;
    }

    public boolean remove(int index)
    {
        checkIndexRangeForRemove(index);
        Node<T> prev = 
            index == 0 ? null : getNodeAt(index - 1);

        if (prev == null)
        {
            head = head.getNext();
        }
        else
        {
            prev.setNext(prev.getNext().getNext());
        }

        size--;

        if(index == size)
            tail = prev;

        return true;
    }

    public T get(int index)
    {
        checkIndexRangeForRemove(index);

        int i = 0;
        Node<T> curr = head;

        while (curr != null)
        {
            if (i == index)
            {
                break;
            }
            curr = curr.getNext();
            i++;
        }
        return curr.getValue();
    }

    public Node<T> nodeIterator()
    {
        currNodeInIteration = head;
        return currNodeInIteration;
    }

    public Node<T> next()
    {
        if(currNodeInIteration != null){
            currNodeInIteration = currNodeInIteration.getNext();
        }
        return currNodeInIteration;
    }

    public int length()
    {
        return size;
    }

    private void checkIndexRangeForRemove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException(String.format("index must be between 0 and %d inclusive ", size - 1));
        }
    }

    private void notNull(Object parm)
    {
        if (parm == null)
        {
            throw new IllegalArgumentException("You cannot pass null parms to a method");
        }
    }

    private  Node<T> getNodeAt(int index)
    {
        int i = 0;
        Node<T> curr = head;

        while (curr != null)
        {
            if (i == index)
            {
                break;
            }
            curr = curr.getNext();
            i++;
        }

        return curr;
    }

    private void checkIndexRangeFprAdd(int index)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException(String.format("index must be between 0 and %d inclusive ", index));
        }
    }

    private Node<T> createNode(T t)
    {
        return new Node<T>(t);
    }
 
    public static < C extends Comparable<? super C>> void sort(SingleLinkedList<C> singleLinkedList)
    {
        if(singleLinkedList == null)
            return;
        singleLinkedList.head = mergeSort(singleLinkedList.head);
    }

    private static <C extends Comparable<? super C>> Node<C> mergeSort(Node<C> head) {
        if(head == null || head.getNext() == null)
        return head;
    
        // get the middle of the list 
        Node<C> middle = getMiddle(head); 
        Node<C> nextofmiddle = middle.getNext(); 
        
        // set the next of middle node to null 
        middle.setNext(null); 

        // Apply mergeSort on left list 
        Node<C> left = mergeSort(head); 

        // Apply mergeSort on right list 
        Node<C> right = mergeSort(nextofmiddle); 

        // Merge the left and right lists 
        Node<C> sortedlist = sortedMerge(left, right); 
        return sortedlist;
	}

	// Utility function to get the middle of the linked list 
	private static <C> Node<C> getMiddle(Node<C> head) 
	{ 
		if (head == null) 
			return head; 

        Node<C> slow = head, fast = head; 

		while (fast.getNext() != null && fast.getNext().getNext() != null) { 
			slow = slow.getNext(); 
			fast = fast.getNext().getNext(); 
		} 
		return slow; 
	} 

   private static <C extends Comparable<? super C>> Node<C> sortedMerge(Node<C> a, Node<C> b) 
	{ 
		Node<C> result = null; 
		/* Base cases */
		if (a == null) 
			return b; 
		if (b == null) 
			return a; 

		/* Pick either a or b, and recur */
		if (a.getValue().compareTo(b.getValue()) <= 0) { 
			result = a; 
			result.setNext(
                sortedMerge(a.getNext(), b)
                ); 
		} 
		else { 
            result = b;
			result.setNext(
                sortedMerge(a, b.getNext())
                ); 
		} 
		return result; 
	} 

    public static void main(String[] args) {
        
    }

}
