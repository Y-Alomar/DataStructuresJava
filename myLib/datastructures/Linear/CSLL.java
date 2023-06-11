import datastructures.nodes.*;
public class CSLL extends SLL {
    
    private int size= 0;
    private SNode head;


    public CSLL()
    {
        this.head=null;
    }

    public CSLL(SNode node)
    {
        this.head=node;
        node.next=this.head;
        this.size++;
    }
    //Functions that do not need changing from SLL



    //Delete functions
    @Override
    public void DeleteHead()
    {
        SNode traverse = this.head;
        while(traverse.next!=this.head)
        {
            traverse =traverse.next;
        }
        traverse.next = this.head.next;
        this.head=this.head.next;
        this.size--;
    }

    @Override
    public void DeleteTail()
    {
        SNode traverse = this.head;
        int current=0;
        while(current != getSize()-1)
        {
            current++;
            traverse=traverse.next;
        }
        traverse.next=this.head;
        this.size--;

    }

    @Override 
    public void Delete(SNode nodeDelete)
    {
        if(Search(nodeDelete)==null){throw new IllegalArgumentException("This node does not exist in the linked list");}
        int pos =0;
        SNode traverse=this.head;

        while(traverse!=nodeDelete)
        {
            pos++;
            traverse=traverse.next;
        }

        if(pos==0)
        {
            DeleteHead();
            return;
        }
        if(pos==getSize())
        {
            DeleteTail();
            return;
        }
        SNode before=this.head;
        int beforePos = 0;
        while(beforePos!=pos-1)
        {
            before = before.next;
            beforePos++;
        }
        SNode after = traverse.next;
        before.next = after;
        this.size--;


    }

    //Inserting functions

    @Override
    public void InsertHead(SNode nodeAdd)
    {
        SNode head = this.head;
        if(head==null)
        {
            this.head = nodeAdd;
            nodeAdd.next=this.head;
            this.size++;
            return;
        }




        nodeAdd.next=head;
        SNode last =this.head;
        int current = 0;
        while(current!=getSize())
        {
            if(last!=null)
            {
                last = last.next;
            }
            current++;
        }
        last.next = nodeAdd;
        this.head = nodeAdd;
        this.size++;



    }

    @Override
    public void InsertTail(SNode nodeAdd)
    {
        if(this.head==null){throw new IllegalArgumentException("The list does not have a head please make add a head first");}
        
        SNode lastNode = this.head;
        int current = 0;
        while(current!=getSize())
        {
            if(lastNode!=null)
            {
                lastNode = lastNode.next;
            }
            current++;
        }
        lastNode.next = nodeAdd;
        nodeAdd.next=this.head;
        this.size++;
    }

    //Nothing really changes between these two inserts(Almost the same thing)
    public void Insert(SNode nodeAdd,int pos){
        
        if(pos<0||pos>getSize()+1){throw new IllegalArgumentException("The postion exceeds the size of the linked list");}
        SNode traverse = this.head;
        int current = 0;

        if(pos==0)
        {
            InsertHead(nodeAdd);
            return;
        }

        while(current!=pos-1)
        {
            current++;
            traverse=traverse.next;
        }

        if(traverse.next==nodeAdd)
        {
            throw new IllegalArgumentException("This node already exists in the linked list");
        }
        SNode nextNode = traverse.next;
        traverse.next=nodeAdd;
        nodeAdd.next=nextNode;
        this.size++;


    }

    @Override
    public void SortedInsert(SNode nodeAdd)
    {
        InsertTail(nodeAdd);
        Sort();
    }



    @Override
    public void Sort()
    {
        if(isSorted()){return;}
        SNode cur=this.head.next;
        if(this.size==2)
        {
            DeleteTail();
            InsertHead(cur);
            return;
        }
        SNode current = this.head;
        do {
            SNode next = current.next;
            boolean swapped = false;
            
            // Traverse the list again, comparing adjacent nodes and swapping them if necessary
            while (next != this.head) {
                if (current.data > next.data) {
                    int temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                    swapped = true;
                }
                current = next;
                next = next.next;
            }

            // If no swaps were made during the inner loop, the list is sorted and we can stop
            if (!swapped) {
                break;
            }

            // Reset the pointers and continue traversing the list
            current = this.head;
        } while (true);
        


    }

    @Override
    public void Clear()
    {
        this.head = null;
        this.size =0;
    }

    @Override
    public void Print()
    {
        if(this.head ==null)
        {
            System.out.printf("\nLength: ",this.size,"\n");
            System.out.println("\nSorted Status: None\n");
            System.out.println("\nNo content to print\n");
            return;
        }
        SNode traverse = this.head;
        System.out.printf("Length: %d\n", this.size);
        System.out.printf("Sorted Status: %b\n",isSorted());
        while(traverse.next != this.head)
        {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }
        System.out.print(traverse.data+" ");


    }


    //Helper functions

    private int getSize()
    {
        int size = 0;
        SNode traverse = this.head;
        if(traverse ==null)
        {
            return 0;
        }
        while(traverse.next!=this.head)
        {
            size++;
            traverse=traverse.next;
        }
        return size;
    }
    
    private boolean isSorted()
    {
        SNode traverse = this.head;
        while(traverse.next!=this.head)
        {
            SNode check = traverse.next;
            if(traverse.data>check.data){return false;}
            traverse=traverse.next;

        }

        return true;
    }

    //Search 

    @Override
    public SNode Search(SNode node)
    {
        SNode traverse = this.head; 
        while(traverse.next !=this.head)
        {
            if(traverse == node) 
            {
                return traverse;
            }
            traverse = traverse.next;
        }
        if(traverse.next == this.head)
        {
            return traverse;
        }

        return null;
    }

}
