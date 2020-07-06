package testando_o_heruko;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-h")
public class TestResource {
	
	@Autowired
	private PessoaRepository repository;
	
	@GetMapping
	public String hello() {
		return "Hello Heroku";
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa p){
		Pessoa pessoaSalva = repository.save(p);
		return ResponseEntity.ok(pessoaSalva);
	}

}
