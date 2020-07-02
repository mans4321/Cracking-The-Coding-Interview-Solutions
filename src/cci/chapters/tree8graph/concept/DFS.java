package cci.chapters.tree8graph.concept;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cci.dataStructures.GNode;

public class DFS
{

    private void start(List<GNode<Integer>> list)
    {
        if (list == null || list.size() == 0)
        {
            return;
        }
        search(list.get(0));
    }

    private void search(GNode<Integer> root)
    {
        if (root == null)
        {
            return;
        }

        for (GNode node : root.getAdjacent())
        {
            if (!node.isVisited())
            {
                search(node);
            }
        }
    }

    private void visited(GNode<Integer> node)
    {
        node.setVisited(true);

        String message = String.format(
                "id= %d \t value= %d \t ",
                node.getId(),
                node.getValue());

        System.out.println(message);
    }


    public static void main(String[] args)
    {
        List<GNode<Integer>> list = new ArrayList<>();
        Random random = new Random();
        int val;

        for (int i = 0; i < 10; i++)
        {
            val = random.nextInt(1000000 + 10);
            list.add(new GNode<>(val));
        }

        int adj;
        int j;
        for (int i = 0; i < 10; i++)
        {
            GNode<Integer> node = list.get(i);
            adj = random.nextInt(3);
            j = Math.abs( i - adj) % 10; ;
            for (; j < 10; j++)
            {
                list.get(i)
                    .addAdjacent(
                            list.get(j)
                    );
            }
        }

        new DFS().start(list);
    }

}
