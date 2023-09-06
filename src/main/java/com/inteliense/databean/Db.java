package com.inteliense.databean;

import com.inteliense.aloft.server.db.internal.supporting.DbDriver;
import com.inteliense.aloft.server.db.internal.supporting.DbType;
import com.inteliense.aloft.server.db.internal.supporting.Query;
import com.inteliense.aloft.utils.exceptions.types.CriticalException;

public class Db {

    private DbDriver driver;
    private String database;

    public Db(DbType type) {
        this.driver = new DbDriver(type);
    }

    public Db(String database, DbType type) {
        this.driver = new DbDriver(type);
        this.database = dbName(database);
    }

    public void setDatabase(String database) throws CriticalException, Exception {
        this.database = dbName(database);
        this.driver.conn().changeDb(database);
    }

    public Query query() {
        return this.driver.buildQuery(dbName(database));
    }

    public Query query(String database) {
        return this.driver.buildQuery(dbName(database));
    }

    private String dbName(String db) {
        return db;
    }

}
