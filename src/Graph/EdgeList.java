package Graph;

import javafx.util.Pair;

import java.util.ArrayList;


public class EdgeList {

    private ArrayList <Pair> edges = null;
    private ArrayList <Integer> weights = null;

    public EdgeList() {
        this.edges = new ArrayList<Pair>();
        this.weights = new ArrayList();
    }

    public EdgeList(ArrayList<Pair> edges) {
        weights = new ArrayList<>();
        this.edges = edges;
    }

    public EdgeList(ArrayList<Pair> edges, ArrayList<Integer> weights) {
        weights = weights;
        this.edges = edges;
    }

    public ArrayList<Pair> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Pair> edges) {
        this.edges = edges;
    }

    public void addEdge(Pair pair) {
        weights.add(0);
        edges.add(pair);
    }

    public void addEdge(Pair pair, Integer weight) {
        weights.add(weight);
        edges.add(pair);
    }

    public void removeEdge(Pair pair)
    {
        for (Pair p: this.edges) {
            if(p.getKey().equals(pair.getKey()) && p.getValue().equals(pair.getValue())){
                int indexR = edges.indexOf(p);
                edges.remove(p);
                weights.remove(indexR);
            }

        }
    }

    public void Print(){
        for (int i=0; i < edges.size(); i++){
            System.out.println(edges.get(i).getKey() + ", " + edges.get(i).getValue() + "   Weight: " + weights.get(i));
        }
    }
}
