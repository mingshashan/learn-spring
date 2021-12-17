package com.mingshashan.learn.hello.thread.lock;

import java.util.concurrent.atomic.AtomicReference;

public class TreiberStack<E> {

    AtomicReference<Node<E>> top = new AtomicReference<>();

    public void push(E element) {
        Node<E> newHead = new Node<>(element);
        Node<E> oldHead;
        do {
            oldHead = top.get();
            newHead.next = oldHead;
        } while (!top.compareAndSet(oldHead, newHead));
    }

    public E pop() {
        Node<E> newHead;
        Node<E> oldHead;
        do {
            oldHead = top.get();
            if (null == oldHead) {
                return null;
            }
            newHead = oldHead.next;
        } while (!top.compareAndSet(oldHead, newHead));
        return oldHead.emement;
    }

    final class Node<E> {
        private final E emement;
        private Node next;

        public Node(E element) {
            this.emement = element;
        }
    }
}
