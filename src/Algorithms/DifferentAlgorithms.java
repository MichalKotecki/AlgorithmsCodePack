package Algorithms;

import Graph.EdgeList;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DifferentAlgorithms {

    ArrayList<Integer> GenerateRandomList(int numOfElements)
    {
        List<Integer> tempList = IntStream.range(0, numOfElements).boxed().collect(Collectors.toList());
        ArrayList<Integer> collection = new ArrayList<>(tempList);
        Collections.shuffle(collection);
        return collection;
    }



    void HoareAlgorithm(ArrayList<Integer> collection, int indexOfSearchedElement)
    {
        if(collection.size() > 1)
        {
           int someNumber =  collection.get(0);
           ArrayList<Integer> collectionA = new ArrayList<>();
           ArrayList<Integer> collectionB = new ArrayList<>();
           collection.forEach( e -> {
               if(e >= someNumber) collectionA.add(e);
               else collectionB.add(e);
           });
           if(collectionA.size() > collectionB.size() && collectionA.size() < indexOfSearchedElement)
           {

           }

        }
        else
        {
            System.out.println("Searched element is: " + collection.get(0));
        }
    }




    public static void main(String[] args) {

       DifferentAlgorithms AlgoObject = new DifferentAlgorithms();

       ArrayList<Integer> List = AlgoObject.GenerateRandomList(15);

       System.out.println(List);
    }
}
