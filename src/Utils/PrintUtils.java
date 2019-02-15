package Utils;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.StringTokenizer;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.JobName;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;

import Framework.Constants;
import Framework.Utils.Data.DateUtils;

/**
 * @author Bruno Konzen Stahl
 * @since 15/05/2008
 */
public class PrintUtils implements Printable { 

	private Font font = new java.awt.Font("Lucida Console",0,10);
	private Color color = Color.black;

	private String text;
	private PrinterJob pj;

	public PrintUtils(){
		new PrintUtils(null);
	}

	public PrintUtils(String namePrint){

		try {
			pj = PrinterJob.getPrinterJob(); 
			pj.setPrintable(this); 

			PrintService[] services = PrinterJob.lookupPrintServices(); 

			if (services.length > 0){ 

				//--Localizando impressora padrão--
				if (namePrint!=null) {
					for (int i = 0; i < services.length; i++) {
						if(services[i].getName().equals(namePrint)){
							pj.setPrintService(services[i]);
						}
					}
				}

				if(pj.getPrintService()==null){

					try { 
						pj.setPrintService(services[0]); 
						pj.printDialog();
						String name = pj.getPrintService().getName().toString();
						try {
							PropertiesUtils propertiesManager = new PropertiesUtils(Constants.propertiesFilename);
							propertiesManager.setProperty("defaultPrint", name);
							Constants.defaultPrint = name;
						} catch (Throwable e){
							e.printStackTrace();
						}

					} catch (PrinterException pe) { 
						System.err.println(pe); 
					} 
				}
			}

		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}

	public void print(String text) throws PrintException{

		if(pj.getPrintService()!=null){
			text+= "\n\n\n\n\n\n\n\n";
			DocPrintJob dpj = pj.getPrintService().createPrintJob();
			InputStream stream = new ByteArrayInputStream(text.getBytes());

			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
			Doc doc = new SimpleDoc(stream, flavor, null);
			dpj.print(doc, null);
		}
	}

	public void prints(PrintRequestAttributeSet aset, String text){

		if(pj.getPrintService()!=null){
			this.text = text;

			if(aset==null){
				aset = getDefaultModel(DateUtils.getSqlDate());
				pj.pageDialog(aset);
				pj.printDialog(aset);
			}

			try {
				pj.print(aset);
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
	}

	public static PrintRequestAttributeSet getDefaultModel(String title){
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet(); 
		aset.add(OrientationRequested.PORTRAIT); 
		aset.add(new Copies(1)); 
		aset.add(new JobName(title, null)); 
		return aset;
	}

	public static PrintRequestAttributeSet getBematechModel(String title){
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet(); 
		aset.add(OrientationRequested.PORTRAIT); 
		aset.add(new Copies(1)); 
		aset.add(new JobName(title, null));
		aset.add(MediaSizeName.LEDGER); 
		aset.add(new MediaPrintableArea(0, 0, 140, 1000,MediaPrintableArea.MM));
		return aset;
	}

	/** 
	 * Método necessário quando a interface Printable é implementada. 
	 */ 
	public int print(Graphics g, PageFormat pf, int pageIndex) { 

		if (pageIndex == 0) { 

			Graphics2D g2d = (Graphics2D) g; 
			g2d.translate(pf.getImageableX(), pf.getImageableY()); 

			g2d.setFont(font);
			g2d.setColor(color); 

			StringTokenizer lista = new StringTokenizer(text);

			int linha = 15;

			while (lista.hasMoreTokens()) {
				String tt = lista.nextToken("\n");
				if(!tt.equals("")){
					g2d.drawString(tt, 10, linha);
					linha = linha + 15;
				}
				else{
					linha = linha + 200;
				}
			}
			return Printable.PAGE_EXISTS; 
		} else { 
			return Printable.NO_SUCH_PAGE; 
		} 
	}

	public static void setDefaultPrint(){
		PrinterJob pj = PrinterJob.getPrinterJob(); 
		if(pj.printDialog()){
			String name = pj.getPrintService().getName().toString();
			try {
				PropertiesUtils propertiesManager = new PropertiesUtils(Constants.propertiesFilename);
				propertiesManager.setProperty("defaultPrint", name);
				Constants.defaultPrint = name;
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	} 
}