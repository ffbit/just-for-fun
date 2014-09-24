package com.ffbit.fun.tree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SearchBinaryTreeTest {
    private SearchBinaryTree<String> tree = new SearchBinaryTree<>();

    @Test
    public void itShouldCreateEmptyTree() {
        assertThat(tree.isEmpty(), is(true));
    }

    @Test
    public void itShouldCreateTreeOfSizeZero() {
        assertThat(tree.size(), is(0));
    }

    @Test
    public void itShouldNotBeEmptyIfOneKeyInserted() {
        tree.insert("A");

        assertThat(tree.isEmpty(), is(false));
    }

    @Test
    public void itShouldBeOfSizeOneIfOneKeyInserted() {
        tree.insert("B");

        assertThat(tree.size(), is(1));
    }

    @Test
    public void itShouldIncreaseSizeWhenDistinctKeysInserted() {
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");

        assertThat(tree.size(), is(3));
    }

    @Test
    public void itShouldNotIncreaseSizeWhenDuplicateKeyInserted() {
        tree.insert("A");
        tree.insert("A");

        assertThat(tree.size(), is(1));
    }

    @Test
    public void itShouldRetrieveElementsPreOrder() {
        tree.insert("F");
        tree.insert("B");
        tree.insert("A");
        tree.insert("D");
        tree.insert("C");
        tree.insert("E");
        tree.insert("G");
        tree.insert("I");
        tree.insert("H");

        assertThat("expected a tree of size 9", tree.size(), is(9));

        assertThat(tree.preOrder(),
                is(new String[]{"F", "B", "A", "D", "C", "E", "G", "I", "H"}));
    }

    @Test
    public void itShouldRetrieveElementsInOrder() {
        tree.insert("F");
        tree.insert("B");
        tree.insert("A");
        tree.insert("D");
        tree.insert("C");
        tree.insert("E");
        tree.insert("G");
        tree.insert("I");
        tree.insert("H");

        assertThat("expected a tree of size 9", tree.size(), is(9));

        assertThat(tree.inOrder(),
                is(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I"}));
    }

    @Test
    public void itShouldRetrieveElementsPostOrder() {
        tree.insert("F");
        tree.insert("B");
        tree.insert("A");
        tree.insert("D");
        tree.insert("C");
        tree.insert("E");
        tree.insert("G");
        tree.insert("I");
        tree.insert("H");

        assertThat("expected a tree of size 9", tree.size(), is(9));

        assertThat(tree.postOrder(),
                is(new String[]{"A", "C", "E", "D", "B", "H", "I", "G", "F"}));
    }

}
