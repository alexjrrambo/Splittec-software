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
 *  @author Elvis Dobner da Rosa
 *  @since 10/02/2011
 */
public class ClienteActionn {

	//Grid da tela de pesquisa!
	public static JTableList tableList;

	/**
	 *  TODO Atualiza a lista na grid!
	 */
	public static void doReload(){
		tableList.doReload();
	}

	/**
	 *  TODO O m�todo � invocado quando o bot�o 'Pesquisar' (Lupa) � clicado!
	 *  Passo1 - Receber um objeto com os crit�rios de busca;
	 *  Passo2 - Executar o SQL para receber o resultado da busca (lista);
	 *  Passo2 - Retornar a lista para que a Grid seja atualizada.
	 */
	public static ArrayList<Cliente> doLoadList(Cliente objeto){

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		//Sele��o de Registros
		String querySelect = "SELECT * FROM Cliente";

		//--Realizar tratamento (Verificar se � WHERE ou AND)..
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


	/**
	 *  TODO M�todo respons�vel por configurar a grid da tela de pesquisa! 
	 */
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

		//Adicionando cabe�alho com t�tulo e imagem
		tableList.setTitle("Pesquisa - Cliente",ImageUtils.resizeImageIcon("Imagens/canstock11432632.png",32,32));

		//Configurando m�todo para adi��o de registros
		tableList.setNewMethod("doNew");

		//Configurando m�todo para impress�o de relat�rios
		tableList.setReportMethod("doPrintReport");

		//Adicionando bot�o para visualiza��o
		ImageIcon imageOpen = new ImageIcon(getClass().getClassLoader().getResource("Framework/Imagens/abrir.png"));
		tableList.addButton(imageOpen, "doLoad", "Visualizar");

		//Adicionando bot�o para exclus�o
		ImageIcon imageExcluir = new ImageIcon(getClass().getClassLoader().getResource("Framework/Imagens/excluir.png"));
		tableList.addButton(imageExcluir, "doRemove", "Excluir");

		//Renderizando grid
		tableList.initGUI();

	}

	/**
	 *  M�todo para adicionar registros
	 */
	public static void doNew(){

		CadastroCliente cadastro = new CadastroCliente();
		cadastro.setVisible(true);
	}

	/**
	 *  M�todo para visualizar registros
	 */
	public static void doLoad(Cliente Cliente){

		CadastroCliente cadastro = new CadastroCliente();
		cadastro.reload(Cliente);
		cadastro.setVisible(true);
	}

	/**
	 *  M�todo para remover registros
	 */
	public static void doRemove(Cliente objeto){

		int option = JOptionPane.showConfirmDialog(null,"Realmente deseja excluir?","Aten��o!",1 );

		if(option == 0){

			//TODO Executar SQL para exclus�o de objeto
			JOptionPane.showMessageDialog(null,"Exclus�o de Objetos");

			//Remo��o de Registros
			String queryDelete = "DELETE FROM Cliente WHERE id = "+objeto.getId();
			ConnectionUtils.executeUpdate(queryDelete);

			//Atualizando lista
			doReload();
		}

	}

	/**
	 *  M�todo para imprimir relat�rios!
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