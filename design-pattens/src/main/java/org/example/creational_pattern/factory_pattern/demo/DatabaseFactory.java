package org.example.creational_pattern.factory_pattern.demo;

public interface DatabaseFactory {

    INoSqlDb createNoSQLDB();

    IRelationalDB createRelationalDB();
}
