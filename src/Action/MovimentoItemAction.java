package Action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Framework.Components.Table.JTableList;
import Framework.Utils.Data.ImageUtils;
import Interface.CadastroMovimento;
import Interface.CadastroMovimentoItem;
import Model.MovimentoItem;
import Utils.ConnectionUtils;
import Utils.PropertiesUtils;
import Utils.ReportUtils;

/**
 *  @author Alex Rambo
 *  @since 10/02/2011
 */
public class MovimentoItemAction {

	//Grid da tela de pesquisa!
	public static JTableList tableList;

	/**
	 *  TODO Atualiza a lista na grid!
	 */
	public static void doReload(){
		tableList.doReload();
	}

	/**
	 *  TODO O método é invocado quando o botão 'Pesquisar' (Lupa) é clicado!
	 *  Passo1 - Receber um objeto com os critérios de busca;
	 *  Passo2 - Executar o SQL para receber o resultado da busca (lista);
	 *  Passo2 - Retornar a lista para que a Grid seja atualizada.
	 */
	public static ArrayList<MovimentoItem> doLoadList(MovimentoItem objeto){

		ArrayList<MovimentoItem> lista = new ArrayList<MovimentoItem>();

		//Seleção de Registros
		String querySelect = "SELECT mi.*, ma.descricao,ma.unidade_medida,ma.quantidade as qtd_material FROM Movimento_item mi left join material ma on ma.id = mi.id_material ";

		//--Realizar tratamento (Verificar se é WHERE ou AND)..
		boolean isWhere = true;
		if(objeto.getId_movimento()!=null){
			if(isWhere){
				querySelect+=" WHERE";
				isWhere = false;
			}
			else{
				querySelect+=" AND";
			}
			querySelect+=" id_movimento = "+objeto.getId_movimento();
		}

		ResultSet rs = ConnectionUtils.executeQuery(querySelect);

		try {
			//Percorrendo as tuplas da tabelas
			while (rs.next()){

				//Obtendo o campo ID da TUPLA e armazenando em um INT
				int id = rs.getInt("id");

				//Obtendo o campo NOME da TUPLA e armazenando em uma STRING
				Integer id_movimento = rs.getInt("id_movimento"); 
				Integer id_material = rs.getInt("id_material");  
				Float quantidade = rs.getFloat("quantidade");
				Float preco = rs.getFloat("preco");
				Float preco_total = rs.getFloat("preco_total");
				String descricaoMaterial = rs.getString("descricao");
				String unidade_medida = rs.getString("unidade_medida");
				Float quantidadeMaterial = rs.getFloat("qtd_material");

				MovimentoItem MovimentoItem = new MovimentoItem();
				MovimentoItem.setId(id);
				MovimentoItem.setId_movimento(id_movimento);
				MovimentoItem.setId_material(id_material);
				MovimentoItem.setQuantidade(quantidade);
				MovimentoItem.setPreco(preco);
				MovimentoItem.setPreco_total(preco_total);
				MovimentoItem.setDescricaoMaterial(descricaoMaterial);
				MovimentoItem.setUnidadeMedida(unidade_medida);
				MovimentoItem.setQuantidadeMaterial(quantidadeMaterial);
				

				lista.add(MovimentoItem);
			}

		} catch (SQLException e) {
			//Exibindo erro no console
			e.printStackTrace();
		}			
		return lista;
	}


	/**
	 *  TODO Método responsável por configurar a grid da tela de pesquisa! 
	 */
	public void createTable(Window window, JPanel panel){

		//---Salvando Propriedades---
		PropertiesUtils utils = new PropertiesUtils("Properties.txt");
		String background = utils.getProperty("background");
		String titleColor = utils.getProperty("TitleColor");

		tableList = new JTableList(window,this,panel,MovimentoItem.class);

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
		tableList.setTitle("Materiais do movimento",ImageUtils.resizeImageIcon("Imagens/canstock11432632.png",32,32));


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
		String valida = CadastroMovimento.textFieldCodigo.getText();
		if(!valida.equals("")){
			JOptionPane.showMessageDialog(null,"Não e possivel adicionar materiais em um movimento que ja foi salvo anteriormente.");
		}else{
			CadastroMovimentoItem cadastro = new CadastroMovimentoItem();
			cadastro.setaIdMovimento();
			cadastro.setVisible(true);
		}
	}

	/**
	 *  Método para visualizar registros
	 */
	public static void doLoad(MovimentoItem MovimentoItem){

		CadastroMovimentoItem cadastro = new CadastroMovimentoItem();
		cadastro.reload(MovimentoItem);
		cadastro.setVisible(true);
	}

	/**
	 *  Método para remover registros
	 */
	public static void doRemove(MovimentoItem objeto){

		if(!CadastroMovimento.textFieldCodigo.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Não e possivel excluir materiais de um movimento que ja foi salvo anteriormente.");
		}else{
			int option = JOptionPane.showConfirmDialog(null,"Realmente deseja excluir?","Atenção!",1 );

			if(option == 0){

				//Remoção de Registros
				String queryDelete = "DELETE FROM Movimento_item WHERE id = "+objeto.getId();
				ConnectionUtils.executeUpdate(queryDelete);

				//Atualizando lista
				doReload();
			}
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