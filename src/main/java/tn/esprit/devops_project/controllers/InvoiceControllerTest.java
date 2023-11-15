package tn.esprit.devops_project.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.services.Iservices.IInvoiceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InvoiceControllerTest {

    @Mock
    private IInvoiceService invoiceService;

    @InjectMocks
    private InvoiceController invoiceController;

    @Test
    void testGetInvoices() {
        // Arrange
        List<Invoice> mockInvoices = new ArrayList<>();
        when(invoiceService.retrieveAllInvoices()).thenReturn(mockInvoices);

        // Act
        List<Invoice> result = invoiceController.getInvoices();

        // Assert
        assertEquals(mockInvoices, result);
        verify(invoiceService, times(1)).retrieveAllInvoices();
    }

    @Test
    void testRetrieveInvoice() {
        // Arrange
        Long invoiceId = 1L;
        Invoice mockInvoice = new Invoice();
        when(invoiceService.retrieveInvoice(invoiceId)).thenReturn(mockInvoice);

        // Act
        Invoice result = invoiceController.retrieveInvoice(invoiceId);

        // Assert
        assertEquals(mockInvoice, result);
        verify(invoiceService, times(1)).retrieveInvoice(invoiceId);
    }

    @Test
    void testCancelInvoice() {
        // Arrange
        Long invoiceId = 1L;

        // Act
        invoiceController.cancelInvoice(invoiceId);

        // Assert
        verify(invoiceService, times(1)).cancelInvoice(invoiceId);
    }

    @Test
    void testGetInvoicesBySupplier() {
        // Arrange
        Long supplierId = 1L;
        List<Invoice> mockInvoices = new ArrayList<>();
        when(invoiceService.getInvoicesBySupplier(supplierId)).thenReturn(mockInvoices);

        // Act
        List<Invoice> result = invoiceController.getInvoicesBySupplier(supplierId);

        // Assert
        assertEquals(mockInvoices, result);
        verify(invoiceService, times(1)).getInvoicesBySupplier(supplierId);
    }

    @Test
    void testAssignOperatorToInvoice() {
        // Arrange
        Long idOperator = 1L;
        Long idInvoice = 2L;

        // Act
        invoiceController.assignOperatorToInvoice(idOperator, idInvoice);

        // Assert
        verify(invoiceService, times(1)).assignOperatorToInvoice(idOperator, idInvoice);
    }

    @Test
    void testGetTotalAmountInvoiceBetweenDates() {
        // Arrange
        Date startDate = new Date();
        Date endDate = new Date();
        float mockTotalAmount = 100.0f;
        when(invoiceService.getTotalAmountInvoiceBetweenDates(startDate, endDate)).thenReturn(mockTotalAmount);

        // Act
        float result = invoiceController.getTotalAmountInvoiceBetweenDates(startDate, endDate);

        // Assert
        assertEquals(mockTotalAmount, result);
        verify(invoiceService, times(1)).getTotalAmountInvoiceBetweenDates(startDate, endDate);
    }
}
