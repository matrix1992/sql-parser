package org.rohan.sql.parser;

import java.util.List;
import java.util.Map;

/**
 * @author matrix1992
 */
public class Application {

    private static final Parser parser = new Parser();

    private static final QueryFilterFactory queryFilterFactory = new QueryFilterFactory();

    public static void main(String[] args) {
        int M, N;
        List<Map<String, String>> table;
        String[] queries;
        int[] limits = parser.parseLimits();
        N = limits[0];
        M = limits[1];
        table = parser.parseData(N);
        queries = parser.parseQueries(M);
        for (String query : queries) {
            QueryFilter queryFilter = queryFilterFactory
                    .getQueryFilter(query.split(" ")[1].charAt(0));
            table = queryFilter.applyFilter(table, query);
        }
        System.out.println(table.size());
    }
}
