package cci.ch.four.tree8graph.concept;

import java.util.Objects;

import cci.data.structures.Tree;
import cci.data.structures.TreeNode;

public class PostOrderTraversal
{
    private static void postOrderTraversal(Tree<Integer> tree)
    {
        postOrderTraversal(tree.getRoot());
    }

    public static void postOrderTraversal(TreeNode<Integer> root)
    {
        if (Objects.nonNull(root))
        {
            postOrderTraversal(root.getLeft());
            postOrderTraversal(root.getRight());
            visit(root);
        }
    }

    private static void visit(TreeNode<Integer> node)
    {
        System.out.println(node.getValue());
    }

    public static void main(String[] args)
    {
        TreeNode<Integer> l1l = new TreeNode<>(9);
        TreeNode<Integer> l1r = new TreeNode<>(18);
        TreeNode<Integer> l1 = new TreeNode<>(5, l1l, l1r);

        TreeNode<Integer> r1l = new TreeNode<>(3);
        TreeNode<Integer> r1r = new TreeNode<>(7);
        TreeNode<Integer> r1 = new TreeNode<>(20, r1l, r1r);

        TreeNode<Integer> root = new TreeNode<>(10, l1, r1);
        Tree<Integer> tree = new Tree<Integer>(root);

        postOrderTraversal(tree);
    }
}
