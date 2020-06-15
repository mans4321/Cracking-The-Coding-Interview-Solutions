package cci.ch.four.tree8graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cci.data.structures.TreeNode;

public class ValidateBST
{
    /**
     * 4.5
     * Validate BST: Implement a function to check if a binary tree is a binary search tree.
     * Hints: #35, #57, #86, # 773, # 728
     */

    private boolean start(TreeNode<Integer> root)
    {
        if (root == null)
        {
            return true;
        }

        Integer val = binarySearch(root, false);
        return val != Integer.MAX_VALUE && root.getValue() < val;
    }

    private Integer binarySearch(TreeNode<Integer> root, boolean smallest)
    {
        if (root == null)
        {
            return null;
        }

        Integer left = binarySearch(root.getLeft(), false);
        Integer right = binarySearch(root.getRight(), true);

        return subTreeIsBinarySearch(root.getValue(), left, right, smallest);
    }

    private Integer subTreeIsBinarySearch(Integer rootVal, Integer left, Integer right, boolean smallest)
    {
        boolean notBinary = false;

        if ((left != null && rootVal < left) ||
                    (right != null && rootVal > right))
        {
            notBinary = true;
        }

        if (smallest)
        {
            if (notBinary)
            {
                return Integer.MAX_VALUE;
            }
            return left == null ? rootVal : left;
        }
        else
        {
            if (notBinary)
            {
                return Integer.MIN_VALUE;
            }
            return right == null ? rootVal : right;
        }
    }

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(8, 4, 10, 2, 6, 0, 20));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(8, 4, 10, 2, 6, 9, 20));

        TreeNode root = new ValidateBST().getRoot(list2);
        new ListOfDepths().listofDepths(root);
        boolean res = new ValidateBST().start(root);
        System.out.println(res);
    }

    public TreeNode getRoot(List<Integer> list)
    {
        TreeNode root = new TreeNode<>(list.get(0));
        build(root, 0, list.size(), list);
        return root;
    }

    private void build(TreeNode<Integer> root, int i, int n, List<Integer> list)
    {
        if (i >= n / 2 || i < 0)
        {
            return;
        }

        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;

        TreeNode left = new TreeNode<>(list.get(leftIndex));
        TreeNode right = new TreeNode<>(list.get(rightIndex));

        build(left, leftIndex, n, list);
        build(right, rightIndex, n, list);
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
}
