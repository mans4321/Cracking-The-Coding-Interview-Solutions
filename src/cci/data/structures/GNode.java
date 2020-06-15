package cci.data.structures;

import java.util.ArrayList;
import java.util.List;

public class GNode<T>
{
    private static int idGenerate;
    private int id;
    private List<GNode<T>> adjacent;
    private T value;
    private boolean visited;
    public GNode(T value)
    {
        this.id = idGenerate++;
        this.value = value;
        this.adjacent = new ArrayList<>();
    }

    public GNode(T value, List<GNode<T>> adjacent)
    {
        this.id = idGenerate++;
        this.value = value;
        this.adjacent = adjacent;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
       this.id = id;
    }

    public boolean isVisited()
    {
        return visited;
    }

    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }

    public void addAdjacent(GNode<T> adj)
    {
        if(this.adjacent == null)
            this.adjacent = new ArrayList<>();
        if(!adjacent.contains(adj))
            this.adjacent.add(adj);
    }

    public List<GNode<T>> getAdjacent()
    {
        return adjacent;
    }

    public void setAdjacent(List<GNode<T>> adjacent)
    {
        this.adjacent = adjacent;
    }

    public T getValue()
    {
        return value;
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    @Override public String toString()
    {
        return "GNode{" +
                       "id=" + id +
                       "adjacent=" + adjacent +
                       ", value=" + value +
                       '}';
    }
}
