package cci.data.structures;

import java.util.List;

public class Stack<T>
{

    private int DEFAULT_CAPACITY = 1;

    private int MIN_THRESHOLD_PERCENTAGE = 25; // TODO can we find a better name ;

    private int MAX_THRESHOLD_PERCENTAGE = 75;// TODO can we find a better name ;

    private int size;

    T arr[];

    public Stack()
    {
        arr = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public Stack(int defaultCapacity)
    {
        DEFAULT_CAPACITY = defaultCapacity;
        arr = (T[]) new Object[defaultCapacity];
    }

    public void add(T t)
    {
        arr[size++] = t;
        ensureInternalCapacity();
    }

    public T remove()
    {
        if(size == 0)
            return null;
        T temp = (T) arr[--size];
        ensureInternalCapacity();
        return temp;
    }

    public void add(List<T> list)
    {
        list.stream().forEach(this::add);
    }

    public T[] remove(int eleToRemove)
    {
        notNull(eleToRemove);
        ensureRangeForRemove(eleToRemove);
        T[] removedEle = (T[]) new Object[eleToRemove];
        for (int i = 0; i < eleToRemove; i++)
        {
            removedEle[i] = remove();
        }
        return removedEle;
    }

    public int length()
    {
        return size;
    }

    private void ensureRangeForRemove(int eleToRemove)
    {
        if (eleToRemove < 0 && eleToRemove > size)
        {
            throw new IllegalArgumentException(
                    String.format("You only can remove between %d and %d",
                                  0, size));
        }
    }

    private void notNull(Object... objs)
    {
        for (Object obj : objs)
        {
            if (obj == null)
            {
                throw new IllegalArgumentException("parms cannot be null");
            }
        }
    }

    private void ensureInternalCapacity()
    {
        int emptinessPercentage = (size * 100) / arr.length;
        if (emptinessPercentage >= MAX_THRESHOLD_PERCENTAGE)
        {
            grow();
        }
        else if (emptinessPercentage <= MIN_THRESHOLD_PERCENTAGE &&
                         arr.length != DEFAULT_CAPACITY)
        {
            shrink();
        }
    }

    private void shrink()
    {
        int newSize = arr.length / 2;
        createResizedArray(newSize);
    }

    private void grow()
    {
        int newSize = arr.length * 2;
        createResizedArray(newSize);
    }

    private void createResizedArray(int newSize)
    {
        T[] newArr = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++)
        {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

}
