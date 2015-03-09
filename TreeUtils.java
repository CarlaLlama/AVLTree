import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Utility procedures for binary tree structures.
 * 
 * @author Stephan Jamieson
 * @version 25/2/2015
 */
public class TreeUtils {
        
    /**
     * Determine whether one tree node structure is similar (has the same structure) as another.
     */
    public static boolean similar(BinaryTreeNode treeStructOne, BinaryTreeNode treeStructTwo) {
        assert(treeStructOne!=null);
        assert(treeStructTwo!=null);
        // Your code here
        return false;
    }
    
    /**
     * Obtain a list containing the root node of the given structure i.e. tNode itself.
     */
    public static List<BinaryTreeNode> levelZero(BinaryTreeNode tNode) {
        List<BinaryTreeNode> level = new ArrayList<BinaryTreeNode>();
        level.add(tNode);
        return level;
    }
    
    
    /**
     * Given a list of nodes, obtain the next level. 
     * 
     * <p>
     * If the tree structure is incomplete, <code>BinaryTreeNode.EMPTY_NODE</code> is inserted as a place holder for each
     * missing node.
     * </p>
     */
    public static List<BinaryTreeNode> nextLevel(List<BinaryTreeNode> level) {
        List<BinaryTreeNode> nextLevel = new ArrayList<BinaryTreeNode>(); 
        
        for (BinaryTreeNode node : level) {
            nextLevel.add(node.hasLeft() ? node.getLeft() : BinaryTreeNode.EMPTY_NODE); 
            nextLevel.add(node.hasRight() ? node.getRight() : BinaryTreeNode.EMPTY_NODE);
        }
        return nextLevel;
    }
    
    /**
     * Determine whether node is a place holder i.e. <code>node==BinaryTreeNode.EMPTY_NODE</code>
     */
    public static boolean isPlaceHolder(BinaryTreeNode node) {
        return node==BinaryTreeNode.EMPTY_NODE;
    }
    
}
