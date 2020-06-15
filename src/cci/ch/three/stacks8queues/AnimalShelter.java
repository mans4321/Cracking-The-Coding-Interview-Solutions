package cci.ch.three.stacks8queues;

import cci.data.structures.Node;

/*
    Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
    out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
    or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
    that type). They cannot select which specific animal they would like. Create the data structures to
    maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
    and dequeueCat. You may use the built-in Linked List data structure.
    
    Hints: #22, #56, #63
*/
public class AnimalShelter 
{

    Node<Animal> oldestDog;
    Node<Animal> newestDog;

    Node<Animal> oldestCat;
    Node<Animal> newestCat;

    Node<Animal> newestAnimal;
    Node<Animal> oldestAnimal;

    public void enqueue(final Animal animal)
    {
        final Node<Animal> newNode  = new Node<>(animal);
        typeEnqueue(newNode);

        if(newestAnimal == null)
        {
            newestAnimal = oldestAnimal = newNode;
        }
        else
        {
            newestAnimal.next = newNode;
            newNode.perv = newestAnimal;
            
            newestAnimal = newNode;
        }
    }

    public Animal dequeueAny()
    {
        if(oldestAnimal == null)
        {
            return null;
        }
        
        Animal animal = oldestAnimal.value;
        dequeue(oldestAnimal);
        
        return animal;
    }

    public Animal dequeueDog()
    {
        if(oldestDog == null)
            return null;

        final Animal animal = oldestDog.value;
        dequeue(oldestDog);
        return animal;
    }

    public Animal dequeueCat()
    {
        if(oldestCat == null)
            return null;

        final Animal animal = oldestCat.value;
        dequeue(oldestCat);
        return animal;
    }


    private void dequeue(Node<Animal> animalNode) 
    {

        if(animalNode.value instanceof Dog)
        {
            oldestDog = oldestDog.typeNext;
        }
        else
        {
            oldestCat = oldestCat.typeNext;
        }

        animalNode.perv = animalNode.next;

        if(animalNode == newestAnimal)
        {
            newestAnimal = newestAnimal.perv;
        }

        if(animalNode == oldestAnimal)
        {
            oldestAnimal = oldestAnimal.next;
        }
    }

    private void typeEnqueue(Node<Animal> node) 
    {

        if(node.value instanceof Dog)
        {
            enqueueDog(node);
        }
        else
        {
           enqueueCat(node);
        }
    }


    private void enqueueCat(final Node<Animal> catNode) 
    {
        if(newestCat == null)
        {
            oldestCat = newestCat = catNode;
        }else
        {
            newestCat.typeNext = catNode;
            newestCat = catNode;
        }
    }

    private void enqueueDog(final Node<Animal> dogNode)
    {
        if(newestDog == null)
        {
            oldestDog = newestDog = dogNode;
        }else
        {
            newestDog.typeNext = dogNode;
            newestDog = dogNode;
        }
    }


    class Node<V extends Animal>
    {
        private Node<V> perv;
        private Node<V> next;
        private Node<V> typeNext;
        private final V value;   
        
        Node(final V value)
        {
            this.value = value;
        }
    }

    abstract class Animal
    {

    }

    class Cat extends Animal
    {

    }

    class Dog extends Animal
    {

    }

}