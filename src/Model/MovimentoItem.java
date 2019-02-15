package Model;

import Framework.Annotations.Find;
import Framework.Annotations.Title;


/**
 *  @author Alex Rambo
 *  @since 10/02/2011
 *  
 *  TODO Essa classe deve ser um espelho do banco de dados 
 */
public class MovimentoItem {

	private Integer id;

	public static Integer id_movimento;
	
	@Title(name="Código Material")
	@Find(find=true,size=0.5)
	private Integer id_material;
	
	@Title(name="Material")
	@Find(find=false,size=2)
	private String descricaoMaterial;
	
	@Title(name="Quantidade")
	@Find(find=false,size=0.4)
	private Float quantidade;
	
	@Title(name="")
	@Find(find=false,size=0.9)
	private String unidadeMedida;
	
	private Float preco;
	
	private Float preco_total;
	
	private Float quantidadeMaterial;

	public Float getQuantidadeMaterial() {
		return quantidadeMaterial;
	}

	public void setQuantidadeMaterial(Float quantidadeMaterial) {
		this.quantidadeMaterial = quantidadeMaterial;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_movimento() {
		return id_movimento;
	}

	public void setId_movimento(Integer id_movimento) {
		this.id_movimento = id_movimento;
	}

	public Integer getId_material() {
		return id_material;
	}

	public void setId_material(Integer id_material) {
		this.id_material = id_material;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public Float getPreco_total() {
		return preco_total;
	}

	public void setPreco_total(Float preco_total) {
		this.preco_total = preco_total;
	}

	public String getDescricaoMaterial() {
		return descricaoMaterial;
	}

	public void setDescricaoMaterial(String descricaoMaterial) {
		this.descricaoMaterial = descricaoMaterial;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

}