package com.banco.pix.bancopix.service;

import com.banco.pix.bancopix.dtos.DeletaChaveResponse;
import com.banco.pix.bancopix.entity.Chave;
import com.banco.pix.bancopix.exceptions.BancoFullException;
import com.banco.pix.bancopix.exceptions.BancoNotFoundException;
import com.banco.pix.bancopix.repository.ChaveRepository;
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
public class DeletaPixServiceTest {

    @Mock
    private ChaveRepository chaveRepository;

    @InjectMocks
    private DeletaPixService deletaPixService;

    @Test
    public void testDeletaChaveWhenRepositoryReturnsEmptyOptionalThenThrowBancoNotFoundException() {
        // Arrange
        String identificacao = UUID.randomUUID().toString();
        when(chaveRepository.findByIdentificacaoId(identificacao)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(BancoNotFoundException.class, () -> deletaPixService.deletaChave(identificacao));
        verify(chaveRepository, times(1)).findByIdentificacaoId(identificacao);
    }

    @Test
    public void testDeletaChaveWhenRepositoryReturnsChaveWithNonNullDataInativacaoThenThrowBancoFullException() {
        // Arrange
        String identificacao = UUID.randomUUID().toString();
        Chave chave = new Chave();
        chave.setIdentificacaoId(UUID.fromString(identificacao));
        chave.setDataInativacao("2023-10-10T10:00:00");
        when(chaveRepository.findByIdentificacaoId(identificacao)).thenReturn(Optional.of(chave));

        // Act & Assert
        assertThrows(BancoFullException.class, () -> deletaPixService.deletaChave(identificacao));
        verify(chaveRepository, times(1)).findByIdentificacaoId(identificacao);
    }

    @Test
    public void testDeletaChaveWhenRepositoryReturnsValidChaveThenInactivateChaveAndReturnDeletaChaveResponse() {
        // Arrange
        String identificacao = UUID.randomUUID().toString();
        Chave chave = new Chave();
        chave.setIdentificacaoId(UUID.fromString(identificacao));
        chave.setTipoChave("CPF");
        chave.setValorChave("12345678900");
        chave.setTipoConta("CORRENTE");
        chave.setNumeroAgencia("0001");
        chave.setNumeroConta("123456");
        chave.setNomeCorrentista("John");
        chave.setSobreNomeCorrentista("Doe");
        chave.setDataInclusao("2023-10-10T10:00:00");
        when(chaveRepository.findByIdentificacaoId(identificacao)).thenReturn(Optional.of(chave));

        // Act
        DeletaChaveResponse response = deletaPixService.deletaChave(identificacao);

        // Assert
        assertNotNull(response);
        assertEquals(identificacao, response.getIdentificacao());
        assertEquals("CPF", response.getTipoChave());
        assertEquals("12345678900", response.getValorChave());
        assertEquals("CORRENTE", response.getTipoConta());
        assertEquals("0001", response.getNumeroAgencia());
        assertEquals("123456", response.getNumeroConta());
        assertEquals("John", response.getNomeCorrentista());
        assertEquals("Doe", response.getSobreNomeCorrentista());
        assertEquals("2023-10-10T10:00:00", response.getDataInclusao());
        assertNotNull(response.getDataInativacao());

        verify(chaveRepository, times(1)).findByIdentificacaoId(identificacao);
        verify(chaveRepository, times(1)).save(chave);
    }
}
