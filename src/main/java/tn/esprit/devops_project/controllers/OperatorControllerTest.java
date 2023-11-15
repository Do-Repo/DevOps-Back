package tn.esprit.devops_project.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.services.Iservices.IOperatorService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OperatorControllerTest {

    @Mock
    private IOperatorService operatorService;

    @InjectMocks
    private OperatorController operatorController;

    @Test
    void testGetOperators() {
        // Arrange
        List<Operator> mockOperators = new ArrayList<>();
        when(operatorService.retrieveAllOperators()).thenReturn(mockOperators);

        // Act
        List<Operator> result = operatorController.getOperators();

        // Assert
        assertEquals(mockOperators, result);
        verify(operatorService, times(1)).retrieveAllOperators();
    }

    @Test
    void testRetrieveOperator() {
        // Arrange
        Long operatorId = 1L;
        Operator mockOperator = new Operator();
        when(operatorService.retrieveOperator(operatorId)).thenReturn(mockOperator);

        // Act
        Operator result = operatorController.retrieveoperator(operatorId);

        // Assert
        assertEquals(mockOperator, result);
        verify(operatorService, times(1)).retrieveOperator(operatorId);
    }

    @Test
    void testAddOperator() {
        // Arrange
        Operator operatorToAdd = new Operator();
        when(operatorService.addOperator(operatorToAdd)).thenReturn(operatorToAdd);

        // Act
        Operator result = operatorController.addOperator(operatorToAdd);

        // Assert
        assertEquals(operatorToAdd, result);
        verify(operatorService, times(1)).addOperator(operatorToAdd);
    }

    @Test
    void testRemoveOperator() {
        // Arrange
        Long operatorIdToRemove = 1L;

        // Act
        operatorController.removeOperator(operatorIdToRemove);

        // Assert
        verify(operatorService, times(1)).deleteOperator(operatorIdToRemove);
    }

    @Test
    void testModifyOperator() {
        // Arrange
        Operator operatorToModify = new Operator();
        when(operatorService.updateOperator(operatorToModify)).thenReturn(operatorToModify);

        // Act
        Operator result = operatorController.modifyOperateur(operatorToModify);

        // Assert
        assertEquals(operatorToModify, result);
        verify(operatorService, times(1)).updateOperator(operatorToModify);
    }
}
