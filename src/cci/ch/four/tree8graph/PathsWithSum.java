package cci.ch.four.tree8graph;

import cci.data.structures.TreeNode;

public class PathsWithSum
{
    /**
     * 4.12
     * Paths with Sum: You are given a binary tree in which each node contains an integer value (which
     * might be positive or negative). Design an algorithm to count the number of paths that sum to a
     * given value. The path does not need to start or end at the root or a leaf, but it must go downwards
     * (traveling only from parent nodes to child nodes).
     * <p>
     * Hints: #6, #74, #52, #68, #77, #87, #94, #703, #708, #115
     */

    private int pathsWithSums(TreeNode<Integer> root, int currSum, int disSum)
    {
        if (root == null)
        {
            return 0;
        }

        int childrenOnly = onlyChildren(root, disSum);
        int myAndMyChildren = onlyIncludeMe(root, disSum);
        int wholeFamily = includeAllOfUs(root, currSum, disSum);

        int sum = childrenOnly + myAndMyChildren + wholeFamily;
        if (currSum + root.getValue() == disSum)
        {
            sum++;
        }
        return sum;
    }

    private int onlyChildren(TreeNode<Integer> root, int disSum)
    {
        int left = pathsWithSums(root.getLeft(), 0, disSum);
        int right = pathsWithSums(root.getRight(), 0, disSum);
        return left + right;
    }

    private int onlyIncludeMe(TreeNode<Integer> root, int disSum)
    {
        if (root.getValue() >= disSum)
        {
            return 0;
        }
        int left = pathsWithSums(root.getLeft(), root.getValue(), disSum);
        int right = pathsWithSums(root.getRight(), root.getValue(), disSum);
        return left + right;
    }

    private int includeAllOfUs(TreeNode<Integer> root, int currSum, int disSum)
    {
        int meAndMyParent = currSum + root.getValue();
        if (meAndMyParent >= disSum)
        {
            return 0;
        }
        int left = pathsWithSums(root.getLeft(), meAndMyParent, disSum);
        int right = pathsWithSums(root.getRight(), meAndMyParent, disSum);
        return left + right;
    }


    private int pathsWithSums(TreeNode<Integer> root, int disSum)
    {
        return pathsWithSums(root, 0, 0);
    }
    public static void main(String[] args)
    {
        TreeNode<Integer> t1 = new TreeNode<>(0);
        TreeNode<Integer> t2 = new TreeNode<>(0);
        TreeNode<Integer> t3 = new TreeNode<>(0);
        t2.setLeft(t3);
        t1.setLeft(t2);

        System.out.println(new PathsWithSum().pathsWithSums(t1, 0));
    }

}