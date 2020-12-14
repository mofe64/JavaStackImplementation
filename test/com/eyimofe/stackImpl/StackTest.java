package com.eyimofe.stackImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(5);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testStackMaxSizeShouldBeSetToValuePassedInAsSize() {
        Stack testStack1 = new Stack(10);
        assertEquals(10, testStack1.getMaximumStackSize());
    }

    @Test
    public void testStackPushMethodShouldAddItemToTopOfStack() throws Exception {
        stack.push(10);
        assertEquals(false, stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(10, stack.peek());
        stack.push(20);
        assertEquals(2, stack.size());
        assertEquals(20, stack.peek());
    }

    @Test
    void testStackPopMethodShouldRemoveItemFromTopOfStack() throws Exception {
        stack.push(20);
        stack.push(30);
        assertEquals(2, stack.size());
        assertEquals(30, stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void testStackPeekMethodShouldReturnItemAtTopOfStackWithoutModifyingStack() throws Exception{
        stack.push(20);
        stack.push(40);
        assertEquals(40, stack.peek());
        assertEquals(2, stack.size());
        stack.push(45);
        assertEquals(45, stack.peek());
        assertEquals(3, stack.size());
    }

    @Test
    void testStackPopMethodShouldThrowExceptionIfAttemptMadeToPopWhenStackIsEmpty() throws Exception {
        Assertions.assertThrows(Exception.class, () -> {
            stack.pop();
        });
    }

    @Test
    void testStackSizeMethodShouldReturnAmountOfItemsCurrentlyInTheStack() throws Exception {
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.push(55);
        assertEquals(2, stack.size());
    }


    @Test
    void testStackIsEmptyMethodShouldCheckIfTheStackIsEmptyOrNot() {
        assertEquals(true, stack.isEmpty());
    }

    @Test
    void testStackIsFullMethodShouldCheckIfTheStackIsFull() throws Exception{
        stack.push(20);
        stack.push(20);
        stack.push(20);
        stack.push(20);
        stack.push(20);
        assertEquals(true, stack.isFull());
    }

    @Test
    void testStackToString() throws Exception{
        stack.push(10);
        stack.push(20);
       String testString=  stack.toString();
        System.out.println(testString);
    }

    @Test
    void testStackSearchMethod() throws Exception{
        stack.push(8);
        stack.push(5);
        stack.push(9);
        stack.push(2);
        stack.push(4);
        assertEquals(3,stack.search(9));
        assertEquals(1,stack.search(4));
        assertEquals(-1,stack.search(500));
        assertEquals(-1, stack.search(1000000));
    }



}