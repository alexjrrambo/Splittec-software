package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *  @author Bruno Konzen Stahl
 *  @since 24/09/2010
 */
public class ConnectionUtils {

	/**
	 *  Atributos de configuração do Banco de Dados
	 */
	public static String mysqlDriver="org.gjt.mm.mysql.Driver";
	public static String postgreDriver="postgresql.Driver";

	private static Connection con;

	/**
	 *  Inicia conexão com o Banco de dados
	 */
	public static void openConnection(String dataBaseConnection, String dataBaseName,String dataBaseUser,String dataBasePassword){
		try {
			Class.forName(mysqlDriver).newInstance();
			con = DriverManager.getConnection("jdbc:mysql://"+dataBaseConnection+"/"+dataBaseName, dataBaseUser, dataBasePassword);
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(null,"Banco de dados não pode ser acessado! \nVerifique as configurações..","Atenção",0);
			e.printStackTrace();
		}
	}

	/**
	 *  Termina conexão com o Banco de dados
	 */
	public static void closeConnection(){
		try {
			con.close();
			con.clearWarnings();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 *  Executa SQL para consulta
	 *  @return ResultSet
	 */
	public static ResultSet executeQuery(String sqlStatement){
		try {
			System.err.println("sqlStatement: "+sqlStatement);
			return con.createStatement().executeQuery(sqlStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *  Executa SQL para atualização de dados
	 */
	public static void executeUpdate(String sqlStatement){
		try {
			System.err.println("sqlStatement: "+sqlStatement);
			PreparedStatement statement  = (PreparedStatement) con.prepareStatement(sqlStatement);
			statement.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static String addCriteria(String criteria, String campo, Object valor){

		String sql = "";
		if(!valor.toString().equals("")){
			if(criteria.equals("")){
				sql+=" WHERE ";
			}
			else{
				sql+=" AND ";
			}
			if(valor.getClass().equals(String.class)){
				sql+=campo+" LIKE '"+valor+"%'";
			}
			if(valor.getClass().equals(int.class)||valor.getClass().equals(Integer.class)){
				sql+=campo+" = "+valor;
			}
		}
		return sql;
	}
}