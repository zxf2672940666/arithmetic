package com.pa.queue;

/**
 * 数组模拟队列
 */
public class ArrayQueueDemo1 {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
    }

    static class ArrayQueue {
        private int maxSize;//数组最大容量
        private int front;//指向队列头
        private int rear;//队列尾部
        private int[] arr;//该数组用于存放数据，模拟队列

        public ArrayQueue(int maxSize) {
            maxSize = maxSize;
            arr = new int[maxSize];
            front = -1;//指向队列头部，
            rear = -1;//指向队列尾部，指向队列尾部数据（即就是队列最后一个数据）
        }

        public boolean isFull() {
            return rear == maxSize - 1;
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public void add(int n) {
            if (isFull()) {
                System.out.println("队列满，不能加入数据");
                return;
            }
            rear++;//后移
            arr[rear] = n;
        }

        public int get() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，不能取出数据");
            }
            front++;
            return arr[front];
        }

        public void showQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，不能取出数据");
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }

        //显示队列投书局
        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，不能取出数据");
            }
            return arr[front + 1];
        }
    }
}
