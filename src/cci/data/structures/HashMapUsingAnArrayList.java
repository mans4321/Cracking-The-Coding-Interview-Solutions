package cci.data.structures;

import java.util.ArrayList;
import java.util.List;

public class HashMapUsingAnArrayList<K, V>
{
    private int size;

    private int numBuckets = 10;

    private double loadingFactor = .70;

    private ArrayList<HashNode<K, V>> arrayList;

    public HashMapUsingAnArrayList(double load)
    {
        loadingFactor = load;
        initArrayList();
    }

    public HashMapUsingAnArrayList()
    {
        initArrayList();
    }

    public void add(K key, V value)
    {
        int bucket = getBucketIndex(key);
        HashNode<K, V> head = arrayList.get(bucket);
        HashNode<K, V> prev;

        while (head != null)
        {
            if (head.key.equals(key))
            {
                head.value = value;
                return;
            }
            prev = head;
            head = head.next;
        }

        size++;
        HashNode newHead = new HashNode<K, V>(key, value);
        newHead.next = arrayList.get(getBucketIndex(key));
        arrayList.set(getBucketIndex(key), newHead);
        ensureCapacityIsWithinLimit();
    }

    public V get(K key)
    {
        int bucket = getBucketIndex(key);
        HashNode<K, V> head = arrayList.get(bucket);

        while (head != null)
        {
            if (head.key.equals(key))
            {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key)
    {
        int bucket = getBucketIndex(key);
        HashNode<K, V> head = arrayList.get(bucket);
        HashNode<K, V> prev = null;

        while (head != null)
        {
            if (head.key.equals(key))
            {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null)
        {
            return null;
        }

        size--;
        if (prev == null)
        {
            arrayList.set(getBucketIndex(key), head.next);
        }
        else
        {
            prev.next = head.next;
        }
        return head.value;
    }

    public void add(List<HashNode<K, V>> list)
    {
        if (list == null)
        {
            return;
        }

        for (HashNode<K, V> head : list)
        {
            while (head != null)
            {
                add(head.key, head.value);
                head = head.next;
            }
        }
    }

    private void ensureCapacityIsWithinLimit()
    {
        double threshold = (size * 1.0) / numBuckets;
        if (threshold < loadingFactor)
        {
            return;
        }

        numBuckets *= 2;
        ArrayList<HashNode<K, V>> temp = arrayList;
        arrayList = new ArrayList<HashNode<K, V>>();
        initArrayList(numBuckets);
        add(temp);

    }

    private void initArrayList()
    {
        initArrayList(10);
    }

    private void initArrayList(int size)
    {
        arrayList = new ArrayList<HashNode<K, V>>();
        for (int i = 0; i < 10; i++)
        {
            arrayList.add(null);
        }
    }

    private int getBucketIndex(K key)
    {
        int hashCode = key.hashCode();
        return hashCode % numBuckets;
    }

    class HashNode<K, V>
    {
        K key;

        V value;

        HashNode<K, V> next;

        public HashNode(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public K getKey()
        {
            return key;
        }
    }

}
