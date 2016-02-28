package org.rohan.sql.parser;

import java.util.List;
import java.util.Map;

/**
 * @author matrix1992
 */
@FunctionalInterface
public interface QueryFilter {

    /**
     * Filters the passed raw data
     * 
     * @param rawData
     * @return
     */
    public List<Map<String, String>> applyFilter(
            List<Map<String, String>> rawData, String query);

}
