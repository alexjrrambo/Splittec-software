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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Action.ClienteActionn;
import Action.MaterialAction;
import Action.MovimentoAction;
import Action.MovimentoItemAction;
import Action.EstoqueAction;
import Framework.Fields.JNumberField;
import Framework.Layout.AnchorConstraint;
import Framework.Panels.JGradientPanel;
import Framework.Utils.Data.ImageUtils;
import Model.Movimento;
import Model.MovimentoItem;
import Utils.ConnectionUtils;
import Utils.DocumentoLimitado;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import Utils.BuscaDados;

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
public class CadastroMovimento extends JFrame{
	private JButton jButton1;
	private JTextField jTextField8;
	private JComboBox jComboBoxTpMovimento;
	private JTextField jTextFieldCliente;
	private JLabel jLabel8;
	private JButton jButton2;
	public static JTextField textFieldCodigo;
	private JLabel lblQuanitdade;
	private JTextField textFieldData;
	private JLabel lblPreoMedio;
	private static JPanel panelPesquisaMovimentoItem = new JPanel();
	private static Integer idMov;
	private JTextField textFieldCliente;

	/**
	 *  TODO Construtor da classe
	 *  O construtor é invocado quando a classe é criada!
	 */
	public CadastroMovimento(Integer idMovimento){
		super();
		initGUI();
		idMov=idMovimento;
	}

	/**
	 *  TODO Método responsável por construir a interface da janela.
	 */
	public void initGUI(){

		//Coloca mensagem na barra do programa
		this.setTitle("Cadastro Movimento");

		//Permite Maximizat ou não true (sim) false (não)
		this.setResizable(false);

		//Define a operação padrão ao clicar no botão 'close'
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//Serve para desenhar dentro do Panel
		this.pack();

		//Definindo o tamanho da janela
		this.setSize(858, 555);

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
			panelFundo.setPreferredSize(new java.awt.Dimension(820,75));
			{
				jLabel8 = new JLabel();
				panelFundo.add(jLabel8, new AnchorConstraint(227, 180, 282, 22, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel8.setText("Cliente:");
				jLabel8.setBounds(13, 45, 60, 11);
				jLabel8.setForeground(new java.awt.Color(0,0,0));
				jLabel8.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				jTextFieldCliente = new JTextField();
				jTextFieldCliente.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent arg0) {
						if(jTextFieldCliente.getText()!=""){
							textFieldCliente.setText(BuscaDados.buscaDescricao("cliente", Integer.parseInt(jTextFieldCliente.getText())));	
						}
					}
				});
				//jTextField13.setDocument(new DocumentoLimitado(15));
				panelFundo.add(jTextFieldCliente, new AnchorConstraint(224,624,285,209,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jTextFieldCliente.setBounds(128, 41, 84, 19);
			}
			{
				ComboBoxModel jComboBox1Model = 
						new DefaultComboBoxModel(
								new String[] {"Entrada", "Saída" });
				jComboBoxTpMovimento = new JComboBox();
				panelFundo.add(jComboBoxTpMovimento);
				jComboBoxTpMovimento.setModel(jComboBox1Model);
				jComboBoxTpMovimento.setBounds(605, 11, 114, 21);
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
				lblQuanitdade = new JLabel();
				lblQuanitdade.setText("Data:");
				lblQuanitdade.setForeground(Color.BLACK);
				lblQuanitdade.setFont(new Font("Century Gothic", Font.ITALIC, 12));
				lblQuanitdade.setBounds(474, 45, 46, 11);
				panelFundo.add(lblQuanitdade);
			}
			{
				textFieldData = new JTextField();
				textFieldData.setEditable(false);
				textFieldData.setBounds(530, 41, 189, 19);
				panelFundo.add(textFieldData);
			}
			{
				lblPreoMedio = new JLabel();
				lblPreoMedio.setText("Tipo de movimento:");
				lblPreoMedio.setForeground(Color.BLACK);
				lblPreoMedio.setFont(new Font("Century Gothic", Font.ITALIC, 12));
				lblPreoMedio.setBounds(474, 15, 128, 11);
				panelFundo.add(lblPreoMedio);
			}
			{
				textFieldCliente = new JTextField();
				textFieldCliente.setEditable(false);
				textFieldCliente.setBounds(222, 41, 198, 19);
				panelFundo.add(textFieldCliente);
			}

			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout());
			//panel.setBackground(new java.awt.Color(219,219,219));
			panel.setPreferredSize(new java.awt.Dimension(820, 400));	
			panel.add(panelPesquisaMovimentoItem);
			panelPesquisaMovimentoItem.setVisible(false);
			panelPesquisaMovimentoItem.setVisible(true);
			/*if(textFieldCodigo.getText()!=null){
				MovimentoItemAction.doReload(Integer.parseInt(textFieldCodigo.getText()));
			}else{
				//MovimentoItemAction.doReload(0);
			}*/

			{
				JPanel panel2 = new JPanel();
				getContentPane().add(panel2, BorderLayout.SOUTH);
				panel2.setLayout(null);
				//panel.setBackground(new java.awt.Color(219,219,219));
				panel2.setPreferredSize(new java.awt.Dimension(820, 50));	
				{
					jButton1 = new JButton();
					panel2.add(jButton1, new AnchorConstraint(898, 490, 1004, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButton1.setForeground(new java.awt.Color(0,0,0));
					jButton1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
					jButton1.setIcon(ImageUtils.resizeImageIcon("Imagens/Save_24x24.png",18,15));
					jButton1.setText("Salvar");
					jButton1.setFont(new java.awt.Font("Comic Sans MS",0,12));
					jButton1.setBounds(246, 0, 303, 51);

					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							save();
						}
					});
				}
				{
					jButton2 = new JButton();
					panel2.add(jButton2, new AnchorConstraint(898, 1000, 1004, 489, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jButton2.setForeground(new java.awt.Color(0,0,0));
					jButton2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0,0,0)));
					jButton2.setIcon(ImageUtils.resizeImageIcon("Imagens/Cancel_32x32.png",18,15));
					jButton2.setText("Cancelar");
					jButton2.setFont(new java.awt.Font("Comic Sans MS",0,12));
					jButton2.setBounds(551, 0, 298, 51);

					jButton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							dispose();
						}
					});
				}		
			}

		}

		new MovimentoItemAction().createTable(this, panelPesquisaMovimentoItem);
		MovimentoItemAction.doReload();
	}

	public void setaIdMovimento(){
		//textFieldCodigo.setText(idMov+"");
		CadastroMovimentoItem.idMov = idMov;
		MovimentoItem.id_movimento = idMov;
	}

	public void reload(Movimento movimento){
		textFieldCodigo.setText(movimento.getId()+"");
		jTextFieldCliente.setText(movimento.getId_cliente()+"");
		jComboBoxTpMovimento.setSelectedItem(movimento.getTipo_movimento());
		textFieldData.setText(BuscaDados.converteDataParaTela(movimento.getData_movimento()));

		if(jTextFieldCliente.getText()!=""){
			textFieldCliente.setText(BuscaDados.buscaDescricao("cliente", Integer.parseInt(jTextFieldCliente.getText())));	
		}
	}

	public void save(){
		Integer id_cliente = Integer.parseInt(jTextFieldCliente.getText());
		String tipo_movimento = jComboBoxTpMovimento.getSelectedItem()+"";
		//String data = textFieldData.getText();
		if (textFieldCodigo.getText().equals("")){
			String queryInsert = "INSERT INTO movimento(id,tipo_movimento,id_cliente,data_movimento) VALUES("+idMov+",'"+tipo_movimento+"',"+id_cliente+", now())";
			ConnectionUtils.executeUpdate(queryInsert);
			if(jComboBoxTpMovimento.getSelectedItem().equals("Entrada")){
				EstoqueAction.reprocessaEstoque(idMov, "+");
			}else{
				EstoqueAction.reprocessaEstoque(idMov, "-");
			}
		}
		else{
			String queryUpdate = "UPDATE movimento SET tipo_movimento = '"+tipo_movimento+"', id_cliente = "+id_cliente+" WHERE Id = "+textFieldCodigo.getText()+"";
			ConnectionUtils.executeUpdate(queryUpdate);
		}
		dispose();
		MovimentoAction.doReload();		
	}
}
