package nutrin.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import nutrin.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
