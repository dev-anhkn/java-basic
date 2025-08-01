package org.example.creational_pattern.factory_pattern.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SQLServerDB implements IRelationalDB {

    private static final Logger logger = LoggerFactory.getLogger(SQLServerDB.class);

    @Override
    public void getConnection() {
        logger.info("Connecting to SQLServerDB");
    }
}
