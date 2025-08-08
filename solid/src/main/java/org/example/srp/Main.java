package org.example.srp;

public class Main {

    public static void main(String[] args) {
        Invoice invoice = new Invoice("Alice", 100.0);

        InvoicePrinter printer = new InvoicePrinter();
        printer.print(invoice);

        InvoiceRepository repository = new InvoiceRepository();
        repository.save(invoice);
    }
}
