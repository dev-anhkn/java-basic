package org.example.srp;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvoicePrinter {

    public void print(Invoice invoice) {
        log.info("===== INVOICE =====");
        log.info("Customer: {}", invoice.customerName());
        log.info("Amount: {}", invoice.amount());
        log.info("Tax (10%): {}", invoice.calculateTax());
        log.info("Total: {}", invoice.getTotal());
        log.info("====================");
    }
}
