import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testFindByCategory() {
        // Arrange
        // Save a Product with a specific category to the repository
        ProductCategory category = ProductCategory.ELECTRONICS;
        Product product = new Product();
        product.setCategory(category);
        productRepository.save(product);

        // Act
        // Use the custom query method
        List<Product> result = productRepository.findByCategory(category);

        // Assert
        // Ensure that the result contains the saved Product
        assertEquals(1, result.size());
        assertEquals(product, result.get(0));
    }

    @Test
    void testFindByStockIdStock() {
        // Arrange
        // Save a Product with a specific stock ID to the repository
        Long stockId = 1L;
        Product product = new Product();
        product.getStock().setIdStock(stockId);
        productRepository.save(product);

        // Act
        // Use the custom query method
        List<Product> result = productRepository.findByStockIdStock(stockId);

        // Assert
        // Ensure that the result contains the saved Product
        assertEquals(1, result.size());
        assertEquals(product, result.get(0));
    }
}
