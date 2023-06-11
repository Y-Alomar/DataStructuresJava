import datastructures.nodes.SNode;

public class QueueLL extends SLL{
    
    private SLL Queue = new SLL();
    
    private SNode head;
    
    private int size=0; 
    
    
    public void Enqueue(SNode nodeAdd)
    {
        if(this.Queue.head==null)
        {
            Queue.InsertHead(nodeAdd); 
            this.head=this.Queue.head;
            this.size++;
            return;
        }
        Queue.InsertTail(nodeAdd);
        this.head = this.Queue.head;
        this.size++;
    }


    
    public int Dequeue()
    {
        SLL queueCopy = this.Queue;
        int val = queueCopy.head.data;
        Queue.DeleteHead();
        this.size--;
        return val;
    }
    
    public int peek()
    {
        return this.Queue.head.data;
        
    }
    
    public int search(SNode node)
    {
        if(this.Queue.Search(node)==null){return -1;}
        
        int pos = 0;
        SLL queueCopy = this.Queue;
        
        if(queueCopy.head ==node){return pos;}
        
        
        while(queueCopy.head!=node)
        {
            pos++;
            queueCopy.head = queueCopy.head.next;
        }
        return pos;
    }
    
    
    public boolean isEmpty()
    {
        if(this.size==0){return true;}
        return false;
    }

    //clears the queue
    public void clear()
    {       
        //First in first out
        while(this.size!=0)
        {
            this.Dequeue();
        }
        
    }
    @Override
    public void Clear(){Clear();this.head=null;}


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
    

