package org.example.creational_pattern.builder_pattern.computer_builder;

public interface ComputerBuilder {

    void buildCpu();

    void buildRam();

    void buildStorage();

    Computer getComputer();
}
