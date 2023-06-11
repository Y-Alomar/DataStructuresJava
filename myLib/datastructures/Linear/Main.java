import datastructures.nodes.*;
import datastructures.Trees.*;
public class Main {
    public static void main(String[] args)
    {
     
        //--------------------------SLL test---------------------------------------

        SLL LLtest = new SLL();

        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SNode node4 = new SNode(4);
        SNode node5 = new SNode(5);
        SNode node6 = new SNode(6);
        SNode node7 = new SNode(7);
        SNode node8 = new SNode(8);

        LLtest.InsertHead(node8);
        LLtest.InsertTail(node1);
        LLtest.Insert(node3, 1);
        LLtest.InsertTail(node7);
        LLtest.Insert(node5, 2);


        // LLtest.DeleteHead();
        // LLtest.DeleteTail();
        // LLtest.Delete(node5);


        LLtest.SortedInsert(node6);
        SNode nodeFound = LLtest.Search(node8);

        LLtest.Delete(node8);
        LLtest.DeleteHead();
        LLtest.Print();
        System.out.println(nodeFound.data);

        LLtest.Sort();
        //LLtest.Clear();
        LLtest.Print();

        LLtest.DeleteTail();
        LLtest.Print();

        LLtest.Clear();

        LLtest.Print();







    //--------------------------DLL test---------------------------------------




        DLL list = new DLL();

        // Test InsertHead method
        System.out.println("InsertHead test:");
        DNode node501 = new DNode(1);
        list.InsertHead(node501);
        list.Print();

        // Test InsertTail method
        System.out.println("InsertTail test:");
        DNode node502 = new DNode(2);
        DNode node503 = new DNode(3);
        list.InsertTail(node502);
        list.InsertTail(node503);
        list.Print();

        // Test Insert method
        System.out.println("Insert test:");
        DNode node504 = new DNode(4);
        DNode node505 = new DNode(5);
        list.Insert(node504, 1);
        list.Insert(node505, 0);
        list.Print();

        // Test SortedInsert method
        System.out.println("SortedInsert test:");
        DNode node506 = new DNode(6);
        DNode node507 = new DNode(7);
        DNode node508 = new DNode(8);
        list.InsertTail(node508);
        list.SortedInsert(node507);
        list.SortedInsert(node506);
        list.Print();

        // Test Sort method
        System.out.println("Sort test:");
        list.Sort();
        list.Print();

        // Test DeleteHead method
        System.out.println("DeleteHead test:");
        list.DeleteHead();
        list.Print();

        // Test DeleteTail method
        System.out.println("DeleteTail test:");
        list.DeleteTail();
        list.Print();

        // Test Delete method
        System.out.println("Delete test:");
        list.Delete(node504);
        list.Print();

        // Test Search method
        System.out.println("Search test:");
        DNode searchNode = list.Search(node502);
        System.out.println("Searched node: " + searchNode.data);

        // Test Clear method
        System.out.println("Clear test:");
        list.Clear();
        list.Print();
    // }



    //--------------------------CSLL test---------------------------------------
    //create a new linked list
    CSLL linkedList = new CSLL();

    // insert some nodes into the list

    SNode node401 = new SNode(1);
    SNode node402 = new SNode(2);
    SNode node403 = new SNode(3);
    SNode node404 = new SNode(4);
    SNode node405 = new SNode(5);
    SNode node406 = new SNode(6);
    SNode node407 = new SNode(7);
    SNode node408 = new SNode(8);
    SNode node409 = new SNode(9);
    SNode node4010 = new SNode(10);



    linkedList.InsertHead(node405);
    linkedList.InsertTail(node402);
    linkedList.InsertTail(node408);
    linkedList.InsertTail(node401);

    // print the contents of the list
    System.out.println("Before sorting:");
    linkedList.Print();

    //sort the list and print it again
    linkedList.Sort();
    System.out.println("After sorting:");
    linkedList.Print();

    // test deleting the head of the list
    linkedList.DeleteHead();
    System.out.println("After deleting the head:");
    linkedList.Print();

    // test deleting the tail of the list
    linkedList.DeleteTail();
    System.out.println("After deleting the tail:");
    linkedList.Print();

    // test deleting a node from the list
    SNode nodeToDelete = linkedList.Search(node402);
    linkedList.Delete(nodeToDelete);
    System.out.println("After deleting node with value 2:");
    linkedList.Print();

    // test inserting a node at a specific position
    linkedList.Insert(node407, 0);
    System.out.println("After inserting node with value 7 at position 2:");
    linkedList.Print();

    // test inserting a node at the head of the list
    linkedList.InsertHead(node4010);
    System.out.println("After inserting node with value 10 at the head of the list:");
    linkedList.Print();

    // test inserting a node at the tail of the list
    linkedList.InsertTail(node404);
    System.out.println("After inserting node with value 4 at the tail of the list:");
    linkedList.Print();

    // test inserting a node into an empty list
    CSLL emptyList = new CSLL();
    emptyList.InsertHead(node401);
    System.out.println("After inserting node with value 1 into an empty list:");
    emptyList.Print();

    // test sorted insert
    linkedList.SortedInsert(node402);
    System.out.println("After sorted insert of node with value 0:");
    linkedList.Print();

    // test clearing the list
    linkedList.Clear();
    System.out.println("After clearing the list:");
    linkedList.Print();

    //-------------------------CDLL test--------------------------------------
    CDLL list1 = new CDLL();
    System.out.println("Testing CDLL class:");
    
    DNode node301 = new DNode(1);
    DNode node302 = new DNode(2);
    DNode node303 = new DNode(3);
    DNode node304 = new DNode(4);
    DNode node305 = new DNode(5);
    DNode node306 = new DNode(6);
    DNode node307 = new DNode(7);
    DNode node308 = new DNode(8);
    DNode node309 = new DNode(9);
    
    




    // Test insertion methods
    list1.InsertHead(node304);
    list1.InsertHead(node301);
    list1.Insert(node302, 1);
    list1.InsertTail(node307);
    list1.InsertTail(node309);
    list1.SortedInsert(node305);
    list1.Print();

    // Test deletion methods
    try
    {
        list1.Delete(list.Search(node302));
    }catch(IllegalArgumentException e){
        System.out.println("Node does not exist");
    }
    list1.DeleteHead();
    list1.DeleteTail();
    list1.Print();

    // Test other methods
    list1.Sort();
    list1.Print();
    list1.Clear();
    list1.Print();
    
    //-------------------------StackLL test--------------------------------------
    StackLL stack = new StackLL();

        // test Push() method
    SNode node201 = new SNode(1);
    stack.Push(node201);
    SNode node202 = new SNode(2);
    stack.Push(node202);
    SNode node203 = new SNode(3);
    stack.Push(node203);

        // test peek() method
    System.out.println("Top element: " + stack.peek()); // output: Top element: 3

        // test Pop() method
    int val = stack.Pop();
    System.out.println("Popped element: " + val); // output: Popped element: 3

        // test search() method
    int pos = stack.search(node201);
    System.out.println("Position of node1: " + pos); // output: Position of node1: 1
    
    System.out.println("Peek returns "+ stack.peek());


        // test Clear() method
    stack.Clear();

    //QueueLL test

    QueueLL queue = new QueueLL();
    SNode node100 = new SNode(1);
    SNode node102 = new SNode(2);
    SNode node103 = new SNode(3);
    SNode node104 = new SNode(4);





    // Add some nodes to the queue
    queue.Enqueue(node100);
    queue.Enqueue(node102);
    queue.Enqueue(node103);
    queue.Enqueue(node104);

    // Test the Dequeue method
    int val1 = queue.Dequeue();
    System.out.println("Dequeued value: " + val1);

    // Test the peek method
    System.out.println("Peeked value: " + queue.peek());

    // Test the search method
    int pos1 = queue.search(node102);
    System.out.println("Position of node 2: " + pos1);

    // Test the isEmpty method
    System.out.println("Queue is empty? " + queue.isEmpty());

    // Test the clear method
    queue.clear();
    System.out.println("Queue is empty after clearing? " + queue.isEmpty());

    
    //
    //BST test

    BST bst = new BST();
    bst.Insert(10);
    bst.Insert(5);
    bst.Insert(15);
    bst.Insert(2);
    bst.Insert(7);
    bst.Insert(12);
    bst.Insert(20);

    TNode foundNode = bst.Search(7);
    if (foundNode != null) {
        System.out.println("Node with value 7 found in tree!");
    } else {
        System.out.println("Node with value 7 not found in tree.");
    }


    TNode root = bst.getRoot();
    bst.printInOrder();
    bst.printBF();
    
    //-------------------AVL test------------------------------

    AVL tree = new AVL();
    tree.Insert(50);
    tree.Insert(30);
    tree.Insert(70);
    tree.Insert(20);
    tree.Insert(40);
    tree.Insert(60);
    tree.Insert(80);
        
    System.out.println("In-order traversal:");
    tree.printInOrder();
    System.out.println();
        
    System.out.println("Breadth-first traversal:");
    tree.printBF();
    System.out.println();
        
    int searchVal = 40;
    TNode node = tree.Search(searchVal);
    if (node != null) {
        System.out.println("Found node with value " + searchVal + " in the tree.");
    } else {
        System.out.println("Node with value " + searchVal + " not found in the tree.");
    }
        
    System.out.println("Inserting node with value 90:");
    tree.Insert(90);
    System.out.println("Breadth-first traversal after insertion:");
    tree.printBF();
    System.out.println();







    }
}        

