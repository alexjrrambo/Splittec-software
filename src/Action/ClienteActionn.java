package Action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Framework.Components.Table.JTableList;
import Framework.Utils.Data.ImageUtils;
import Interface.CadastroCliente;
import Model.Cliente;
import Utils.ConnectionUtils;
import Utils.PropertiesUtils;
import Utils.ReportUtils;

/**
 *  @author Alex Junior Rambo
 *  @since 10/02/2011
 */
public class ClienteActionn {

	//Grid da tela de pesquisa!
	public static JTableList tableList;

	
	//atualiza a lista na grid!	 
	public static void doReload(){
		tableList.doReload();
	}

	
	public static ArrayList<Cliente> doLoadList(Cliente objeto){

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		//Seleção de Registros
		String querySelect = "SELECT * FROM Cliente";

		//--Realizar tratamento (Verificar se é WHERE ou AND)..
		boolean isWhere = true;
		if(objeto.getId()!=null){
			if(isWhere){
				querySelect+=" WHERE";
				isWhere = false;
			}
			else{
				querySelect+=" AND";
			}
			querySelect+=" id = "+objeto.getId();
		}
		if(objeto.getNomedoCliente()!=null){
			if(isWhere){
				querySelect+=" WHERE";
				isWhere = false;
			}
			else{
				querySelect+=" AND";
			}
			querySelect+=" nomedocliente LIKE '"+objeto.getNomedoCliente()+"%'";
		}
		
		if(objeto.getEstadocivil()!=null){
			if(isWhere){
				querySelect+=" WHERE";
				isWhere = false;
			}
			else{
				querySelect+=" AND";
			}
			querySelect+=" estadocivil = '"+objeto.getEstadocivil()+"'";
		}

		ResultSet rs = ConnectionUtils.executeQuery(querySelect);

		try {
			//Percorrendo as tuplas da tabelas
			while (rs.next()){

				//Obtendo o campo ID da TUPLA e armazenando em um INT
				int id = rs.getInt("id");

				//Obtendo o campo NOME da TUPLA e armazenando em uma STRING
				String nomedoCliente = rs.getString("nomedoCliente");  
				String cidade = rs.getString("cidade");
				String bairro = rs.getString("bairro");
				String rua = rs.getString("rua");
				String pais = rs.getString("pais");
				String sim = rs.getString("sim");
				String nao = rs.getString("nao");
				String estadocivil = rs.getString("estadocivil");
				String cpf = rs.getString("cpf");
				String rg = rs.getString("rg");
				String data = rs.getString("data");
				String obs = rs.getString("obs");

				Cliente Cliente = new Cliente();
				Cliente.setId(id);
				Cliente.setNomedoCliente(nomedoCliente);
				Cliente.setSim(sim);
				Cliente.setNao(nao);
				Cliente.setBairro(bairro);
				Cliente.setCidade(cidade);
				Cliente.setCpf(cpf);
				Cliente.setData(data);
				Cliente.setEstadocivil(estadocivil);
				Cliente.setRg(rg);
				Cliente.setPais(pais);
				Cliente.setRua(rua);
				Cliente.setObs(obs);

				lista.add(Cliente);
			}

		} catch (SQLException e) {
			//Exibindo erro no console
			e.printStackTrace();
		}			
		return lista;
	}


	
	//Método responsável por configurar a grid da tela de pesquisa! 	 
	public void createTable(Window window, JPanel panel){

		//---Salvando Propriedades---
		PropertiesUtils utils = new PropertiesUtils("Properties.txt");
		String background = utils.getProperty("background");
		String titleColor = utils.getProperty("TitleColor");

		tableList = new JTableList(window,this,panel,Cliente.class);

		if(background!=null){
			Color corFundo = new Color(new Integer(background));
			tableList.setBackground(corFundo);
		}
		//Muda a cor da label
		if(titleColor!=null){
			Color colortitle = new Color(new Integer(titleColor));
			tableList.setTitleColor(colortitle);
		}

		//Muda a imagem add da label
		tableList.setIconAdicionar(ImageUtils.resizeImageIcon("Imagens/2914_128x128.png",32,32));

		//Muda a imagem lupa da label
		tableList.setIconPesquisar(ImageUtils.resizeImageIcon("Imagens/1999_32x32.png",32,32));

		//Muda a imagem impressora da label
		tableList.setIconImprimir(ImageUtils.resizeImageIcon("Imagens/2979_128x128.png",32,32));

		//Muda a fonte da label
		Font fonte = new Font("Times New Roman", Font.ITALIC, 16);
		tableList.setTitleFont(fonte);

		//Adicionando cabeçalho com título e imagem
		tableList.setTitle("Pesquisa - Cliente",ImageUtils.resizeImageIcon("Imagens/canstock11432632.png",32,32));

		//Configurando método para adição de registros
		tableList.setNewMethod("doNew");

		//Configurando método para impressão de relatórios
		tableList.setReportMethod("doPrintReport");

		//Adicionando botão para visualização
		ImageIcon imageOpen = new ImageIcon(getClass().getClassLoader().getResource("Framework/Imagens/abrir.png"));
		tableList.addButton(imageOpen, "doLoad", "Visualizar");

		//Adicionando botão para exclusão
		ImageIcon imageExcluir = new ImageIcon(getClass().getClassLoader().getResource("Framework/Imagens/excluir.png"));
		tableList.addButton(imageExcluir, "doRemove", "Excluir");

		//Renderizando grid
		tableList.initGUI();

	}

	/**
	 *  Método para adicionar registros
	 */
	public static void doNew(){

		CadastroCliente cadastro = new CadastroCliente();
		cadastro.setVisible(true);
	}

	/**
	 *  Método para visualizar registros
	 */
	public static void doLoad(Cliente Cliente){

		CadastroCliente cadastro = new CadastroCliente();
		cadastro.reload(Cliente);
		cadastro.setVisible(true);
	}

	/**
	 *  Método para remover registros
	 */
	public static void doRemove(Cliente objeto){

		int option = JOptionPane.showConfirmDialog(null,"Realmente deseja excluir?","Atenção!",1 );

		if(option == 0){

			//TODO Executar SQL para exclusão de objeto
			JOptionPane.showMessageDialog(null,"Exclusão de Objetos");

			//Remoção de Registros
			String queryDelete = "DELETE FROM Cliente WHERE id = "+objeto.getId();
			ConnectionUtils.executeUpdate(queryDelete);

			//Atualizando lista
			doReload();
		}

	}

	/**
	 *  Método para imprimir relatórios!
	 *  Somente o que aparece na grid deve ser impresso.
	 */
	public static void doPrintReport(){

		HashMap parametros = new HashMap();
		parametros.put("imgContext", "Imagens/Globe_32x32.png");
		parametros.put("NMUSUARIO", "Splittec");
		parametros.put("RODAPE", "Splittec Software");
		//parametros.put("Arquivo", "C:/Arquivos de programas/xerox");

		ReportUtils reportUtils = new ReportUtils("Splittec");
		reportUtils.addReport("Report/relatorioCliente.jasper",parametros,tableList.getList());
		reportUtils.createReport();

	}



}
