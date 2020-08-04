package com.onejava.ds;

public class BinaryTree<X extends Comparable<X>> {
    private Node root;
    private int size;

    public int size() {
        return size;
    }

    public void add(X item) {
        Node node = new Node(item);
        if(root == null){
            root = node;
            size++;
        }
        else{
            insert(root, node);
        }
    }

    public boolean contains(X item) {
        return getNode(item) != null ? true : false;
    }

    public boolean delete(X item){
        boolean deleted = false;
        if (root == null) {
            return false;
        }
        // Find the node to delete
        Node currentNode = getNode(item);

        if(currentNode != null){
            // If the node to delete does not have any children, just delete it
            if(currentNode.getLeft() == null && currentNode.getRight()== null){
                unLink(currentNode, null);
                deleted = true;
            }
            // If the node to delete only has a right child, remove it in the hierarchy
            else if(currentNode.getLeft() == null && currentNode.getRight() != null){
                unLink(currentNode, currentNode.getRight());
                deleted = true;
            }
            // If the node to delete only has a left child, remove it in the hierarchy
            else if(currentNode.getLeft() != null && currentNode.getRight() == null){
                unLink(currentNode, currentNode.getLeft());
                deleted = true;
            }
            // If node has both children, do a node swap to delete
            // We can pick either left path or right path
            else{
                // we can swap out the node with the right most leaf node on the left side
                Node child = currentNode.getLeft();
                while(child.getRight() != null && child.getLeft() != null){
                    child = child.getRight();
                }

                // We have right most leaf node. We can replace the current node with this node.
                child.getParent().setRight(null); // Removing this leaf node from it's current position
                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());
                unLink(currentNode, child);
                deleted = true;
            }
        }
        if (deleted){
            size--;
        }
        return deleted;
    }

    private void unLink(Node currentNode, Node newNode){
        if(currentNode == root){
            if (size > 1) {
                newNode.setLeft(currentNode.getLeft());
                newNode.setRight(currentNode.getRight());
            }
            root = newNode;
        }
        else if(currentNode.getParent().getLeft() == currentNode){
            currentNode.getParent().setLeft(newNode);
        }
        else {
            currentNode.getParent().setRight(newNode);
        }

    }


    private void insert(Node parent, Node child){
        // If Child is less than Parent, it goes on the left
        if (child.getItem().compareTo(parent.getItem()) < 0){
            // If the left Node is null, we have found the spot
            if(parent.getLeft() == null){
                parent.setLeft(child);
                child.setParent(parent);
                size++;
            }
            // Otherwise we need to call insert again and test for left or right (recursion)
            else{
                insert(parent.getLeft(), child);
            }
        }
        // If Child is greater than Parent, it goes on the right
        if (child.getItem().compareTo(parent.getItem()) > 0){
            // If the right Node is null, we have found the spot
            if(parent.getRight() == null){
                parent.setRight(child);
                child.setParent(parent);
                size++;
            }
            // Otherwise we need to call insert again and test for left or right (recursion)
            else{
                insert(parent.getRight(), child);
            }

        }

        // If parent and child node is equal, we don't do anything
        // We assume, data in binary tree is unique. If value already exists we don't do anything.

    }

    private Node getNode(X item) {
        Node currentNode = root;

        while (currentNode != null){
            int val = item.compareTo(currentNode.getItem());
            if(val == 0){
                return currentNode;
            }
            else if(val < 0){
                currentNode = currentNode.getLeft();
            }
            else {
                currentNode = currentNode.getRight();
            }
        }
        return currentNode;
    }

    private class Node{
        private Node left;
        private Node right;
        private Node parent;
        private X item;

        public Node(X item) {
            this.item = item;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }

    }


}


