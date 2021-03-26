package com.ysy.structure.sparsearray;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        int width = 11, height = 11;
        int[][] chessArr = new int[height][width];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 3;

        // 输出原创的二维数组
        System.out.println("原创的二维数组~~~");
        print(chessArr);

        // 将二维数组 转 稀疏数组
        int[][] sparseArr = sparseArr(chessArr);

        System.out.println("稀疏数组~~~");
        print(sparseArr);

        // 稀疏数组 还原 二维数组
        chessArr = revertChessArr(sparseArr);

        // 输出还原后的二维数组
        System.out.println("还原二维数组~~");
        print(chessArr);

    }

    private static int[][] revertChessArr(int[][] sparseArr) {
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            int[] row = sparseArr[i];
            chessArr[row[0]][row[1]] = row[2];
        }
        return chessArr;
    }

    /**
     * 将二维数组 转 稀疏数组
     *
     * @param chessArr
     * @return
     */
    private static int[][] sparseArr(int[][] chessArr) {
        // 1、先遍历二维数组 得到非0数据的个数
        int sumNum = getSumNumNotZero(chessArr);
        System.out.println("二维数组非零个数num=" + sumNum);

        int[][] sparseArr = new int[sumNum + 1][3];
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sumNum;

        // 遍历数值放入稀疏数组
        int sparseRowNum = 1;
        for (int i = 0; i < chessArr.length; i++) {
            int[] row = chessArr[i];
            for (int j = 0; j < row.length; j++) {
                int v = row[j];
                if (v != 0) {
                    sparseArr[sparseRowNum][0] = i;
                    sparseArr[sparseRowNum][1] = j;
                    sparseArr[sparseRowNum][2] = v;
                    sparseRowNum++;
                }
            }
        }
        return sparseArr;
    }

    private static int getSumNumNotZero(int[][] chessArr) {
        int num = 0;
        for (int[] row : chessArr) {
            for (int col : row) {
                if (col != 0) {
                    num++;
                }
            }
        }
        return num;
    }

    private static void print(int[][] chessArr) {
        for (int[] row : chessArr) {
            for (int col : row) {
                System.out.printf(col + "    ");
            }
            System.out.println();
        }
    }

}
