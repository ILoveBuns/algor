package graph;

public class GraphNode {
    String value;
    int level;
    GraphNode(String value){
        this.value = value;
    }
    GraphNode(String value,int level){
        this.value = value;
        this.level = level;
    }
}
