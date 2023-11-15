import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockServiceImplTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @Test
    void testAddStock() {
        // Arrange
        Stock stockToAdd = new Stock();
        when(stockRepository.save(stockToAdd)).thenReturn(stockToAdd);

        // Act
        Stock result = stockService.addStock(stockToAdd);

        // Assert
        assertEquals(stockToAdd, result);
    }

    @Test
    void testRetrieveStock() {
        // Arrange
        Long stockId = 1L;
        Stock mockStock = new Stock();
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(mockStock));

        // Act
        Stock result = stockService.retrieveStock(stockId);

        // Assert
        assertEquals(mockStock, result);
    }

    @Test
    void testRetrieveAllStock() {
        // Arrange
        List<Stock> mockStocks = new ArrayList<>();
        when(stockRepository.findAll()).thenReturn(mockStocks);

        // Act
        List<Stock> result = stockService.retrieveAllStock();

        // Assert
        assertEquals(mockStocks, result);
    }
}
