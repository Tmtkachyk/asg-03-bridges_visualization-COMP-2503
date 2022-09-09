package main;

import java.util.List;

/**
 * I hesitate to call this a list...it's so trimmed down.
 *
 * @author jpratt
 * @param <E> the kind of things in the list
 */
public interface SimpleList<E> {

  /**
   * Adds a thing to the end of this list.
   *
   * @param t the thing to add to this list
   */
  void append(E e);

  /**
   * Returns the first element in this list. If the list is empty, returns null.
   *
   * @return the first element in this list, or null if the list is empty
   */
  E first();

  /**
   * Returns a new SimpleList from the second element in the list onward. If the list only has one
   * or two items, returns null.
   *
   * @return a SimpleList starting from the second element in this list onward
   */
  SimpleList<E> rest();

  /**
   * Returns the number of elements in this list.
   *
   * @return the number of elements in this list
   */
  int size();

  /**
   * Returns true if there are no elements in this list.
   *
   * @return true if there are no elements in this list
   */
  boolean isEmpty();

  /**
   * Returns a List of the elements in this SimpleList from the start to the end.
   *
   * @return a List of the elements in this SimpleList from the start to the end
   */
  List<E> elementsForward();

  /**
   * Returns a List of the elements in this SimpleList from the end to the start.
   *
   * @return a List of the elements in this SimpleList from the end to the start
   */
  List<E> elementsBackward();
}
