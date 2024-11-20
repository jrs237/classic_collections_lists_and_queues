/*
 * Copyright 2024 Ben Philps <bp413@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, J.R. Shovelton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.jrs237.linkedlists;

import java.util.NoSuchElementException;

public class LinkList {

  private static class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }

    Node(int value) {
      this.value = value;
      this.next = null;
    }

    @Override
    public String toString() {
      if (next == null) {
        return String.valueOf(value);
      }
      return value + "," + next;
    }
  }

  public static LinkList create(int[] elements) {
    return createInner(elements, 0);
  }

  static LinkList createInner(int[] elements, int index) {
    if (elements.length == index)
      return new LinkList();

    LinkList linkList = createInner(elements, index + 1);
    linkList.addFirst(elements[index]);
    return linkList;
  }

  private Node head;

  LinkList() {
    this.head = null;
  }

  void addFirst(int element) {
    if (head == null) {
      head = new Node(element);
    } else {
      head = new Node(element, head);
    }
  }

  int removeFirst() {
    if (head == null)
      throw new NoSuchElementException();

    int value = head.value;
    head = head.next;
    return value;
  }

  int get(int elem) {
    Node pointer = head;

    if (pointer == null)
      throw new NoSuchElementException();

    for (int item = 0; item < elem; item++) {
      pointer = pointer.next;

      if (pointer == null)
        throw new NoSuchElementException();
    }

    return pointer.value;
  }

  int length() {
    Node pointer = head;
    int i = 0;

    while(pointer != null) {
      pointer = pointer.next;
      i++;
    }

    return i;
  }

  @Override
  public String toString() {
    return String.format("[%s]", head == null ? "" : head.toString());
  }
}
