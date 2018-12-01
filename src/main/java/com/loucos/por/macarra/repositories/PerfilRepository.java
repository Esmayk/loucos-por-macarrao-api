package com.loucos.por.macarra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loucos.por.macarra.domain.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
