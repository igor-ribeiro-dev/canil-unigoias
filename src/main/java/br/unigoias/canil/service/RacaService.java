package br.unigoias.canil.service;

import br.unigoias.canil.model.Cao;
import br.unigoias.canil.model.Raca;
import br.unigoias.canil.repository.CaoRepository;
import br.unigoias.canil.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RacaService {

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private CaoRepository caoRepository;

    public List<Raca> findAll() {
        return racaRepository.findAll();
    }

    public Raca findById(Long id) throws EntityNotFoundException {

        Optional<Raca> raca = racaRepository.findById(id);

        if (raca.isPresent()) {
            return raca.get();
        }

        throw new EntityNotFoundException("A entidade não existe para o id " + id);
    }

    public Raca create(Raca raca) {
        return racaRepository.save(raca);
    }

    public Raca updateById(Long id, Raca raca) throws EntityNotFoundException {

        Optional<Raca> novaRaca = racaRepository.findById(id);
        if (novaRaca.isPresent()) {
            novaRaca.get().setDescricao(raca.getDescricao());
            return racaRepository.save(novaRaca.get());
        }

        throw new EntityNotFoundException("A entidade não existe para o id " + id);
    }

    public void deleteById(Long id) throws EntityNotFoundException {

        if (!racaRepository.existsById(id)) {
            throw new EntityNotFoundException("A entidade não existe para o id " + id);
        }

        racaRepository.deleteById(id);
    }

    public Cao createCaoByRacaId(Long id, Cao cao) throws EntityNotFoundException {

        Optional<Raca> raca = racaRepository.findById(id);

        if (raca.isPresent()) {
            cao.setRaca(raca.get());
            return caoRepository.save(cao);
        }

        throw new EntityNotFoundException("A entidade não existe para o id " + id);
    }
}
