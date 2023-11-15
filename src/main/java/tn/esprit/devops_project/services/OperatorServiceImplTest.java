import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OperatorServiceImplTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @Test
    void testRetrieveAllOperators() {
        // Arrange
        List<Operator> mockOperators = new ArrayList<>();
        when(operatorRepository.findAll()).thenReturn(mockOperators);

        // Act
        List<Operator> result = operatorService.retrieveAllOperators();

        // Assert
        assertEquals(mockOperators, result);
    }

    @Test
    void testAddOperator() {
        // Arrange
        Operator operatorToAdd = new Operator();
        when(operatorRepository.save(operatorToAdd)).thenReturn(operatorToAdd);

        // Act
        Operator result = operatorService.addOperator(operatorToAdd);

        // Assert
        assertEquals(operatorToAdd, result);
    }

    @Test
    void testDeleteOperator() {
        // Arrange
        Long operatorIdToDelete = 1L;

        // Act
        operatorService.deleteOperator(operatorIdToDelete);

        // Assert
        verify(operatorRepository, times(1)).deleteById(operatorIdToDelete);
    }

    // Similar tests for other methods in OperatorServiceImpl...

    @Test
    void testRetrieveOperator() {
        // Arrange
        Long operatorId = 1L;
        Operator mockOperator = new Operator();
        when(operatorRepository.findById(operatorId)).thenReturn(Optional.of(mockOperator));

        // Act
        Operator result = operatorService.retrieveOperator(operatorId);

        // Assert
        assertEquals(mockOperator, result);
    }
}
