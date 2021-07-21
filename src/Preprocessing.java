import java.io.*;
import java.util.*;

/**
 * Project 2 - Preprocessing.java
 *
 * This program uses arrays, loops, and data types to manipulate information from a file and and turn it into a new
 *  array with differently formatted data.
 *
 * @author Emelie Coleman, sec. L17
 *
 * @version February 28, 2019
 *
 */

public class Preprocessing {

    /** YOU ARE NOT REQUIRED TO CHANGE THIS LINE. ENSURE THE FILE survey_data.csv IS LOCATED AT THE ROOT OF YOUR PROJECT
     *  FOR EXAMPLE, IF YOU ARE USING INTELLIJ AND YOUR PROJECT IS CALLED Project2, PLACE IT IN THE FOLDER Project2
     * (NOT THE src FOLDER)
     */
    private static String fileName = "survey_data.csv";
    // DO NOT REMOVE THESE LINES. THEY ARE USED FOR TESTING YOUR PROJECT.
    private static Double[][] cleanedData;
    private static Double[][] transformedData;
    private static Double[][] reducedData;
    private static int[][] preprocessedData;

    // THE NEXT TWO DECLARATIONS ARE A 2D ARRAY CONTAINING EVERY ROW AND COLUMN (EXCEPT THE FIRST COLUMN - DEGREE -
    // HELD WITHIN THE 1D ARRAY degreeColumn.
    private static Double[][] dataSet;
    private static String[] degreeColumn;


    public static void main(String[] args) {
        // DO NOT CHANGE THIS CALL OR THE DATA SET WILL NOT BE LOADED!
        loadData();

        // Call printData() whenever you want the data set in its current state to be printed.
        //printData();

        /* TASK 1 - DATA CLEANING
         * PUT YOUR CODE FOR TASK 1 BELOW. */
        degreeColumn = new String[10];
        dataSet = new Double[degreeColumn.length][5];

        // Calculate average for each column
        Double total0 = 0.0;
        Double total1 = 0.0;
        Double total2 = 0.0;
        Double total3 = 0.0;
        Double total4 = 0.0;

        for (int i = 0; i < degreeColumn.length; i++) {
            if (dataSet[i][0] != null) {
                total0 += dataSet[i][0];
            }
        }
        for (int i = 1; i < degreeColumn.length; i++) {
            if (dataSet[i][1] != null) {
                total1 += dataSet[i][1];
            }
        }
        for (int i = 2; i < degreeColumn.length; i++) {
            if (dataSet[i][2] != null) {
                total2 += dataSet[i][2];
            }
        }
        for (int i = 3; i < degreeColumn.length; i++) {
            if (dataSet[i][3] != null) {
                total3 += dataSet[i][3];
            }
        }
        for (int i = 4; i < degreeColumn.length; i++) {
            if (dataSet[i][4] != null) {
                total4 += dataSet[i][4];
            }
        }
        //System.out.println(total0);

        Double avgAge = total0 / degreeColumn.length;
        Double avgGrade = total1 / degreeColumn.length;
        Double avgGPA = total2 / degreeColumn.length;
        Double avgHours = total3 / degreeColumn.length;
        Double avgMonths = total4 / degreeColumn.length;

        //printData();
        // Replace null values in each column
        for (int i = 0; i < degreeColumn.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0 && dataSet[i][j] == null) {
                    dataSet[i][j] = avgAge;
                } else if (j == 1 && dataSet[i][j] == null) {
                    dataSet[i][j] = avgGrade;
                } else if (j == 2 && dataSet[i][j] == null) {
                    dataSet[i][j] = avgGPA;
                } else if (j == 3 && dataSet[i][j] == null) {
                    dataSet[i][j] = avgHours;
                } else if (j == 4 && dataSet[i][j] == null) {
                    dataSet[i][j] = avgMonths;
                }
            }
        }
        //printData();

        /* END OF CODE FOR TASK 1 */

        // DO NOT REMOVE THIS METHOD CALL! IT IS USED FOR TESTING YOUR RESULTS FROM TASK 1.
        storeCleanedData(dataSet);

        /* TASK 2 - DATA TRANSFORMATION
         * PUT YOUR CODE FOR TASK 2 BELOW. */

        // Find min and max values
        Double min0 = dataSet[0][0];
        Double min1 = dataSet[0][1];
        Double min2 = dataSet[0][2];
        Double min3 = dataSet[0][3];
        Double min4 = dataSet[0][4];
        Double max0 = dataSet[0][0];
        Double max1 = dataSet[0][1];
        Double max2 = dataSet[0][2];
        Double max3 = dataSet[0][3];
        Double max4 = dataSet[0][4];

        for (int i = 1; i < degreeColumn.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    if (min0 > dataSet[i][j]) {
                        min0 = dataSet[i][j];
                    }
                    if (max0 < dataSet[i][j]) {
                        max0 = dataSet[i][j];
                    }
                } else if (j == 1) {
                    if (min1 > dataSet[i][j]) {
                        min1 = dataSet[i][j];
                    }
                    if (max1 < dataSet[i][j]) {
                        max1 = dataSet[i][j];
                    }
                } else if (j == 2) {
                    if (min2 > dataSet[i][j]) {
                        min2 = dataSet[i][j];
                    }
                    if (max2 < dataSet[i][j]) {
                        max2 = dataSet[i][j];
                    }
                } else if (j == 3) {
                    if (min3 > dataSet[i][j]) {
                        min3 = dataSet[i][j];
                    }
                    if (max3 < dataSet[i][j]) {
                        max3 = dataSet[i][j];
                    }
                } else {
                    if (min4 > dataSet[i][4]) {
                        min4 = dataSet[i][4];
                    }
                    if (max4 < dataSet[i][4]) {
                        max4 = dataSet[i][4];
                    }
                }
            }
        }

        for (int i = 0; i < degreeColumn.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    Double v0 = (dataSet[i][j] - min0) / (max0 - min0);
                    dataSet[i][j] = v0;
                } else if (j == 1) {
                    Double v1 = (dataSet[i][j] - min1) / (max1 - min1);
                    dataSet[i][j] = v1;
                } else if (j == 2) {
                    Double v2 = (dataSet[i][j] - min2) / (max2 - min2);
                    dataSet[i][j] = v2;
                } else if (j == 3) {
                    Double v3 = (dataSet[i][j] - min3) / (max3 - min3);
                    dataSet[i][j] = v3;
                } else {
                    Double v4 = (dataSet[i][j] - min4) / (max4 - min4);
                    dataSet[i][j] = v4;
                }
            }
        }
        //printData();

        /* END OF CODE FOR TASK 2 */

        // DO NOT REMOVE THIS METHOD CALL! IT IS USED FOR TESTING YOUR RESULTS FROM TASK 2.
        storeTransformedData(dataSet);

        /* TASK 3 - DATA REDUCTION
         * PUT YOUR CODE FOR TASK 3 BELOW. */

        Scanner s = new Scanner(System.in);
        System.out.println("How many bins do you want?");
        int b = s.nextInt();
        double incr = 1 / b;
        int k = 0;
        double nextIncr = ((k + 1) / b);
        double epsilon = 0.0000000001;
        while (k < b) {
            for (int i = 0; i < degreeColumn.length; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i == 0 && 0 < dataSet[i][j] && dataSet[i][j] < incr && Math.abs(dataSet[i][j] - 0) < epsilon
                            && Math.abs(dataSet[i][j] - incr) < epsilon) {
                        dataSet[i][j] = (double) k;
                    } else if ((incr * k) < dataSet[i][j] && dataSet[i][j] <= nextIncr
                            && Math.abs(dataSet[i][j] - nextIncr) < epsilon) {
                        dataSet[i][j] = (double) k;
                    }
                }
            }
            k++;
        }
        //printData();

        /* END OF CODE FOR TASK 3 */

        // DO NOT REMOVE THIS METHOD CALL! IT IS USED FOR TESTING YOUR RESULTS FROM TASK 3.
        storeReducedData(dataSet);

        /* TASK 4 - LABEL ENCODING
         * PUT YOUR CODE FOR TASK 4 BELOW. */

        int[] degreeData = new int[degreeColumn.length];
        for (int i = 0; i < degreeColumn.length; i++) {
            int newDegree = 0;
            String lowerCase = degreeColumn[i].toLowerCase();
            for (int j = 0; j < degreeColumn[i].length(); j++) {
                char currentChar = lowerCase.charAt(j);
                int intChar = (int) currentChar;
                newDegree += intChar;
            }
            degreeData[i] = newDegree;
        }
        //printData();

        /* END OF CODE FOR TASK 4 */

        /* TASK 5 - PUTTING IT ALL TOGETHER
         * PUT YOUR CODE FOR TASK 5 BELOW. */

        preprocessedData = new int[degreeColumn.length][6];

        for (int i = 0; i < degreeColumn.length; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    preprocessedData[i][j] = degreeData[j];
                } else {
                    preprocessedData[i][j] = dataSet[i][j - 1].intValue();
                }
            }
        }
        doMachineLearning(preprocessedData);

        /* END OF CODE FOR TASK 5 */

    }

    /**
     * Method printData
     * Pretty-prints table made up of values from dataSet and degreeColumn.
     *
     * Usage: Simply call printData() in your code whenever you would like the table to be printed.
     *
     * Note: You do not need to edit this method, but if you wish to edit it to print your own values, your grade will
     * not be affected.
     */
    private static void printData() {
        String[] headers = {"Age", "CS180_Grade", "GPA", "Credit_Hours", "Months_Until_Employment"};
        System.out.printf("| %-40s |", "Degree");
        for (String header : headers) {
            System.out.printf(" %-23s |", header);
        }
        System.out.println();
        for (int i = 0; i < 174; i++) {
            System.out.print("_");
        }
        System.out.println();
        for (int i = 0; i < dataSet.length; i++) {
            System.out.printf("| %-40s |", degreeColumn[i]);
            for (int j = 0; j < dataSet[i].length; j++) {
                System.out.printf(" %-23s |", dataSet[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Method loadData
     * Loads the file fileName from disk
     */
    private static void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            ArrayList<Double[]> data = new ArrayList<>(); // ArrayList used for data sets of different length.
            ArrayList<String> stringColumn = new ArrayList<>();

            String line = br.readLine(); // Ignore Headers
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",", -1);
                stringColumn.add(row[0]);
                Double[] restOfRow = new Double[row.length - 1];
                for (int i = 1; i < row.length; i++) {
                    try {
                        restOfRow[i - 1] = Double.parseDouble(row[i]);
                    } catch (NumberFormatException e) { // Missing Value
                        restOfRow[i - 1] = null;
                    }
                }
                data.add(restOfRow);
            }
            dataSet = new Double[data.size()][data.get(0).length];
            for (int i = 0; i < data.size(); i++) {
                dataSet[i] = data.get(i);
            }
            degreeColumn = new String[stringColumn.size()];
            for (int i = 0; i < stringColumn.size(); i++) {
                degreeColumn[i] = stringColumn.get(i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error Loading File. Ensure survey_data.csv " +
                    "is located within the same folder as this file.");
        } catch (IOException e) {
            System.out.println("Error While Parsing Data From CSV:");
            e.printStackTrace();
        }
    }

    /**
     * Method doMachineLearning
     * Does some very complicated machine learning with the data you have preprocessed!
     * WARNING: DO NOT TOUCH THIS CODE!
     * @param preprocessedDataSet A 2D array of preprocessed data.
     */
    private static void doMachineLearning(int[][] preprocessedDataSet) {
        System.out.println("The Machine is Learning...");
        System.out.println();
        String[] headers = {"Degree", "Age", "CS180_Grade", "GPA", "Credit_Hours", "Months_Until_Employment"};
        System.out.print("|");
        for (String header : headers) {
            System.out.printf(" %-23s |", header);
        }
        System.out.println();
        for (int i = 0; i < 157; i++) {
            System.out.print("_");
        }
        System.out.println();
        for (int[] row : preprocessedDataSet) {
            for (int value : row) {
                System.out.printf(" %-23s |", value);
            }
            System.out.println();
        }
        System.out.println("The Machine has Learned!");
        Preprocessing.preprocessedData = preprocessedDataSet;
    }

    /**
     * Method storeCleanedData
     * Stores the provided data set in the 2D array cleanedData.
     * Used for testing.
     * @param cleanedDataSet The data set to store.
     */
    private static void storeCleanedData(Double[][] cleanedDataSet) {
        cleanedData = new Double[cleanedDataSet.length][cleanedDataSet[0].length];
        for (int i = 0; i < cleanedDataSet.length; i++) {
            if (cleanedDataSet[i].length >= 0) System.arraycopy(cleanedDataSet[i], 0, cleanedData[i], 0,
                    cleanedDataSet[i].length);
        }
    }

    /**
     * Method storeReducedData
     * Stores the provided data set in the 2D array reducedData.
     * Used for testing.
     * @param reducedDataSet The data set to store.
     */
    private static void storeReducedData(Double[][] reducedDataSet) {
        reducedData = new Double[reducedDataSet.length][reducedDataSet[0].length];
        for (int i = 0; i < reducedDataSet.length; i++) {
            if (reducedDataSet[i].length >= 0) System.arraycopy(reducedDataSet[i], 0, reducedData[i], 0,
                    reducedDataSet[i].length);
        }
    }

    /**
     * Method storeTransformedData
     * Stores the provided data set in the 2D array transformedData.
     * Used for testing.
     * @param transformedDataSet The data set to store.
     */
    private static void storeTransformedData(Double[][] transformedDataSet) {
        transformedData = new Double[transformedDataSet.length][transformedDataSet[0].length];
        for (int i = 0; i < transformedDataSet.length; i++) {
            if (transformedDataSet[i].length >= 0) System.arraycopy(transformedDataSet[i], 0, transformedData[i], 0,
                    transformedDataSet[i].length);
        }
    }
}