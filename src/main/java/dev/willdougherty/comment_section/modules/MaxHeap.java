package dev.willdougherty.comment_section.modules;

import java.util.ArrayList;

public class MaxHeap {

  // entries in the heap
  public class Node {
    public int priority;
    public String id;

    public Node(int priority, String id) {
      this.priority = priority;
      this.id = id;
    }
  }

  // class attributes
  private ArrayList<Node> heap;

  // class methods
  // CONSTRUCTOR
  public MaxHeap() {
    this.heap = new ArrayList<Node>();
  }

  // private methods
  private void swap(int i1, int i2) {
    Node temp = heap.get(i1);
    heap.set(i1, heap.get(i2));
    heap.set(i2, temp);
  }

  private void heapifyUp() {
    int index = heap.size() - 1;
    while (index != 0 && heap.get(Math.floorDiv(index, 2)).priority < heap.get(index).priority) {
      swap(index, Math.floorDiv(index, 2));
    }
  }

  // TODO: fix heapifyDown
  private void heapifyDown() {
    int index = 0;
    int left, right;
    // while not a leaf and child is larger
    while (true) {
      left = index * 2 + 1;
      right = index * 2 + 2;
      if (right < heap.size()) {
        // two children
        swap(index, left);
        index = left;
        continue;
      }
      if (left < heap.size()) {
        // single child
      } else {
        break;
      }
    }
  }

  // public methods
  public void addElement(int priority, String id) {
    heap.add(new Node(priority, id));
    heapifyUp();
  }

  public String removeMax() {
    if (heap.isEmpty()) {
      return null;
    }
    swap(0, heap.size());
    String ret = heap.removeLast().id;
    heapifyDown();
    return ret;
  }

  public ArrayList<Node> getHeap() {
    return this.heap;
  }
}
