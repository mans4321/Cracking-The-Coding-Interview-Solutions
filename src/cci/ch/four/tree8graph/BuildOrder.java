package cci.ch.four.tree8graph;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import cci.data.structures.GNode;

public class BuildOrder
{

    /**
     * 4.7
     * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
     * projects, where the second project is dependent on the first project). All of a project's dependencies
     * must be built before the project is. Find a build order that will allow the projects to be built. If there
     * is no valid build order, return an error.
     * <p>
     * EXAMPLE
     * Input:
     * projects: a, b, c, d, e, f
     * dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
     * Output:
     * f, e, a, b, d, c
     * Hints:
     * #26, #47, #60, #85, # 125, # 733
     */

    private List<Character> buildOrder(List<GNode<Character>> pd)
    {
        List<Character> bo = new ArrayList<>();
        Map<Character, Boolean> map = new HashMap<>();
        pd.forEach(ele ->
                           buildOrder(ele, map, bo)
        );

        if (map.get('*') != null)
        {
            System.out.println("No_PATH");
        }else
        {
            System.out.println(bo);
        }
        return null;
    }

    private void buildOrder(GNode<Character> project, Map<Character, Boolean> map, List<Character> buildOrder)
    {
        if (map.get(project.getValue()) != null)
        {
            return;
        }

        project.setVisited(true);
        for (GNode<Character> dependency : project.getAdjacent())
        {
            if (dependency.isVisited())
            {
                map.put('*', true);
                return;
            }
            buildOrder(dependency, map, buildOrder);
        }

        project.setVisited(false);
        buildOrder.add(project.getValue());
        map.put(project.getValue(), true);

    }

    public static void main(String[] args)
    {
        List<GNode<Character>> projects = Arrays.asList(
                new GNode<>('b'),
                new GNode<>('c'),
                new GNode<>('d'),
                new GNode<>('e'),
                new GNode<>('a'),
                new GNode<>('f'));

        List<String> dependenies = Arrays.asList("a:d", "f:b", "b:d", "f:a", "d:c");

        Map<Character, GNode<Character>> map =
                projects.stream().collect(Collectors.toMap(node -> node.getValue(), Function.identity()));

        dependenies.forEach(ele -> {
            GNode<Character> p = map.get(ele.charAt(2));
            GNode<Character> d = map.get(ele.charAt(0));
            p.addAdjacent(d);
        });

        new BuildOrder().buildOrder(projects);

    }
}