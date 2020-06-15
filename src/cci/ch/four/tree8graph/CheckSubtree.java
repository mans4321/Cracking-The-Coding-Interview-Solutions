package cci.ch.four.tree8graph;

import java.util.ArrayList;
import java.util.List;

import cci.data.structures.TreeNode;

public class CheckSubtree
{
    /**
     * 4.10
     * Check Subtree: Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
     * algorith m to determine if T2 is a subtree of Tl .
     * A tree T2 is a subtree ofTi if there exists a node n in Ti such that the subtree of n is identical to T2.
     * That is, if you cut off the tree at node n, the two trees would be identical.
     * <p>
     * Hints: #4, #7 7, #78, #37, #37
     */

    public void checkSubtree(TreeNode<Integer> t1, TreeNode<Integer> t2)
    {
        List<TreeNode<Integer>> founds = new ArrayList<>();
        find(t1, t2.getValue(), founds);

        for (TreeNode<Integer> found : founds)
        {
            if (equal(found, t2))
            {
                System.out.println(true);
                return;
            }
        }

        System.out.println(false);
    }

    private void find(TreeNode<Integer> root, int val, List<TreeNode<Integer>> founds)
    {
        if (root == null)
        {
            return;
        }

        if (root.getValue() == val)
        {
            founds.add(root);
        }

        find(root.getLeft(), val, founds);
        find(root.getRight(), val, founds);
    }

    private boolean equal(TreeNode<Integer> t1, TreeNode<Integer> t2)
    {
        if (t1 == null || t2 == null)
        {
            return t1 == t2;
        }

        boolean left = equal(t1.getLeft(), t2.getLeft());
        boolean right = equal(t1.getRight(), t2.getRight());

        return left && right;
    }

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++)
        {
            list.add(i + 1);
        }
        TreeNode<Integer> t1 = new MinimalTree().start(list);
        TreeNode<Integer> t2 = new TreeNode<>(60);

        new CheckSubtree().checkSubtree(t1, t2);

    }
}
