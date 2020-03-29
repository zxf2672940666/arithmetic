package com.pa.queue;

/**
 * 数组模拟环形队列
 * 前队列有效数据个数：(rear + maxSize - front) % maxSize
 * 队列满：(rear + 1) % maxSize == front
 * 队列为空：rear == front
 */
public class ArrayQueueDemo2 {


    static class ArrayQueue {
        private int[] arr;//该数组用于存放数据，模拟队列
        private int maxSize;//数组最大容量
        private int front;//指向队列头 指向队列的第一个元素 初始值 0
        private int rear;//队列尾部 指向队列最后一个元素的后一个位置 初始值0

        public ArrayQueue(int maxSize) {
            maxSize = maxSize;
            arr = new int[maxSize];
        }

        public boolean isFull() {
            if ((rear + 1) % maxSize == front) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            if (rear == front) {
                return true;
            }
            return false;
        }

        public void add(int n) {
            if (isFull()) {
                System.out.println("队列已满");
                return;
            }
            //将数据加入
            arr[rear] = n;
            //将rear后移
            rear = (rear + 1) % maxSize;
        }

        public int poll() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，不能取出数据");
            }
            //1、将front对应的值保存在一个临时变量中
            //2、front后移 考虑取模
            //3、将临时保存的变量返回
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }

        public void showQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，不能取出数据");
            }
            // 思路，从front开始遍历，便利多少个元素
            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }

        //求出当前队列有效数据个数
        public int size() {
            return (rear + maxSize - front) % maxSize;
        }

        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，不能取出数据");
            }
            return arr[front];
        }
    }
}
