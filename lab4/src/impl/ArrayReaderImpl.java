package impl;

import interf.ArrayReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ArrayReaderImpl implements ArrayReader {
    @Override
    public double[] readOneDimensionalArray(File file) {
        try (Scanner in = new Scanner(new FileReader(file))){;
            in.useLocale(Locale.US);
            int n = in.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextDouble();
            }
            return arr;
        } catch (IOException ex) {
            System.err.println("Error reading file" + ex);
            return null;
        }
    }

    @Override
    public double[] readOneDimensionalArray(String fileName) {
        try (Scanner in = new Scanner(new FileReader(fileName))){;
            in.useLocale(Locale.US);
            int n = in.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextDouble();
            }
            return arr;
        } catch (IOException ex) {
            System.err.println("Error reading file" + ex);
            return null;
        }
    }
    @Override
    public double[][] readTwoDimensionalArray(File file) {
        return new double[0][];
    }

    @Override
    public double[][] readTwoDimensionalArray(String fileName) {
        try (Scanner in = new Scanner(new FileReader(fileName))){;
            in.useLocale(Locale.US);
            int n = in.nextInt();
            double[][] arr = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextDouble();
                }
            }
            return arr;
        } catch (IOException ex) {
            System.err.println("Error reading file" + ex);
            return null;
        }
    }
}
