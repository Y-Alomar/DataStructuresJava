
import datastructures.nodes.DNode;

public class DLL {
    
    private DNode head;
    private DNode tail;
    private int size= 0;


    public DLL()
    {
        this.head=null;
        this.tail=null;
    }
    public DLL(DNode node)
    {
        this.head = node;//Head points to the node
        this.tail = node;//There are no other elements so just set both the head and tail to point to the same node
        this.size++;
    }

    public void InsertHead(DNode nodeAdd)
    {
        if(this.head ==null){
            this.head = nodeAdd;//Head points to the node
            this.tail = nodeAdd;//There are no other elements so just set both the head and tail to point to the same node
            this.size++;
            return;
        }
        nodeAdd.next=this.head;//Make the new node added point to the head
        nodeAdd.prev =this.head.prev;
        nodeAdd.next.prev=nodeAdd;
        this.head =nodeAdd;//Break connection to first node and make head point to new node
        this.size++;
    }

    public void InsertTail(DNode nodeAdd)
    {
        if(this.head==null){throw new IllegalArgumentException("The list does not have a head please make add a head first");}
        DNode end =this.tail;//Store the current tail in end
        end.next = nodeAdd;//Make end point to the new tail
        nodeAdd.prev=end;//Make the new tail point to the previous tail
        nodeAdd.next=null;//The new tail is the last element so it has to point to null
        this.tail=nodeAdd;//Make the tail the new node tail
        this.size++;


    }

    public void Insert(DNode nodeAdd,int pos)
    {
        if(pos<0||pos>getSize()+1)
        {
            throw new IllegalArgumentException("The position exceeds the size of the linked list");
        }
        DNode traverse = this.head;
        int current = 0;
        if(pos==0){InsertHead(nodeAdd);return;}
        while(current!=pos-1)
        {
            current++;
            traverse=traverse.next;
        }
        if(traverse==nodeAdd)
        {
            throw new IllegalArgumentException("This node already exists in the linked list");
        }
        DNode nextNode = traverse.next;
        traverse.next=nodeAdd;
        nodeAdd.next=nextNode;
        nextNode.prev=nodeAdd;
        nodeAdd.prev=traverse;
        this.size++;


    }


    public void SortedInsert(DNode node)
    {
        InsertTail(node);
        Sort();
    }



    //Code provided by ChatGPT maybe try to make your own implementation later
    public void Sort()
    {
        if (isSorted()) {
            return;
        }
        DNode current = this.head.next;
        while (current != null) {
            DNode next = current.next;
            if (current.data < current.prev.data) {
                DNode temp = current.prev;
                while (temp != null && current.data < temp.data) {
                    temp = temp.prev;
                }
                if (temp == null) {
                    // Insert at head
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                    current.next = this.head;
                    this.head.prev = current;
                    current.prev = null;
                    this.head = current;
                } else {
                    // Insert after temp
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                    current.prev = temp;
                    current.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = current;
                    }
                    temp.next = current;
                }
            }
            current = next;
        }
    }






    public void DeleteHead()
    {
        DNode after = this.head.next;//This will be the new head
        after.prev = null; //No node before head so previous should point to null
        this.head  = after;//Set the head to be the new head
        this.size--;
    }

    public void DeleteTail()
    {
        DNode beforeLast = this.head;
        int current = 0;
        while(current!=getSize()-1)
        {
            if(beforeLast!=null)
            {
                beforeLast=beforeLast.next;
            }
            current++;
        }
        beforeLast.next=null;
        this.tail.prev =null;
        this.size--;
    }

    public void Delete(DNode node)
    {
        if(Search(node)==null)
        {
            throw new IllegalArgumentException("This node does not exist in the list");
        }
        DNode before = node.prev;//Node before the node we want to delete
        DNode after  = node.next;//Node after the node we want to delete
        before.next = node.next;//Have the node before point to the same node that as the node we want to delete
        after.prev = node.prev;
        this.size--;


    }


    public DNode Search(DNode node)
    {
        DNode traverse = this.head;
        while(traverse!=null)
        {
            if(traverse ==node)
            {
                return traverse;
            }
            traverse =traverse.next;
        }
        return null;
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
        while(traverse != null)
        {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }
    }


    //Helper functions 
    private int getSize()
    {
        if(this.head ==null){return 0;}
        else
        {
            int size =0;
            DNode traverse =this.head;
            while(traverse.next!=null)
            {
                size++;
                traverse = traverse.next;
                
            }
            return size;
        }   
        
        
    }

    private boolean isSorted()
    {
        DNode traverse = this.head;
        while(traverse.next!=null)
        {
            DNode check = traverse.next;
            if(traverse.data>check.data){return false;}
            traverse=traverse.next;

        }

        return true;


    }


    


}
