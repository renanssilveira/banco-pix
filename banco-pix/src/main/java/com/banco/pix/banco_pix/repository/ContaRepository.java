package com.banco.pix.banco_pix.repository;

import com.banco.pix.banco_pix.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {


}
