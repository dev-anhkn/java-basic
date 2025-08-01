package org.example.creational_pattern.factory_pattern.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleDB implements IRelationalDB {
    
    private static final Logger logger = LoggerFactory.getLogger(OracleDB.class);

    @Override
    public void getConnection() {
        logger.info("Connecting to OracleDB");
    }
}
