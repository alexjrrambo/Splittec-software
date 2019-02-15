package Utils;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;

/**
 *  @author Bruno Konzen Stahl
 *  @since 15/05/2008
 */
@SuppressWarnings("unchecked")
public class ReportUtils {

	private String title;
	private ArrayList<JasperPrint> listReport = new ArrayList<JasperPrint>();

	public ReportUtils(String title){
		this.title = title;
	}

	public void addReport(String jasperDir, Map parameters){
		Vector vetor = new Vector();
		vetor.addElement("");
		addReport(jasperDir,parameters,vetor);
	}

	public void addReport(String jasperDir, Map parameters, List lista){

		try{
			parameters.put("TITULO",title);
			URL diretorio = ReportUtils.class.getClassLoader().getResource(jasperDir);
			JasperReport jasperReport = (JasperReport)	JRLoader.loadObject(diretorio);

			JRBeanCollectionDataSource jr = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lista);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jr);
			listReport.add(jasperPrint);
		} catch(JRException jre){
			jre.printStackTrace();
		}
	}

	public void createReport(){

		//---Agrupando páginas do relatório---
		for (int i = 1; i < listReport.size(); i++) {
			JasperPrint jasperPrint = listReport.get(i);
			List<JRPrintPage> pages = jasperPrint.getPages();
			for (int count = 0; count < pages.size(); count++){
				listReport.get(0).addPage(pages.get(count));  
			}
		}

		//---Iniciando interface gráfica---
		JRViewer viewer = new JRViewer(listReport.get(0));      

		JFrame dialog = new JFrame();
		dialog.setTitle(title);
		dialog.setContentPane(viewer);
		dialog.setSize(800,600);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		dialog.setLocation((d.width/2)-(dialog.getWidth()/2),(d.height/2)-(dialog.getHeight()/2));

		dialog.setTitle(title);
		dialog.setIconImage(new ImageIcon(ReportUtils.class.getClassLoader().getResource("Framework/Imagens/report.png")).getImage());
		dialog.setExtendedState(Frame.MAXIMIZED_BOTH);
		dialog.setVisible(true);
	}
}