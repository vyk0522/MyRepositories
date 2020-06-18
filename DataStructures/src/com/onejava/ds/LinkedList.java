package com.onejava.ds;

public interface LinkedList<X> {
    /*
        It returns the size of linked list.
         */
    int size();

    /*
        1. It adds the new item at the end
        2. Logic
        A. Check if fist node is null, if null set first and last node
        B. Else, Link/add the node at the end and point the last node to new node
        C. Increment the nodeCount
         */
    void add(X item);

    /*
        1. It removes the first element. If empty, throws exception
        2. Logic
        A. Get first node's item required to return.
        B. Reinitialize first node with first node's next node.
        C. if new first node is null. Make last node also null
        D. Decrement the node count.
         */
    X remove();

    /*
        1. It inserts the new item at given position
        2. Scenarios
        A. Insert item at the position greater than size -- Throw exception

        B. Insert item at the position equal to size -- invoke add() -- which adds item at the end

        C. Insert item at the position 0
        i. If size is 0 -- invoke add()
        ii. Else, Set first node as new node's next node and point new node as first node. Increment node count

        D. Insert item in between
        i. Traverse up to currentNode. Ex:  If position is 5, currentNode is node which is at position 4

        A. Insert at 1 pos -- 0 itr
        B. Insert at 2 pos -- 1 itr
        C. Insert at N pos -- N-1 itr  to get the current node

        ii. Set newNode as currentNode's next node. and set nextNode(which is currentNode's next node) as newNode's next node. Increment nodeCount

         */
    void insert(X item, int position);

    /*
        1. It removes the item at given position
        2. Scenarios
        A. Remove the item at position equal or greater than size -- throw exception
        B. Remove the item at 0 position -- invoke remove()
        C. Remove item at last(size -1) position
        i. Traverse up to currentNode. Get last node's nodeItem required to return. set null as currentNode's next node.
        ii. point currentNode as last node and decrement node count.
        D. Remove item in between
        i. traverse up to currentNode. Get currentNode's next node as skipNode. Set skipNode's next node as currentNode's next node.
        ii. Decrement the node count.
         */
    X removeAt(int position);

    /*
    1. It gets the item present at the specified position
    2. Scenarios
    A. If position is greater or equal to size. or list's size is 0  -- throw exception
    B. If position is 0, return first node's item
    C. Else If position is size -1, return last node's item
    D. Else, traverse to currentNode. Return currentNode next node's item

     */
    X get(int position);

    /*
   1. It returns the position if given item is present
   2. Scenarios
   A. Check if size is 0, if 0 return -1
   B. Check whether given item matches with first node item, if yes return 0
   C. Else, check whether given item matches with last node item, if yes return (size - 1)
   D. Else, iterate from second node to last -1 as first and last nodes are already checked
   and check if given node matches, if yes return the position
   E. Else return -1
    */
    int find(X item);
}
