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

import static com.google.common.truth.Truth.assertThat;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LinkListTest {

  @Test
  public void linkList_toStringIsEmptyList_whenListEmpty() {
    // ARRANGE
    LinkList empty = new LinkList();

    // ACT
    String value = empty.toString();

    // ASSERT
    assertThat(value).isEqualTo("[]");
  }

  @Test
  public void linkList_toStringIsSingleItem_whenListContainsOneItem() {
    // ARRANGE
    LinkList list = new LinkList();
    list.addFirst(1);

    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[1]");
  }

  @Test
  public void linkList_toStringIsTwoThenOne_whenListHasOneThenTwoAdded() {
    // ARRANGE
    LinkList list = new LinkList();
    list.addFirst(1);
    list.addFirst(2);

    // ACT
    String value = list.toString();

    // ASSERT
    assertThat(value).isEqualTo("[2,1]");
  }

  @Test
  public void linkList_emptyArrayToList() {
    int[] arr = new int[] {};


    LinkList linkList = LinkList.create(arr);

    assertThat(linkList.toString()).isEqualTo("[]");
  }

  @Test
  public void linkList_nonEmptyArrayToList() {
    int[] arr = new int[] {1, 2, 3};

    LinkList linkList = LinkList.create(arr);

    assertThat(linkList.toString()).isEqualTo("[1,2,3]");
  }

  @Test(expected = NoSuchElementException.class)
  public void linkList_removeFirstEmptyException() {
    LinkList linkList = new LinkList();
    
    linkList.removeFirst();
  }

  @Test
  public void linkList_removeFirstEmptyNoException() {
    LinkList linkList = new LinkList();

    linkList.addFirst(5);
    int result = linkList.removeFirst();
    String remaining = linkList.toString();

    assertThat(result).isEqualTo(5);
    assertThat(remaining).isEqualTo("[]");
  }
}
