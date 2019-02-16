package com.udemy.algorithms.datastructures;

public class SimpleLinearProbingHashMap<K, V> {

    //for quadratic probing
    private static final int DEFAULT_SIZE = 16;
    private HashNode<K,V>[] elements;
    private int size;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;
    private float loadFactor = DEFAULT_LOAD_FACTOR;

    public SimpleLinearProbingHashMap() {
        this(DEFAULT_SIZE, DEFAULT_LOAD_FACTOR);
    }

    public SimpleLinearProbingHashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public SimpleLinearProbingHashMap(int capacity, float growFactor) {
        this.elements = new HashNode[DEFAULT_SIZE];
        this.loadFactor = growFactor;
    }

    //table will double its size if threshold, set by @loadFactor, is reached
    private void growAndRehash(int newSize) {
        HashNode<K,V>[] newElements = new HashNode[elements.length*2];
        for(HashNode<K,V> node : elements) {
            if(node == null) {
                continue;
            }

            int newPos = indexForKey(node.key, newElements.length);
            int curPos = newPos;
            while(newElements[newPos] != null || curPos == newPos) {
                newPos = ++newPos % newElements.length;
            }
            newElements[newPos] = node;
        }

        elements = newElements;
    }

    private void ensureCapacity(int newSize) {
        if(newSize/elements.length > loadFactor) {
            growAndRehash(newSize);
        }
    }

    public void put(K key, V value) {
        ensureCapacity(size + 1);

        int pos = indexForKey(key);

        //rewrite key if present
        if(elements[pos] != null && elements[pos].key.equals(key)) {
            elements[pos].value = value;
            return;
        }

        int curPos = pos;
        while(elements[pos] != null || curPos != pos) {
            pos = ++pos % elements.length;
        }

        elements[pos] = new HashNode<>(key, value);
        size++;
    }

    public V getValue(K key) {
        int pos = getRealIndex(indexForKey(key), key);

        return elements[pos] != null ? elements[pos].value : null;
    }

    public boolean containsKey(K key) {
        int pos = getRealIndex(indexForKey(key), key);
        return elements[pos] != null && elements[pos].key.equals(key);
    }

    public V remove(K key) {
        int pos = getRealIndex(indexForKey(key), key);

        if(elements[pos] == null) {
            return null;
        }
        else {
            V oldValue = elements[pos].value;
            elements[pos] = null;
            size--;
            return oldValue;
        }
    }

    private int getRealIndex(int startPos, K key) {
        int pos = startPos;
        do {
            if(elements[pos] != null && elements[pos].key.equals(key)) {
                break;
            }
            pos = ++pos % elements.length;
        }
        while (pos != startPos);

        return pos;
    }


    private int indexForKey(K key) {
        return indexForKey(key, elements.length);
    }

    private int indexForKey(K key, int capacity) {
        return hashKey(key) & (capacity - 1);
    }

    //(c) HashMap
    private int hashKey(K key) {
        int h = 0;
        h ^= key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public int getSize() {
        return size;
    }

    static class HashNode<K,V> {
        K key;
        V value;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
