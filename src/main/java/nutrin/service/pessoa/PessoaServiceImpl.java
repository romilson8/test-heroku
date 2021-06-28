package nutrin.service.pessoa;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nutrin.entity.Pessoa;
import nutrin.repository.PessoaRepository;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @Override
    public Pessoa findById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Objeto não encontrado", Pessoa.class.getName()));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(findById(id));
    }
}
