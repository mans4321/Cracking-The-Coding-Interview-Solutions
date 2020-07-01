package cci.ch.recursion8dynamicProgramming;

public class Parens
{
/*
    Parens:
        Implement an algorithm to print all valid (e.g., properly opened and closed) combinations
        of n pairs of parentheses.

    EXAMPLE
        Input: 3
        Output: ((())), (()()), (())(), ()(()), ()()()

    Hints: #138, #174, #187, #209, #243, #265, #295
*/

    public static void main(String[] args)
    {
        int num = 3;
        solution("(", 1, 0,  num * 2);
    }

    private static void solution(String str, int open, int close, int total)
    {
        if (str.length() == total)
        {
            System.out.println(str);
        }
        if (open < total / 2)
        {
            solution(str + "(", open + 1, close, total);
        }
        if (open > close)
        {
            solution(str + ")", open, close + 1, total);
        }

    }
}
