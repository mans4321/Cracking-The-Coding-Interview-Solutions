package cci.data.structures;

import java.util.Arrays;

public class ArrayList<T>
{
    private static final int DEFAULT_CAPACITY = 1;

    private static final int DEFAULT_SHRINK_PERCENTAGE = 25;

    private static final int DEFAULT_DOUBLE_PERCENTAGE = 75;

    private int size;

    private Object[] arr;

    public ArrayList(int size)
    {
        if (size > 0)
        {
            this.arr =  new Object[size];
        }
        else
        {
            throw new IllegalArgumentException("Illegal Capacity: " + size);
        }
    }

    public ArrayList()
    {
        this.arr = new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public T get(int index)
    {
        rangeCheckForIndex(index);
        return (T) arr[index];
    }

    public void add(T ele)
    {
        this.arr[this.size] = ele;
        size++;
        this.ensureCapacityIsWithinLimit();

    }

    public void remove(int index)
    {
        rangeCheckForIndex(index);
        leftShiftEle(index);
        decreaseSize();
        ensureCapacityIsNotTooBig();
    }

    public boolean remove(Object obj)
    {
        int index = indexOf(obj);
        if (index < 0)
        {
            return false;
        }

        leftShiftEle(index);
        decreaseSize();
        ensureCapacityIsNotTooBig();
        return true;
    }

    public boolean contains(Object obj)
    {
        return indexOf(obj) >= 0;
    }

    public int indexOf(Object obj)
    {
        int index = -1;
        for (int i = 0; i < size; i++)
        {
            if (arr[i].equals(obj))
            {
                return i;
            }
        }
        return index;
    }


    private void ensureCapacityIsNotTooBig()
    {
        int percentage = size * 100 / arr.length;
        if (percentage < DEFAULT_SHRINK_PERCENTAGE && arr.length > 1)
        {
            shrink();
        }
    }

    private void ensureCapacityIsWithinLimit()
    {
        int percentage = size * 100 / arr.length;
        if (percentage >= DEFAULT_DOUBLE_PERCENTAGE)
        {
            grow();
        }
    }

    private void shrink()
    {
        int newArrayLength = arr.length / 2;
        createNewArrayAndCopyOldToIt(newArrayLength);
    }

    private void grow()
    {
        int newArrayLength = size * 2;
        if ( 2147483639 - newArrayLength <= 0) {
            throw new OutOfMemoryError();
        }
        createNewArrayAndCopyOldToIt(newArrayLength);
    }

    private void createNewArrayAndCopyOldToIt(int newArrayLength)
    {
        arr = Arrays.copyOf(arr,newArrayLength);
    }

    private void decreaseSize()
    {
        size--;
    }

    private void leftShiftEle(int index)
    {
        if(size == 1 || index == size - 1)
            return;
        while (index < size ){
            arr[index] = arr[index + 1];
            index++;
        }
    }


    private void rangeCheckForIndex(int index)
    {
        if (index >= this.size || index < 0)
        {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int var1)
    {
        return "Index: " + var1 + ", Size: " + this.size;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println(arr.isEmpty());

        arr.add(1);
        System.out.println(arr.isEmpty());
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(3);

        System.out.println(arr.indexOf(1));
        System.out.println(arr.indexOf(2));
        System.out.println(arr.indexOf(3));
        System.out.println(arr.size);
        System.out.println("------------------");
        arr.remove(0);
        System.out.println(arr.get(0));

        System.out.println(arr.remove(new Integer(4)));
        System.out.println(arr.arr.length);
        System.out.println(arr.remove(new Integer(3)));
        System.out.println(arr.arr.length);
        System.out.println(arr.indexOf(new Integer(3)));
        System.out.println(arr.remove(new Integer(2)));
        System.out.println(arr.arr.length);
    }

}