package com.inteliense.databean.supporting;

public interface ExecutesQueries {

    QueryResults execute(QueryParams p);
    void executeUpdate(QueryParams p);

}
