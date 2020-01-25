import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestGraphAdapter {

    @Test
    public void testAddEdge(){
        Graph g = new ListGraph();
        Edge e = new Edge("a","b");
        EdgeGraphAdapter adapter =new EdgeGraphAdapter(g);
        Assert.assertEquals(true,  adapter.addEdge(e));
        Assert.assertEquals(false,  adapter.addEdge(e));
    }

    @Test
    public void testHasNode(){
        Graph g = new ListGraph();
        Edge e = new Edge("a","b");
        EdgeGraphAdapter adapter =new EdgeGraphAdapter(g);
        Assert.assertEquals(false,  adapter.hasNode("a"));

        adapter.addEdge(e);
        Assert.assertEquals(true,  adapter.hasNode("a"));


    }

    @Test
    public void testHasEdge(){
        Graph g = new ListGraph();
        Edge e = new Edge("a","b");
        EdgeGraphAdapter adapter =new EdgeGraphAdapter(g);
        Assert.assertEquals(false,  adapter.hasEdge(e));

        adapter.addEdge(e);
        Assert.assertEquals(true,  adapter.hasEdge(e));

    }

    @Test
    public void testHasPath(){
        Graph g = new ListGraph();
        EdgeGraphAdapter adapter =new EdgeGraphAdapter(g);
        Edge e0 = new Edge("a","b");
        Edge e1 =new Edge("a","c");
        Edge e2 =new Edge("b","d");
        Edge e3 =new Edge("b","e");
        Edge e4 =new Edge("b","c");
        Edge e5 =new Edge("d","f");
        Edge e6 =new Edge("f","g");
        Edge e7 =new Edge("c","g");
        adapter.addEdge(e0);
        adapter.addEdge(e1);
        adapter.addEdge(e2);
        adapter.addEdge(e3);
        adapter.addEdge(e4);
        adapter.addEdge(e5);
        adapter.addEdge(e6);
        adapter.addEdge(e7);
        List<Edge> l = new LinkedList<Edge>();
        l.add(e0);
        l.add(e2);
        l.add(e5);
        l.add(e6);
        l.add(e3);
        l.add(e1);
        l.add(e4);
        l.add(e7);
        Assert.assertEquals(false,  adapter.hasPath(l));

        /*l.add(e0);
        l.add(e2);
        l.add(e5);
        l.add(e6);
        Assert.assertEquals(true,  adapter.hasPath(l));*/
    }


}
