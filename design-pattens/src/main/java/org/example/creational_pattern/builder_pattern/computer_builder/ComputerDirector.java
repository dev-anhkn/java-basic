package org.example.creational_pattern.builder_pattern.computer_builder;

public class ComputerDirector {

    private final ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void constructComputer() {
        builder.buildCpu();
        builder.buildRam();
        builder.buildStorage();
    }

    public Computer getComputer() {
        return builder.getComputer();
    }
}
