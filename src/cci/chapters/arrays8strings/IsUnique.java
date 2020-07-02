package cci.chapters.arrays8strings;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
        Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
        cannot use additional data structures?
        
        Hints: #44, # 777, # 7 32

*/
public class IsUnique
{


    /*
        Solution 1 : use hashMap

        S:O(N), M:O(N)
    */
    public boolean solution1(String str)
    {
        notNull(str);
        str = cleanString(str);

        Map<Character, Integer> map = str.chars()
                                         .boxed()
                                         .collect(
                                                 Collectors.toMap(
                                                         k -> Character.valueOf((char) k.intValue()),
                                                         v -> 1,
                                                         Integer::sum));
        map.keySet().forEach(k -> System.out.println(k + " " + map.get(k)));
        return map.values().stream().noneMatch(v -> v > 1);
    }

    /*
        Solution 2 : Sort and Iterator to see if two adjacent character are equal.

        S: O(NlogN)
    */
    public boolean solution2(String str)
    {
        notNull(str);
        str = cleanString(str);

        String[] strings = str.split("");
        Arrays.sort(strings);
        Stream.of(strings).forEach(System.out::println);
        System.out.println(strings.length);
        for (int i = 1; i < strings.length; i++)
        {
            if (strings[i].equals(strings[i - 1]))
            {
                return false;
            }
        }
        return true;
    }

    private void notNull(String str)
    {
        if (str == null)
        {
            throw new IllegalArgumentException("Cannot pass parms to a function");
        }
    }

    private String cleanString(String str)
    {
        return str.toLowerCase().replace(" ", "").trim();
    }

}
