package cci.dataStructures;

public class TreeNode<T>
{
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode()
    {

    }
    public TreeNode(T value)
    {
        this.value = value;
    }

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    public void setLeft(TreeNode<T> left)
    {
        this.left = left;
    }

    public void setRight(TreeNode<T> right)
    {
        this.right = right;
    }

    public T getValue()
    {
        return value;
    }

    public TreeNode<T> getLeft()
    {
        return left;
    }

    public TreeNode<T> getRight()
    {
        return right;
    }

}
