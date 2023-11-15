package tn.esprit.devops_project.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.services.Iservices.IProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private IProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    void testAddProduct() {
        // Arrange
        Long idStock = 1L;
        Product productToAdd = new Product();
        when(productService.addProduct(productToAdd, idStock)).thenReturn(productToAdd);

        // Act
        Product result = productController.addProduct(productToAdd, idStock);

        // Assert
        assertEquals(productToAdd, result);
        verify(productService, times(1)).addProduct(productToAdd, idStock);
    }

    @Test
    void testRetrieveProduct() {
        // Arrange
        Long productId = 1L;
        Product mockProduct = new Product();
        when(productService.retrieveProduct(productId)).thenReturn(mockProduct);

        // Act
        Product result = productController.retrieveProduct(productId);

        // Assert
        assertEquals(mockProduct, result);
        verify(productService, times(1)).retrieveProduct(productId);
    }

    @Test
    void testRetrieveAllProduct() {
        // Arrange
        List<Product> mockProducts = new ArrayList<>();
        when(productService.retreiveAllProduct()).thenReturn(mockProducts);

        // Act
        List<Product> result = productController.retreiveAllProduct();

        // Assert
        assertEquals(mockProducts, result);
        verify(productService, times(1)).retreiveAllProduct();
    }

    @Test
    void testRetrieveProductStock() {
        // Arrange
        Long stockId = 1L;
        List<Product> mockProducts = new ArrayList<>();
        when(productService.retreiveProductStock(stockId)).thenReturn(mockProducts);

        // Act
        List<Product> result = productController.retreiveProductStock(stockId);

        // Assert
        assertEquals(mockProducts, result);
        verify(productService, times(1)).retreiveProductStock(stockId);
    }

    @Test
    void testRetrieveProductByCategory() {
        // Arrange
        ProductCategory category = ProductCategory.ELECTRONICS;
        List<Product> mockProducts = new ArrayList<>();
        when(productService.retrieveProductByCategory(category)).thenReturn(mockProducts);

        // Act
        List<Product> result = productController.retrieveProductByCategory(category);

        // Assert
        assertEquals(mockProducts, result);
        verify(productService, times(1)).retrieveProductByCategory(category);
    }

    @Test
    void testDeleteProduct() {
        // Arrange
        Long productIdToDelete = 1L;

        // Act
        productController.deleteProduct(productIdToDelete);

        // Assert
        verify(productService, times(1)).deleteProduct(productIdToDelete);
    }
}
