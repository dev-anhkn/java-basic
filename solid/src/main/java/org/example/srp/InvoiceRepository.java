package org.example.srp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvoiceRepository {


    public void save(Invoice invoice) {
        // Giả lập thao tác lưu DB
        log.info("Tết Saving invoice for customer: {}", invoice.customerName());
        // Ví dụ: insert into DB (ở đây chỉ log)
    }
}
