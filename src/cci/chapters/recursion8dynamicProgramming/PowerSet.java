package cci.chapters.recursion8dynamicProgramming;

import java.util.*;

public class PowerSet
{
/*
     Power Set: Write a method to return all subsets of a set.

      Hints: #273, #290, #338, #354, #373
*/

    public List<List<Integer>> solution(int index, List<Integer> set) // O(2^n)
    {
        List<List<Integer>> setOfSets = new ArrayList<>();
        if(index < 0)
        {
            setOfSets.add(new ArrayList<>());
            return setOfSets;
        }
        setOfSets = solution(index - 1, set);
        int me = set.get(index);
        createSetsByAddingMe(setOfSets, me);
        return setOfSets;
    }

    private void createSetsByAddingMe(List<List<Integer>> setOfSets, int me)
    {
        int size = setOfSets.size();
        for (int i = 0; i < size; i++)
        {
            List addMe =  new ArrayList(setOfSets.get(i));
            addMe.add(me);
            setOfSets.add(addMe);
        }
    }

    public static void main(String[] args)
    {
        List<Integer> set = Arrays.asList(1,2);
        List<List<Integer>> setOfSets = new PowerSet().solution(set.size() - 1, set);

        setOfSets.forEach(System.out::println);
    }
}
