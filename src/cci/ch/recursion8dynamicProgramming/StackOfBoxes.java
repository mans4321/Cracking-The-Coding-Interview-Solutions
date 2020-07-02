package cci.ch.recursion8dynamicProgramming;

import java.util.Arrays;

public class StackOfBoxes
{
/*
    Stack of Boxes:

        You have a stack of n boxes, with widths Wi ' heights hi ' and depths d . The boxes
        icannot be rotated and can only be stacked on top of one another if each box in the stack is strictly
        larger than the box above it in width, height, and depth. Implement a method to compute the
        height of the tallest possible stack. The height of a stack is the sum of the heights of each box.

    Hints: #155, #194, #214, #260, #322, #368, #378
*/

    public static void main(String[] args)
    {
        Box [] boxs = {
                new Box(2, 2, 2),
                new Box(2, 2, 2),
                new Box(3, 3, 3),
                new Box(2, 2, 2),
                new Box(3, 3, 3),
                new Box(4, 4, 4)
        };

        Arrays.sort(boxs);
        int totalHeight = boxs[0].h;
        for (int i = 1; i < boxs.length ; i++)
        {
            if(boxs[i].sum() > boxs[i - 1].sum())
            {
                totalHeight += boxs[i].h;
            }
        }

        System.out.println(totalHeight);
    }


    static class Box implements Comparable<Box>
    {
        int h;
        int w;
        int d;

        public Box(int h, int w, int d)
        {
            this.h = h;
            this.w = w;
            this.d = d;
        }

        int sum()
        {
            return h + w + d;
        }

        @Override public int compareTo(Box box)
        {
            return Integer.compare(this.sum(), box.sum());
        }
    }

}
