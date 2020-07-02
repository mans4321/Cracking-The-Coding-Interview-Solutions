package cci.chapters.tree8graph.concept;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class PrefixTrees
{

    TreeNode root;

    public PrefixTrees(List<String> words)
    {
        root = new TreeNode((char) -1);

        for (int i = 0; i < words.size(); i++)
        {
            TreeNode curr = root;
            for (int j = 0; j < words.get(i).length(); j++)
            {
                char ch = words.get(i).charAt(j);
                curr = curr.getChild(ch) != null ?
                                curr.getChild(ch) : curr.add(ch);
            }
            curr.add('*');
        }
    }

    private boolean find(String str)
    {
        TreeNode curr = root;
        for (int i = 0; i < str.length(); i++)
        {
            TreeNode chNode = curr.getChild(str.charAt(i));
            if(chNode == null)
                return false;
            curr = chNode;
        }

        return curr.getChild('*') != null;
    }

    public static void main(String[] args)
    {

        List<String> lines = readFile("wordlist.txt");
        List<String> words =
                lines.stream().map(
                        line -> Arrays.asList(line.split(" ")))
                     .flatMap(Collection::stream).map(String::trim).filter(str -> !str.isEmpty()).collect(Collectors.toList());

       boolean res =  new PrefixTrees(words).find("zygotic");
        System.out.println(res);
    }

    private static List<String> readFile(String filename)
    {
        List<String> records = new ArrayList<String>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (!line.trim().isEmpty())
                {
                    records.add(line);
                }

            }
            reader.close();
            return records;
        }
        catch (Exception e)
        {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
        }
        return null;
    }

    private class TreeNode
    {
        char ch;

        Map<Character, TreeNode> map;

        public TreeNode(char ch)
        {
            this.ch = ch;
            map = new HashMap<>();
        }

        public TreeNode add(char ch)
        {
            map.put(ch,  new TreeNode(ch));
            return map.get(ch);
        }


        TreeNode getChild(char ch)
        {
            return map.get(ch);
        }
    }
}
