package org.example.creational_pattern.factory_pattern.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CouchDB implements INoSqlDb {

    private static final Logger logger = LoggerFactory.getLogger(MongoDB.class);

    @Override
    public void getConnection() {
        logger.info("Connecting to MongoDB");
    }
}
