import com.sun.source.tree.BreakTree;

import java.util.*;

public class ListGraph implements Graph {
    private HashMap<String, LinkedList<String>> nodes = new HashMap<>(); //hashmap key value add get remove contains great


    public boolean hasNode(String n) {
        return nodes.containsKey(n);
    }

    public boolean hasEdge(String n1, String n2) {   //just check not throw
        if (!(nodes.get(n1) == null)) {
            for (String n : nodes.get(n1)) {     //iterate
                if (n.equals(n2)) return true;
            }
        }
        return false;
    }


    public boolean addNode(String n) {
        if (!hasNode(n)) {
            nodes.put(n, new LinkedList<String>());
            return true;
        } else return false;
    }

    public boolean addEdge(String n1, String n2) throws NoSuchElementException {    //take actions have to throw
        try {
            if (!hasNode(n1)) throw new NoSuchElementException(n1 + " was not added!"); //was n1 added?
            else if (!hasNode(n2)) throw new NoSuchElementException(n2 + " was not added!"); //was n2 added?
            else {
                if (!hasEdge(n1, n2)) {
                    nodes.get(n1).add(n2);
                    return true;
                }
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw e;
        }
        return false;
    }


    public List<String> succ(String n) throws NoSuchElementException {
        try {
            if (!hasNode(n)) throw new NoSuchElementException(n + " was not added!");
            return nodes.get(n);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<String> pred(String n) throws NoSuchElementException {
        try {
            if (!hasNode(n)) throw new NoSuchElementException(n + " was not added!");
            List<String> predNodes = new LinkedList<String>();
            for (Map.Entry<String, LinkedList<String>> entry : nodes.entrySet()) {    //
                if (entry.getValue().contains(n)) predNodes.add(entry.getKey());    //
            }
            return predNodes;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean connected(String n1, String n2) throws NoSuchElementException {
        try {
            if (!hasNode(n1)) throw new NoSuchElementException(n1 + " was not added!"); //was n1 added?
            else if (!hasNode(n2)) throw new NoSuchElementException(n2 + " was not added!"); //was n2 added?
            else {
                Queue<String> queue = new LinkedList<String>();          //queue first-in first-out
                HashSet<String> discoverSet = new HashSet<>();     //hashset easy to add,get,remove.contains

                discoverSet.add(n1);       //first set discover
                queue.offer(n1);           //add queue
                while(!(queue.size()==0)){       //queue never be null!
                    String head = queue.poll();    //retrieve and remove first
                    if (head.equals(n2)) return true;   //find destination! true
                    for (String n: nodes.get(head)){      //next get(head)! not get(n1)
                        if(!discoverSet.contains(n)) {   //was discovered?
                            discoverSet.add(n);        //no, set discovered and add in queue
                            queue.offer(n);
                        }
                    }
                }                                  //until queue is null
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return false;               //after catching, have to return
    }
}