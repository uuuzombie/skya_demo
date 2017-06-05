package com.sky.demo.algorithm.tree;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 17/6/5.
 */
public class BinaryTreeDemoTest {


    private BiTree biTree;

    @Before
    public void setUp() {
        biTree = new BiTree(10);

        BiTree biTree1 = new BiTree(5);
        BiTree biTree2 = new BiTree(15);
        BiTree biTree3 = new BiTree(2);
        BiTree biTree4 = new BiTree(29);
        BiTree biTree5 = new BiTree(7);
        BiTree biTree6 = new BiTree(11);

        biTree.setLeft(biTree1);
        biTree.setRight(biTree2);
        biTree1.setLeft(biTree3);
        biTree2.setRight(biTree4);
        biTree1.setRight(biTree5);
        biTree2.setLeft(biTree6);

    }


    @Test
    public void test_preOrderTraversal() {

        BinaryTreeDemo.preOrderTraversal(biTree);
    }

    @Test
    public void test_inOrderTraversal() {
        BinaryTreeDemo.inOrderTraversal(biTree);
    }

    @Test
    public void test_postOrderTraversal() {
        BinaryTreeDemo.postOrderTraversal(biTree);
    }


}
