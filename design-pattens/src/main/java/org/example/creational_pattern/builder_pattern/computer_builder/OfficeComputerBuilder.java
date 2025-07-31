package org.example.creational_pattern.builder_pattern.computer_builder;

public class OfficeComputerBuilder implements ComputerBuilder {

    private final Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCpu() {
        computer.setCpu("Intel Core i5");
    }

    @Override
    public void buildRam() {
        computer.setRam("16GB DDR4");
    }

    @Override
    public void buildStorage() {
        computer.setStorage("512GB SSD");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
