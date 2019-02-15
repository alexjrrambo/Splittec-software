package Action;

import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.ConnectionUtils;

public class EstoqueAction {

	public static void reprocessaEstoque(Integer id_movimento,String operacao){
		Integer id_material;
		Float quantidade;
		Float quantidadeMaterial;
		Float quantidadeASerInserida;
		//Seleção de Registros
		String querySelect = "select * from movimento_item where id_movimento="+id_movimento;
		ResultSet rs = ConnectionUtils.executeQuery(querySelect);

		try {
			while(rs.next()){
				id_material = rs.getInt("id_material");
				quantidade  = rs.getFloat("quantidade");			
				
				String querySelect2 = "select * from material where id="+id_material;
				ResultSet rs2 = ConnectionUtils.executeQuery(querySelect2);

					while(rs2.next()){
						quantidadeMaterial  = rs2.getFloat("quantidade");
						
						if(operacao=="-"){
						quantidadeASerInserida = quantidadeMaterial-quantidade;
						}else{
						quantidadeASerInserida = quantidadeMaterial+quantidade;
						}
						
						String queryUpdate = "UPDATE material SET quantidade = "+quantidadeASerInserida+" WHERE id = "+id_material;
						ConnectionUtils.executeUpdate(queryUpdate);
					
					}	
			}
		} catch (SQLException e) {
			//Exibindo erro no console
			e.printStackTrace();
		}	
	}
	
}
