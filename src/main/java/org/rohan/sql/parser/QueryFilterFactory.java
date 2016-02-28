package org.rohan.sql.parser;

import static java.util.stream.Collectors.toList;

/**
 * <p>
 * Factory method for generating query filters
 * </p>
 * 
 * @author matrix1992
 */
public class QueryFilterFactory {

    public QueryFilter getQueryFilter(char operator) {
        switch (operator) {
        case '>':
            return (rawData, query) -> {
                return rawData
                        .parallelStream()
                        .filter(dataMap -> {
                            String[] queryParams = query.split(" ");
                            return dataMap.get(queryParams[0]).compareTo(
                                    queryParams[1]) == 1;
                        }).collect(toList());
            };
        case '<':
            return (rawData, query) -> {
                return rawData
                        .parallelStream()
                        .filter(dataMap -> {
                            String[] queryParams = query.split(" ");
                            return dataMap.get(queryParams[0]).compareTo(
                                    queryParams[1]) == -1;
                        }).collect(toList());
            };
        case '=':
            return (rawData, query) -> {
                return rawData
                        .parallelStream()
                        .filter(dataMap -> {
                            String[] queryParams = query.split(" ");
                            return dataMap.get(queryParams[0]).compareTo(
                                    queryParams[1]) == 0;
                        }).collect(toList());
            };
        default:
            return null;
        }
    }

}
