package br.com.mecinsta.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Demonstra que classe é armazenavel no banco
@Entity 
@Table (name="departamento") // torna explicido o nome da table
public class Departamento {
	
	@Column(name="id") //explicito o nome da coluna
	@Id			//indicio que este atribuito corresponde a Pk da table
	@GeneratedValue(strategy=GenerationType.IDENTITY) ///auto-incremento
	private Integer codigo;
	
	@Column(name="nome",length = 50,nullable = false)
	private String nome;
	
	@Column(name="descricao",nullable = true,columnDefinition = "TEXT")
	private String descricao;
	
	@OneToMany(mappedBy ="departamento",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("departamento")
	private List<Produto> listaProduto;
	
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	
	
	
	
}
