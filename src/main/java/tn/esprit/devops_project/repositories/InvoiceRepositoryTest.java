import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    void testRetrieveInvoicesBySupplier() {
        // Arrange
        // Save a Supplier and an associated Invoice to the repository
        Supplier supplier = new Supplier();
        Invoice invoice = new Invoice();
        invoice.setSupplier(supplier);
        invoiceRepository.save(invoice);

        // Act
        // Use the custom query method
        List<Invoice> result = invoiceRepository.retrieveInvoicesBySupplier(supplier);

        // Assert
        // Ensure that the result contains the saved Invoice
        assertEquals(1, result.size());
        assertEquals(invoice, result.get(0));
    }

    @Test
    void testGetTotalAmountInvoiceBetweenDates() {
        // Arrange
        // Save an Invoice with a specific amount and date to the repository
        Date startDate = new Date();
        Date endDate = new Date();
        Invoice invoice = new Invoice();
        invoice.setAmountInvoice(100.0f);
        invoice.setDateCreationInvoice(new Date());
        invoiceRepository.save(invoice);

        // Act
        // Use the custom query method
        float result = invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate);

        // Assert
        // Ensure that the result matches the saved amount
        assertEquals(100.0f, result);
    }

    @Test
    void testUpdateInvoice() {
        // Arrange
        // Save an Invoice to the repository
        Invoice invoice = new Invoice();
        invoiceRepository.save(invoice);

        // Act
        // Use the custom modifying query method
        invoiceRepository.updateInvoice(invoice.getIdInvoice());

        // Assert
        // Ensure that the archived flag is updated to true
        Invoice updatedInvoice = invoiceRepository.findById(invoice.getIdInvoice()).orElse(null);
        assertEquals(true, updatedInvoice.isArchived());
    }
}
