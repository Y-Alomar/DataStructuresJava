package datastructures.Trees;
import datastructures.nodes.*;
import java.util.*;
public class BST {

    public TNode root;


    public BST(){this.root=null;}
    public BST(int val){
       TNode m = new TNode();
       m.setData(val);
       this.root=m; 
    }
    public BST(TNode obj)
    {
        this.root=obj;
    }

    //Getter
    public TNode getRoot(){return this.root;}
    //Setter
    public void setRoot(TNode root){this.root=root;}


    public void Insert(int val)
    {

        TNode newChild = new TNode();
        newChild.setData(val);
        
        TNode current=this.root;
        TNode parent = null;
        while(current!=null)
        {
            parent=current;
            if(val<=current.data)
            {
                current = current.left;
            }
            else
            {
                current=current.right;
            }

        }
        if(this.root==null)
        {
            this.root=newChild;
        }
        else if(val<=parent.data)
        {
            TNode left = new TNode();
            left.setData(val);
            left.setParent(parent);
            parent.setLeft(left);
        }
        else
        {
            TNode right = new TNode();
            right.setData(val);
            right.setParent(parent);
            parent.setRight(right);
        }

    }

    public void Insert(TNode newChild)
    {
        
        TNode current=this.root;
        TNode parent = null;
        while(current!=null)
        {
            parent=current;
            if(newChild.data<=current.data)
            {
                current = current.left;
            }
            else
            {
                current=current.right;
            }

        }
        if(this.root==null)
        {
            this.root=newChild;
        }
        else if(newChild.data<=parent.data)
        {
            TNode left = new TNode();
            left.setData(newChild.data);
            left.setParent(parent);
            parent.setLeft(left);
        }
        else
        {
            TNode right = new TNode();
            right.setData(newChild.data);
            right.setParent(parent);
            parent.setRight(right);
        }
    }

    public void Delete(int val)
    {
        if(Search(val)==null){System.out.println("This node does not exist in the tree");}
        TNode node = Search(val);
        if (node.getLeft() == null && node.getRight() == null) {
            // Case 1: node has no children
            if (node.getParent() == null) {
                // Node is root
                this.root = null;
            } else if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(null);
            } else {
                node.getParent().setRight(null);
            }
        } else if (node.getLeft() == null) {
            // Case 2a: node has only right child
            if (node.getParent() == null) {
                // Node is root
                this.root = node.getRight();
            } else if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(node.getRight());
            } else {
                node.getParent().setRight(node.getRight());
            }
            node.getRight().setParent(node.getParent());
        } else if (node.getRight() == null) {
            // Case 2b: node has only left child
            if (node.getParent() == null) {
                // Node is root
                this.root = node.getLeft();
            } else if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(node.getLeft());
            } else {
                node.getParent().setRight(node.getLeft());
            }
            node.getLeft().setParent(node.getParent());
        } else {
            // Case 3: node has two children
            TNode successor = FindSmallestNode(node.getRight());
            node.setData(successor.getData());
            Delete(successor.data);
        }




    }


    private TNode FindSmallestNode(TNode node) {
        TNode current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }




    public TNode Search(int val) {
        TNode current = this.root;
    
        while (current != null) {
            if (val == current.getData()) {
                // node with val found, return it
                return current;
            } else if (val < current.getData()) {
                // val is less than current node data, traverse left subtree
                current = current.getLeft();
            } else {
                // val is greater than current node data, traverse right subtree
                current = current.getRight();
            }
        }
    
        // node with val not found in tree, return null
        return null;
    }

    public void printInOrder()
    {
        TNode node = this.root;
        printRec(node);
    }
    private void printRec(TNode node)
    {
        if(node==null){return;}
        printRec(node.left);
        System.out.print(node.data+" ");
        printRec(node.right);

    }
    public void printBF() {
        if (this.root == null) {
            return;
        }
        Queue<TNode> queue = new LinkedList<TNode>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TNode node = queue.poll();
                System.out.print(node.getData() + " ");
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            System.out.println();
        }
    }


    
}
