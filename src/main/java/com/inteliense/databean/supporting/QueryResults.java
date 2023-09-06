package com.inteliense.databean.supporting;

import com.inteliense.aloft.utils.exceptions.types.CriticalException;

import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryResults {

    private ArrayList<Record> records = new ArrayList<Record>();

    public QueryResults(ResultSet rs, ArrayList<Field> select) {
        try {
            while(rs.next()) {
                ArrayList<Field> fields = new ArrayList<Field>();
                for(int i=0; i<select.size(); i++) {
                    String col = select.get(i).column();
                    fields.add(new Field(col, rs.getObject(col)));
                }
                records.add(new Record(fields));
            }
        } catch (Exception e) {
            new CriticalException("Failed to get results from query.", e).report();
        }
    }

}