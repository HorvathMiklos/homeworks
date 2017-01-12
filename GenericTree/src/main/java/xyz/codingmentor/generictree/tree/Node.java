
package xyz.codingmentor.generictree.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhorvath
 */
public class Node<T> {
    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private int iD;
    private T value;
    private List<Node> childrens;
    private Node parent;
    private static int nextiD=0;
    public Node(T value, Node parent) {
        this.iD=nextiD++;
        this.value = value;
        this.parent = parent;
        childrens=new ArrayList<>();
    }

    public Node(Node parent) {
        this.iD=nextiD++;
        this.parent = parent;
        childrens=new ArrayList<>();
    }
    
    public void addChildren(Node newChildren){
        childrens.add(newChildren);
        LOGGER.log(Level.INFO,this.toString()+ " has new child: "+ newChildren.toString());
    }
    public void log(){
        LOGGER.log(Level.INFO,this.toString()+" was visited");
    }
    public void visitDescendands(){
        if(this.hasChilds()){
            for(Node child: this.getChildrens()){
                child.log();
                child.visitDescendands();
            }
        }else{
            LOGGER.log(Level.INFO,this.toString()+" is a leaf");
        }
    }
    public boolean haveParent(){
        return null==this.parent;
    }
    public boolean hasChilds(){
        return !this.childrens.isEmpty();
    }
    public int getiD() {
        return iD;
    }

    public T getValue() {
        return value;
    }

    public List<Node> getChildrens() {
        return childrens;
    }

    public Node getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "Node{" + "iD=" + iD + ", value=" + value + ", parent=" + parent + '}';
    }
    
}
