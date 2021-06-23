package testando_o_heruko.service.pessoa;

import javassist.NotFoundException;
import testando_o_heruko.entity.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    List<Pessoa> findAll();

    Pessoa save(Pessoa p);

    Pessoa findById(Integer id);

    void delete(Integer id);
}
