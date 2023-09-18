package interf;

import java.io.File;

public interface ArrayReader {
    double[] readOneDimensionalArray(File file);
    double[] readOneDimensionalArray(String fileName);
    double[][] readTwoDimensionalArray(File file);
    double[][] readTwoDimensionalArray(String fileName);
}
