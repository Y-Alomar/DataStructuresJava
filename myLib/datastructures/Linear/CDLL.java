import datastructures.nodes.*;


public class CDLL extends DLL {
    
    private DNode head;
    private DNode tail;
    private int size= 0;

    public CDLL()
    {
        this.head=null;
        this.tail=null;
    }

    public CDLL(DNode node)
    {
        this.head=node;
        this.tail=node;
        node.prev=node;
        node.next=node;
        this.size++;
    }

    //Delete Methods

    public void DeleteHead()
    {
        if(this.head==null){throw new IllegalAccessError("You need to instantiate the list");}

        DNode after = this.head.next;
        after.prev=this.tail;
        this.tail.next=after;
        this.head=after;
        this.size--;

    }

    public void DeleteTail()
    {
        if(this.head==null){throw new IllegalAccessError("You need to instantiate the list");}

        DNode before = this.tail.prev;
        before.next = this.head;
        this.head.prev=before;
        this.tail=before;
        this.size--;
    }
    public void Delete(DNode node)
    {

        if(Search(node)==null){throw new IllegalArgumentException("This node does not exist in the list");}

        DNode traverse = this.head;
        int current = 0;

        if(traverse==node){DeleteHead();return;}



        while(traverse.next!=node)
        {
            current++;
            traverse = traverse.next;
        }
        if(traverse != node){current++;traverse=traverse.next;}

        //if(current == getSize()){DeleteTail();return;}
        
        DNode before = traverse.prev;
        DNode after = traverse.next;
        before.next=after;
        after.prev = before;
        this.size--; 


    }


    //Insert Methods
    public void InsertHead(DNode nodeAdd)
    {
        if(this.head==null)
        {
            this.head=nodeAdd;
            this.tail=nodeAdd;
            nodeAdd.prev=nodeAdd;
            nodeAdd.next=nodeAdd;
            this.size++;
            return;
        }
        DNode currentHead = this.head;
        currentHead.prev=nodeAdd;
        nodeAdd.next=currentHead;
        nodeAdd.prev =this.tail;
        this.head=nodeAdd;
        this.tail.next=this.head;
        this.size++;
    }


    public void InsertTail(DNode nodeAdd)
    {
        DNode currentTail = this.tail;
        currentTail.next=nodeAdd;
        nodeAdd.prev=currentTail;
        nodeAdd.next=this.head;
        this.tail=nodeAdd;
        this.head.prev=this.tail;
        this.size++;

    }

    public void Insert(DNode nodeAdd,int pos)
    {
        if(pos<0||pos>getSize()+1){throw new IllegalArgumentException("This postion exceeds the size of the linked list ");}

        if(pos==0){InsertHead(nodeAdd);return;}
        if(pos==getSize()){InsertTail(nodeAdd);return;}

        DNode traverse = this.head;
        int current = 0;

        while(current!=pos)
        {
            current++;
            traverse=traverse.next;

        }
        if(traverse.next==nodeAdd){throw new IllegalArgumentException("This node already exists in the list");}
        DNode previous = traverse.prev;
        previous.next = nodeAdd;
        traverse.prev =nodeAdd;
        nodeAdd.next =traverse;
        nodeAdd.prev=previous;
        this.size++;

    }

    public void SortedInsert(DNode nodeAdd)
    {
        Insert(nodeAdd, getSize());
        Sort();
    }



    //Other useful methods
    public void Sort() {
        // if list is empty or has only one element, it is already sorted
        if (isSorted()) {
            return;
        }
        DNode current = this.head.next;
        int numNodesTraversed = 0;
        int listSize = getSize();
        while (numNodesTraversed < listSize) {
            DNode next = current.next;
            if (current.data < current.prev.data) {
                DNode temp = current.prev;
                while (temp != this.head && current.data < temp.data) {
                    temp = temp.prev;
                }
                if (temp == this.head) {
                    // Insert at head
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current.next = this.head;
                    current.prev = this.head.prev;
                    this.head.prev.next = current;
                    this.head.prev = current;
                    this.head = current;
                } else {
                    // Insert after temp
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current.prev = temp;
                    current.next = temp.next;
                    temp.next.prev = current;
                    temp.next = current;
                }
            }
            current = next;
            numNodesTraversed++;
            }
            DNode newHead = this.head;
            int pos = 0;
            while(pos!=getSize())
            {
                pos++;
                newHead = newHead.next;
                
            }
            this.tail=newHead;



        }


    
    




    public void Clear()
    {
        if(this.head==null){return;}
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    public void Print()
    {
        if(this.head ==null)
        {
            System.out.printf("\nLength: ",this.size,"\n");
            System.out.println("\nSorted Status: None\n");
            System.out.println("\nNo content to print\n");
            return;
        }
        DNode traverse = this.head;
        System.out.printf("Length: %d\n", this.size);
        System.out.printf("Sorted Status: %b\n",isSorted());
        while(traverse.next != this.head)
        {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }
        System.out.print(traverse.data + " ");
    }

    public DNode Search(DNode node)
    {
        DNode traverse = this.head;
        while(traverse.next!=this.head)
        {
            if(traverse==node)
            {
                return traverse;
            }
            traverse = traverse.next;
        }

        if(traverse == node)
        {
            return node;
        }
        return null;



    }

    









    //Helper functions

    
    private int getSize()
    {
        if(this.head==null){return 0;}
        DNode traverse = this.head;
        int size = 0;
        while(traverse.next!=this.head)
        {
            size++;
            traverse=traverse.next;
        }
        return size;

    }

    private boolean isSorted()
    {
        DNode traverse = this.head;
        while(traverse.next!=this.head)
        {
            DNode check = traverse.next;
            if(traverse.data>check.data){return false;}
            traverse=traverse.next;

        }

        return true;


    }


}