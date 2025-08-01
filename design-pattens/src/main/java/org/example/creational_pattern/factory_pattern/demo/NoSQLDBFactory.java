package org.example.creational_pattern.factory_pattern.demo;

public class NoSQLDBFactory implements DatabaseFactory {

    @Override
    public INoSqlDb createNoSQLDB() {
        return new MongoDB();
    }

    @Override
    public IRelationalDB createRelationalDB() {
        return null;
    }
}
