package tn.esprit.devops_project.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.services.Iservices.IStockService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StockControllerTest {

    @Mock
    private IStockService stockService;

    @InjectMocks
    private StockController stockController;

    @Test
    void testAddStock() {
        // Arrange
        Stock stockToAdd = new Stock();
        when(stockService.addStock(stockToAdd)).thenReturn(stockToAdd);

        // Act
        Stock result = stockController.addStock(stockToAdd);

        // Assert
        assertEquals(stockToAdd, result);
        verify(stockService, times(1)).addStock(stockToAdd);
    }

    @Test
    void testRetrieveStock() {
        // Arrange
        Long stockId = 1L;
        Stock mockStock = new Stock();
        when(stockService.retrieveStock(stockId)).thenReturn(mockStock);

        // Act
        Stock result = stockController.retrieveStock(stockId);

        // Assert
        assertEquals(mockStock, result);
        verify(stockService, times(1)).retrieveStock(stockId);
    }

    @Test
    void testRetrieveAllStock() {
        // Arrange
        List<Stock> mockStocks = new ArrayList<>();
        when(stockService.retrieveAllStock()).thenReturn(mockStocks);

        // Act
        List<Stock> result = stockController.retrieveAllStock();

        // Assert
        assertEquals(mockStocks, result);
        verify(stockService, times(1)).retrieveAllStock();
    }
}
