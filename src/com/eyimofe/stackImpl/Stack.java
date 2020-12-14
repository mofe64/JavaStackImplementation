package com.eyimofe.stackImpl;

import java.util.Scanner;

public class Stack {
    private int maximumStackSize;
    private int[] stackArray;
    private int topOfStack;

    public Stack(int size) {
        this.maximumStackSize = size;
        stackArray = new int[size];
        topOfStack = -1;
    }

    public void push(int itemToAdd) throws Exception {
        if (!isFull()) {
            stackArray[topOfStack + 1] = itemToAdd;
            topOfStack++;
        } else {
            throw new Exception("Stack is currently full and cannot push items onto the stack");
        }

    }

    public int pop() throws Exception {
        if (!isEmpty()) {
            int itemToPop = stackArray[topOfStack];
            stackArray[topOfStack] = 0;
            topOfStack--;
            return itemToPop;
        } else {
            throw new Exception("Stack is currently empty and cannot pop items off");
        }

    }

    public int peek() {
        return stackArray[topOfStack];
    }

    public boolean isEmpty() {
        if (topOfStack == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        int maxIndexAttainable = maximumStackSize - 1;
        if (topOfStack == maxIndexAttainable) {
            return true;
        }
        return false;
    }

    public int size() {
        return topOfStack + 1;
    }

    public int getMaximumStackSize() {
        return maximumStackSize;
    }

    public int search(int stackItem) {
        boolean stackItemFound = false;
        int[] stackArrayReversed = reverseArray(stackArray, stackArray.length);
        int index = -1;
        for (int i = 0; i < stackArrayReversed.length; i++) {
            if (stackArrayReversed[i] == stackItem) {
                index = i;
                stackItemFound = true;
            }
        }
        if (stackItemFound == true) {
            return index += 1;
        } else {
            return index;
        }


    }

    private int[] reverseArray(int[] array, int arrayLength) {
        int[] reversedArray = new int[arrayLength];
        int limit = arrayLength;
        for (int i = 0; i < arrayLength; i++) {
            reversedArray[limit - 1] = array[i];
            limit = limit - 1;

        }
        return reversedArray;
    }

    @Override
    public String toString() {
        String returnString = "[";
        for (int i = 0; i < stackArray.length - 1; i++) {
            if (stackArray[i] != 0) {
                returnString += " " + stackArray[i];
            }
        }
        returnString += " ]";
        return returnString;
    }


}
