package com.banco.pix.bancopix.service;

import com.banco.pix.bancopix.dtos.EditaRequest;
import com.banco.pix.bancopix.dtos.EditaResponse;
import com.banco.pix.bancopix.entity.Chave;
import com.banco.pix.bancopix.exceptions.BancoFullException;
import com.banco.pix.bancopix.exceptions.BancoNotFoundException;
import com.banco.pix.bancopix.repository.ChaveRepository;
import com.banco.pix.bancopix.validator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EditaPixServiceTest {

    @Mock
    private ChaveRepository chaveRepository;

    @Mock
    private AgenciaValidator agenciaValidator;

    @Mock
    private ContaValidator contaValidator;

    @Mock
    private NomeValidator nomeValidator;

    @Mock
    private SobreNomeValidator sobreNomeValidator;

    @InjectMocks
    private EditaPixService editaPixService;

    private EditaRequest editaRequest;

    @BeforeEach
    public void setUp() {
        editaRequest = new EditaRequest();
        editaRequest.setId(UUID.randomUUID().toString());
        editaRequest.setTipoConta("CORRENTE");
        editaRequest.setNumeroAgencia("0001");
        editaRequest.setNumeroConta("123456");
        editaRequest.setNomeCorrentista("John");
        editaRequest.setSobreNomeCorrentista("Doe");

        when(agenciaValidator.isValidAgencia(anyString())).thenReturn(true);
        when(contaValidator.isValidConta(anyString())).thenReturn(true);
        when(nomeValidator.isValidNome(anyString())).thenReturn(true);
        when(sobreNomeValidator.isValidSobreNome(anyString())).thenReturn(true);
    }

    @Test
    public void testEditaContaWhenChaveNotFoundThenThrowBancoNotFoundException() {
        // Arrange
        when(chaveRepository.findByIdentificacaoId(anyString())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(BancoNotFoundException.class, () -> editaPixService.editaConta(editaRequest));
        verify(chaveRepository, times(1)).findByIdentificacaoId(anyString());
    }

    @Test
    public void testEditaContaWhenChaveInativaThenThrowBancoFullException() {
        // Arrange
        Chave chave = new Chave();
        chave.setDataInativacao("2023-10-10T10:00:00");
        when(chaveRepository.findByIdentificacaoId(anyString())).thenReturn(Optional.of(chave));

        // Act & Assert
        assertThrows(BancoFullException.class, () -> editaPixService.editaConta(editaRequest));
        verify(chaveRepository, times(1)).findByIdentificacaoId(anyString());
    }

    @Test
    public void testEditaContaWhenValidRequestThenReturnEditaResponse() {
        // Arrange
        Chave chave = new Chave();
        chave.setIdentificacaoId(UUID.fromString(editaRequest.getId()));
        chave.setTipoChave("CPF");
        chave.setValorChave("12345678900");
        chave.setTipoConta("CORRENTE");
        chave.setNumeroAgencia("0001");
        chave.setNumeroConta("123456");
        chave.setNomeCorrentista("John");
        chave.setSobreNomeCorrentista("Doe");
        chave.setDataInclusao("2023-10-10T10:00:00");
        when(chaveRepository.findByIdentificacaoId(anyString())).thenReturn(Optional.of(chave));

        // Act
        EditaResponse response = editaPixService.editaConta(editaRequest);

        // Assert
        assertNotNull(response);
        assertEquals(editaRequest.getId(), response.getIdentificacao());
        assertEquals("CPF", response.getTipoChave());
        assertEquals("CORRENTE", response.getTipoConta());
        assertEquals("0001", response.getNumeroAgencia());
        assertEquals("123456", response.getNumeroConta());
        assertEquals("John", response.getNomeCorrentista());
        assertEquals("Doe", response.getSobreNomeCorrentista());
        assertEquals("2023-10-10T10:00:00", response.getDataInclusao());

        verify(chaveRepository, times(1)).findByIdentificacaoId(anyString());
        verify(chaveRepository, times(1)).save(chave);
    }

    @Test
    public void testValidaTipoContaWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> editaPixService.validaTipoConta("CORRENTE"));
    }

    @Test
    public void testValidaTipoContaWhenInvalidThenThrowBancoFullException() {
        // Act & Assert
        assertThrows(BancoFullException.class, () -> editaPixService.validaTipoConta("INVALID"));
    }

    @Test
    public void testValidaAgenciaWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> editaPixService.validaAgencia("0001"));
    }

    @Test
    public void testValidaAgenciaWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(agenciaValidator.isValidAgencia(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> editaPixService.validaAgencia("0001"));
    }

    @Test
    public void testValidaContaWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> editaPixService.validaConta("123456"));
    }

    @Test
    public void testValidaContaWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(contaValidator.isValidConta(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> editaPixService.validaConta("123456"));
    }

    @Test
    public void testValidaNomeWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> editaPixService.validaNome("John"));
    }

    @Test
    public void testValidaNomeWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(nomeValidator.isValidNome(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> editaPixService.validaNome("John"));
    }

    @Test
    public void testValidaSobreNomeWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> editaPixService.validaSobreNome("Doe"));
    }

    @Test
    public void testValidaSobreNomeWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(sobreNomeValidator.isValidSobreNome(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> editaPixService.validaSobreNome("Doe"));
    }
}