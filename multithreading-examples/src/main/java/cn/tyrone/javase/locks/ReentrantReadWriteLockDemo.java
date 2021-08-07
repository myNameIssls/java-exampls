package cn.tyrone.javase.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

}
