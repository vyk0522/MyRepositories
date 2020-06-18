package com.onejava.ds;

public class BasicLinkedList<X> implements LinkedList<X> {
    private Node first;
    private Node last;
    private int nodeCount;

    /*
    It returns the size of linked list.
     */
    @Override
    public int size() {
        return nodeCount;
    }

    /*
    Get First Node's item
     */
    public X getFirstNodeItem() {
        return first.getNodeItem();
    }

    /*
    Get Last Node's item
     */
    public X getLastNodeItem() {
        return last.getNodeItem();
    }

    /*
    1. It adds the new item at the end
    2. Logic
    A. Check if fist node is null, if null set first and last node
    B. Else, Link/add the node at the end and point the last node to new node
    C. Increment the nodeCount
     */
    @Override
    public void add(X item){
        if(first == null){
            first = new Node(item);
            last = first;
        }
        else{
            Node newNode = new Node(item);
            last.setNextNode(newNode);
            last = newNode;
        }
        nodeCount++;
    }

    /*
    1. It removes the first element. If empty, throws exception
    2. Logic
    A. Get first node's item required to return.
    B. Reinitialize first node with first node's next node.
    C. if new first node is null. Make last node also null
    D. Decrement the node count.
     */
    @Override
    public X remove() {
        if(size() == 0){
            throw new IllegalStateException("LinkedList is empty. We cannot remove");
        }
        X item = first.getNodeItem();
        first = first.getNextNode();
        if (first == null){
            last = null;
        }
        nodeCount--;
        return item;
    }

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
    @Override
    public void insert(X item, int position){
        if(position > size()){
            throw new IllegalStateException("We cannot insert new item at this position as it is greater than size");
        }
        else if(position == size()){
            add(item);
        }
        else if(position == 0){
            if (size() == 0){
                add(item);
            }
            else {
                Node newNode = new Node(item);
                newNode.setNextNode(first);
                first = newNode;
                nodeCount++;
            }
        }
        else {
            Node newNode = new Node(item);
            Node currentNode = first;
            for(int i= 0; i < position -1; i++){
                currentNode = currentNode.getNextNode();
            }
            Node nextNode = currentNode.getNextNode();
            currentNode.setNextNode(newNode);
            newNode.setNextNode(nextNode);
            nodeCount++;
        }
    }

    /*
    1. It removes the item at given position
    2. Scenarios
    A. Remove the item at position equal or greater than size. Also, size is zero -- throw exception
    B. Remove the item at 0 position -- invoke remove()
    C. Remove item at last(size -1) position
    i. Traverse up to currentNode. Get last node's nodeItem required to return. set null as currentNode's next node.
    ii. point currentNode as last node and decrement node count.
    D. Remove item in between
    i. traverse up to currentNode. Get currentNode's next node as skipNode. Set skipNode's next node as currentNode's next node.
    ii. Decrement the node count.
     */
    @Override
    public X removeAt(int position){
        if(position >= size() || first == null){
            throw new IllegalStateException("Cannot remove item at this position");
        }
        else if(position == 0){
            return remove();
        }
        else if(position == size() -1){
            Node currentNode = first;
            for(int i=0; i < position -1; i++){
                currentNode = currentNode.getNextNode();
            }
            Node skipNode = currentNode.getNextNode();
            X item = skipNode.getNodeItem();
            currentNode.setNextNode(null);
            last = currentNode;
            nodeCount--;
            return item;
        }
        else{
            Node currentNode = first;
            for(int i = 0; i < position -1; i++){
                currentNode = currentNode.getNextNode();
            }
            Node skipNode = currentNode.getNextNode();
            X item = skipNode.getNodeItem();
            Node nextNode = skipNode.getNextNode();
            currentNode.setNextNode(nextNode);
            nodeCount--;
            return item;
        }
    }

    /*
        1. It gets the item present at the specified position
        2. Scenarios
        A. If position is greater or equal to size. or list's size is 0  -- throw exception
        B. If position is 0, return first node's item
        C. Else If position is size -1, return last node's item
        D. Else, traverse to currentNode. Return currentNode next node's item

         */
    @Override
    public X get(int position) {
        if(position >= size() || first == null){
            throw new IllegalStateException("Cannot get the element");
        }
        if(position == 0){
            return first.getNodeItem();
        }
        else if(position == size()-1){
            return last.getNodeItem();
        }
        else{
            Node currentNode = first;
            for(int i=0; i < position-1; i++){
                currentNode = currentNode.getNextNode();
            }
            return currentNode.getNextNode().getNodeItem();
        }
    }

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
    @Override
    public int find(X item) {
        if(first == null){
            return -1;
        }
        if(item.equals(first.getNodeItem())){
            return 0;
        }
        if(item.equals(last.getNodeItem())){
            return size() -1;
        }
        Node currentNode = first;
        for(int i=1; i < size() - 1 ; i++){  // If list has 4 Nodes, loop should run two times as first and last nodes are already checked
            currentNode = currentNode.getNextNode();
            if(currentNode != null && item.equals(currentNode.getNodeItem())){
                return i;
            }
        }

        return -1;
    }

    //useful for pretty print
    public String toString() {
        StringBuffer contents = new StringBuffer();
        BasicLinkedList.Node curNode = first;

        while(curNode != null) {
            contents.append(curNode.getNodeItem());
            curNode = curNode.getNextNode();

            if(curNode != null) {
                contents.append(", ");
            }
        }
        return contents.toString();
    }

    private class Node{
        private X nodeItem;
        private Node nextNode;

        public Node(X nodeItem) {
            this.nodeItem = nodeItem;
        }

        public X getNodeItem() {
            return nodeItem;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
