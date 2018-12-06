package com.hpu.lzl.linked.geekbang;

import java.util.Random;

/**
 * 跳表的一种实现方法。
 * 跳表中存储的是正整数，并且存储的是不重复的。
 *
 * Author：ZHENG
 */
public class SkipList {

  private static final int MAX_LEVEL = 16;

  private int levelCount = 1;

  private Node head = new Node();  // 带头链表

  private Random r = new Random();

  public Node find(int value) {
    Node p = head;
    for (int i = levelCount - 1; i >= 0; --i) {
      while (p.forwords[i] != null && p.forwords[i].data < value) {
        p = p.forwords[i];
      }
    }

    if (p.forwords[0] != null && p.forwords[0].data == value) {
      return p.forwords[0];
    } else {
      return null;
    }
  }

  public void insert(int value) {
    int level = randomLevel();
    Node newNode = new Node();
    newNode.data = value;
    newNode.maxLevel = level;
    Node update[] = new Node[level];
    for (int i = 0; i < level; ++i) {
      update[i] = head;
    }

    Node p = head;
    for (int i = level - 1; i >= 0; --i) {
      while (p.forwords[i] != null && p.forwords[i].data < value) {
        p = p.forwords[i];
      }
      update[i] = p;
    }

    for (int i = 0; i < level; ++i) {
      newNode.forwords[i] = update[i].forwords[i];
      update[i].forwords[i] = newNode;
    }

    if (levelCount < level) levelCount = level;
  }

  public void delete(int value) {
    Node[] update = new Node[levelCount];
    Node p = head;
    for (int i = levelCount - 1; i >= 0; --i) {
      while (p.forwords[i] != null && p.forwords[i].data < value) {
        p = p.forwords[i];
      }
      update[i] = p;
    }

    if (p.forwords[0] != null && p.forwords[0].data == value) {
      for (int i = levelCount - 1; i >= 0; --i) {
        if (update[i].forwords[i] != null && update[i].forwords[i].data == value) {
          update[i].forwords[i] = update[i].forwords[i].forwords[i];
        }
      }
    }
  }

  private int randomLevel() {
    int level = 1;
    for (int i = 1; i < MAX_LEVEL; ++i) {
      if (r.nextInt() % 2 == 1) {
        level++;
      }
    }

    return level;
  }

  public void printAll() {
    Node p = head;
    while (p.forwords[0] != null) {
      System.out.print(p.forwords[0] + " ");
      p = p.forwords[0];
    }
    System.out.println();
  }

  public class Node {
    private int data = -1;
    private Node forwords[] = new Node[MAX_LEVEL];
    private int maxLevel = 0;

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("{ data: ");
      builder.append(data);
      builder.append("; levels: ");
      builder.append(maxLevel);
      builder.append(" }");

      return builder.toString();
    }
  }

  public static void main(String[] args) {
    SkipList skipList = new SkipList();
    skipList.insert(1);
    skipList.insert(2);
    skipList.insert(3);
    skipList.insert(4);
    skipList.insert(5);
    skipList.insert(6);
    skipList.insert(7);
    skipList.insert(8);
    skipList.insert(9);
    skipList.insert(110);
    skipList.insert(12);
    skipList.insert(13);
    skipList.insert(19);
    skipList.insert(14);
    skipList.insert(28);
    skipList.insert(55);
    skipList.insert(34);
    skipList.insert(0);

    skipList.printAll();
  }
}