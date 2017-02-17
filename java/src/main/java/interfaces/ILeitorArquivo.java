package interfaces;

import java.io.IOException;

public interface ILeitorArquivo {

	Integer getCount() throws IOException;

	Integer getCountDistinct(String comandoTeclado) throws IOException;

	String getFilter(String comandoTeclado) throws IOException;

}
