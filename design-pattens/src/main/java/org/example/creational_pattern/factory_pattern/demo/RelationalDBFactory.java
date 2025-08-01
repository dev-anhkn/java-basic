package org.example.creational_pattern.factory_pattern.demo;

public class RelationalDBFactory implements DatabaseFactory {
    @Override
    public INoSqlDb createNoSQLDB() {
        return null;
    }

    @Override
    public IRelationalDB createRelationalDB() {
        return new SQLServerDB();
    }
}
