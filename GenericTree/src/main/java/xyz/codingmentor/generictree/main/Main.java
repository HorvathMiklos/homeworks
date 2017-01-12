
package xyz.codingmentor.generictree.main;

import xyz.codingmentor.generictree.tree.Tree;

/**
 *
 * @author mhorvath
 */
public class Main {

    private Main() {
    }
    
    public static void main(String[] args) {
        Tree testTree=new Tree();
        testTree.addNewNode(null, "R");
        testTree.addNewNodeById(0, "A0");
        testTree.addNewNodeById(0, "A1");
        testTree.addNewNodeById(0, "A2");        
        testTree.addNewNodeById(1, "B0");
        testTree.addNewNodeById(1, "B1");        
        testTree.visitAllNodes();
    }
}
