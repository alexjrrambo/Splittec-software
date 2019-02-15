package Model;

import Framework.Annotations.Find;
import Framework.Annotations.Id;
import Framework.Annotations.Title;

/**
 *  @author Alex Rambo
 *  @since 10/02/2011
 *  
 *  TODO Essa classe deve ser um espelho do banco de dados 
 */
public class Material {


	@Id
	@Title(name="Código")
	@Find(find=true,size=0.5)
	private Integer id;

	@Find(find=true,size=1.5)
	@Title(name="Descricao")
	private String descricao;
	
	@Find(find=true)
	@Title(name="Identificador")
	private String cd_material;

	@Find(find=false)
	@Title(name="Quantidade")
	private Float quantidade;
	
	private Float qtd_aviso;
	
	public Float getQtd_aviso() {
		return qtd_aviso;
	}

	public void setQtd_aviso(Float qtd_aviso) {
		this.qtd_aviso = qtd_aviso;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	private Float valor_medio;

	private String unidade_medida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCd_material() {
		return cd_material;
	}

	public void setCd_material(String cd_material) {
		this.cd_material = cd_material;
	}

	public Float getValor_medio() {
		return valor_medio;
	}

	public void setValor_medio(Float valor_medio) {
		this.valor_medio = valor_medio;
	}

	public String getUnidade_medida() {
		return unidade_medida;
	}

	public void setUnidade_medida(String unidade_medida) {
		this.unidade_medida = unidade_medida;
	}

}