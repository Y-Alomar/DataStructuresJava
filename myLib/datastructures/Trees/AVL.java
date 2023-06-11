package datastructures.Trees;
import datastructures.nodes.*;
public class AVL extends BST {
    
    private TNode root;

    public void AVL(){this.root=null;}
    public void AVL(int val)
    {
        TNode node = new TNode();
        node.setData(val);
        super.root=node;
        this.root=node;

    }
    public void AVL(TNode obj)
    {
        super.root=obj;
        this.root =super.root;
        balance(super.root);
    }


    public void setRoot(TNode node)
    {
        super.root = node;
        this.root=super.root;
    }
    public TNode getRoot(){return super.root;}

    @Override
    public void Insert(TNode nodeAdd){super.Insert(nodeAdd);balance(super.root);}

    @Override
    public void Insert(int val){super.Insert(val);balance(super.root);}

    @Override
    public void printInOrder(){super.printInOrder();}

    @Override
    public void printBF(){super.printBF();}

    @Override
    public TNode Search(int val){return super.Search(val);}

    private void balance(TNode node) {
        if (node == null) {
            return;
        }
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            node = rotateRight(node);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            node = rotateLeft(node);
        }
        // update balance factor for this node
        node.setBalance(getBalanceFactor(node));
        // recursively balance child nodes
        balance(node.getLeft());
        balance(node.getRight());
    }

    
    private TNode rotateLeft(TNode node) {
        TNode temp = node.getRight();
        node.setRight(temp.getLeft());
        temp.setLeft(node);
        return temp;
    }
    
    private TNode rotateRight(TNode node) {
        TNode temp = node.getLeft();
        node.setLeft(temp.getRight());
        temp.setRight(node);
        return temp;
    }
    
    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = node.getLeft() == null ? 0 : getHeight(node.getLeft());
        int rightHeight = node.getRight() == null ? 0 : getHeight(node.getRight());
        return leftHeight - rightHeight;
    }
    
    private int getHeight(TNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = node.getLeft() == null ? 0 : getHeight(node.getLeft());
        int rightHeight = node.getRight() == null ? 0 : getHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

}

