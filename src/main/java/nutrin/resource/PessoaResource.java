package nutrin.resource;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import nutrin.entity.Pessoa;
import nutrin.service.pessoa.PessoaService;

import javax.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> getPessoa() {
		return pessoaService.findAll();
	}

	@GetMapping("/{id}")
	public Pessoa getPessoaById(@PathVariable("id") Integer id) {

		return pessoaService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> criarPessoa(@Valid @RequestBody Pessoa pessoa){
		Pessoa pessoaSalva = pessoaService.save(pessoa);
		return ResponseEntity.ok(pessoaSalva);
	}
	
	@DeleteMapping("/{id}")
	public void apagarPessoa(@PathVariable("id") Integer id) {
		pessoaService.delete(id);
	}
	

}
