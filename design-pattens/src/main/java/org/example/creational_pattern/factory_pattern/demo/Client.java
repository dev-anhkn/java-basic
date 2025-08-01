package org.example.creational_pattern.factory_pattern.demo;

public class Client {

    public static void main(String[] args) {
        DatabaseFactory noSqlFactory = new NoSQLDBFactory();
        INoSqlDb mongo = noSqlFactory.createNoSQLDB();
        mongo.getConnection();

        DatabaseFactory relationalFactory = new RelationalDBFactory();
        IRelationalDB sqlServer = relationalFactory.createRelationalDB();
        sqlServer.getConnection();
    }
}
