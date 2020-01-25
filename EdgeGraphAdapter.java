import java.lang.reflect.Array;
import java.util.*;

public class EdgeGraphAdapter implements EdgeGraph {

    private Graph g;


    EdgeGraphAdapter(Graph g) { this.g = g; }

    public boolean addEdge(Edge e) {
        g.addNode(e.getSrc());
        g.addNode(e.getDst());
        return g.addEdge(e.getSrc(),e.getDst());
    }


    public boolean hasNode(String n) {

        return g.hasNode(n);

    }


    public boolean hasEdge(Edge e) {
	return g.hasEdge(e.getSrc(), e.getDst());
    }

    public boolean hasPath(List<Edge> e) throws BadPath{
	try{
	    for(int i = 0; i < e.size(); i++){
	        if(!hasEdge(e.get(i))) return false;
	        if(!(i==e.size()-1)) {      // not the end of edges
                if (!(e.get(i).getDst().equals(e.get(i+1).getSrc()))) throw new BadPath("It is a bad path!");
            }
        }
	    return true;
    } catch (Exception ex) {
        ex.printStackTrace();
        System.out.println(ex.getMessage());
    }return false;
    }

}