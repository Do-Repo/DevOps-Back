import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceImplTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private OperatorRepository operatorRepository;

    @Mock
    private InvoiceDetailRepository invoiceDetailRepository;

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @Test
    void testRetrieveAllInvoices() {
        // Arrange
        List<Invoice> mockInvoices = new ArrayList<>();
        when(invoiceRepository.findAll()).thenReturn(mockInvoices);

        // Act
        List<Invoice> result = invoiceService.retrieveAllInvoices();

        // Assert
        assertEquals(mockInvoices, result);
    }

    @Test
    void testCancelInvoice() {
        // Arrange
        Long invoiceId = 1L;
        Invoice mockInvoice = new Invoice();
        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(mockInvoice));

        // Act
        invoiceService.cancelInvoice(invoiceId);

        // Assert
        verify(invoiceRepository, times(1)).save(mockInvoice);
    }

    // Similar tests for other methods in InvoiceServiceImpl...

    @Test
    void testGetTotalAmountInvoiceBetweenDates() {
        // Arrange
        Date startDate = new Date();
        Date endDate = new Date();
        float mockTotalAmount = 100.0f;
        when(invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate)).thenReturn(mockTotalAmount);

        // Act
        float result = invoiceService.getTotalAmountInvoiceBetweenDates(startDate, endDate);

        // Assert
        assertEquals(mockTotalAmount, result);
    }
}
