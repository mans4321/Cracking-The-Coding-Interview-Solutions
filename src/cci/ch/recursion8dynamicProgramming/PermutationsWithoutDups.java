package cci.ch.recursion8dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithoutDups
{
    /*
        Permutations without Dups:
            Write a method to compute all permutations of a string of unique characters.

        Hints: #150, #185, #200, #267, #278, #309, #335, #356
    */

    public List<String> solution(String str, int index)
    {
        if (index < 0)
        {
            return new ArrayList<>();
        }
        List<String> permutations = solution(str, index - 1);
        char me = str.charAt(index);
        return addMeToAllPermutations(me, permutations);
    }

    private List<String> addMeToAllPermutations(char me, List<String> permutations)
    {
        List<String> addMe = new ArrayList();

        if (permutations.isEmpty())
        {
             addMeAtPosition(me, 0, "", addMe);
        }

        for (String str : permutations)
        {
            addMeToAllPositions(me, str, addMe);
        }
        return addMe;
    }

    private void addMeToAllPositions(char me, String str, List<String> addMe)
    {
        for (int i = 0; i <= str.length(); i++)
        {
            addMeAtPosition(me, i, str, addMe);
        }
    }

    private void addMeAtPosition(char me, int pos, String str, List<String> addMe)
    {
        String before = str.substring(0, pos);
        String after =  str.substring(pos);
        String newStr = before + me + after;
        addMe.add(newStr);
    }

    public static void main(String[] args)
    {
        String str = "ab";
        List<String> list = new PermutationsWithoutDups().solution(str, str.length() - 1);
        list.forEach(System.out::println);
    }
}
