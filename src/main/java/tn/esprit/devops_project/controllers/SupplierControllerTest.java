package tn.esprit.devops_project.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.services.Iservices.ISupplierService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SupplierControllerTest {

    @Mock
    private ISupplierService supplierService;

    @InjectMocks
    private SupplierController supplierController;

    @Test
    void testGetSuppliers() {
        // Arrange
        List<Supplier> mockSuppliers = new ArrayList<>();
        when(supplierService.retrieveAllSuppliers()).thenReturn(mockSuppliers);

        // Act
        List<Supplier> result = supplierController.getSuppliers();

        // Assert
        assertEquals(mockSuppliers, result);
        verify(supplierService, times(1)).retrieveAllSuppliers();
    }

    @Test
    void testRetrieveSupplier() {
        // Arrange
        Long supplierId = 1L;
        Supplier mockSupplier = new Supplier();
        when(supplierService.retrieveSupplier(supplierId)).thenReturn(mockSupplier);

        // Act
        Supplier result = supplierController.retrieveSupplier(supplierId);

        // Assert
        assertEquals(mockSupplier, result);
        verify(supplierService, times(1)).retrieveSupplier(supplierId);
    }

    @Test
    void testAddSupplier() {
        // Arrange
        Supplier supplierToAdd = new Supplier();
        when(supplierService.addSupplier(supplierToAdd)).thenReturn(supplierToAdd);

        // Act
        Supplier result = supplierController.addSupplier(supplierToAdd);

        // Assert
        assertEquals(supplierToAdd, result);
        verify(supplierService, times(1)).addSupplier(supplierToAdd);
    }

    @Test
    void testRemoveFournisseur() {
        // Arrange
        Long supplierIdToRemove = 1L;

        // Act
        supplierController.removeFournisseur(supplierIdToRemove);

        // Assert
        verify(supplierService, times(1)).deleteSupplier(supplierIdToRemove);
    }

    @Test
    void testModifyFournisseur() {
        // Arrange
        Supplier supplierToModify = new Supplier();
        when(supplierService.updateSupplier(supplierToModify)).thenReturn(supplierToModify);

        // Act
        Supplier result = supplierController.modifyFournisseur(supplierToModify);

        // Assert
        assertEquals(supplierToModify, result);
        verify(supplierService, times(1)).updateSupplier(supplierToModify);
    }
}
