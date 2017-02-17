package util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CarregaProperties {

    String      arquivo;
    InputStream inputStream;

    public String getPropValues() throws IOException {

	try {
	    Properties prop = new Properties();
	    String propFileName = "arquivo.properties";

	    inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

	    if (inputStream != null) {
		prop.load(inputStream);
	    } else {
		throw new FileNotFoundException("Arquivo de Propriedade '" + propFileName + "' não encontrado");
	    }

	    arquivo = prop.getProperty("arquivo.csv");

	} catch (Exception e) {
	    System.out.println("Exception: " + e);
	} finally {
	    inputStream.close();
	}
	return arquivo;
    }
}