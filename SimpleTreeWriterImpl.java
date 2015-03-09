import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
/**
 * Write a description of class BinaryTreeNodePrintStream here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleTreeWriterImpl implements SimpleTreeWriter {

    private PrintStream output;
    
    public SimpleTreeWriterImpl(PrintStream output) {
        this.setDestination(output);
    }

    public void setDestination(PrintStream output) {
        this.output=output;
    }
    
    public void write(BinaryTreeNode node) {
        List<BinaryTreeNode> level = TreeUtils.levelZero(node);
        final int labelSize = node.getLargest().toString().length();
   
        for(int levelNum=0; levelNum<node.getHeight(); levelNum++) {
            final int nodeSpacing = powerOf2(node.getHeight()-levelNum)-1;
            writeLevel(nodeSpacing, labelSize, level);
            level = TreeUtils.nextLevel(level);
        }
    }
    
    
    private void writeLevel(int nodeSpacing, int labelSize, List<BinaryTreeNode> level) {
        final String leadingSpace = makeSpacing((nodeSpacing/2)*labelSize);
        final String interNodeSpace = makeSpacing(nodeSpacing*labelSize);

        Iterator<BinaryTreeNode> iterator = level.iterator();
        assert(iterator.hasNext());
        
        output.print(leadingSpace);        
        writeNode(iterator.next(), labelSize);
        
        while (iterator.hasNext()) {
            output.print(interNodeSpace);
            writeNode(iterator.next(), labelSize);
        }
        output.println();
    }

    private void writeNode(BinaryTreeNode node, int labelSize) {
        final String blankNode = makeSpacing(labelSize);
        if (TreeUtils.isPlaceHolder(node)) {
            output.printf(blankNode);
        }
        else {
            output.printf("%"+labelSize+"d", node.getItem());
        }        
    }

    private static int powerOf2(int power) {
        if (power==0) {
            return 1;
        }
        else {
            return 2*powerOf2(power-1);
        }
    }
        
    private static String makeSpacing(int size) {
        StringBuilder builder = new StringBuilder(size);
        while(size>0) {
            builder.append(' ');
            size--;
        }
        return builder.toString();
    }

}
