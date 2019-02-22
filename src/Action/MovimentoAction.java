package Action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Action.EstoqueAction;
import Framework.Components.Table.JTableList;
import Framework.Utils.Data.ImageUtils;
import Interface.CadastroMovimento;
import Model.Movimento;
import Model.MovimentoItem;
import Utils.BuscaDados;
import Utils.ConnectionUtils;
import Utils.PropertiesUtils;
import Utils.ReportUtils;

/**
 *  @author Alex Rambo
 *  @since 10/02/2011
 */
public class MovimentoAction {

	//Grid da tela de pesquisa!
	public static JTableList tableList;

	/**
	 *  TODO Atualiza a lista na grid!
	 */
	public static void doReload(){
		tableList.doReload();
	}

	public static ArrayList<Movimento> doLoadList(Movimento objeto){

		ArrayList<Movimento> lista = new ArrayList<Movimento>();

		//Seleção de Registros
		String querySelect = "SELECT m.*,c.nomedocliente FROM Movimento m left join cliente c on c.id = m.id_cliente  WHERE m.id<>1 ";

		//--Realizar tratamento (Verificar se é WHERE ou AND)..
		boolean isWhere = false;
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
		if(objeto.getTipo_movimento()!=null){
			if(isWhere){
				querySelect+=" WHERE";
				isWhere = false;
			}
			else{
				querySelect+=" AND";
			}
			querySelect+=" tipo_movimento = '"+objeto.getTipo_movimento()+"'";
		}
		if(objeto.getClienteDescricao()!=null){
			if(isWhere){
				querySelect+=" WHERE";
				isWhere = false;
			}
			else{
				querySelect+=" AND";
			}
			querySelect+=" c.nomedocliente like '%"+objeto.getClienteDescricao()+"%'";
		}
		
		querySelect+=" order by data_movimento desc";

		ResultSet rs = ConnectionUtils.executeQuery(querySelect);

		try {
			//Percorrendo as tuplas da tabelas
			while (rs.next()){

				//Obtendo o campo ID da TUPLA e armazenando em um INT
				int id = rs.getInt("id");

				//Obtendo o campo NOME da TUPLA e armazenando em uma STRING
				String tipo_movimento = rs.getString("tipo_movimento"); 
				Integer id_cliente = rs.getInt("id_cliente");  
				Date data_movimento = rs.getDate("data_movimento");
				String nomedocliente = rs.getString("nomedocliente");


				Movimento Movimento = new Movimento();
				Movimento.setId(id);
				Movimento.setTipo_movimento(tipo_movimento);
				Movimento.setId_cliente(id_cliente);
				Movimento.setData_movimento(data_movimento);
				Movimento.setClienteDescricao(nomedocliente);
				Movimento.setDataFormatada(BuscaDados.converteDataParaTela(data_movimento));

				lista.add(Movimento);
			}

		} catch (SQLException e) {
			//Exibindo erro no console
			e.printStackTrace();
		}			
		return lista;
	}


	/**
	 *  Método responsável por configurar a grid da tela de pesquisa! 
	 */
	public void createTable(Window window, JPanel panel){

		//---Salvando Propriedades---
		PropertiesUtils utils = new PropertiesUtils("Properties.txt");
		String background = utils.getProperty("background");
		String titleColor = utils.getProperty("TitleColor");

		tableList = new JTableList(window,this,panel,Movimento.class);

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
		tableList.setTitle("Pesquisa - Movimento",ImageUtils.resizeImageIcon("Imagens/canstock11432632.png",32,32));

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
		Integer id_movimento=0;
		//Seleção de Registros
		String querySelect = "select id from movimento order by id desc LIMIT 1";
		ResultSet rs = ConnectionUtils.executeQuery(querySelect);

		try {
			while(rs.next()){
			id_movimento = rs.getInt("id");
			}
		} catch (SQLException e) {
			//Exibindo erro no console
			e.printStackTrace();
		}	
		MovimentoItem.id_movimento = id_movimento+1;
		CadastroMovimento cadastro = new CadastroMovimento(id_movimento+1);
		cadastro.setaIdMovimento();
		cadastro.setVisible(true);
	}

	/**
	 *  Método para visualizar registros
	 */
	public static void doLoad(Movimento Movimento){
		MovimentoItem.id_movimento = Movimento.getId();
		CadastroMovimento cadastro = new CadastroMovimento(Movimento.getId());
		//cadastro.setaIdMovimento();
		cadastro.reload(Movimento);
		cadastro.setVisible(true);
	}

	/**
	 *  Método para remover registros
	 */
	public static void doRemove(Movimento objeto){

		int option = JOptionPane.showConfirmDialog(null,"Realmente deseja excluir o movimento?","Atenção!",1 );

		if(option == 0){

			if(objeto.getTipo_movimento().equals("Entrada")){
				EstoqueAction.reprocessaEstoque(objeto.getId(), "-");
			}else{
				EstoqueAction.reprocessaEstoque(objeto.getId(), "+");
			}
			JOptionPane.showMessageDialog(null,"Exclusão de Objetos");

			//Remoção de Registros
			String queryDelete = "DELETE FROM Movimento WHERE id = "+objeto.getId();
			ConnectionUtils.executeUpdate(queryDelete);
			
			String queryDelete2 = "DELETE FROM Movimento_item WHERE id_movimento = "+objeto.getId();
			ConnectionUtils.executeUpdate(queryDelete2);

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
