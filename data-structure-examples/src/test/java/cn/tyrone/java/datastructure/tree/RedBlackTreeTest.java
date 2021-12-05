package cn.tyrone.java.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RedBlackTreeTest {

    private RedBlackTree redBlackTree;

    @BeforeEach
    void init(){

        if (redBlackTree == null) {
            redBlackTree = new RedBlackTree();
        }

    }

    @Test
    void insert() {

//        // 插入情景1:当前红黑树是空树。
//        redBlackTree.insert(50, 50);

//        // 插入情况2：新插入结点的父结点是黑色
//        int[] keys = {50, 30, 80};
//        for (int i = 0; i < keys.length; i++) {
//            redBlackTree.insert(keys[i], keys[i]);
//        }

//        // 插入情况3：插入结点的父结点和叔叔结点都是红色
//        int[] keys = {50, 30, 80, 20};
//        for (int i = 0; i < keys.length; i++) {
//            redBlackTree.insert(keys[i], keys[i]);
//            System.out.println("第" + i + "次插入");
//        }

//        // 插入情况4：插入结点的父结点是红色，叔叔结点是黑色或者为空结点，且父结点位于祖父结点的左子树结点，且插入结点位于父结点左子树结点。
//        int[] keys = {50, 30, 20};
//        for (int i = 0; i < keys.length; i++) {
//            redBlackTree.insert(keys[i], keys[i]);
//            System.out.println("第" + i + "次插入");
//        }


//        // 插入情况5：插入结点的父结点是红色，叔叔结点是黑色或者为空结点，且父结点位于祖父结点的右子树结点，且插入结点位于父结点左子树结点。
//        int[] keys = {50, 30, 35};
//        for (int i = 0; i < keys.length; i++) {
//            redBlackTree.insert(keys[i], keys[i]);
//            System.out.println("第" + i + "次插入");
//        }

//        // 插入情况6：插入结点的父结点是红色，且父结点位于祖父结点的右子树结点，叔叔结点是黑色或者为空结点，且插入结点位于父结点右子树结点。
//        int[] keys = {30, 50, 60};
//        for (int i = 0; i < keys.length; i++) {
//            redBlackTree.insert(keys[i], keys[i]);
//            System.out.println("第" + i + "次插入");
//        }

        // 插入情况7：插入结点的父结点是红色，且父结点位于祖父结点的右子树结点，叔叔结点是黑色或者为空结点，且插入结点位于父结点左子树结点。
        int[] keys = {30, 50, 40};
        for (int i = 0; i < keys.length; i++) {
            redBlackTree.insert(keys[i], keys[i]);
            System.out.println("第" + i + "次插入");
        }

        System.out.println("--------- 红黑树插入结点结束 ---------");


    }
}