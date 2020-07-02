package cci.chapters.arrays8strings;

/*
    String Rotation: Assume you have a method isSubst ring which checks if one word is a substring
    of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
    call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat").
    
    Hints: #34, #88, #104

*/
public class StringRotation
{
    /**
     * iterator &  match
     */
    public boolean isRotation(String first, String second)
    {
        notNull(first, second);
        first = cleanString(first);
        second = cleanString(second);

        if (first.length() != second.length())
        {
            return false;
        }

        if (first.isEmpty() && second.isEmpty())
        {
            return true;
        }

        int matchStart = -1;
        int length = first.length();

        int i = 0;
        int j = 0;

        while (i < length && j < length)
        {
            if (first.charAt(i) == second.charAt(j))
            {
                if (matchStart < 0)
                {
                    matchStart = i;
                }
                i++;
                j++;

            }
            else
            {
                matchStart = -1;
                i++;
            }
        }
        
        return matchStart < 0 ? false : second.contains(first.substring(0, matchStart));
    }

    private void notNull(String... strings)
    {
        for (String str : strings)
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
        StringRotation rotation = new StringRotation();
        boolean result = rotation.isRotation("waterbottll", "waterbottle");

        System.out.println(result);
    }
}
