package br.unigoias.canil.repository;

import br.unigoias.canil.model.Cao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaoRepository extends JpaRepository<Cao, Long> {}
