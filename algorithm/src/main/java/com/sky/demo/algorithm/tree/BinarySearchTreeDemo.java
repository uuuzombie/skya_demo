package com.sky.demo.algorithm.tree;


/**
 * Created by user on 17/6/5.
 * 二叉搜索树
 * 1.若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 2.若任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 3.任意节点的左、右子树也分别为二叉查找树；
 * 4.没有键值相等的节点。
 */
public class BinarySearchTreeDemo {


    public static BiTree searchBiTree(BiTree root, int key) {

        if (root == null) {
            return null;
        }

        if (root.getValue() == key) {
            return root;
        } else if (root.getValue() > key ) {
            return searchBiTree(root.getLeft(), key);
        } else if (root.getValue() < key) {
            return searchBiTree(root.getRight(), key);
        }

        return null;
    }

}
