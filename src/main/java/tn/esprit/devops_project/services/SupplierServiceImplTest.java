import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.SupplierRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SupplierServiceImplTest {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @Test
    void testRetrieveAllSuppliers() {
        // Arrange
        List<Supplier> mockSuppliers = new ArrayList<>();
        when(supplierRepository.findAll()).thenReturn(mockSuppliers);

        // Act
        List<Supplier> result = supplierService.retrieveAllSuppliers();

        // Assert
        assertEquals(mockSuppliers, result);
    }

    @Test
    void testAddSupplier() {
        // Arrange
        Supplier supplierToAdd = new Supplier();
        when(supplierRepository.save(supplierToAdd)).thenReturn(supplierToAdd);

        // Act
        Supplier result = supplierService.addSupplier(supplierToAdd);

        // Assert
        assertEquals(supplierToAdd, result);
    }

    @Test
    void testUpdateSupplier() {
        // Arrange
        Supplier supplierToUpdate = new Supplier();
        when(supplierRepository.save(supplierToUpdate)).thenReturn(supplierToUpdate);

        // Act
        Supplier result = supplierService.updateSupplier(supplierToUpdate);

        // Assert
        assertEquals(supplierToUpdate, result);
    }

    @Test
    void testDeleteSupplier() {
        // Arrange
        Long supplierIdToDelete = 1L;

        // Act
        supplierService.deleteSupplier(supplierIdToDelete);

        // Assert
        verify(supplierRepository, times(1)).deleteById(supplierIdToDelete);
    }

    @Test
    void testRetrieveSupplier() {
        // Arrange
        Long supplierId = 1L;
        Supplier mockSupplier = new Supplier();
        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(mockSupplier));

        // Act
        Supplier result = supplierService.retrieveSupplier(supplierId);

        // Assert
        assertEquals(mockSupplier, result);
    }
}
