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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
public class TesteTabela extends JFrame {
	private JTextField jTextField8;
	public static Integer idMov;

	/**
	 *  TODO Construtor da classe
	 *  O construtor é invocado quando a classe é criada!
	 */
	public TesteTabela(){
		super();
		initGUI();
		//idMov=idMovimento;
	}

	/**
	 *  TODO Método responsável por construir a interface da janela.
	 */
	public void  initGUI(){

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
				DefaultTableModel modelo = new DefaultTableModel(null, new String[] {"Codigo", "Material"});
				final JTable tabela = new JTable(modelo);
				tabela.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						CadastroMovimentoItem.jTextFieldIdMaterial.setText(tabela.getValueAt(tabela.getSelectedRow(),0)+"");
						CadastroMovimentoItem.setaInfosMaterial();
						dispose();
					}
				});
				tabela.setBounds(35, 36, 545, 164);
				ResultSet rs = ConnectionUtils.executeQuery("select id as Codigo,descricao as Material from material order by descricao");
				try {
					while(rs.next()) {
					    String[] dados = new String[2];
					    dados[0] = rs.getString("Codigo");
					    dados[1] = rs.getString("Material");
					    modelo.addRow(dados);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				panelFundo.add(tabela);
			}

		}

	}
	
	public void setaIdMovimento(){
		

		
	}
}
