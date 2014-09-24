package com.ffbit.fun.tree;

public class SearchBinaryTree<E extends Comparable<E>> {
    private Node<E> root;
    private int size;

    private static class Node<E> {
        private final E value;
        private Node<E> left;
        private Node<E> right;

        private Node(E value) {
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(E v) {
        if (isEmpty()) {
            root = new Node<>(v);
            size++;
        } else {
            if (insert(root, v)) {
                size++;
            }
        }
    }

    private boolean insert(Node<E> parent, E v) {
        if (v.compareTo(parent.value) < 0) {
            if (parent.left != null) {
                return insert(parent.left, v);
            }

            parent.left = new Node<>(v);
            return true;
        } else if (v.compareTo(parent.value) > 0) {
            if (parent.right != null) {
                return insert(parent.right, v);
            }

            parent.right = new Node<>(v);
            return true;
        }

        return false;
    }

    public E[] preOrder() {
        E[] values = (E[]) new Comparable[size];

        if (!isEmpty()) {
            traversePreOrder(values, 0, root);
        }

        return values;
    }

    private int traversePreOrder(E[] values, int index, Node<E> node) {
        int i = index;

        values[i++] = node.value;

        if (node.left != null) {
            i = traversePreOrder(values, i, node.left);
        }

        if (node.right != null) {
            i = traversePreOrder(values, i, node.right);
        }

        return i;
    }

    public E[] inOrder() {
        E[] values = (E[]) new Comparable[size];

        if (!isEmpty()) {
            traverseInOrder(values, 0, root);
        }

        return values;
    }

    private int traverseInOrder(E[] values, int index, Node<E> node) {
        int i = index;

        if (node.left != null) {
            i = traverseInOrder(values, i, node.left);
        }

        values[i++] = node.value;

        if (node.right != null) {
            i = traverseInOrder(values, i, node.right);
        }

        return i;
    }

    public E[] postOrder() {
        E[] values = (E[]) new Comparable[size];

        if (!isEmpty()) {
            postOrder(values, 0, root);
        }

        return values;
    }

    private int postOrder(E[] values, int index, Node<E> node) {
        int i = index;

        if (node.left != null) {
            i = postOrder(values, i, node.left);
        }

        if (node.right != null) {
            i = postOrder(values, i, node.right);
        }

        values[i++] = node.value;

        return i;
    }

}
