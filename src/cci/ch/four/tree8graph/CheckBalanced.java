package cci.ch.four.tree8graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cci.data.structures.TreeNode;

public class CheckBalanced
{
    /**
     * 4.4
     * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
     * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
     * node never differ by more than one.
     * Hints: #2 7, #33, #49, # 705, # 724
     */

    void start(TreeNode root)
    {
        int res = isBalanced(root);
        System.out.println(res == -1 ? false : true);
    }

    private int isBalanced(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        int lD = isBalanced(root.getLeft());
        int rD = isBalanced(root.getRight());

        if (Math.abs(lD - rD) > 1 ||
                    lD == -1 ||
                    rD == -1)
        {
            return -1;
        }

        return Math.max(lD, rD) + 1;
    }

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++)
        {
            list.add(i + 1);
        }

        TreeNode root = new MinimalTree().start(list);
        new CheckBalanced().start(root);
    }

}
