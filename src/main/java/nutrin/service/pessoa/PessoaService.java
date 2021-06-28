package nutrin.service.pessoa;

import nutrin.entity.Pessoa;

import java.util.List;

public interface PessoaService {
    List<Pessoa> findAll();

    Pessoa save(Pessoa p);

    Pessoa findById(Integer id);

    void delete(Integer id);
}
