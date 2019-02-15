package Utils;

import java.awt.Image;
import java.awt.print.PrinterJob;
import java.io.File;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

/**
 *  @author Bruno Konzen Stahl
 *  @since 13/10/2010
 */
public class BarCodeUtils {

	public static Barcode getBarcode(String code){
		try {
			return BarcodeFactory.createCode128B(code);
		} catch (BarcodeException e){
			e.printStackTrace();
		}
		return null;
	}

	public static Image getImage(String code){
		try {
			return BarcodeImageHandler.getImage(getBarcode(code));
		} catch (OutputException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveBarcodeImage(String code, String outputFolder){
		try {
			File f = new File(outputFolder);
			BarcodeImageHandler.savePNG(getBarcode(code), f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printBarCode(String code){

		try{
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(getBarcode(code));
			if (job.printDialog()){
				job.print();
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}