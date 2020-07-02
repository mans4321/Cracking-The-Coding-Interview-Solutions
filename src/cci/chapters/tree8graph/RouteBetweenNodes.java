package cci.chapters.tree8graph;

import java.util.*;
import cci.dataStructures.GNode;

public class RouteBetweenNodes
{
    /**
     * 4.1
     *  Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
     * route between two nodes.
     * Hints: #127
     */


    private boolean bfs(GNode<Integer> start, GNode<Integer> end)
    {
        if (start == null || end == null)
        {
            return false;
        }

        Queue<GNode<Integer>> queue = new LinkedList<>();
        queue.add(start);
        start.setVisited(true);

        while (!queue.isEmpty())
        {
            GNode<Integer> node = queue.poll();
            if(node.getId() == end.getId())
                return true;
            visited(node);
            for (GNode adj : node.getAdjacent())
            {
                if (!adj.isVisited())
                {
                    if(adj.getId() == end.getId())
                        return true;
                    adj.setVisited(true);
                    queue.add(adj);
                }
            }
        }
        return false;
    }

    private void visited(GNode<Integer> node)
    {

        String message = String.format(
                "id= %d \t value= %d",
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

        for (int i = 0; i < 10; i++)
        {
            GNode<Integer> node = list.get(i);
            for (int j = 0; j < 3; j++)
            {
                int index = random.nextInt(10);
                if (i == index)
                    continue;
                node.addAdjacent(
                            list.get(index)
                    );
            }
            System.out.print(node.getId() + "\t");
            node.getAdjacent().forEach(no-> System.out.print(no.getId() + "\t"));
            System.out.println();
        }

        RouteBetweenNodes route = new RouteBetweenNodes();
       // new RouteBetweenNodes().dfs(list.get(0), list.get(9));

        boolean bfs_res = route.bfs(list.get(0), list.get(9));
        System.out.println(bfs_res);
    }

}
