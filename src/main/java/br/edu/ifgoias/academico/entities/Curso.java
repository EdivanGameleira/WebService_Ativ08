package br.edu.ifgoias.academico.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Curso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcurso;
	
	@Column (name = "nomecurso", nullable= false )
	private String nome;
	
	
	
	@OneToMany (mappedBy = "curso")
	@JsonIgnore
	private List<Aluno> alunos = new ArrayList<>();

	public Curso() {

	}
	
	public Curso(Integer idcurso, String nome) {
		this.idcurso = idcurso;
		this.nome = nome;
	}

	public Integer getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void addAluno (Aluno a) {
			this.alunos.add(a);
			a.setCurso(this);
	}
	
	public void removeAluno (Aluno a) {
		
		if (this.alunos.contains(a)) {
			this.removeAluno(a);
			a.setCurso(null);
		}
	}

	@Override
	public String toString() {
		return "Curso [idcurso=" + idcurso + ", nome=" + nome + "]";
	}
		
}
