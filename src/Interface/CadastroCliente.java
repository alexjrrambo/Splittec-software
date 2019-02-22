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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Action.ClienteActionn;
import Framework.Fields.JNumberField;
import Framework.Layout.AnchorConstraint;
import Framework.Panels.JGradientPanel;
import Framework.Utils.Data.ImageUtils;
import Model.Cliente;
import Utils.ConnectionUtils;

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
public class CadastroCliente extends JFrame{

	private JLabel jLabel1;
	private JButton jButton1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel13;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JTextField jTextField7;
	private JTextField jTextField4;
	private JTextField jTextField5;
	private JTextField jTextField6;
	private JTextArea jTextArea1;
	private JLabel jLabel2;
	private JSeparator jSeparator1;
	private JTextField jTextField8;
	private JLabel jLabel7;
	private JComboBox Solteiro;
	private JComboBox jComboBox1;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton1;
	private JTextField jTextField13;
	private JTextField jTextField10;
	private JTextField jTextField3;
	private JTextField jTextField1;
	private JLabel jLabel14;
	private JLabel jLabel6;
	private JLabel dadosdocliente;
	private JLabel jLabel8;
	private JButton jButton2;

	/**
	 *  TODO Construtor da classe
	 *  O construtor é invocado quando a classe é criada!
	 */
	public CadastroCliente(){
		super();
		initGUI();
	}

	/**
	 *  TODO Método responsável por construir a interface da janela.
	 */
	public void initGUI(){

		//Coloca mensagem na barra do programa
		this.setTitle("Cadastro Cliente");

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
				jLabel1 = new JLabel();
				panelFundo.add(jLabel1, new AnchorConstraint(302, 245, 356, 22, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("Data de Nascimento:");
				jLabel1.setBounds(8, 69, 145, 19);
				jLabel1.setForeground(new java.awt.Color(0,0,0));
				jLabel1.setFont(new java.awt.Font("Century Gothic",2,12));
			}
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
				jLabel8.setText("Nome Completo:");
				jLabel8.setBounds(10, 49, 137, 11);
				jLabel8.setForeground(new java.awt.Color(0,0,0));
				jLabel8.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				dadosdocliente = new JLabel();
				panelFundo.add(dadosdocliente);
				dadosdocliente.setText("Dados do Cliente");
				dadosdocliente.setBounds(122, 12, 576, 66);
				dadosdocliente.setFont(new java.awt.Font("Times New Roman",2,26));
				dadosdocliente.setBounds(55, -2, 212, 43);
				dadosdocliente.setForeground(new java.awt.Color(0,0,0));
			}
			{
				jLabel4 = new JLabel();
				panelFundo.add(jLabel4);
				jLabel4.setText("CPF/CNPJ" +
						":");
				jLabel4.setBounds(7, 102, 69, 16);
				jLabel4.setForeground(new java.awt.Color(0,0,0));
				jLabel4.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				jLabel5 = new JLabel();
				panelFundo.add(jLabel5);
				jLabel5.setText("RG:");
				jLabel5.setBounds(7, 127, 58, 14);
				jLabel5.setForeground(new java.awt.Color(0,0,0));
				jLabel5.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				jLabel6 = new JLabel();
				panelFundo.add(jLabel6);
				jLabel6.setText("Categoria:");
				jLabel6.setBounds(7, 155, 95, 16);
				jLabel6.setForeground(new java.awt.Color(0,0,0));
				jLabel6.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				jLabel9 = new JLabel();
				panelFundo.add(jLabel9);
				jLabel9.setText("Rua:");
				jLabel9.setBounds(324, 46, 53, 16);
				jLabel9.setForeground(new java.awt.Color(0,0,0));
				jLabel9.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				jLabel10 = new JLabel();
				panelFundo.add(jLabel10);
				jLabel10.setText("Bairro:");
				jLabel10.setBounds(322, 72, 80, 16);
				jLabel10.setForeground(new java.awt.Color(0,0,0));
				jLabel10.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				jLabel11 = new JLabel();
				panelFundo.add(jLabel11);
				jLabel11.setText("Cidade:");
				jLabel11.setBounds(321, 95, 113, 16);
				jLabel11.setForeground(new java.awt.Color(0,0,0));
				jLabel11.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				jLabel12 = new JLabel();
				panelFundo.add(jLabel12);
				jLabel12.setText("Pais:");
				jLabel12.setBounds(323, 117, 57, 16);
				jLabel12.setForeground(new java.awt.Color(0,0,0));
				jLabel12.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				jLabel13 = new JLabel();
				panelFundo.add(jLabel13);
				jLabel13.setText("Apartamento:");
				jLabel13.setBounds(322, 139, 103, 16);
				jLabel13.setForeground(new java.awt.Color(0,0,0));
				jLabel13.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				jLabel14 = new JLabel();
				panelFundo.add(jLabel14);
				jLabel14.setText("Endereço do Cliente");
				jLabel14.setBounds(339, -9, 274, 55);
				jLabel14.setFont(new java.awt.Font("Times New Roman",2,26));
				jLabel14.setForeground(new java.awt.Color(0,0,0));
			}
			{
				jTextField1 = new JTextField();
				panelFundo.add(jTextField1, new AnchorConstraint(224,624,285,209,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jTextField1.setBounds(154, 69, 132, 20);
			}
			{
				jTextField3 = new JTextField();
				panelFundo.add(jTextField3, new AnchorConstraint(224,624,285,209,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jTextField3.setBounds(376, 92, 187, 19);
			}
			{
				jTextField4 = new JTextField();
				panelFundo.add(jTextField4, new AnchorConstraint(224,624,285,209,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jTextField4.setBounds(364, 69, 200, 19);
			}
			{
				jTextField7 = new JNumberField();
				panelFundo.add(jTextField7, new AnchorConstraint(224,624,285,209,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jTextField7.setBounds(102, 126, 182, 18);
			}
			{
				jTextField5 = new JTextField();
				panelFundo.add(jTextField5, new AnchorConstraint(224,624,285,209,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jTextField5.setBounds(362, 43, 202, 20);
			}
			{
				jTextField10 = new JTextField();
				panelFundo.add(jTextField10, new AnchorConstraint(224,624,285,209,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jTextField10.setBounds(103, 101, 181, 19);
			}
			{
				jTextField13 = new JTextField();
				panelFundo.add(jTextField13, new AnchorConstraint(224,624,285,209,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jTextField13.setBounds(128, 45, 158, 19);
			}
			{
				jRadioButton1 = new JRadioButton();
				panelFundo.add(jRadioButton1);
				jRadioButton1.setText("Sim");
				jRadioButton1.setBounds(430, 141, 54, 13);
				jRadioButton1.setFont(new java.awt.Font("Century Gothic",2,12));
				jRadioButton1.setAutoscrolls(true);
				jRadioButton1.setOpaque(false);
			}
			{
				jRadioButton2 = new JRadioButton();
				panelFundo.add(jRadioButton2);
				jRadioButton2.setText("Não");
				jRadioButton2.setBounds(484, 140, 54, 14);
				jRadioButton2.setFont(new java.awt.Font("Century Gothic",2,12));
				jRadioButton2.setAutoscrolls(true);
				jRadioButton2.setOpaque(false);
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "Brasil", "Argentina", "Argentina", "Bolivia", "Paraguai", "Uruguai", "Chile", "Mexico", "EUA", "Africa", "Japão", "China", "Australia" });
				jComboBox1 = new JComboBox();
				panelFundo.add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(361, 116, 174, 21);
			}
			{
				ComboBoxModel SolteiroModel = new DefaultComboBoxModel(new String[] { "Cliente", "Fornecedor" });
				Solteiro = new JComboBox();
				panelFundo.add(Solteiro);
				Solteiro.setModel(SolteiroModel);
				Solteiro.setBounds(102, 151, 182, 22);
			}

			{
				jLabel7 = new JLabel();
				panelFundo.add(jLabel7);
				jLabel7.setText("Código:");
				jLabel7.setFont(new java.awt.Font("Century Gothic",2,12));
				jLabel7.setForeground(new java.awt.Color(0,0,0));
				jLabel7.setBounds(321, 164, 113, 16);
			}
			{
				jTextField6 = new JTextField();
				panelFundo.add(jTextField6);
				jTextField6.setBounds(376, 164, 185, 19);
				jTextField6.setEnabled(false);
			}
			{
				jSeparator1 = new JSeparator();
				panelFundo.add(jSeparator1);
				jSeparator1.setBounds(302, 4, 10, 189);
				jSeparator1.setOpaque(false);
				jSeparator1.setOrientation(SwingConstants.VERTICAL);
			}
			{
				jLabel2 = new JLabel();
				panelFundo.add(jLabel2);
				jLabel2.setText("Ultimos servicos feitos:");
				jLabel2.setFont(new java.awt.Font("Century Gothic",2,12));
				jLabel2.setForeground(new java.awt.Color(0,0,0));
				jLabel2.setBounds(7, 212, 140, 16);
			}
			{
				jTextArea1 = new JTextArea();
				panelFundo.add(jTextArea1);
				jTextArea1.setBounds(36, 240, 557, 110);
			}

		}

	}
	public void reload(Cliente cliente){
		jTextField13.setText(cliente.getNomedoCliente());
		jTextField5.setText(cliente.getRua());
		jTextField3.setText(cliente.getCidade());
		jTextField4.setText(cliente.getBairro());
		Solteiro.setSelectedItem(cliente.getEstadocivil());
		jRadioButton1.setSelected(new Boolean(cliente.getSim()));
		jRadioButton2.setSelected(new Boolean(cliente.getNao()));
		jComboBox1.setSelectedItem(cliente.getPais());
		jTextField1.setText(cliente.getData());
		jTextField10.setText(cliente.getCpf()+"");
		jTextField7.setText(cliente.getRg()+"");
		jTextField6.setText(cliente.getId()+"");
		jTextArea1.setText(cliente.getObs());
	}

	public void save(){
		String nome = jTextField13.getText();
		String rua = jTextField5.getText();
		String cidade = jTextField3.getText();
		String bairro = jTextField4.getText();
		String estadocivil = Solteiro.getSelectedItem()+"";
		String pais = jComboBox1.getSelectedItem()+"";
		String sim = jRadioButton1.isSelected()+"";
		String nao = jRadioButton2.isSelected()+"";
		String data = jTextField1.getText();
		String cpf = jTextField10.getText();
		String rg = jTextField7.getText();
		String obs = jTextArea1.getText();
		
		if (jTextField6.getText().equals("")){
			String queryInsert = "INSERT INTO cliente(nomedocliente,rua,bairro,cidade,estadocivil,sim,nao,data,cpf,rg,pais,obs)VALUES('"+nome+"','"+rua+"','"+bairro+"','"+cidade+"','"+estadocivil+"','"+sim+"','"+nao+"','"+data+"','"+cpf+"','"+rg+"','"+pais+"','"+obs+"')";
			ConnectionUtils.executeUpdate(queryInsert);
		}
		else{
			String queryUpdate = "UPDATE cliente SET nomedocliente = '"+nome+"', rua = '"+rua+"', bairro = '"+bairro+"', cidade = '"+cidade+"', estadocivil = '"+estadocivil+"', sim = '"+sim+"', nao = '"+nao+"', data = '"+data+"', cpf = '"+cpf+"', rg = '"+rg+"', pais = '"+pais+"', obs = '"+obs+"' WHERE Id = "+jTextField6.getText()+"";
			ConnectionUtils.executeUpdate(queryUpdate);
		}
		dispose();
		ClienteActionn.doReload();
	}

}
