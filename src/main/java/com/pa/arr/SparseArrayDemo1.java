package com.pa.arr;

/**
 * 稀疏数组demo 当一个数组大部分元素是0，
 * 或者为同一个值得时候，可以使用稀疏数组来保存该数组
 * 稀疏数组的处理方法是：
 * 1、记录数组一共几行几咧，有多少个不同的值
 * 2、把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
 * 例如：棋盘，地图
 */
public class SparseArrayDemo1 {

    public static void main(String[] args) {
        int[][] arrs = new int[3][3];
        arrs[0][0] = 11;
        arrs[0][1] = 11;
        arrs[0][2] = 3;
        arrs[1][0] = 1;
        arrs[1][1] = 2;
        arrs[1][2] = 1;
        arrs[2][0] = 2;
        arrs[2][1] = 3;
        arrs[2][2] = 2;
        int[][] ints = sparseArrayToArrray(arrs);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.printf("%d\t", ints[i][j]);
            }
            System.out.println();
        }

        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[i][j] != 0) {
                    count++;
                }
            }
        }
        System.out.println("-----------------------------");
        int[][] arrrayToSparseArray = arrrayToSparseArray(ints, count);

        for (int i = 0; i < arrrayToSparseArray.length; i++) {
            for (int j = 0; j < arrrayToSparseArray[0].length; j++) {
                System.out.printf("%d\t", arrrayToSparseArray[i][j]);
            }
            System.out.println();
        }
    }


    private static int[][] sparseArrayToArrray(int[][] sparseArray) {
        int[][] arr = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {
            arr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return arr;
    }

    private static int[][] arrrayToSparseArray(int[][] arr, int count) {
        int[][] sparseArray = new int[count + 1][3];
        boolean result = arrayIsNull(arr);
        if (result) {
            return  sparseArray;
        }
        sparseArray[0][0] = arr.length;
        sparseArray[0][1] = arr[0].length;
        sparseArray[0][2] = count;

        int local = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArray[local][0] = i;
                    sparseArray[local][1] = j;
                    sparseArray[local][2] = arr[i][j];
                    local++;
                }
            }
        }
        return sparseArray;
    }

    private static boolean arrayIsNull(int[][] arr) {
        boolean result = false;
        if (arr == null || arr.length == 0 || (arr.length == 1 && arr[0].length == 0)) {
            return true;
        }
        return result;
    }
}
