package com.banco.pix.bancopix.service;

import com.banco.pix.bancopix.dtos.ConsultaChaveResponse;
import com.banco.pix.bancopix.entity.Chave;
import com.banco.pix.bancopix.exceptions.BancoFullException;
import com.banco.pix.bancopix.exceptions.BancoNotFoundException;
import com.banco.pix.bancopix.repository.ChaveRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultaPixServiceTest {

    @Mock
    private ChaveRepository chaveRepository;

    @InjectMocks
    private ConsultaPixService consultaPixService;

    @Test
    public void testConsultaByFilterWhenIdentificacaoProvidedThenReturnChave() {
        // Arrange
        String identificacao = "123e4567-e89b-12d3-a456-426614174000";
        Chave chave = new Chave();
        chave.setIdentificacaoId(UUID.fromString(identificacao));
        chave.setTipoChave("CPF");
        chave.setValorChave("12345678900");
        chave.setTipoConta("CORRENTE");
        chave.setNumeroAgencia("0001");
        chave.setNumeroConta("123456");
        chave.setNomeCorrentista("John");
        chave.setSobreNomeCorrentista("Doe");
        chave.setDataInclusao(LocalDateTime.now().toString());

        when(chaveRepository.findByIdentificacaoId(identificacao)).thenReturn(Optional.of(chave));

        // Act
        Set<ConsultaChaveResponse> result = consultaPixService.consultaByFilter(identificacao, null, null, null, null, null, null);

        // Assert
        verify(chaveRepository, times(1)).findByIdentificacaoId(identificacao);
        assertEquals(1, result.size());
        ConsultaChaveResponse response = result.iterator().next();
        assertEquals(identificacao, response.getIdentificacao());
        assertEquals("CPF", response.getTipoChave());
        assertEquals("12345678900", response.getValorChave());
        assertEquals("CORRENTE", response.getTipoConta());
        assertEquals("0001", response.getNumeroAgencia());
        assertEquals("123456", response.getNumeroConta());
        assertEquals("John", response.getNomeCorrentista());
        assertEquals("Doe", response.getSobreNomeCorrentista());
    }

    @Test
    public void testConsultaByFilterWhenNoParametersProvidedThenReturnAllChaves() {
        // Arrange
        Chave chave1 = new Chave();
        chave1.setIdentificacaoId(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));
        chave1.setTipoChave("CPF");
        chave1.setValorChave("12345678900");
        chave1.setTipoConta("CORRENTE");
        chave1.setNumeroAgencia("0001");
        chave1.setNumeroConta("123456");
        chave1.setNomeCorrentista("John");
        chave1.setSobreNomeCorrentista("Doe");
        chave1.setDataInclusao(LocalDateTime.now().toString());

        Chave chave2 = new Chave();
        chave2.setIdentificacaoId(UUID.fromString("223e4567-e89b-12d3-a456-426614174001"));
        chave2.setTipoChave("EMAIL");
        chave2.setValorChave("john.doe@example.com");
        chave2.setTipoConta("POUPANCA");
        chave2.setNumeroAgencia("0002");
        chave2.setNumeroConta("654321");
        chave2.setNomeCorrentista("Jane");
        chave2.setSobreNomeCorrentista("Doe");
        chave2.setDataInclusao(LocalDateTime.now().toString());

        List<Chave> chaves = Arrays.asList(chave1, chave2);

        when(chaveRepository.findAll()).thenReturn(chaves);

        // Act
        Set<ConsultaChaveResponse> result = consultaPixService.consultaByFilter(null, null, null, null, null, null, null);

        // Assert
        verify(chaveRepository, times(1)).findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindByIdentificacaoWhenIdentificacaoNotFoundThenThrowException() {
        // Arrange
        String identificacao = "123e4567-e89b-12d3-a456-426614174000";
        when(chaveRepository.findByIdentificacaoId(identificacao)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(BancoNotFoundException.class, () -> consultaPixService.findByIdentificacao(identificacao));
        verify(chaveRepository, times(1)).findByIdentificacaoId(identificacao);
    }

    @Test
    public void testValidateIdentificacaoFilterWhenIdentificacaoProvidedWithOtherParametersThenThrowException() {
        // Arrange
        String identificacao = "123e4567-e89b-12d3-a456-426614174000";
        String tipoChave = "CPF";
        String agencia = "0001";
        String conta = "123456";
        String nome = "John";
        String dtInclusao = "01/01/2023";
        String dtInativacao = "01/02/2023";

        // Act & Assert
        assertThrows(BancoFullException.class, () -> consultaPixService.validateIdentificacaoFilter(identificacao, tipoChave, agencia, conta, nome, dtInclusao, dtInativacao));
    }
}
