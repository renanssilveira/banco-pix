package com.banco.pix.bancopix.repository;

import com.banco.pix.bancopix.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {

    Set<Conta> findBynumeroAgenciaAndnumeroConta(String numeroAgencia, String NumeroConta);
}
