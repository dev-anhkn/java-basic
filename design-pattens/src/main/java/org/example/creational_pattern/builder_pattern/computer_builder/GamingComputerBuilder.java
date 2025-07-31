package org.example.creational_pattern.builder_pattern.computer_builder;

public class GamingComputerBuilder implements ComputerBuilder {

    private final Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCpu() {
        computer.setCpu("Intel Core i9");
    }

    @Override
    public void buildRam() {
        computer.setRam("32GB DDR5");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("1TB NVMe SSD");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
