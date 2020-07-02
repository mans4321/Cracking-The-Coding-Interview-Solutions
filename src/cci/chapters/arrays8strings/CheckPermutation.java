package cci.chapters.arrays8strings;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
    Check Permutation: Given two strings, write a method to decide 
    if one is a permutation of the other.
    
    Hints: #7, #84, #722, #737
*/
public class CheckPermutation
{

    /*
        Solution 1 : use 2 hashMap and check if the keys in map 1 exists in map 2 and with same value

        S:O(N + M), M:O(N + M)
    */
    public boolean solution1(String first, String second)
    {
        notNull(first);
        first = cleanString(first);
        second = cleanString(second);

        if (first.length() != second.length())
        {
            return false;
        }

        Map<Character, Integer> firstMap = characterCount(first);
        Map<Character, Integer> secondMap = characterCount(second);

        Set<Character> keySet = firstMap.keySet();
        for (Character key : keySet)
        {
            if (secondMap.get(key) == null &&
                        !firstMap.get(key).equals(secondMap.get(key)))
                return false;
        }

        return true;
    }

    /*
        Solution 2: use 2 hashMap and check if the keys in map 1 exists in map 2 and with same value

        S:O(NLogN + MLogM)
    */
    public boolean solution2(String first, String second)
    {
        notNull(first);
        first = cleanString(first);
        second = cleanString(second);

        if (first.length() != second.length())
        {
            return false;
        }

        String [] firstStringArray = first.split("");
        String [] secondStringArray = second.split("");

        Arrays.sort(firstStringArray);
        Arrays.sort(secondStringArray);

        for (int i = 0; i < firstStringArray.length; i++)
        {
            if(!firstStringArray[i].equals(secondStringArray[i]))
                return false;
        }

        return true;
    }


    private Map<Character, Integer> characterCount(String str)
    {
        return str.chars()
                  .boxed()
                  .collect(
                          Collectors.toMap(
                                  k -> Character.valueOf((char) k.intValue()),
                                  v -> 1,
                                  Integer::sum));
    }

    private void notNull(String... stringsr)
    {
        for (String str : stringsr)
        {
            if (str == null)
            {
                throw new IllegalArgumentException("Cannot pass parms to a function");
            }
        }

    }

    private String cleanString(String str)
    {
        return str.toLowerCase().replace(" ", "").trim();
    }

    public static void main(String[] args)
    {
        System.out.println(7/2);
    }

}
