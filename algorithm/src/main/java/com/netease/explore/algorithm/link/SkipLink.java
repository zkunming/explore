package com.netease.explore.algorithm.link;

/**
 * Skip link imp
 * @author zkm
 * @date 2019-12-14 16:38 晴天
 */
public class SkipLink<T>  {

  private Node<T> tail;

  public static void main(String[] args) {
    SkipLink<String> skipLink = new SkipLink<>();
    skipLink.add("1");
    skipLink.add("2");
    skipLink.add("3");

    skipLink.out();
  }

  public void add(T data) {
    Node<T> node = new Node<>();
    node.setData(data);
    if (tail != null) {
      node.setPre(tail);
    }
    this.tail = node;
  }

  public void out() {
    Node current = tail;
    while (current != null) {
      System.out.println("current:" + current.getData());
      current = current.pre;
    }
  }

  class Node<T> {
    private Node pre;
    private Node next;
    private T data;

    public Node() {
    }

    public Node(Node pre, Node next, T data) {
      this.pre = pre;
      this.next = next;
      this.data = data;
    }

    public Node getPre() {
      return pre;
    }

    public void setPre(Node pre) {
      this.pre = pre;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    @Override
    public String toString() {
      return "Node{" +
          "pre=" + pre +
          ", next=" + next +
          ", data=" + data +
          '}';
    }

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

  }
}
