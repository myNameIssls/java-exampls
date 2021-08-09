package cn.tyrone.javase.locks;


import jdk.internal.org.objectweb.asm.util.Printer;
import org.openjdk.jol.info.ClassLayout;

/**
 * Java内置锁共有4种状态：无锁状态、偏向锁状态、轻量级锁状态、重量级锁状态
 * 该示例用来演示内置锁不同状态
 */
public class InnerLockTest {



    void showBiasedLoack(){
//        ClassLayout.parseInstance().toPrintable();
    }

}
