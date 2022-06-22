package br.unigoias.canil.service;

import br.unigoias.canil.model.Cao;
import br.unigoias.canil.repository.CaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CaoService {

    @Autowired
    private CaoRepository caoRepository;

    public List<Cao> findAll() {
        return caoRepository.findAll();
    }

    public Cao findById(Long id) throws EntityNotFoundException {

        Optional<Cao> cao = caoRepository.findById(id);

        if (cao.isPresent()) {
            return cao.get();
        }

        throw new EntityNotFoundException("A entidade não existe para o id " + id);
    }

    public Cao create(Cao cao) {
        return caoRepository.save(cao);
    }

    public Cao updateById(Long id, Cao cao) throws EntityNotFoundException {

        Optional<Cao> novaCao = caoRepository.findById(id);
        if (novaCao.isPresent()) {
            novaCao.get().setNome(cao.getNome());
            return caoRepository.save(novaCao.get());
        }

        throw new EntityNotFoundException("A entidade não existe para o id " + id);
    }

    public void deleteById(Long id) throws EntityNotFoundException {

        if (!caoRepository.existsById(id)) {
            throw new EntityNotFoundException("A entidade não existe para o id " + id);
        }

        caoRepository.deleteById(id);
    }
}
