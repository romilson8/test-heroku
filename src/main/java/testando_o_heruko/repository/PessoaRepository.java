package testando_o_heruko.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import testando_o_heruko.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
