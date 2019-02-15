package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe responsável gerenciar o acesso a informações em arquivos de propriedades.
 * @author brunokonzen
 */

public class PropertiesUtils {

	private Properties properties; 
	private String filename;

	/**
	 * Construtor responsável pela inicialização dos campos da classe. 
	 * @param filename Nome do arquivo .properties
	 * @throws Throwable Aborta a criação do objeto caso não consiga inicializar/carregar o arquivo de propriedades
	 */
	public PropertiesUtils(String filename){
		try {
			this.filename = filename;
			this.properties = loadProperties();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
	}
	
	private File getFile() throws IOException {
		
		File file = new File(filename);
		
		if (!file.exists()) {
			file.createNewFile();
		}	
		return file;
	}
	
	private Properties loadProperties() throws Throwable {
		Properties properties = new Properties();
		try {
			File file = getFile();
			properties.load(new FileInputStream(file));
		} catch (Throwable e) {
			e.printStackTrace();
			throw e;
		}
		return properties;
	}
	
	public void saveProperties() {
		try {
			File file = getFile();
			properties.store(new FileOutputStream(file), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setProperty(String key, String value) {
		properties.setProperty(key, value);
		saveProperties();
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}	
}