package cci.chapters.tree8graph.concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap
{
    private List<Integer> list;

    public MinHeap(List<Integer> list)
    {
        this.list = list;
    }

    public void start()
    {
        insert(-1);
        int min = extractMin();
        insert(-2);

    }

    private void insert(int value)
    {
        list.add(value);
        bubbleUp();
    }

    private void bubbleUp()
    {
        int i = list.size() - 1;
        int p = parent(i);
        while (i > 0 && list.get(i).compareTo(list.get(p)) < 0)
        {
            swap(i, p);
            i = p;
            p = parent(i);
        }
    }
    private int extractMin()
    {
        if (list.size() == 0)
        {
            return Integer.MAX_VALUE;
        }

        int min = list.get(0);
        swap(0, list.size() - 1);
        list.remove(list.size() - 1);
        trickleDown();
        return min;
    }

    private void trickleDown()
    {
        int n = list.size();
        if (n < 2)
        {
            return;
        }

        int i = 0;
        int l = 1;
        int r = 2;

        while (r < n || l < n)
        {
            int smaller;
            if (r >= n)
            {
                smaller = l;
            }
            else
            {
                smaller = list.get(r) < list.get(l) ? r : l;
            }

            if (list.get(i) < list.get(smaller))
            {
                return;
            }

            swap(i, smaller);
            i = smaller;
            l = left(i);
            r = right(i);
        }
    }

    private int left(int i)
    {
        return 2 * i + 1;
    }

    private int right(int i)
    {
        return 2 * i + 2;
    }

    private int parent(int i)
    {
        return (i - 1) / 2;
    }

    private void swap(int i, int p)
    {
        int tmp = list.get(i);
        list.set(i, list.get(p));
        list.set(p, tmp);
    }

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>(
                Arrays.asList(
                        0, 1, 2, 3, 4, 5, 6, 7,
                        8, 9, 10, 11, 12, 13, 14
                )
        );

        new MinHeap(list).start();
    }

}

