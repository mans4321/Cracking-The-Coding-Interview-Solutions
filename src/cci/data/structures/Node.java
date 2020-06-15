package cci.data.structures;

public class Node<V>
{
    private Node<V> next;
    private V value;

	public Node()
	{

	}
	
    public Node(V value)
    {
        this.value = value;
    }

    public Node(V value, Node<V> next)
    {
        this.value = value;
        this.next = next;
    }

	public Node<V> getNext() {
		return next;
	}

	public Node<V> setNext(Node<V> next) {
		this.next = next;
		return next;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

    
}