package br.edu.ifgoias.academico.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.services.AlunoService;

@RestController
@RequestMapping (value = "/idaluno")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity< List<Aluno> > findAll(){
		
		List<Aluno> alunos = service.findAll();
		return ResponseEntity.ok().body(alunos);
	}
	
	@GetMapping  ( value = "/{idaluno}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer idaluno){
		
		Aluno aluno = service.findById(idaluno);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity<Aluno> insert(@RequestBody Aluno a){
		a = service.insert(a);
		return ResponseEntity.ok().body(a);
	}
	
	@DeleteMapping ( value = "/{idaluno}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer idaluno) {
		service.delete(idaluno);
	}
	
	
	@PutMapping( value = "/{idaluno}")
	@ResponseStatus (HttpStatus.OK)
	public ResponseEntity<Aluno> update(@PathVariable Integer idaluno, @RequestBody Aluno a){
		a = service.update(idaluno, a);
		return ResponseEntity.ok().body(a);
	}
}