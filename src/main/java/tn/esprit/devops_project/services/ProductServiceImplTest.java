import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void testAddProduct() {
        // Arrange
        Long stockId = 1L;
        Product productToAdd = new Product();
        Stock mockStock = new Stock();
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(mockStock));
        when(productRepository.save(productToAdd)).thenReturn(productToAdd);

        // Act
        Product result = productService.addProduct(productToAdd, stockId);

        // Assert
        assertEquals(productToAdd, result);
        assertEquals(mockStock, result.getStock());
    }

    @Test
    void testRetrieveProduct() {
        // Arrange
        Long productId = 1L;
        Product mockProduct = new Product();
        when(productRepository.findById(productId)).thenReturn(Optional.of(mockProduct));

        // Act
        Product result = productService.retrieveProduct(productId);

        // Assert
        assertEquals(mockProduct, result);
    }

    // Similar tests for other methods in ProductServiceImpl...

    @Test
    void testRetrieveProductByCategory() {
        // Arrange
        ProductCategory category = ProductCategory.ELECTRONICS;
        List<Product> mockProducts = new ArrayList<>();
        when(productRepository.findByCategory(category)).thenReturn(mockProducts);

        // Act
        List<Product> result = productService.retrieveProductByCategory(category);

        // Assert
        assertEquals(mockProducts, result);
    }

    @Test
    void testDeleteProduct() {
        // Arrange
        Long productIdToDelete = 1L;

        // Act
        productService.deleteProduct(productIdToDelete);

        // Assert
        verify(productRepository, times(1)).deleteById(productIdToDelete);
    }

    @Test
    void testRetrieveProductStock() {
        // Arrange
        Long stockId = 1L;
        List<Product> mockProducts = new ArrayList<>();
        when(productRepository.findByStockIdStock(stockId)).thenReturn(mockProducts);

        // Act
        List<Product> result = productService.retreiveProductStock(stockId);

        // Assert
        assertEquals(mockProducts, result);
    }
}
