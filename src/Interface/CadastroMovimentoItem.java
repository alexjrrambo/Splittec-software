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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Action.ClienteActionn;
import Action.MovimentoAction;
import Action.MovimentoItemAction;
import Framework.Fields.JNumberField;
import Framework.Layout.AnchorConstraint;
import Framework.Panels.JGradientPanel;
import Framework.Utils.Data.ImageUtils;
import Model.Movimento;
import Model.MovimentoItem;
import Utils.ConnectionUtils;
import Utils.DocumentoLimitado;
import Utils.Utils;
import Utils.BuscaDados;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
public class CadastroMovimentoItem extends JFrame {
	private JButton jButton1;
	private JTextField jTextField8;
	private static JTextField jTextFieldUnMedida;
	public static JTextField jTextFieldIdMaterial;
	private JLabel jLabel8;
	private JButton jButton2;
	private JTextField textFieldCodigo;
	private static JTextField textFieldDescricaoMaterial;
	private JLabel lblQuanitdade;
	private JTextField textFieldQuantidade;
	private JLabel lblPreoMedio;
	private JTextField textFieldPreco;
	private JTextField textFieldPrecoTotal;
	private JNumberField textFieldIdMovimento;
	public static Integer idMov;
	private static JTextField textFieldEstoque;

	/**
	 *  TODO Construtor da classe
	 *  O construtor é invocado quando a classe é criada!
	 */
	public CadastroMovimentoItem(){
		super();
		initGUI();
		//idMov=idMovimento;
	}

	/**
	 *  TODO Método responsável por construir a interface da janela.
	 */
	public void initGUI(){

		//Coloca mensagem na barra do programa
		this.setTitle("Cadastro Itens de Movimento");

		//Permite Maximizat ou não true (sim) false (não)
		this.setResizable(false);

		//Define a operação padrão ao clicar no botão 'close'
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//Serve para desenhar dentro do Panel
		this.pack();

		//Definindo o tamanho da janela
		this.setSize(625, 250);

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
			panelFundo.setPreferredSize(new java.awt.Dimension(619, 225));
			{
				jButton1 = new JButton();
				panelFundo.add(jButton1, new AnchorConstraint(898, 490, 1004, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton1.setForeground(new java.awt.Color(0,0,0));
				jButton1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
				jButton1.setIcon(ImageUtils.resizeImageIcon("Imagens/Save_24x24.png",18,15));
				jButton1.setText("Salvar");
				jButton1.setFont(new java.awt.Font("Comic Sans MS",0,12));
				jButton1.setBounds(10, 155, 303, 51);
				jButton1.setEnabled(CadastroMovimento.textFieldCodigo.getText().equals(""));

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
				jButton2.setBounds(313, 155, 298, 51);

				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						dispose();
					}
				});
			}
			{
				jLabel8 = new JLabel();
				panelFundo.add(jLabel8, new AnchorConstraint(227, 180, 282, 22, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel8.setText("Material:");
				jLabel8.setBounds(13, 49, 105, 11);
				jLabel8.setForeground(new java.awt.Color(0,0,0));
				jLabel8.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				jTextFieldIdMaterial = new JTextField();
				jTextFieldIdMaterial.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						if(arg0.getKeyCode()==116){
							TesteTabela cadastro = new TesteTabela();
							cadastro.setVisible(true);
						}
					}
				});
				jTextFieldIdMaterial.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						if(jTextFieldIdMaterial.getText()!=""){
							textFieldDescricaoMaterial.setText(BuscaDados.buscaDescricao("material", Integer.parseInt(jTextFieldIdMaterial.getText())));	
							jTextFieldUnMedida.setText(BuscaDados.buscaUnMedidaMaterial(Integer.parseInt(jTextFieldIdMaterial.getText())));
							textFieldEstoque.setText(BuscaDados.buscaQuantidadeMaterial(Integer.parseInt(jTextFieldIdMaterial.getText()))+"");
						}
					}
				});
				//jTextField13.setDocument(new DocumentoLimitado(15));
				panelFundo.add(jTextFieldIdMaterial, new AnchorConstraint(224,624,285,209,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jTextFieldIdMaterial.setBounds(125, 45, 84, 19);
			}
			{
				jTextFieldUnMedida = new JTextField();
				jTextFieldUnMedida.setEditable(false);
				//jTextField13.setDocument(new DocumentoLimitado(15));
				panelFundo.add(jTextFieldUnMedida, new AnchorConstraint(224,624,285,209,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jTextFieldUnMedida.setBounds(211, 72, 49, 19);
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
			textFieldCodigo.setEditable(false);
			textFieldCodigo.setEnabled(false);
			textFieldCodigo.setBounds(125, 15, 84, 19);
			panelFundo.add(textFieldCodigo);
			{
				textFieldDescricaoMaterial = new JTextField();
				textFieldDescricaoMaterial.setEditable(false);
				textFieldDescricaoMaterial.setBounds(211, 45, 369, 19);
				panelFundo.add(textFieldDescricaoMaterial);
			}
			{
				lblQuanitdade = new JLabel();
				lblQuanitdade.setText("Quanitdade:");
				lblQuanitdade.setForeground(Color.BLACK);
				lblQuanitdade.setFont(new Font("Century Gothic", Font.ITALIC, 12));
				lblQuanitdade.setBounds(10, 76, 105, 11);
				panelFundo.add(lblQuanitdade);
			}
			{
				textFieldQuantidade = new JTextField();
				textFieldQuantidade.setText("0");
				textFieldQuantidade.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						if (!textFieldQuantidade.getText().equals("")&&!textFieldPreco.getText().equals("")){
							Float calculo = Float.parseFloat(textFieldQuantidade.getText())  * Float.parseFloat(textFieldPreco.getText());
							textFieldPrecoTotal.setText(calculo+"");
						}
					}
				});
				textFieldQuantidade.setBounds(125, 72, 84, 19);
				panelFundo.add(textFieldQuantidade);
			}
			{
				lblPreoMedio = new JLabel();
				lblPreoMedio.setText("Pre\u00E7o:");
				lblPreoMedio.setForeground(Color.BLACK);
				lblPreoMedio.setFont(new Font("Century Gothic", Font.ITALIC, 12));
				lblPreoMedio.setBounds(10, 103, 105, 11);
				panelFundo.add(lblPreoMedio);
			}
			{
				textFieldPreco = new JTextField();
				textFieldPreco.setText("0");
				textFieldPreco.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						if (!textFieldQuantidade.getText().equals("")&&!textFieldPreco.getText().equals("")){
							Float calculo = Float.parseFloat(textFieldQuantidade.getText())  * Float.parseFloat(textFieldPreco.getText());
							textFieldPrecoTotal.setText(calculo+"");
						}
					}
				});
				textFieldPreco.setBounds(125, 99, 84, 19);
				panelFundo.add(textFieldPreco);
			}
			
			JLabel lblMovimento = new JLabel();
			lblMovimento.setText("Movimento:");
			lblMovimento.setForeground(Color.BLACK);
			lblMovimento.setFont(new Font("Century Gothic", Font.ITALIC, 12));
			lblMovimento.setBounds(265, 15, 84, 19);
			panelFundo.add(lblMovimento);
			
			textFieldIdMovimento = new JNumberField();
			textFieldIdMovimento.setEnabled(false);
			textFieldIdMovimento.setEditable(false);
			textFieldIdMovimento.setBounds(347, 15, 84, 19);
			panelFundo.add(textFieldIdMovimento);
			
			textFieldPrecoTotal = new JTextField();
			textFieldPrecoTotal.setText("0");
			textFieldPrecoTotal.setBounds(125, 125, 84, 19);
			panelFundo.add(textFieldPrecoTotal);
			
			JLabel lblPreoTotal = new JLabel();
			lblPreoTotal.setText("Pre\u00E7o total:");
			lblPreoTotal.setForeground(Color.BLACK);
			lblPreoTotal.setFont(new Font("Century Gothic", Font.ITALIC, 12));
			lblPreoTotal.setBounds(10, 129, 105, 11);
			panelFundo.add(lblPreoTotal);
			
			textFieldEstoque = new JTextField();
			textFieldEstoque.setEditable(false);
			textFieldEstoque.setBounds(382, 72, 49, 19);
			panelFundo.add(textFieldEstoque);
			
			JLabel lblEmEstoque = new JLabel();
			lblEmEstoque.setText("Em estoque:");
			lblEmEstoque.setForeground(Color.BLACK);
			lblEmEstoque.setFont(new Font("Century Gothic", Font.ITALIC, 12));
			lblEmEstoque.setBounds(298, 76, 74, 11);
			panelFundo.add(lblEmEstoque);

		}

	}
	
	public void setaIdMovimento(){
		textFieldIdMovimento.setText(idMov+"");
	}
	
	public static void setaInfosMaterial(){
		textFieldDescricaoMaterial.setText(BuscaDados.buscaDescricao("material", Integer.parseInt(jTextFieldIdMaterial.getText())));	
		jTextFieldUnMedida.setText(BuscaDados.buscaUnMedidaMaterial(Integer.parseInt(jTextFieldIdMaterial.getText())));
		textFieldEstoque.setText(BuscaDados.buscaQuantidadeMaterial(Integer.parseInt(jTextFieldIdMaterial.getText()))+"");
	}
	
	public void reload(MovimentoItem item){
		textFieldCodigo.setText(item.getId()+"");
		jTextFieldIdMaterial.setText(item.getId_material()+"");
		textFieldIdMovimento.setText(item.getId_movimento()+"");
		//jTextFieldUnMedida.setSelectedItem(item.getUnidade_medida());
		//textFieldDescricaoMaterial.setText(item.getDescricao());
		textFieldPreco.setText(item.getPreco()+"");
		textFieldPrecoTotal.setText(item.getPreco_total()+"");
		textFieldQuantidade.setText(item.getQuantidade()+"");
		
		if(jTextFieldIdMaterial.getText()!=""){
			textFieldDescricaoMaterial.setText(BuscaDados.buscaDescricao("material", Integer.parseInt(jTextFieldIdMaterial.getText())));	
			jTextFieldUnMedida.setText(BuscaDados.buscaUnMedidaMaterial(Integer.parseInt(jTextFieldIdMaterial.getText())));
			textFieldEstoque.setText(BuscaDados.buscaQuantidadeMaterial(Integer.parseInt(jTextFieldIdMaterial.getText()))+"");
		}
	}

	public void save(){
		if (Float.parseFloat(textFieldQuantidade.getText()) > Float.parseFloat(textFieldEstoque.getText())){
			JOptionPane.showMessageDialog(null,"Estoque insuficiente.");
		}else{
			Integer id_material = Integer.parseInt(jTextFieldIdMaterial.getText());
			Integer id_movimento = Integer.parseInt(textFieldIdMovimento.getText());
			Float preco = Float.parseFloat(textFieldPreco.getText());
			Float precoTotal = Float.parseFloat(textFieldPreco.getText());
			Float quantidade = Float.parseFloat(textFieldQuantidade.getText());
			if (textFieldCodigo.getText().equals("")){
				String queryInsert = "INSERT INTO movimento_item(id_movimento,id_material,quantidade,preco,preco_total) VALUES("+id_movimento+","+id_material+","+quantidade+","+preco+","+precoTotal+")";
				ConnectionUtils.executeUpdate(queryInsert);
			}
			else{
				String queryUpdate = "UPDATE material SET id_movimento = '"+id_movimento+"', id_material = '"+id_material+"', quantidade = "+quantidade+", preco = '"+preco+"', preco_total = "+precoTotal+" WHERE Id = "+textFieldCodigo.getText()+"";
				ConnectionUtils.executeUpdate(queryUpdate);
			}
			dispose();
			MovimentoItemAction.doReload();
		}
	}
}
