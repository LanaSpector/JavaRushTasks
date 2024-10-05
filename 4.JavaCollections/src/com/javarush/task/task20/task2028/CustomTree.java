package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    int size = 0;

    public CustomTree() {
        this.root = new Entry<>("root");
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    public String getParent(String string) {
        return getParent(root, string);
    }

    private String getParent(Entry<String> entry, String elementName) {
        if (entry == null) return null;

        if (entry.leftChild != null && entry.leftChild.elementName.equals(elementName)
                || entry.rightChild != null && entry.rightChild.elementName.equals(elementName)) {
            return entry.elementName;
        }
        String parent = getParent(entry.leftChild, elementName);
        if (parent == null) {
            parent = getParent(entry.rightChild, elementName);
        }

        return parent;
    }

    @Override
    public boolean add(String string) {
        Entry<String> entry = new Entry<>(string); //1 //2//3

        Entry<String> parent = findParent(); //root//root//1

        if (parent == null) return false;

        if (parent.availableToAddLeftChildren) {
            parent.leftChild = entry;
            parent.availableToAddLeftChildren = false;
        } else if (parent.availableToAddRightChildren) {
            parent.rightChild = entry;
            parent.availableToAddRightChildren = false;
        }
        entry.parent = parent;
        size++;
        return true;
    }

    private Entry<String> findParent() {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);//1

        while (!queue.isEmpty()) {
            Entry<String> current = queue.poll();//0//2{1.2}{,2,3,4}//5
            if (current.isAvailableToAddChildren()) return current; //f///2

            if (current.leftChild != null) queue.add(current.leftChild); //q.(1)//1
            if (current.rightChild != null) queue.add(current.rightChild);//q.(2)//2
        }

        return null;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();

        String elementName = (String) o;

        Entry<String> entryToRemove = findEntry(root, elementName);

        if (entryToRemove == null) return false;

        removeEntry(entryToRemove);

        updateParentStatus(entryToRemove);

        return true;
    }

    private Entry<String> findEntry(Entry<String> entry, String elementName) {
        if (entry == null) return null;

        if (entry.elementName.equals(elementName)) {
            return entry;
        }

        Entry<String> foundEntry = findEntry(entry.leftChild, elementName);

        if (foundEntry != null) return foundEntry;

        return findEntry(entry.rightChild, elementName);
    }

    private void removeEntry(Entry<String> entry) {
        if (entry.parent != null) {
            if (entry.parent.leftChild == entry) {
                entry.parent.leftChild = null;
            } else {
                entry.parent.rightChild = null;
            }
        }

        if (entry.leftChild != null) {
            removeEntry(entry.leftChild);
            size--;
        }
        if (entry.rightChild != null) {
            removeEntry(entry.rightChild);
            size--;
        }
        entry.leftChild = null;
        entry.rightChild = null;

    }

    private void updateParentStatus(Entry<String> entry) {
        Entry<String> parent = entry.parent;
        while (parent != null) {
            if (parent.leftChild == null && parent.rightChild == null) {
                parent.availableToAddLeftChildren = true;
                parent.availableToAddRightChildren = true;
            }
            parent = parent.parent;
        }
        entry.parent = null;
        size--;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }
    }
}