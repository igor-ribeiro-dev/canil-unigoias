package br.unigoias.canil.service;

import br.unigoias.canil.model.Raca;
import br.unigoias.canil.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RacaService {

    @Autowired
    private RacaRepository racaRepository;

    public List<Raca> findAll() {
        return racaRepository.findAll();
    }

    public Raca create(Raca raca) {
        return racaRepository.save(raca);
    }

    public Raca updateById(Long id, Raca raca) throws EntityNotFoundException {

        if(racaRepository.existsById(id)){
            raca.setId(id);
            return racaRepository.save(raca);
        }

        throw new EntityNotFoundException("A entidade não existe para o id " + id);
    }
}
