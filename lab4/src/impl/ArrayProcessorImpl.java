package impl;

import interf.ArrayProcessor;

import static java.lang.Math.abs;

public class ArrayProcessorImpl implements ArrayProcessor {
    @Override
    public double calculate(double[] array) {
        double firstPositive = 0;
        double lastPositive = 0;

        double tmp;
        for (int i = 0; i < array.length; i++) {
            tmp = array[i];
            if (array[i] > 0) {
                if (firstPositive == 0) {
                    firstPositive = tmp;
                }
                lastPositive = tmp;
            }
        }
        return lastPositive - firstPositive;
    }

    @Override
    public double calculate(double[][] array) {
        double sum = 0.0;
        int n = array.length;
        for (int i = 0; i <= n/2; i++) {
            for (int j = i; j < n - i; j++) {
                if ((int)array[i][j] % 3 == 0) {
                    sum += array[i][j];
                }
            }
        }
        for (int i = n - 1; i > n/2; i--) {
            for (int j = n - i - 1; j <= i ; j++) {
                if ((int)array[i][j] % 3 == 0) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }

    @Override
    public void processArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    @Override
    public void processArray(double[][] array) {
//        String ANSI_GREEN = "\u001B[32m";
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
