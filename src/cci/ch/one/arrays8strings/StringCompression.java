package cci.ch.one.arrays8strings;


/*
    String Compression: Implement a method to perform basic string compression using the counts
    of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
    "compressed" string would not become smaller than the original string, your method should return
    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
    
    Hints: #92, # 11 0
*/
public class StringCompression
{
    /*
        Solution 1 : Sort and Iterator to see if the adjacent character are equal and how many .

        S: O(NlogN)
    */
    public String solution1(String str)
    {
        notNull(str);
        str = cleanString(str);

        StringBuilder builder = new StringBuilder();
        int i = 0;

        while ( i < str.length())
        {
            int j = i + 1;
            while (j < str.length())
            {

                if(str.charAt(j) != str.charAt(i))
                    break;
                j++;
            }

            builder.append(str.charAt(i));
            builder.append(j - i);
            i = j;
        }

        return builder.length() < str.length() ? builder.toString() : str;
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

    public static void main(String[] args)
    {
        StringCompression compression = new StringCompression();

        System.out.println(compression.solution1("aabcccccaaa"));

        System.out.println(compression.solution1("abcdefgtyhu"));
    }
}
