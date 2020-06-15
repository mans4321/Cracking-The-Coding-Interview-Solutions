package cci.ch.four.tree8graph;

import java.util.ArrayList;
import java.util.List;

import cci.data.structures.TreeNode;

public class MinimalTree
{
    /**
     * 4.2
     * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algo-
     * rithm to create a binary search tree with minimal height.
     * Hints: #19, #73, #176
     */

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++)
        {
            list.add(i + 1);
        }
        new MinimalTree().start(list);
    }

    public TreeNode<Integer> start(List<Integer> list)
    {
        TreeNode root = new TreeNode<>(0);
        build(root, 0, list.size());
        //print(root);
        return root;
    }

    private void build(TreeNode<Integer> root, int i, int n)
    {
        if (i >= n / 2 || i < 0)
        {
            return;
        }

        int leftIndex = left(i);
        int rightIndex = right(i);

        TreeNode left = new TreeNode<>(leftIndex);
        TreeNode right = new TreeNode<>(rightIndex);

        build(left, leftIndex, n);
        build(right, rightIndex, n);
        attachChildToParent(root, left, leftIndex);
        attachChildToParent(root, right, rightIndex);
    }

    private void attachChildToParent(TreeNode<Integer> parent, TreeNode child, int i)
    {
        if (i % 2 == 0)
        {
            parent.setRight(child);
        }
        else
        {
            parent.setLeft(child);
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
}
