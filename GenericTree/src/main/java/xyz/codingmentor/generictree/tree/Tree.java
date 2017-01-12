
package xyz.codingmentor.generictree.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.generictree.exeptions.AlreadyHasRootExeption;

/**
 *
 * @author mhorvath
 */
public class Tree<T> {
    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private Node<T> root;
    private Map<Integer, Node<T>> nodes;
    private Node newNode;
    public Tree() {
        this.nodes = new HashMap<>();
    }
    public void addNewNodeById(int parentId,T value){
            addChildIfParentIdMatches(parentId, value, root);
            addNewNodeForDescendandtWithMatchingId(parentId, value, root);
            
    }
    private boolean addNewNodeForDescendandtWithMatchingId(int parentId,T value,Node<T> node){
        boolean isSuccesfull;
        if(node.hasChilds()){
            for(Node child: node.getChildrens()){
                isSuccesfull=addChildIfParentIdMatches(parentId, value, child);
                if(isSuccesfull){
                    return true;
                }
                isSuccesfull=addNewNodeForDescendandtWithMatchingId(parentId,value,child);
                if(isSuccesfull){
                    return true;
                }
            }
        }else{
            isSuccesfull=addChildIfParentIdMatches(parentId, value, node);
            if(isSuccesfull){
                return true;
            }
        }
        return false;
    }
    private boolean addChildIfParentIdMatches(int parentId,T value, Node parent){
        if(parentId==parent.getiD()){
            addNewNode(parent, value);
            return true;
        }else{        
            return false;
        }
    }
    public void addNewNode(Node parent, T value) {
        if (null == parent) {
            if (root!=null) {
                throw new AlreadyHasRootExeption();
            } else {
                root = new Node<>(value,null);
                nodes.put(root.getiD(), root);
                LOGGER.log(Level.INFO,root.toString()+" was created as root.");
            }
        }else{
            newNode=new Node(value,parent);
            parent.addChildren(newNode);
            nodes.put(newNode.getiD(),newNode);
            LOGGER.log(Level.INFO, newNode.toString()+" was created.");
        }
    }
    public void visitAllNodes(){
        LOGGER.log(Level.INFO,"All nodes of the tree");
        root.log();
        root.visitDescendands();
    }
    
    
    
    
}