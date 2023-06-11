import datastructures.nodes.SNode;

public class SLL
{
    
    private int size = 0;
    SNode head; //Beginning of linked list


    public SLL()
    {
        //Set Head to point to null
        this.head= null; //Entire object head is null 
    }
    public SLL(SNode node)
    {
        this.head = node;//Node argument is going to be used as the head here
        this.size++;
    }

    public void InsertHead(SNode nodeAdd)
    {
        SNode node1 = this.head; //This is the node that head points to
        nodeAdd.next = node1;// Make the newNode point at the previous node that head pointed to
        this.head = nodeAdd;//Break the connection between head and node1 and make head point to nodeAdd
        this.size++;

    }
    public void InsertTail(SNode nodeAdd)
    {
        SNode traverse = this.head;
        while(traverse.next!=null)//Go through the linked list until we get to the end
        {
            traverse = traverse.next;
        }
        traverse.next = nodeAdd;// We are now at the end instead of having next point to null have it point to nodeAdd
        this.size++;

    }
    //Helper function to determine size of linked list
    private int getSize()
    {
        if(this.head ==null){return 0;}
        else
        {
            int size =0;
            SNode traverse =this.head;
            while(traverse.next!=null)
            {
                size++;
                traverse = traverse.next;
                
            }
            return size;
        }   
        
        
    }

    public void Insert(SNode nodeAdd, int pos)
    {

        if(this.head==null){System.out.println("The list is empty please initalize a head for the linked list");}


        if(pos<0||pos>getSize()+1)
        {
            throw new IllegalArgumentException("The position exceeds the size of the linked list");
        }
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
            traverse =traverse.next;
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
    //Helper function to check if linked list is sorted


    private boolean isSorted()
    {
        SNode traverse = this.head;
        while(traverse.next!=null)
        {
            SNode check = traverse.next;
            if(traverse.data>check.data){return false;}
            traverse=traverse.next;

        }

        return true;


    }

    public void Sort()
    {
        if (head == null || head.next == null) {
            // List is already sorted or empty
            return;
        }
        
        SNode newHead = null;
        SNode current = head;
        while (current != null) {
            SNode next = current.next;
            if (newHead == null || current.data < newHead.data) {
                // Insert current node at beginning of new list
                current.next = newHead;
                newHead = current;
            } else {
                // Find correct insertion point for current node
                SNode search = newHead;
                while (search.next != null && current.data >= search.next.data) {
                    search = search.next;
                }
                current.next = search.next;
                search.next = current;
            }
            current = next;
        }
        
        // Update head to point to new sorted list
        head = newHead;
    }



    public void SortedInsert(SNode nodeAdd)
    {
        InsertTail(nodeAdd);
        Sort();

    }


    public SNode Search(SNode node)
    {
        SNode traverse = this.head; 
        while(traverse !=null)
        {
            if(traverse == node) 
            {
                return traverse;
            }
            traverse = traverse.next;
        }
        return null;
    }   
    
    public void DeleteHead()
    {
        this.head = this.head.next; //Make the new head point to whatever the previous head was pointing to
        this.size--;
    }

    public void DeleteTail()
    {
        if(this.head ==null){return;}
        SNode traverse = this.head;
        int current = 0;
        while(current!= getSize()-1)
        {

            if(traverse.next!=null){traverse = traverse.next;};
            current++;
        }
        //Now we are at the node before the last one
        traverse.next=null; //Make the node before the last point to null, effectively removing the last node
        this.size--;

    }

    public void Delete(SNode nodeDelete)
    {
        if(Search(nodeDelete)==null){
            throw new IllegalArgumentException("This node does not exist in the linked list");
        }
        SNode traverse = this.head;
        int current = 0;
        while(traverse!=nodeDelete)
        {
            current++;
            traverse=traverse.next;
        }
        if(current==0)
        {
            DeleteHead();
            return;
        }
        if(current==getSize())
        {
            DeleteTail();
            return;
        }
        SNode before=this.head;
        int beforePos = 0;
        while(beforePos!=current-1)
        {
            before = before.next;
            beforePos++;
        }
        SNode after = traverse.next;
        before.next = after;
        this.size--;

    }

    public void Clear()
    {
        if(this.head ==null){return;}
        this.head=null;
        this.size =0;


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
        SNode traverse = this.head;
        System.out.printf("Length: %d\n", this.size);
        System.out.printf("Sorted Status: %b\n",isSorted());
        while(traverse != null)
        {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }


    }

}
