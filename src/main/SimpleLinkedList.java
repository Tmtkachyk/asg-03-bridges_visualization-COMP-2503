package main;

import bridges.base.SLelement;
import java.util.ArrayList;
import java.util.List;

public class SimpleLinkedList<E> implements SimpleList<E> {

  private SLelement<E> head;
  private SLelement<E> tail;
  private int size;

  public SimpleLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  public SimpleLinkedList(List<E> startingElem) {
    this();
    appendAll(startingElem);
  }

  // private 'cause my Nodes are my own bidness
  private SimpleLinkedList(SLelement<E> head, SLelement<E> tail, int size) {
    this.head = head;
    this.tail = tail;
    this.size = size;
  }

  @Override
  public E first() {
    return isEmpty() ? null : getHead().getValue();
  }

  @Override
  public SimpleLinkedList<E> rest() {
    return isEmpty() ? null : new SimpleLinkedList<>(getHead().getNext(), getTail(), size - 1);
  }

  @Override
  public void append(E t) {

    SLelement<E> newGuy = new SLelement<>(t);

    if (isEmpty()) {
      head = newGuy;

    } else {
      getTail().setNext(newGuy);
    }
    tail = newGuy;

    size++;
  }

  /**
   * Adds all items in the given List to the end of this SLL.
   *
   * <p>Good Lord, yes - it should not be recursive, but that dang loop-sniffing unit test will
   * brook no insolence!
   *
   * @param things the things to add to the end of this list
   */
  public void appendAll(List<E> things) {
    if (things.isEmpty()) {
      return;
    } else if (things.size() == 1) {
      append(things.get(0));
    } else {
      List<E> smallerList = new ArrayList<>(things);
      append(smallerList.remove(0));
      appendAll(smallerList);
    }
  }

  /**
   * Returns a List of the elements in this SLL from the start to the end.
   *
   * @return a List of the elements in this SLL from the start to the end
   */
  @Override
  public List<E> elementsForward() {
    // TODO: complete this recursive wrapper method; it should be paired with a private
    // recursive method

    List<E> newList = new ArrayList<>();
    return elementsForward(newList, getHead());
  }

  public List<E> elementsForward(List<E> newList, SLelement<E> nextNode) {
    // pass list as parameter
    // pass next node to add
    // check if head is null

    if (getHead() == null) {
      return newList;
    } else {
      // add next element to list
      newList.add(getHead().getValue());
      getHead().setNext(getHead());
      // add rest of the list using recursive method
      return elementsForward(newList, getHead());
    }
  }

  /**
   * Returns a List of the elements in this SLL from the end to the start.
   *
   * @return a List of the elements in this SLL from the end to the start
   */
  @Override
  public List<E> elementsBackward() {
    // TODO: complete this recursive wrapper method; it should be paired with a private
    // recursive method

    /* List<T> newList = new ArrayList<>();
    elementsBackward(newList, head);
    return newList;*/

    List<E> newList = new ArrayList<>();
    elementsBackward(newList, getHead());
    return newList;
  }

  public void elementsBackward(List<E> newList, SLelement<E> nextNode) {
    // TODO: complete this recursive wrapper method; it should be paired with a private
    // recursive method

    if (nextNode != null) {
      elementsBackward(newList, nextNode.getNext());
      newList.add(nextNode.getValue());
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return getHead() == null;
  }

  public SLelement<E> getHead() {
    return head;
  }

  public SLelement<E> getTail() {
    return tail;
  }

  /*  private static class SLelement<E> {

    private E data;
    private SLelement<E> next;

    public SLelement(E data) {
      this.data = data;
      this.next = null;
    }

    @Override
    public String toString() {
      return String.format("%s", data.toString());
    }
  }*/
}
