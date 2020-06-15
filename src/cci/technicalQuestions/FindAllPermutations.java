package cci.technicalQuestions;

import java.util.Map;

public class FindAllPermutations
{

    /**
     * Example: Given a smaller string s  and a bigger string b.
     * design an algorithm to find all  permutation of the shorter String
     * within the longer one. print the location of each permutation.
     *
     */

    public static void main(String[] args)
    {
        String shortStr = "abbc";
        String longStr = "cbabadebbabbebabaabcebabe";

        allPermutation(shortStr, longStr);
    }

    private static void allPermutation(String shortStr, String longStr)
    {
        Map<Character, Integer> originalMap = createMap(shortStr);
        int i = 0;
        for (int j = 0; j < longStr.length(); j++)
        {
            
        }
    }

    private static Map<Character, Integer> createMap(String shortStr)
    {
      //  Stream.of(shortStr).collect(Collectors.toMap());
        return null;
    }

}
