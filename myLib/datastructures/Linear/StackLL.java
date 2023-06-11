import datastructures.nodes.SNode;


public class StackLL extends SLL{

    private SLL Stack = new SLL();

    private SNode head;

    private int size=0;



    public void Push(SNode nodeAdd)
    {
        if(this.Stack.head==null)
        {
            Stack.InsertHead(nodeAdd);
            //this.head=this.Stack.head;
            //this.Stack.head =this.head;
            this.size++;
            return;
        }
        Stack.InsertHead(nodeAdd);
        this.head = this.Stack.head;
        this.size++;


    }

    public int Pop()
    {
        SLL stackCopy = this.Stack;
        int val = stackCopy.head.data;
        Stack.DeleteHead();
        this.head = this.Stack.head;
        this.size--;
        return val;
    }

    public int peek()
    {
        return this.Stack.head.data;

    }

    public int search(SNode node)
    {
        if(this.Stack.Search(node)==null){return -1;}

        int pos =this.size -1;
        SLL stackCopy = this.Stack;

        if(stackCopy.head ==node){return pos;}


        while(stackCopy.head!=node)
        {
            pos--;
            stackCopy.head = stackCopy.head.next;
        }

        return pos;

    }
    @Override
    public void Clear(){this.Stack.Clear();}


    @Override
    public void InsertTail(SNode nodeAdd){}

    @Override
    public void InsertHead(SNode nodeAdd){}

    @Override
    public void Insert(SNode nodeAdd,int pos){}

    @Override
    public void Sort(){}

    @Override
    public void SortedInsert(SNode nodeadd){}

    @Override
    public SNode Search(SNode node){return null;}

    @Override
    public void Delete(SNode node){}

    @Override
    public void DeleteTail(){}

    @Override
    public void DeleteHead(){}


}