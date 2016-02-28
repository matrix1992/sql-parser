package org.rohan.sql.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author matrix1992
 */
public class Parser {

    public int[] parseLimits() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int N, M;
        N = Integer.parseInt(str.split(",")[0]);
        M = Integer.parseInt(str.split(",")[1]);
        scanner.close();
        return new int[] { N, M };
    }

    /**
     * <p>
     * Parses the input and generates the list of maps, there is an issue with
     * the input, the <b>data type</b> not being specified anywhere, though a
     * problem with java but this will not come as an issue in ruby
     * </p>
     * 
     * @return
     */
    public List<Map<String, String>> parseData(int N) {
        Scanner scanner = new Scanner(System.in);
        List<Map<String, String>> table = new ArrayList<>();
        // Assuming here the input is from stdin
        String[] columnList = scanner.nextLine().split(",");
        for (int i = 0; i < N; i++) {
            String[] rowValues = scanner.nextLine().split(",");
            table.add(createMap(columnList, rowValues));
        }
        scanner.close();
        return table;
    }

    public String[] parseQueries(int M) {
        Scanner scanner = new Scanner(System.in);
        String[] queries = new String[M];
        for (int i = 0; i < M; i++) {
            queries[i] = scanner.nextLine();
        }
        scanner.close();
        return queries;
    }

    private Map<String, String> createMap(String[] columnList,
            String[] rowValues) {
        Map<String, String> tableRow = new HashMap<>();
        for (int i = 0; i < rowValues.length; i++) {
            tableRow.put(columnList[i], rowValues[i]);
        }
        return tableRow;
    }

}
