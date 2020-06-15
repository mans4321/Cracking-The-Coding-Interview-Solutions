package cci.ch.four.tree8graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cci.data.structures.TreeNode;

public class FirstCommonAncestor
{
    /**
     * 4.8
     * First Common Ancestor: Design an algorithm and write code to find the first common ancestor
     * of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
     * necessarily a binary search tree.
     * Hints: # 10, #16, #28, #36, #46, #70, #80, #96
     */

    private void start(TreeNode<Integer> root, TreeNode<Integer> first, TreeNode<Integer> second)
    {
        TreeNode<Integer> found = fca(root, first, second);
        System.out.println(found.getValue());
    }

    private TreeNode<Integer> fca(
            TreeNode<Integer> root,
            TreeNode<Integer> first,
            TreeNode<Integer> second)
    {
        if (root != null)
        {
            if(first == root || second == root)
                return root;

            TreeNode<Integer> left = fca(root.getLeft(), first, second);
            TreeNode<Integer> right  = fca(root.getRight(), first,second);

            if(left != null && right != null)
                return root;
            if (left != null || right != null)
                return left == null ? right : left;
        }
        return null;

    }

    private TreeNode<Integer> notNull(
            TreeNode<Integer> fLeft,
            TreeNode<Integer> sRight,
            TreeNode<Integer> sLeft,
            TreeNode<Integer> fRight)
    {
        if (fLeft != null)
        {
            return fLeft;
        }
        if (sRight != null)
        {
            return sRight;
        }
        if (sLeft != null)
        {
            return sLeft;
        }
        return fRight;
    }

    public static void main(String[] args)
    {
        List<Integer> list2 = new ArrayList<>(Arrays.asList(8, 4, 10, 2, 6, 9, 20));
        TreeNode root = new ValidateBST().getRoot(list2);
        TreeNode<Integer> first = root.getRight().getRight();
        TreeNode<Integer> second = root.getRight().getLeft();
        new FirstCommonAncestor().start(root, first, second);
    }

}
