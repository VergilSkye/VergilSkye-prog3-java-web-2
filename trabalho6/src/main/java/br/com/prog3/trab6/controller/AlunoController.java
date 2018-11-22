package br.com.prog3.trab6.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import br.com.prog3.trab6.model.Aluno;
import br.com.prog3.trab6.persistence.AlunoDaoImp;

@ManagedBean
@RequestScoped
public class AlunoController {

	private Integer matricula;
	private String nome;
	private String ra;
	private Aluno aluno;
	private List<Aluno> listAluno = new ArrayList<Aluno>();

	private String mensagem;

	public void loadAlunoDetail() throws SQLException {
		Integer emp = matricula;

		AlunoDaoImp ad = new AlunoDaoImp();
		Aluno al = ad.findByMatricula(emp);
		if (al != null) {
			this.nome = al.getNome();
			this.ra = al.getRa();
		}

	}

	public void addAluno() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setRa(ra);
		AlunoDaoImp ad = new AlunoDaoImp();		
		String res = ad.save(aluno);		
		setMensagem(res);
		saveMessage();
		
		
	}	

	public void editAluno() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setRa(ra);
		AlunoDaoImp ad = new AlunoDaoImp();
		setMensagem(ad.update(aluno));
		saveMessage();
	}

	public void deleteAluno() {
		AlunoDaoImp ad = new AlunoDaoImp();
		setMensagem(ad.delete(matricula));
		saveMessage();
	}

	public List<Aluno> getAlunos() {
		AlunoDaoImp ad = new AlunoDaoImp();
		return ad.list();
	}

	public Aluno findAluno() {
		AlunoDaoImp ad = new AlunoDaoImp();		
		return ad.findByMatricula(matricula);
	}
	public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(mensagem) );      
    }

	@PostConstruct
	public void init() {
		AlunoDaoImp ad = new AlunoDaoImp();
		listAluno = ad.list();
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<Aluno> getListAluno() {
		return listAluno;
	}

	public void setListAluno(List<Aluno> listAluno) {
		this.listAluno = listAluno;
	}

}
