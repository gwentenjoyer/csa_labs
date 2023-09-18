import impl.ArrayProcessorImpl;
import impl.ArrayReaderImpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayProcessorImpl useless = new ArrayProcessorImpl();
        ArrayReaderImpl arrayReader = new ArrayReaderImpl();
        double[] arr = arrayReader.readOneDimensionalArray("inputdata1.txt");
//        useless.processArray(arr);
        double[][] arr2 = arrayReader.readTwoDimensionalArray("inputdata2.txt");
//        useless.processArray(arr2);
        System.out.printf("\u001B[32m" +  "Calculate 1: %f\n", useless.calculate(arr));
        System.out.println(useless.calculate(arr2));
    }
    private static double[][] generateRandomMatrix(int n) {
        double[][] matrix = new double[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double randomValue = -200 + 400 * random.nextDouble();

                matrix[i][j] = Math.round(randomValue * 100.0) / 100.0;
                System.out.print(matrix[i][j] + "\t");
//                matrix[i][j] = Math.round(randomValue * 100.0) / 100.0;
//                matrix[i][j] = Math.round(randomValue * 100.0) / 100.0;
            }
            System.out.println();
        }

        return matrix;
    }
}