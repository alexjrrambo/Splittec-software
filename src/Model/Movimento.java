package Model;

import java.util.Date;

import Framework.Annotations.Find;
import Framework.Annotations.Id;
import Framework.Annotations.Title;

/**
 *  @author Alex Rambo
 *  @since 10/02/2011
 *  
 *  TODO Essa classe deve ser um espelho do banco de dados 
 */
public class Movimento {


	@Id
	@Title(name="Código")
	@Find(find=true)
	private Integer id;

	@Find(find=true,comboboxFind={"Entrada","Saida"})
	@Title(name="Movimento")
	private String tipo_movimento;
	
	private Integer id_cliente;
	
	@Title(name="Data do movimento")
	@Find(find=false)
	private String dataFormatada;
		
	private Date data_movimento;
	
	@Title(name="Cliente")
	@Find(find=true)
	private String clienteDescricao;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo_movimento() {
		return tipo_movimento;
	}

	public void setTipo_movimento(String tipo_movimento) {
		this.tipo_movimento = tipo_movimento;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Date getData_movimento() {
		return data_movimento;
	}

	public void setData_movimento(Date data_movimento) {
		this.data_movimento = data_movimento;
	}

	public String getClienteDescricao() {
		return clienteDescricao;
	}

	public void setClienteDescricao(String clienteDescricao) {
		this.clienteDescricao = clienteDescricao;
	}

	public String getDataFormatada() {
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

}