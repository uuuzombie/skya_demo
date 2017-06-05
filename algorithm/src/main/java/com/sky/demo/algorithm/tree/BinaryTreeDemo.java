package com.sky.demo.algorithm.tree;

import com.google.common.base.Preconditions;

/**
 * Created by user on 17/6/5.
 * 二叉树
 */
public class BinaryTreeDemo {


    //先序遍历
    public static void preOrderTraversal(BiTree root) {
//        Preconditions.checkNotNull(root, "Tree is null");

        if (root == null) {
            return;
        }

        System.out.println(root.getValue()); //or do something

        if (root.getLeft() != null) {
            preOrderTraversal(root.getLeft());
        }

        if (root.getRight() != null) {
            preOrderTraversal(root.getRight());
        }
    }


    //中序遍历
    public static void inOrderTraversal(BiTree root) {

        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            inOrderTraversal(root.getLeft());
        }

        System.out.println(root.getValue()); //or do something

        if (root.getRight() != null) {
            inOrderTraversal(root.getRight());
        }
    }


    //后序遍历
    public static void postOrderTraversal(BiTree root) {
        if (root == null) {
            return;
        }

        if (root.getLeft() != null) {
            postOrderTraversal(root.getLeft());
        }

        if (root.getRight() != null) {
            postOrderTraversal(root.getRight());
        }

        System.out.println(root.getValue()); //or do something
    }

}
