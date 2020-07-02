package cci.chapters.arrays8strings;

/*
    One Away: There are three types of edits that can be performed on strings: insert a character,
    remove a character, or replace a character. Given two strings, write a function to check if they are
    one edit (or zero edits) away.
    
    EXAMPLE
        pale,  pIe   -> true
        pales, pale  -> true
        pale,  bale  -> true
        pale,  bake  -> false
*/
public class OneAway
{

    /**
     * solution loop and compare
     * <p>
     * S: O(N + M)
     */

    public boolean check(String first, String second)
    {
        notNull(first, second);
        first = cleanString(first);
        second = cleanString(second);

        if (Math.abs(first.length() - second.length()) > 1)
        {
            return false;
        }

        int [] indices = new int [] {0, 0, 0};
        int editCount = 0;

        while (indices[1] < first.length() && indices[2] < second.length())
        {
            if (first.charAt(indices[1]) != second.charAt(indices[2]))
            {
                if (++editCount > 1)
                {
                    return false;
                }
                moveIndices(first, second, indices);
            }
            else
            {
                indices[1]++;
                indices[2]++;
            }

        }

        return indices[1] == first.length() && indices[2] == second.length() ? true :
                                 editCount == 0;
    }

    private int [] moveIndices(String first, String second, int [] indices )
    {
        if (indices[1] + 1 < first.length() &&
                    first.charAt(indices[1] + 1) == second.charAt(indices[2]))
        {
            indices[1]++;
        }
        else if (indices[2] + 1 < second.length() &&
                         first.charAt(indices[1]) == second.charAt(indices[2] + 1))
        {
            indices[2]++;
        }
        else
        {
            indices[1]++;
            indices[2]++;
        }
        return indices;
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
        OneAway p = new OneAway();
        System.out.println("true: " + p.check("pale", "ple"));
        System.out.println("true: " + p.check("pales", "pale"));
        System.out.println("true: " + p.check("pale", "bale"));
        System.out.println("false: " + p.check("pale", "bake"));
        System.out.println("true: " + p.check("", ""));
    }
}
