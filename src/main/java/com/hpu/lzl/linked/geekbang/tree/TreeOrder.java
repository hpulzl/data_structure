package com.hpu.lzl.linked.geekbang.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
*   
* @author:awo  
* @time:2018/11/14  上午9:20 
* @Description: info
**/  
public class TreeOrder {
    static class Tree{
        int data;
        Tree left;
        Tree right;

        public Tree(int data) {
            this.data = data;
        }
    }

    /**
     * 先序遍历
     * 中、左、右
     * @param tree
     */
    public static void preOrder(Tree tree){
        //终止条件
        if (tree == null){
            return;
        }
        printAppend(tree.data,",");
        preOrder(tree.left);
        preOrder(tree.right);
    }

    public static void printAppend(int data,String str){
        System.out.print(data + str);

    }
    /**
     * 中序遍历
     * 左、中、右
     * @param tree
     */
    public static void inOrder(Tree tree){
        //终止条件
        if (tree == null){
            return;
        }
        inOrder(tree.left);
        printAppend(tree.data,",");
        inOrder(tree.right);
    }

    /**
     * 后序遍历
     * 左、右、中
     * @param tree
     */
    public static void postOrder(Tree tree){
        //终止条件
        if (tree == null){
            return;
        }
        postOrder(tree.left);
        postOrder(tree.right);
        printAppend(tree.data,",");
    }

    /**
     * 层遍历
     * @param tree
     */
    public static void order(Tree tree){
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()){
            Tree temp = queue.peek();
            printAppend(temp.data,",");
            queue.poll();
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree a = new Tree(1);
        Tree b = new Tree(2);
        Tree c = new Tree(3);
        Tree d = new Tree(4);
        Tree e = new Tree(5);
        Tree f = new Tree(6);
        Tree g = new Tree(7);
        Tree h = new Tree(8);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        System.out.println("先序遍历:");
        preOrder(a);
        System.out.println("\n中序遍历:");
        inOrder(a);
        System.out.println("\n后序遍历:");
        postOrder(a);
        System.out.println("\n按层遍历:");
        order(a);
    }
}
