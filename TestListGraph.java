import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestListGraph {

    @Test
    public  void testAddNode(){
        Graph g = new ListGraph();

        Assert.assertEquals(true, g.addNode("a"));
        Assert.assertEquals(false, g.addNode("a"));
        Assert.assertEquals(true, g.addNode("b"));
    }

    @Test
    public  void testAddEdge(){
        Graph g = new ListGraph();
        g.addNode("a");
        g.addNode("b");

        Assert.assertEquals(true, g.addEdge("a","b"));
        Assert.assertEquals(false, g.addEdge("a","b"));

    }

    @Test
    public  void testHasNode(){
        Graph g = new ListGraph();
        g.addNode("a");

        Assert.assertEquals(true, g.hasNode("a"));
        Assert.assertEquals(false, g.hasNode("b"));

    }

    @Test
    public  void testHasEdge(){
        Graph g = new ListGraph();
        g.addNode("a");
        g.addNode("b");
        g.addEdge("a","b");

        Assert.assertEquals(true, g.hasEdge("a","b"));
        Assert.assertEquals(false, g.hasEdge("b","a"));
        Assert.assertEquals(false, g.hasEdge("c","a"));

    }

    @Test
    public  void testSucc(){
        Graph g = new ListGraph();
        g.addNode("a");
        g.addNode("b");
        g.addNode("c");
        g.addNode("d");
        g.addNode("e");
        g.addNode("f");
        g.addNode("g");
        g.addNode("h");
        g.addNode("i");

        g.addEdge("a","b");
        g.addEdge("b","c");
        g.addEdge("a","c");
        g.addEdge("b","d");
        g.addEdge("b","e");
        g.addEdge("d","f");
        g.addEdge("f","g");
        g.addEdge("c","g");
        g.addEdge("b","c");

        List<String> succ = Arrays.asList("d","e","c") ;

        Assert.assertEquals(succ.size(), g.succ("b").size());
        Assert.assertTrue(g.succ("b").containsAll(succ));

        Assert.assertEquals(new LinkedList<String>(), g.succ("e"));
        Assert.assertEquals(new LinkedList<String>(), g.succ("h"));
//        Assert.assertEquals(null, g.succ("t"));

    }

    @Test
    public  void testPred(){
        Graph g = new ListGraph();
        g.addNode("a");
        g.addNode("b");
        g.addNode("c");
        g.addNode("d");
        g.addNode("e");
        g.addNode("f");
        g.addNode("g");
        g.addNode("h");
        g.addNode("i");

        g.addEdge("a","b");
        g.addEdge("b","c");
        g.addEdge("a","c");
        g.addEdge("b","d");
        g.addEdge("b","e");
        g.addEdge("d","f");
        g.addEdge("f","g");
        g.addEdge("c","g");


        List<String> pred = Arrays.asList("a","b") ;

        Assert.assertEquals(pred, g.pred("c"));
        Assert.assertEquals(new LinkedList<String>(), g.pred("a"));
        Assert.assertEquals(new LinkedList<String>(), g.pred("h"));
//        Assert.assertEquals(null, g.pred("t"));
    }



    @Test
    public  void testConnected(){
        Graph g = new ListGraph();
        g.addNode("a");
        g.addNode("b");
        g.addNode("c");
        g.addNode("d");
        g.addNode("e");
        g.addNode("f");
        g.addNode("g");
        g.addNode("h");
        g.addNode("i");

        g.addEdge("a","b");
        g.addEdge("b","c");
        g.addEdge("a","c");
        g.addEdge("b","d");
        g.addEdge("b","e");
        g.addEdge("d","f");
        g.addEdge("f","g");
        g.addEdge("c","g");


        Assert.assertEquals(true, g.connected("a","g"));
        Assert.assertEquals(false, g.connected("e","g"));
        Assert.assertEquals(false, g.connected("h","g"));
//        Assert.assertEquals(false, g.connected("t","g"));
//        Assert.assertEquals(false, g.connected("g","t"));

    }



}
