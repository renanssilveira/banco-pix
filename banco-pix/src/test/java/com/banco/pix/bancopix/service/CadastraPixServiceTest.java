package com.banco.pix.bancopix.service;

import com.banco.pix.bancopix.domain.TipoChave;
import com.banco.pix.bancopix.domain.TipoConta;
import com.banco.pix.bancopix.dtos.CriaChaveRequest;
import com.banco.pix.bancopix.entity.Chave;
import com.banco.pix.bancopix.entity.Conta;
import com.banco.pix.bancopix.exceptions.BancoFullException;
import com.banco.pix.bancopix.repository.ChaveRepository;
import com.banco.pix.bancopix.repository.ContaRepository;
import com.banco.pix.bancopix.validator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastraPixServiceTest {

    @Mock
    private ChaveRepository chaveRepository;

    @Mock
    private ContaRepository contaRepository;

    @Mock
    private CpfCnpjValidator cpfCnpjValidator;

    @Mock
    private EmailValidator emailValidator;

    @Mock
    private CelularValidator celularValidator;

    @Mock
    private AleatorioValidator aleatorioValidator;

    @Mock
    private AgenciaValidator agenciaValidator;

    @Mock
    private ContaValidator contaValidator;

    @Mock
    private NomeValidator nomeValidator;

    @Mock
    private SobreNomeValidator sobreNomeValidator;

    @InjectMocks
    private CadastraPixService cadastraPixService;

    private CriaChaveRequest criaChaveRequest;

    @BeforeEach
    public void setUp() {
        criaChaveRequest = new CriaChaveRequest();
        criaChaveRequest.setTipoChave("CPF");
        criaChaveRequest.setValorChave("12345678901");
        criaChaveRequest.setTipoConta("CORRENTE");
        criaChaveRequest.setNumeroAgencia("0001");
        criaChaveRequest.setNumeroConta("123456");
        criaChaveRequest.setNomeCorrentista("John");
        criaChaveRequest.setSobreNomeCorrentista("Doe");

        when(cpfCnpjValidator.isCpf(anyString())).thenReturn(true);
        when(emailValidator.isValidEmailAddress(anyString())).thenReturn(true);
        when(celularValidator.isValidCelular(anyString())).thenReturn(true);
        when(aleatorioValidator.isValidAleatorio(anyString())).thenReturn(true);
        when(agenciaValidator.isValidAgencia(anyString())).thenReturn(true);
        when(contaValidator.isValidConta(anyString())).thenReturn(true);
        when(nomeValidator.isValidNome(anyString())).thenReturn(true);
        when(sobreNomeValidator.isValidSobreNome(anyString())).thenReturn(true);
    }

    @Test
    public void testCadastraChavePixWhenValidCPFThenReturnUUID() {
        // Arrange
        when(chaveRepository.save(any(Chave.class))).thenAnswer(invocation -> {
            Chave chave = invocation.getArgument(0);
            chave.setIdentificacaoId(UUID.randomUUID());
            return chave;
        });

        // Act
        UUID result = cadastraPixService.cadastraChavePix(criaChaveRequest);

        // Assert
        assertNotNull(result);
    }

    @Test
    public void testCadastraChavePixWhenInvalidCPFThenThrowBancoFullException() {
        // Arrange
        when(cpfCnpjValidator.isCpf(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.cadastraChavePix(criaChaveRequest));
    }

    @Test
    public void testCadastraChavePixWhenDuplicateKeyThenThrowBancoFullException() {
        // Arrange
        when(chaveRepository.findByValorChave(anyString())).thenReturn(Optional.of(new Chave()));

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.cadastraChavePix(criaChaveRequest));
    }

    @Test
    public void testCadastraChavePixWhenMaxKeysForPersonalAccountThenThrowBancoFullException() {
        // Arrange
        Conta conta = new Conta();
        conta.setPerfil("PF");
        when(contaRepository.findByNumeroAgenciaAndNumeroConta(anyString(), anyString())).thenReturn(conta);
        when(chaveRepository.findByNumeroAgenciaAndNumeroConta(anyString(), anyString())).thenReturn(Set.of(new Chave(), new Chave(), new Chave(), new Chave(), new Chave()));

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.cadastraChavePix(criaChaveRequest));
    }

    @Test
    public void testCadastraChavePixWhenMaxKeysForBusinessAccountThenThrowBancoFullException() {
        // Arrange
        Conta conta = new Conta();
        conta.setPerfil("PJ");
        when(contaRepository.findByNumeroAgenciaAndNumeroConta(anyString(), anyString())).thenReturn(conta);
        when(chaveRepository.findByNumeroAgenciaAndNumeroConta(anyString(), anyString())).thenReturn(Set.of(new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave(), new Chave()));

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.cadastraChavePix(criaChaveRequest));
    }

    @Test
    public void testValidaTipoChaveWhenValidThenReturnTipoChave() {
        // Act
        TipoChave result = cadastraPixService.validaTipoChave("CPF");

        // Assert
        assertEquals(TipoChave.CPF, result);
    }

    @Test
    public void testValidaTipoChaveWhenInvalidThenThrowBancoFullException() {
        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaTipoChave("INVALID"));
    }

    @Test
    public void testValidaTipoContaWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaTipoConta("CORRENTE"));
    }

    @Test
    public void testValidaTipoContaWhenInvalidThenThrowBancoFullException() {
        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaTipoConta("INVALID"));
    }

    @Test
    public void testValidaCPFWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaCPF("12345678901"));
    }

    @Test
    public void testValidaCPFWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(cpfCnpjValidator.isCpf(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaCPF("12345678901"));
    }

    @Test
    public void testValidaCNPJWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaCNPJ("12345678000195"));
    }

    @Test
    public void testValidaCNPJWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(cpfCnpjValidator.isCnpj(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaCNPJ("12345678000195"));
    }

    @Test
    public void testValidaEmailWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaEmail("test@example.com"));
    }

    @Test
    public void testValidaEmailWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(emailValidator.isValidEmailAddress(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaEmail("test@example.com"));
    }

    @Test
    public void testValidaCelularWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaCelular("+5511900000000"));
    }

    @Test
    public void testValidaCelularWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(celularValidator.isValidCelular(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaCelular("+5511900000000"));
    }

    @Test
    public void testValidaAleatorioWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaAleatorio("randomKey"));
    }

    @Test
    public void testValidaAleatorioWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(aleatorioValidator.isValidAleatorio(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaAleatorio("randomKey"));
    }

    @Test
    public void testValidaAgenciaWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaAgencia("0001"));
    }

    @Test
    public void testValidaAgenciaWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(agenciaValidator.isValidAgencia(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaAgencia("0001"));
    }

    @Test
    public void testValidaContaWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaConta("123456"));
    }

    @Test
    public void testValidaContaWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(contaValidator.isValidConta(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaConta("123456"));
    }

    @Test
    public void testValidaNomeWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaNome("John"));
    }

    @Test
    public void testValidaNomeWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(nomeValidator.isValidNome(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaNome("John"));
    }

    @Test
    public void testValidaSobreNomeWhenValidThenNoException() {
        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaSobreNome("Doe"));
    }

    @Test
    public void testValidaSobreNomeWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(sobreNomeValidator.isValidSobreNome(anyString())).thenReturn(false);

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaSobreNome("Doe"));
    }

    @Test
    public void testValidaQtdChavesWhenValidThenNoException() {
        // Arrange
        Conta conta = new Conta();
        conta.setPerfil("PF");
        when(contaRepository.findByNumeroAgenciaAndNumeroConta(anyString(), anyString())).thenReturn(conta);
        when(chaveRepository.findByNumeroAgenciaAndNumeroConta(anyString(), anyString())).thenReturn(Set.of(new Chave(), new Chave(), new Chave(), new Chave()));

        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaQtdChaves(criaChaveRequest));
    }

    @Test
    public void testValidaQtdChavesWhenInvalidThenThrowBancoFullException() {
        // Arrange
        Conta conta = new Conta();
        conta.setPerfil("PF");
        when(contaRepository.findByNumeroAgenciaAndNumeroConta(anyString(), anyString())).thenReturn(conta);
        when(chaveRepository.findByNumeroAgenciaAndNumeroConta(anyString(), anyString())).thenReturn(Set.of(new Chave(), new Chave(), new Chave(), new Chave(), new Chave()));

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaQtdChaves(criaChaveRequest));
    }

    @Test
    public void testValidaChaveDuplicadaWhenValidThenNoException() {
        // Arrange
        when(chaveRepository.findByValorChave(anyString())).thenReturn(Optional.empty());

        // Act & Assert
        assertDoesNotThrow(() -> cadastraPixService.validaChaveDuplicada("12345678901"));
    }

    @Test
    public void testValidaChaveDuplicadaWhenInvalidThenThrowBancoFullException() {
        // Arrange
        when(chaveRepository.findByValorChave(anyString())).thenReturn(Optional.of(new Chave()));

        // Act & Assert
        assertThrows(BancoFullException.class, () -> cadastraPixService.validaChaveDuplicada("12345678901"));
    }
}
