package cn.tyrone.java.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeSequenceTest {

    private BinaryTreeSequence binaryTreeSequence;

    @BeforeEach
    void init(){
        if (binaryTreeSequence == null) {

            int[] data = {1,2,3,4,5,6,7};

            binaryTreeSequence = new BinaryTreeSequence(data);
        }
    }

    @Test
    void preOrder() {

        binaryTreeSequence.preOrder();

    }
}