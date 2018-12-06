package com.hpu.lzl.linked.geekbang.tree;

/**
*   
* @author:awo  
* @time:2018/10/25  下午7:32 
* @Description: 平衡二叉树
 * 左左型 右旋
 * 右右型 左旋
 * 左右型 先左旋，再右旋
 * 右左型 先右旋，再左旋
**/  
public class AVLTree {

    class AvlNode{
        //节点数据
        int data;
        //左子树
        AvlNode lchild;
        //🈶️右子树
        AvlNode rchild;
        //节点的高度
        int height;
    }

    /**
     * 左左型，右旋
     * @param k2
     * @return
     */
    private AvlNode rRotation(AvlNode k2){
        AvlNode k1;
        k1 = k2.lchild;
        k2.lchild = k1.rchild;
        k1.rchild = k2;

        //计算k1、k2的高度
        k1.height = Math.max(getHeight(k1.rchild),getHeight(k1.lchild)) + 1;
        k2.height = Math.max(getHeight(k2.rchild),getHeight(k2.lchild)) + 1;
        return k2;
    }
    /**
     * 右右型，左旋
     * @param k2
     * @return
     */
    private AvlNode lRotation(AvlNode k2){
        AvlNode k1;
        k1 = k2.rchild;
        k2.rchild = k1.lchild;
        k1.lchild = k2;

        //计算k1、k2的高度
        k1.height = Math.max(getHeight(k1.rchild),getHeight(k1.lchild)) + 1;
        k2.height = Math.max(getHeight(k2.rchild),getHeight(k2.lchild)) + 1;
        return k1;
    }

    /**
     * 左右型，左旋--右旋
     * @param k2
     * @return
     */
    private AvlNode lrRotation(AvlNode k2){
        AvlNode k1;
//        k1.lchild = lRotation(k2);

        return k2;
    }

    /**
     * 右左型，右旋--左旋
     * @param k2
     * @return
     */
    private AvlNode rlRotation(AvlNode k2){
        return k2;
    }

    private int getHeight(AvlNode t){
        if (t == null){
            return -1;
        }
        return t.height;
    }
    public AvlNode insert(int data,AvlNode t){
        if (t == null){
           createAvlNode(data,t);
           //数据不为空，递归构建平衡二叉树
        }else if (data < t.data){
            //插入左子树
           t.lchild = insert(data,t.lchild);
           //左子树-右子树高度为2，考虑旋转
           if (getHeight(t.lchild) - getHeight(t.rchild) == 2){
               //左左型
               if (data < t.lchild.data){
                   t = rRotation(t);
               }else {
                   //左右型
                   t = lrRotation(t);
               }
           }
        }else{
            //插入右子树
            t.rchild = insert(data,t.rchild);
            if (getHeight(t.rchild) - getHeight(t.lchild) == 2){
                //右右型
                if (data > t.rchild.data){
                    t = lRotation(t);
                }else {
                    t = rlRotation(t);
                }
            }
        }

        //计算t的高度
        t.height = Math.max(t.lchild.height,t.rchild.height) + 1;
        return t;
    }

    private AvlNode createAvlNode(int data,AvlNode t){
        t = new AvlNode();
        t.data = data;
        t.rchild = t.lchild = null;
        return t;
    }
}
