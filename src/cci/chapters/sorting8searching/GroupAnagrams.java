package cci.chapters.sorting8searching;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class GroupAnagrams
{
/*    Group Anagrams:
           Write a method to sort an array of strings so that all
           the anagrams are next to each other.

    Hints: #177, #182, #263, #342
*/

    public static void main(String[] args)
    {
        String[] strs = { "acre", "mam", "dad", "race", "mans", "saad" , "whatever", "care" };
        solution1(strs);// N * maxNumOfChars(...str)
        System.out.println(Arrays.toString(strs));
    }

    private static void solution1(String[] strs)
    {
        HashMap<String, List<String>> map = new HashMap<>();
        int lastIndex = strs.length - 1;
        for (int i = 0; i < strs.length; i++)
        {
            String curr = strs[i];
            strs[i] = null;
            String hashed = getHash(curr);
            put(hashed, curr, map);
        }
        addToArray(map.values(), strs);
    }

    private static void addToArray(Collection<List<String>> from, String[] to)
    {
        AtomicInteger index = new AtomicInteger();
        from.stream()
            .flatMap(Collection::stream)
            .forEach(str -> {
                to[index.getAndIncrement()] = str;
            });
    }

    private static void put(String hashed, String str, HashMap<String, List<String>> map)
    {
        if (map.get(hashed) == null)
        {
            List<String> strings = new ArrayList<>(Arrays.asList(str));
            map.put(hashed, strings);
            return;
        }
        map.get(hashed).add(str);
    }

    private static String getHash(String str)
    {
        int[] charCount = countCharactr(str);
        return buildHashString(charCount);
    }

    private static String buildHashString(int[] charCount)
    {
        StringBuilder hash = new StringBuilder(26);
        for (int i = 0; i < charCount.length; i++)
        {
            hash.append(charCount[i]);
        }
        return hash.toString();
    }

    private static int[] countCharactr(String str)
    {
        int[] charCount = new int[26];
        for (int i = 0; i < str.length(); i++)
        {
            int index = str.charAt(i) - 'a';
            charCount[index]++;
        }
        return charCount;
    }
}
