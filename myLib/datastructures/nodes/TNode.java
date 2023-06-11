package datastructures.nodes;

public class TNode {
    public int data;
    public TNode left;
    public TNode right;
    public TNode parent;
    public int balance;
    
    //setters
    public void setData(int data){this.data=data;}
    public void setLeft(TNode left){this.left=left;} 
    public void setRight(TNode right){this.right=right;}
    public void setParent(TNode parent){this.parent=parent;}
    public void setBalance(int balance){this.balance=balance;}


    //Getters

    public int getData(){return this.data;}
    public TNode getLeft(){return this.left;}
    public TNode getRight(){return this.right;}
    public TNode getParent(){return this.parent;}
    public int getBalance(){return this.balance;}

    //Constructors

    public TNode()
    {
        this.data =0;
        this.left=null;
        this.right=null;
        this.parent=null;
        this.balance=-2; //Only allowed value for balance is -1,0,1
    }

    public TNode(int data,int balance,TNode P,TNode L,TNode R)
    {
        this.data = data;
        this.parent=P;
        this.left=L;
        this.right=R;
        if(balance ==0 || balance ==1||balance==-1)
        {
            this.balance=balance;
        }
    }
    public String toString(){return Integer.toString(this.data);}

    public void print()
    {
        System.out.println("Parent Node: "+this.parent.data);
        System.out.println("Left Node: "+this.left.data);
        System.out.println("Right Node: "+this.right.data);
        System.out.println("Balance: "+this.balance);


    }

    
}
