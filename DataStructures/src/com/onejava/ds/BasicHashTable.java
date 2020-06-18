package com.onejava.ds;

public class BasicHashTable<X, Y> {
    private BasicEntry<X, Y> data[];
    private int capacity;
    private int size;

    public BasicHashTable(int capacity) {
        this.capacity = capacity;
        data = new BasicEntry[capacity];
    }

    public Y get(X key){
        int hash = calculateHash(key);
        BasicEntry<X, Y> entry = data[hash];
        return (entry != null)? entry.getValue() : null;
    }

    public void put(X key, Y value){
        int hash = calculateHash(key);
        data[hash] = new BasicEntry<>(key, value);
    }

    /*
    1. To calculate hash which is required to store and retrieve objects.
    2. Before storing an object, calculate its hash and store at that hash. This helps to retrieve object at constant time
    Note: Collision: different objects (by the equals() method) might have the same hashcode.
    3. To avoid collision, check any object is stored in that hash, if its there loop until you find empty hash.
    And store new object in that empty slot by incrementing the previous slot
    0 hash --> 8
    1 hash --> 9 7 1
     */
    public int calculateHash(X key){
        int slot = (key != null)? key.hashCode() : 0;
        slot = slot % capacity;
        while(data[slot] != null && ! data[slot].getKey().equals(key)){
            slot = (slot + 1) % capacity;
        }
        return slot;
    }

    public Y delete(X key){

        return null;
    }






    private class BasicEntry<X, Y>{
        private X key;
        private Y value;

        public BasicEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }

        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return value;
        }

        public void setValue(Y value) {
            this.value = value;
        }
    }
}
