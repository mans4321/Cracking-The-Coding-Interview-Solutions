package cci.ch.four.tree8graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cci.data.structures.Tree;
import cci.data.structures.TreeNode;

public class Successor
{
    /**
     * 4.6
     *      Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
     *      binary search tree. You may assume that each node has a link to its parent.
     * Hints: #79, #91
     */


    private TreeNode<Integer> successor(TreeNode<Integer> root)
    {
        if(root == null || root.getRight() == null)
            return null;

        TreeNode<Integer> curr = root.getRight();

        while (curr.getLeft() != null)
        {
            curr = curr.getLeft();
        }
        return  curr;
    }

    public static void main(String[] args)
    {
        List<Integer> list2 = new ArrayList<>(Arrays.asList(8, 4, 10, 2, 6, 9, 20));

        TreeNode root = new ValidateBST().getRoot(list2);
        TreeNode<Integer> succ = new Successor().successor(root.getLeft());

        System.out.println(succ.getValue());
    }

}
