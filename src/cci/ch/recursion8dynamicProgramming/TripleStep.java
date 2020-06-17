package cci.ch.recursion8dynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TripleStep
{

/*
    Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
    steps at a time. Implement a method to count how many possible ways the child can run up the stairs.

    Hints: # 152, # 178, #217, #237, #262, #359

*/

    public int solution(int n)
    {
        throwIfNLessThanZero(n);

        List<Integer> hops = new LinkedList<>(Arrays.asList(1, 3, 6)); // base cases for n == 1,  n == 2,or n == 3 respectably

        if (n < 4) // n is base cse
        {
            return baseCase(n, hops);
        }

        final int FIRST_INDEX = 0;
        final int LAST_INDEX = 2;

        for (int i = 3; i < n; i++)
        {
            int sum = hops.stream().reduce(0, (a, b) -> a + b);
            hops.remove(0);
            hops.add(sum);
        }
        return hops.get(2);
    }

    private int baseCase(int n, List<Integer> hops)
    {
        if(n == 0)
            return 0;
        return hops.get(n - 1);
    }

    private void throwIfNLessThanZero(int n)
    {
        if (n < 0)
        {
            throw new IllegalArgumentException("number of steps has to be larger than 0");
        }
    }

    public static void main(String[] args)
    {
        int res = new TripleStep().solution(6);
        System.out.println(res);
    }
}
