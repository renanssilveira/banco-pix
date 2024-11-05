package com.banco.pix.bancopix.repository;

import com.banco.pix.bancopix.entity.Chave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ChaveRepository extends JpaRepository<Chave, UUID> {

    Optional<Chave> findByIdentificacaoId(String identificacaoId);

    Set<Chave> findByNumeroAgenciaAndNumeroConta(String agencia, String conta);

    Optional<Chave> findByValorChave(String chave);


}
