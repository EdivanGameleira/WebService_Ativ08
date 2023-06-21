package br.edu.ifgoias.academico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.entities.repositories.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRep;
	
	public List<Aluno> findAll(){
		return alunoRep.findAll();
	}
	public Aluno findById(Integer idaluno) {
		return alunoRep.findById(idaluno).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	public Aluno insert(Aluno obj) {
		return alunoRep.save(obj);
	}
	public void delete(Integer idaluno) {
		 alunoRep.deleteById(idaluno);
	}
	public Aluno update(Integer idaluno, Aluno obj){
		return alunoRep.findById(idaluno).map(
				aluno -> {
					aluno.setNome( obj.getNome());
					return alunoRep.save(aluno);
					     }
			).orElseThrow(
					() -> new ResponseStatusException(HttpStatus.NOT_FOUND)
					);
	}
	

}
