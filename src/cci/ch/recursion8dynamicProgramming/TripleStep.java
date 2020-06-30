package cci.ch.recursion8dynamicProgramming;

import java.util.LinkedList;

public class TripleStep
{

/*
    Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
    steps at a time. Implement a method to count how many possible ways the child can run up the stairs.

    Hints: # 152, # 178, #217, #237, #262, #359

*/

    public int solution(int n)
    {
        if (n < 0)
        {
            throw new IllegalArgumentException("The Number Of Steps must be larger than zero");
        }

        int[] mem = create8InitMem(n + 1);
        //int s1 = solution1(n, mem);// O(N) time & O(N) Memory
        int s2 = solution2(n); // O(N) time & O(1) Memory
        return s2;
    }

    private int solution2(int n)
    {
        if (n == 0)
        {
            return 0;
        }

        LinkedList<Integer> mem = create8InitMemQueue();

        if (n <= 3)
        {
            return mem.get(n - 1);
        }

        for (int i = 4; i < n; i++)
        {
            int sum = getSum(mem);
            appendToEndAndRemoveFirst(sum, mem);
        }

        return getSum(mem);
    }

    private void appendToEndAndRemoveFirst(int sum, LinkedList<Integer> mem)
    {
        mem.addLast(sum);
        mem.removeFirst();
    }

    private int getSum(LinkedList<Integer> mem)
    {
        return mem.stream()
                  .reduce(0, (num1, num2) -> num1 + num2);
    }

    private LinkedList<Integer> create8InitMemQueue()
    {
        LinkedList<Integer> mem = new LinkedList<>();
        mem.add(1);
        mem.add(2);
        mem.add(4);
        return mem;
    }

    private int[] create8InitMem(int size)
    {
        int[] mem = new int[size];
        mem[0] = 1;
        return mem;
    }

    public int solution1(int n, int[] mem)
    {
        if (n < 0)
        {
            return 0;
        }
        if (mem[n] != 0)
        {
            return mem[n];
        }

        int oneStep = solution1(n - 1, mem);
        int twoSteps = solution1(n - 2, mem);
        int threeSteps = solution1(n - 3, mem);

        return oneStep + twoSteps + threeSteps;
    }

    public static void main(String[] args)
    {
        int res = new TripleStep().solution(5);
        System.out.println(res);
    }
}
