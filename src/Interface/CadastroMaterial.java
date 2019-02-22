package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import Action.ClienteActionn;
import Action.MaterialAction;
import Framework.Fields.JNumberField;
import Framework.Layout.AnchorConstraint;
import Framework.Panels.JGradientPanel;
import Framework.Utils.Data.ImageUtils;
import Model.Material;
import Utils.ConnectionUtils;
import Utils.DocumentoLimitado;
import java.awt.Font;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */

/**
 *  @author Alex Rambo
 *  @since 10/02/2011
 *  
 *  Classe demosntração para construção de janela (tipo JFrame).
 */
public class CadastroMaterial extends JFrame{
	private JButton jButton1;
	private JTextField jTextField8;
	private JComboBox jComboBoxUnMedida;
	private JTextField jTextFieldCdMaterial;
	private JLabel jLabel8;
	private JButton jButton2;
	private JTextField textFieldCodigo;
	private JTextField textFieldDescricao;
	private JLabel lblDescricao;
	private JLabel lblQuanitdade;
	private JTextField textFieldQuantidade;
	private JLabel lblPreoMedio;
	private JTextField textFieldPrecoMedio;
	private JLabel lblQtdParaAviso;
	private JTextField textFieldQtdAviso;

	/**
	 *  TODO Construtor da classe
	 *  O construtor é invocado quando a classe é criada!
	 */
	public CadastroMaterial(){
		super();
		initGUI();
	}

	/**
	 *  TODO Método responsável por construir a interface da janela.
	 */
	public void initGUI(){

		//Coloca mensagem na barra do programa
		this.setTitle("Cadastro Material");

		//Permite Maximizat ou não true (sim) false (não)
		this.setResizable(false);

		//Define a operação padrão ao clicar no botão 'close'
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//Serve para desenhar dentro do Panel
		this.pack();

		//Definindo o tamanho da janela
		this.setSize(625, 452);

		//Obtendo resolução da tela
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		//Centralizando janela na tela obtida
		this.setLocation((d.width/2)-(this.getWidth()/2),(d.height/2)-(this.getHeight()/2));
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Imagens/users3.png")).getImage());
		{
			JGradientPanel panelFundo = new JGradientPanel(250);
			getContentPane().add(panelFundo, BorderLayout.NORTH);
			panelFundo.setLayout(null);
			panelFundo.setBackground(new java.awt.Color(219,219,219));
			panelFundo.setPreferredSize(new java.awt.Dimension(619, 425));
			
			
			{
				jButton1 = new JButton();
				panelFundo.add(jButton1, new AnchorConstraint(898, 490, 1004, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton1.setForeground(new java.awt.Color(0,0,0));
				jButton1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
				jButton1.setIcon(ImageUtils.resizeImageIcon("Imagens/Save_24x24.png",18,15));
				jButton1.setText("Salvar");
				jButton1.setFont(new java.awt.Font("Comic Sans MS",0,12));
				jButton1.setBounds(7, 362, 303, 51);

				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						save();
					}
				});
			}
			{
				jButton2 = new JButton();
				panelFundo.add(jButton2, new AnchorConstraint(898, 1000, 1004, 489, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton2.setForeground(new java.awt.Color(0,0,0));
				jButton2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
				jButton2.setIcon(ImageUtils.resizeImageIcon("Imagens/Cancel_32x32.png",18,15));
				jButton2.setText("Cancelar");
				jButton2.setFont(new java.awt.Font("Comic Sans MS",0,12));
				jButton2.setBounds(310, 362, 298, 51);

				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						dispose();
					}
				});
			}
			{
				jLabel8 = new JLabel();
				panelFundo.add(jLabel8, new AnchorConstraint(227, 180, 282, 22, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel8.setText("Identificador:");
				jLabel8.setBounds(13, 49, 105, 11);
				jLabel8.setForeground(new java.awt.Color(0,0,0));
				jLabel8.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				jTextFieldCdMaterial = new JTextField();
				//jTextField13.setDocument(new DocumentoLimitado(15));
				panelFundo.add(jTextFieldCdMaterial, new AnchorConstraint(224,624,285,209,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jTextFieldCdMaterial.setBounds(128, 45, 158, 19);
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] {"Peças", "Metros" });
				jComboBoxUnMedida = new JComboBox();
				panelFundo.add(jComboBoxUnMedida);
				jComboBoxUnMedida.setModel(jComboBox1Model);
				jComboBoxUnMedida.setBounds(245, 97, 95, 21);
			}
			{
				ComboBoxModel SolteiroModel = new DefaultComboBoxModel(new String[] { "Cliente", "Fornecedor" });
			}
			
			JLabel lblCodigo = new JLabel();
			lblCodigo.setText("Codigo:");
			lblCodigo.setForeground(Color.BLACK);
			lblCodigo.setFont(new Font("Century Gothic", Font.ITALIC, 12));
			lblCodigo.setBounds(13, 15, 105, 19);
			panelFundo.add(lblCodigo);
			
			textFieldCodigo = new JNumberField();
			textFieldCodigo.setEnabled(false);
			textFieldCodigo.setEditable(false);
			textFieldCodigo.setBounds(128, 15, 84, 19);
			panelFundo.add(textFieldCodigo);
			{
				textFieldDescricao = new JTextField();
				textFieldDescricao.setBounds(128, 71, 434, 19);
				panelFundo.add(textFieldDescricao);
			}
			{
				lblDescricao = new JLabel();
				lblDescricao.setText("Descricao:");
				lblDescricao.setForeground(Color.BLACK);
				lblDescricao.setFont(new Font("Century Gothic", Font.ITALIC, 12));
				lblDescricao.setBounds(13, 75, 105, 11);
				panelFundo.add(lblDescricao);
			}
			{
				lblQuanitdade = new JLabel();
				lblQuanitdade.setText("Quanitdade:");
				lblQuanitdade.setForeground(Color.BLACK);
				lblQuanitdade.setFont(new Font("Century Gothic", Font.ITALIC, 12));
				lblQuanitdade.setBounds(13, 102, 105, 11);
				panelFundo.add(lblQuanitdade);
			}
			{
				textFieldQuantidade = new JTextField();
				textFieldQuantidade.setText("0");
				textFieldQuantidade.setBounds(128, 98, 114, 19);
				panelFundo.add(textFieldQuantidade);
			}
			{
				lblPreoMedio = new JLabel();
				lblPreoMedio.setText("Pre\u00E7o medio:");
				lblPreoMedio.setForeground(Color.BLACK);
				lblPreoMedio.setFont(new Font("Century Gothic", Font.ITALIC, 12));
				lblPreoMedio.setBounds(13, 129, 105, 11);
				panelFundo.add(lblPreoMedio);
			}
			{
				textFieldPrecoMedio = new JTextField();
				textFieldPrecoMedio.setText("0");
				textFieldPrecoMedio.setBounds(128, 125, 114, 19);
				panelFundo.add(textFieldPrecoMedio);
			}
			{
				lblQtdParaAviso = new JLabel();
				lblQtdParaAviso.setText("Qtd. para aviso:");
				lblQtdParaAviso.setForeground(Color.BLACK);
				lblQtdParaAviso.setFont(new Font("Century Gothic", Font.ITALIC, 12));
				lblQtdParaAviso.setBounds(13, 151, 105, 19);
				panelFundo.add(lblQtdParaAviso);
			}
			{
				textFieldQtdAviso = new JTextField();
				textFieldQtdAviso.setText("0");
				textFieldQtdAviso.setBounds(128, 151, 114, 19);
				panelFundo.add(textFieldQtdAviso);
			}

		}

	}
	public void reload(Material material){
		textFieldCodigo.setText(material.getId()+"");
		jTextFieldCdMaterial.setText(material.getCd_material());
		jComboBoxUnMedida.setSelectedItem(material.getUnidade_medida());
		textFieldDescricao.setText(material.getDescricao());
		textFieldPrecoMedio.setText(material.getValor_medio()+"");
		textFieldQuantidade.setText(material.getQuantidade()+"");
		textFieldQtdAviso.setText(material.getQtd_aviso()+"");
	}

	public void save(){
		String cd_material = jTextFieldCdMaterial.getText();
		String unidade_medida = jComboBoxUnMedida.getSelectedItem()+"";
		String descricao = textFieldDescricao.getText();
		Float valorMedio = Float.parseFloat(textFieldPrecoMedio.getText());
		Float quantidade = Float.parseFloat(textFieldQuantidade.getText());
		Float qtd_aviso = Float.parseFloat(textFieldQtdAviso.getText());
		if (textFieldCodigo.getText().equals("")){
			String queryInsert = "INSERT INTO material(cd_material,descricao,quantidade,unidade_medida,valor_medio,qtd_minima) VALUES('"+cd_material+"','"+descricao+"',"+quantidade+",'"+unidade_medida+"',"+valorMedio+","+qtd_aviso+")";
			ConnectionUtils.executeUpdate(queryInsert);
		}
		else{
			String queryUpdate = "UPDATE material SET cd_material = '"+cd_material+"', descricao = '"+descricao+"', quantidade = "+quantidade+", unidade_medida = '"+unidade_medida+"', valor_medio = "+valorMedio+", qtd_minima="+qtd_aviso+" WHERE Id = "+textFieldCodigo.getText()+"";
			ConnectionUtils.executeUpdate(queryUpdate);
		}
		dispose();
		MaterialAction.doReload();
	}
}
