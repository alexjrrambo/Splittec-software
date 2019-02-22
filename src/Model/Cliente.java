package Model;

import Framework.Annotations.Find;
import Framework.Annotations.Id;
import Framework.Annotations.Title;

/**
 *  @author Alex Rambo
 *  @since 10/02/2011
 *  
 *  TODO Essa classe deve ser um espelho do banco de dados (tabela pessoa)
 */
public class Cliente {


	@Id
	@Title(name="Código")
	@Find(find=true,size=0.5)
	private Integer id;

	@Find(find=true,size=1.5)
	@Title(name="Nome do Cliente")
	private String nomedocliente;

	private String rua;

	private String bairro;

	@Find()
	@Title(name="Cidade")
	private String cidade;

	private String nomepai;

	private String nomemae;

	private String pais;

	private String sim;

	private String nao;

	@Find(find=true)
	@Title(name="RG")
	private String rg;

	@Find(find=true)
	@Title(name="CPF")
	private String cpf;

	@Find(find=true,comboboxFind={"Cliente","Fornecedor"})
	@Title(name="Categoria")
	private String estadocivil;

	private String data;
	
	private String obs;
	


	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getNomedocliente() {
		return nomedocliente;
	}

	public void setNomedocliente(String nomedocliente) {
		this.nomedocliente = nomedocliente;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNomepai() {
		return nomepai;
	}

	public void setNomepai(String nomepai) {
		this.nomepai = nomepai;
	}

	public String getNomemae() {
		return nomemae;
	}

	public void setNomemae(String nomemae) {
		this.nomemae = nomemae;
	}

	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getNao() {
		return nao;
	}

	public void setNao(String nao) {
		this.nao = nao;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomedoCliente() {
		return nomedocliente;
	}

	public void setNomedoCliente(String nomedocliente) {
		this.nomedocliente = nomedocliente;
	}





}
