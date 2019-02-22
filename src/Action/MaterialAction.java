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
import Interface.CadastroMaterial;
import Model.Material;
import Utils.ConnectionUtils;
import Utils.PropertiesUtils;
import Utils.ReportUtils;

/**
 *  @author Alex Rambo
 *  @since 10/02/2011
 */
public class MaterialAction {

	//Grid da tela de pesquisa!
	public static JTableList tableList;

	/**
	 *Atualiza a lista na grid!
	 */
	public static void doReload(){
		tableList.doReload();
	}

	public static ArrayList<Material> doLoadList(Material objeto){

		ArrayList<Material> lista = new ArrayList<Material>();

		//Seleção de Registros
		String querySelect = "SELECT * FROM Material";

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
		if(objeto.getDescricao()!=null){
			if(isWhere){
				querySelect+=" WHERE";
				isWhere = false;
			}
			else{
				querySelect+=" AND";
			}
			querySelect+=" descricao LIKE '"+objeto.getDescricao()+"%'";
		}
		
		if(objeto.getCd_material()!=null){
			if(isWhere){
				querySelect+=" WHERE";
				isWhere = false;
			}
			else{
				querySelect+=" AND";
			}
			querySelect+=" cd_material LIKE '"+objeto.getCd_material()+"%'";
		}

		ResultSet rs = ConnectionUtils.executeQuery(querySelect);

		try {
			//Percorrendo as tuplas da tabelas
			while (rs.next()){

				//Obtendo o campo ID da TUPLA e armazenando em um INT
				int id = rs.getInt("id");

				//Obtendo o campo NOME da TUPLA e armazenando em uma STRING
				String cd_material = rs.getString("cd_material"); 
				String descricao = rs.getString("descricao");  
				String unidade_medida = rs.getString("unidade_medida");
				Float quantidade = rs.getFloat("quantidade");
				Float valor_medio = rs.getFloat("valor_medio");
				Float qtd_aviso = rs.getFloat("qtd_minima");

				Material Material = new Material();
				Material.setId(id);
				Material.setCd_material(cd_material);
				Material.setDescricao(descricao);
				Material.setUnidade_medida(unidade_medida);
				Material.setQuantidade(quantidade);
				Material.setValor_medio(valor_medio);
				Material.setQtd_aviso(qtd_aviso);

				lista.add(Material);
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

		tableList = new JTableList(window,this,panel,Material.class);

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
		tableList.setTitle("Pesquisa - Material",ImageUtils.resizeImageIcon("Imagens/canstock11432632.png",32,32));

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

		CadastroMaterial cadastro = new CadastroMaterial();
		cadastro.setVisible(true);
	}

	/**
	 *  Método para visualizar registros
	 */
	public static void doLoad(Material Material){

		CadastroMaterial cadastro = new CadastroMaterial();
		cadastro.reload(Material);
		cadastro.setVisible(true);
	}

	/**
	 *  Método para remover registros
	 */
	public static void doRemove(Material objeto){

		int option = JOptionPane.showConfirmDialog(null,"Realmente deseja excluir?","Atenção!",1 );

		if(option == 0){
			JOptionPane.showMessageDialog(null,"Exclusão de Objetos");

			//Remoção de Registros
			String queryDelete = "DELETE FROM Material WHERE id = "+objeto.getId();
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
