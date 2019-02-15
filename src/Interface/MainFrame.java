package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import Action.ClienteActionn;
import Action.MaterialAction;
import Action.MovimentoAction;
import Framework.Utils.Data.ImageUtils;
import Utils.ConnectionUtils;
import Utils.FerramentasUtils;
import Utils.PropertiesUtils;
import Utils.UtilsDateHora;

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
 *  @author Alex Junior Rambo
 *  @since 10/02/2013
 */
public class MainFrame extends JFrame{
	private static JPanel panelHome;
	private JMenuBar Arquivo;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private static JPanel panelPesquisaCliente = new JPanel();
	private static JPanel panelPesquisaMaterial = new JPanel();
	private static JPanel panelPesquisaMovimento = new JPanel();
	private JMenuItem jMenuItem15;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuItem3;
	private JMenu jMenu3;
	private JMenuItem jMenuItem8;
	private JMenuItem jMenuItem14;
	private JMenuItem jMenuItem7;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem5;
	private JPanel jPanel1;
	private JPanel jPanelPrincipal;
	private JLabel lblMateriaisComPouco;
	private JTable tabela;

	/**
	 *  TODO Inicio do programa
	 *  Não podemos trabalhar estaticamente, 
	 *  será necessário criar uma instância para cada janela.
	 */
	public static void main(String[] args){
		setLook();
		
		ConnectionUtils.openConnection("localhost","financeiro","root","001993");


				MainFrame main = new MainFrame();
				main.setVisible(true);	

	}

	public static void setLook(){

		PropertiesUtils utils = new PropertiesUtils("Properties.txt");

		//Muda a fonte do programa
		Font fonte = new Font(utils.getProperty("font"), Font.PLAIN, 10);
		UIManager.put("Label.font", fonte);
		UIManager.put("Button.font", fonte);
		UIManager.put("ComboBox.font", fonte);
		UIManager.put("TextField.font", fonte);
		UIManager.put("TextArea.font", fonte);
		UIManager.put("CheckBox.font", fonte);
		UIManager.put("MenuBar.font", fonte);
		UIManager.put("MenuItem.font", fonte);
		UIManager.put("Menu.font", fonte);
		UIManager.put("RadioButton.font", fonte);
		UIManager.put("TabbedPane.font", fonte);
		UIManager.put("TitledBorder.font", fonte);
		UIManager.put("Spinner.font", fonte);
	}

	/**
	 *  TODO Construtor da classe
	 *  O construtor é invocado quando a classe é criada!
	 */
	public MainFrame(){
		super();
		initGUI();
	}

	/**
	 *  TODO Método responsável por construir a interface da janela.
	 */
	public void initGUI(){

		//Coloca texto na barra do programa
		this.setTitle("Software SplitTec.             v2.0");

		//Permite Redimencionar
		this.setResizable(true);

		//Define a operação padrão ao clicar no botão 'close'
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();

		//Definindo o tamanho da janela
		this.setSize(1280, 768);
		this.setMinimumSize(new Dimension(400, 200));

		//Obtendo resolução da tela
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		//Centralizando janela na tela obtida
		this.setLocation((d.width/2)-(this.getWidth()/2),(d.height/2)-(this.getHeight()/2));
		this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Imagens/Globe_32x32.png")).getImage());

		{
			Arquivo = new JMenuBar();
			setJMenuBar(Arquivo);
			{
				jMenu1 = new JMenu();
				Arquivo.add(jMenu1);
				jMenu1.setText("Arquivo");

				{
					jMenuItem4 = new JMenuItem();
					jMenu1.add(jMenuItem4);
					jMenuItem4.setText("Sair");
					jMenuItem4.setIcon(ImageUtils.resizeImageIcon("Imagens/exit-3.png",25,25));

					jMenuItem4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							//Ao clicar em sair o programa fecha
							dispose();
						}
					});

				}

				{
					jMenuItem15 = new JMenuItem();
					jMenu1.add(jMenuItem15);
					jMenuItem15.setText("Tela Inicial");
					jMenuItem15.setIcon(ImageUtils.resizeImageIcon("Imagens/icone-home.png",27,27));

					jMenuItem15.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {

							getContentPane().removeAll();
							getContentPane().add(jPanelPrincipal);
							jPanelPrincipal.setVisible(false);							
							jPanelPrincipal.setVisible(true);
							jPanel1.remove(tabela);
							{
								DefaultTableModel modelo = new DefaultTableModel(null, new String[] {"Material", "Quantidade"});
								tabela = new JTable(modelo);
								//tabela.setBounds(600, 181, 545, 164);
								ResultSet rs = ConnectionUtils.executeQuery("select descricao as Material,quantidade as Quantidade,unidade_medida from material where quantidade<=qtd_minima");
								try {
									while(rs.next()) {
									    String[] dados = new String[2];
									    dados[0] = rs.getString("Material");
									    dados[1] = rs.getString("Quantidade")+" "+rs.getString("unidade_medida");
									    modelo.addRow(dados);
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								jPanel1.add(tabela);
							}
							
						}
					});

				}
				{
					jMenu2 = new JMenu();
					Arquivo.add(jMenu2);
					jMenu2.setText("Cadastros");

					{
						jMenuItem2 = new JMenuItem();
						jMenu2.add(jMenuItem2);
						jMenuItem2.setText("Pesquisa Cliente");
						jMenuItem2.setIcon(ImageUtils.resizeImageIcon("Imagens/canstock11432632.png",30,30));

						jMenuItem2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								getContentPane().removeAll();
								getContentPane().add(panelPesquisaCliente);
								panelPesquisaCliente.setVisible(false);
								panelPesquisaCliente.setVisible(true);
							}
						});

					}
					
					{
						jMenuItem3 = new JMenuItem();
						jMenu2.add(jMenuItem3);
						jMenuItem3.setText("Pesquisa Material");
						jMenuItem3.setIcon(ImageUtils.resizeImageIcon("Imagens/palet-02-icon.png",30,30));

						jMenuItem3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								getContentPane().removeAll();
								getContentPane().add(panelPesquisaMaterial);
								panelPesquisaMaterial.setVisible(false);
								panelPesquisaMaterial.setVisible(true);
							}
						});

					}
					
					{
						jMenuItem5 = new JMenuItem();
						jMenu2.add(jMenuItem5);
						jMenuItem5.setText("Pesquisa Movimento");
						jMenuItem5.setIcon(ImageUtils.resizeImageIcon("Imagens/pallet2.png",30,30));

						jMenuItem5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								getContentPane().removeAll();
								getContentPane().add(panelPesquisaMovimento);
								panelPesquisaMovimento.setVisible(false);
								panelPesquisaMovimento.setVisible(true);
							}
						});

					}

					{
						jMenu3 = new JMenu();
						Arquivo.add(jMenu3);
						jMenu3.setText("Ferramentas");

						{
							jMenuItem7 = new JMenuItem();
							jMenu3.add(jMenuItem7);
							jMenuItem7.setText("Calculadora");
							jMenuItem7.setIcon(ImageUtils.resizeImageIcon("Imagens/3031_128x128.png",25,25));

							jMenuItem7.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									FerramentasUtils.openCalc();
								}
							});
						}
						{
							jMenuItem8 = new JMenuItem();
							jMenu3.add(jMenuItem8);
							jMenuItem8.setText("Bloco de Notas");
							jMenuItem8.setIcon(ImageUtils.resizeImageIcon("Imagens/NotePad_128.png",25,25));

							jMenuItem8.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									FerramentasUtils.openBN();

								}
							});
						}
						{
							jMenuItem14 = new JMenuItem();
							jMenu3.add(jMenuItem14);
							jMenuItem14.setText("Hora / Date");
						}
						//Novo menu pra ver horas
						jMenuItem14.setIcon(ImageUtils.resizeImageIcon("Imagens/icone-relogio2.jpg",25,25));
						jMenuItem14.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {

								ImageIcon icon = ImageUtils.resizeImageIcon("Imagens/alarmclock.png",29,29);

								//Colocar algo junto com a mensagem na tela, String >teste< = >Nomeclasse<.get>Metodo<();
								//Depois é só colocar a String >teste< junto do + ao lado da mensagem
								String hora = UtilsDateHora.getFormatTime();
								String date = UtilsDateHora.getFormatDate();
								JOptionPane.showConfirmDialog(null,"Horario de Brasilia \n" + hora + "\n"+ "Data \n" + date,"Horario",0,0,icon);

							}

						});
					}
					{
						
						
						jPanelPrincipal = new JPanel();
						this.getContentPane().add(jPanelPrincipal);
						jPanelPrincipal.setPreferredSize(new java.awt.Dimension(260, 50));	
						jPanelPrincipal.setOpaque(false);
						jPanelPrincipal.setLayout(new BorderLayout());

						//Coloca imagem no panel fundo
						//panelHome = new JPanel();
						ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Imagens/planodefundo.jpg"));
						panelHome = new JPanelImage(icon.getImage());
						jPanelPrincipal.add(panelHome, BorderLayout.CENTER);
						panelHome.setLayout(new BorderLayout());


						{
							
							jPanel1 = new JPanel();
							jPanelPrincipal.add(jPanel1,BorderLayout.EAST);
							jPanel1.setPreferredSize(new java.awt.Dimension(260, 50));	
							jPanel1.setOpaque(false);
							jPanel1.setLayout(new BorderLayout());
							
							{
								DefaultTableModel modelo = new DefaultTableModel(null, new String[] {"Material", "Quantidade"});
								tabela = new JTable(modelo);
								//tabela.setBounds(600, 181, 545, 164);
								ResultSet rs = ConnectionUtils.executeQuery("select descricao as Material,quantidade as Quantidade,unidade_medida from material where quantidade<=qtd_minima");
								try {
									while(rs.next()) {
									    String[] dados = new String[2];
									    dados[0] = rs.getString("Material");
									    dados[1] = rs.getString("Quantidade")+" "+rs.getString("unidade_medida");
									    modelo.addRow(dados);
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								jPanel1.add(tabela);
							}
							{
								lblMateriaisComPouco = new JLabel("MATERIAIS COM POUCO ESTOQUE");
								lblMateriaisComPouco.setFont(new Font("Arial", Font.BOLD, 15));
								lblMateriaisComPouco.setForeground(new java.awt.Color(0,0,0));
								jPanel1.add(lblMateriaisComPouco, BorderLayout.NORTH);

							}
							
							{
								/*	ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("Imagens/fundo.jpg"));
								JLabel label = new JLabel();
								label.setIcon(icon);   
								panelHome.add(label, BorderLayout.CENTER);  
								label.setOpaque(false);
								label.setLayout(null);*/
								
								JButton jButton2 = new JButton();
								jButton2.setHorizontalAlignment(SwingConstants.LEFT);
								panelHome.add(jButton2, BorderLayout.SOUTH);
								jButton2.setText("Pesquisa Cliente");
								jButton2.setFont(new Font("Arial", Font.ITALIC, 20));
								jButton2.setBounds(245, 345, 280, 85);
								//Deixa o botão da cor do panel
								jButton2.setContentAreaFilled(false);
								jButton2.setBorderPainted(false);
								jButton2.setFocusable(false);
								jButton2.setForeground(new java.awt.Color(0,0,0));
								jButton2.setIcon(ImageUtils.resizeImageIcon("Imagens/canstock11432632.png",70,70));
								jButton2.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										getContentPane().removeAll();
										getContentPane().add(panelPesquisaCliente);
										panelPesquisaCliente.setVisible(false);
										panelPesquisaCliente.setVisible(true);
										ClienteActionn.doReload();


									}
								});
								JButton jButton3 = new JButton();
								jButton3.setHorizontalAlignment(SwingConstants.LEFT);
								panelHome.add(jButton3);
								jButton3.setText("Pesquisa Material");
								jButton3.setFont(new Font("Arial", Font.ITALIC, 20));
								jButton3.setBounds(245, 100, 280, 85);
								//Deixa o botão da cor do panel
								jButton3.setContentAreaFilled(false);
								jButton3.setBorderPainted(false);
								jButton3.setFocusable(false);
								jButton3.setForeground(new java.awt.Color(0,0,0));
								jButton3.setIcon(ImageUtils.resizeImageIcon("Imagens/palet-02-icon.png",70,70));
								jButton3.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										getContentPane().removeAll();
										getContentPane().add(panelPesquisaMaterial);
										panelPesquisaMaterial.setVisible(false);
										panelPesquisaMaterial.setVisible(true);
										MaterialAction.doReload();


									}
								});
								
								JButton jButton4 = new JButton();
								jButton4.setHorizontalAlignment(SwingConstants.LEFT);
								jButton4.setVerticalAlignment(SwingConstants.TOP);
								panelHome.add(jButton4, BorderLayout.NORTH);
								jButton4.setText("Pesquisa Movimento");
								jButton4.setFont(new Font("Arial", Font.ITALIC, 20));
								//jButton4.setBounds(245, 500, 280, 85);
								//Deixa o botão da cor do panel
								jButton4.setContentAreaFilled(false);
								jButton4.setBorderPainted(false);
								jButton4.setFocusable(false);
								jButton4.setForeground(new java.awt.Color(0,0,0));
								jButton4.setIcon(ImageUtils.resizeImageIcon("Imagens/pallet2.png",70,70));
								jButton4.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										getContentPane().removeAll();
										getContentPane().add(panelPesquisaMovimento);
										panelPesquisaMovimento.setVisible(false);
										panelPesquisaMovimento.setVisible(true);
										MovimentoAction.doReload();


									}
								});



							}

						}


					}
					/**
					 *  TODO MUITO IMPORTANTE
					 *  A classe Action é o coração da Interface Gráfica!
					 *  É através dela que é realizada todas as operações de banco de dados.
					 */

					new ClienteActionn().createTable(this, panelPesquisaCliente);
					new MaterialAction().createTable(this, panelPesquisaMaterial);
					new MovimentoAction().createTable(this, panelPesquisaMovimento);


				}
			}

		}
	}
}