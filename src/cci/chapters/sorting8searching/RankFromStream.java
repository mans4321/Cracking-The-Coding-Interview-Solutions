package cci.chapters.sorting8searching;

public class RankFromStream
{
/*
    Rank from Stream:
        Imagine you are reading in a stream of integers. Periodically, you wish to be able
        to look up the rank of a number x (the number of values less than or equal to x). Implement the data
        structures and algorithms to support these operations. That is, implement the method track (intx),
        which is called when each number is generated, and the method getRankOfNumber(int x),
        which returns the number of values less than or equal to X (not including x itself).
*/

    static class Node
    {
        int value;

        int rank;

        Node left, right;

        Node(int value)
        {
            this.value = value;
            left = null;
            right = null;
        }
    }

    int getRankOfNumber(Node node, int value, int rank)
    {
        if(node == null)
            return rank;

        if (value == node.value)
        {
            return node.rank;
        }
        else if (value < node.value)
        {
            return getRankOfNumber(node.left, value, rank);
        }
        else
        {
            return getRankOfNumber(node.right, value, node.rank);
        }
    }

    public void insert(Node node, int value)
    {
        if (value <= node.value)
        {
            node.rank++;
            if (node.left != null)
            {
                insert(node.left, value);
            }
            else
            {
                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new Node(value);
            }
        }
        else if (value > node.value)
        {
            if (node.right != null)
            {
                insert(node.right, value);
            }
            else
            {
                System.out.println("  Inserted " + value + " to right of "
                                           + node.value);
                node.right = new Node(value);
            }
        }
    }

}
