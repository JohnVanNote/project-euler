package com.jvn.object;

public class BinaryTree<E> {

  private Node<E> topNode;

  public BinaryTree(Node<E> topNode) {
    this.setTopNode(topNode);
  }

  public Node<E> getTopNode() {
    return topNode;
  }

  public void setTopNode(Node<E> topNode) {
    this.topNode = topNode;
  }
}
