package cci.chapters.tree8graph;

import java.util.*;

import cci.dataStructures.TreeNode;

public class ListOfDepths
{
    /**
     * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
     * at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
     * Hints: #107, #123, #735
     */


    public void listofDepths(TreeNode root)
    {
        List<List<TreeNode<Integer>>> lod = new LinkedList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);
        int i = 0;
        int d= 0;
        lod.add(new LinkedList<>());

        while (queue.peek() !=null)
        {
            TreeNode<Integer> curr = queue.poll();
            lod.get(d).add(curr);
            i++;
            if(i == Math.pow(2,d))
            {
                i= 0;
                d++;
                lod.add(new LinkedList<TreeNode<Integer>>());
            }
            queue.add(curr.getLeft());
            queue.add(curr.getRight());
        }

        //lod.forEach(coll -> {System.out.println();coll.forEach( node -> System.out.print(node.getValue() + "\t"));});
    }

    public void start()
    {
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++)
        {
            list.add(i + 1);
        }
        TreeNode node = new MinimalTree().start(list);
        new ListOfDepths().listofDepths(node);
    }



    public static void main(String[] args)
    {
        new ListOfDepths().start();
    }


}
