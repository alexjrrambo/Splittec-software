package Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuscaDados {

	public static String buscaDescricao(String tabela,Integer id){
		String descricao="";
		
		if (tabela=="cliente"){
			//Seleção de Registros
			String querySelect = "select nomedocliente from "+tabela+" where id="+id;
			ResultSet rs = ConnectionUtils.executeQuery(querySelect);

			try {
				while(rs.next()){
					descricao = rs.getString("nomedocliente");
				}
			} catch (SQLException e) {
				//Exibindo erro no console
				e.printStackTrace();
			}	
		}else{
			//Seleção de Registros
			String querySelect = "select descricao from "+tabela+" where id="+id;
			ResultSet rs = ConnectionUtils.executeQuery(querySelect);

			try {
				while(rs.next()){
					descricao = rs.getString("descricao");
				}
			} catch (SQLException e) {
				//Exibindo erro no console
				e.printStackTrace();
			}		
		}
		return descricao;
	}
	
	public static String buscaUnMedidaMaterial(Integer id){
		
		String unMedida="";
		//Seleção de Registros
		String querySelect = "select unidade_medida from material where id="+id;
		ResultSet rs = ConnectionUtils.executeQuery(querySelect);

		try {
			while(rs.next()){
				unMedida = rs.getString("unidade_medida");
			}
		} catch (SQLException e) {
			//Exibindo erro no console
			e.printStackTrace();
		}			
		return unMedida;
	}
	
	public static String converteDataParaBanco(Date dataFormatar){
		Date dataAserFormatada = dataFormatar;
		String dataFormatada ="";
		SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");
		dataFormatada= formataData.format(dataAserFormatada);

		return dataFormatada;
	}
	
	public static String converteDataParaTela(Date dataFormatar){
		Date dataAserFormatada = dataFormatar;
		String dataFormatada ="";
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		dataFormatada= formataData.format(dataAserFormatada);

		return dataFormatada;
	}
	
	public static float buscaQuantidadeMaterial(Integer id){
		
		float unMedida = 0;
		//Seleção de Registros
		String querySelect = "select quantidade from material where id="+id;
		ResultSet rs = ConnectionUtils.executeQuery(querySelect);

		try {
			while(rs.next()){
				unMedida = rs.getFloat("quantidade");
			}
		} catch (SQLException e) {
			//Exibindo erro no console
			e.printStackTrace();
		}			
		return unMedida;
	}
	
	
}
