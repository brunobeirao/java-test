package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import interfaces.ILeitorArquivo;
import util.CarregaProperties;
import view.Calculo;

public class LeitorController implements ILeitorArquivo {

	public static CarregaProperties leituraArquivo = new CarregaProperties();
	public static Scanner lerComando = new Scanner(System.in);

	public static String comandoCountDistinct = "count distinct ";
	public static String comandoCount = "count";
	public static String comandoFilter = "filter ";

	public static void main(String[] args) throws IOException {
		aguardaComando();
	}

	private static void aguardaComando() throws IOException {
		System.out.printf("\nInforme um comando: \n");
		String comandoTeclado;
		comandoTeclado = lerComando.nextLine();
		lerComando(comandoTeclado);
	}

	private static void lerComando(String comandoTeclado) throws IOException {

		if (comandoTeclado.contains(comandoCountDistinct)) {
			comandoCountDistinct(comandoTeclado);
		}
		if (comandoTeclado.equals(comandoCount)) {
			comandoCount();
		} else if (comandoTeclado.contains(comandoFilter)) {
			comandoFilter(comandoTeclado);
		} else {
			System.out.println("Comando não encontrado!");
		}
		aguardaComando();
	}

	private static Integer comandoCountDistinct(String comandoTeclado) throws IOException, FileNotFoundException {
		
		Calculo calculo = new Calculo();
		String[] colunas = calculo.retornaColunas();
		for (String coluna : colunas) {
			if (comandoTeclado.equals(comandoCountDistinct + coluna)) {
				calculo.processaPropriedade(null, null);
				return calculo.processaDistintos(coluna);
			}
		}
		return null;
	}

	private static Integer comandoCount() throws IOException {
		Calculo calculo = new Calculo();
		return calculo.retornaQuantidadeRegistros();
	}

	private static String comandoFilter(String comandoTeclado) throws IOException{
		
		ArrayList<String[]> linhasComando = null;
		Calculo calculo = new Calculo();
		String valor = retornaValorDigitado(comandoTeclado);

		String[] colunas = calculo.retornaColunas();

		for (String coluna : colunas) {
			if (comandoTeclado.equals(comandoFilter + coluna + " " + valor)) {
				linhasComando = calculo.processaPropriedade(coluna, valor);
			}
		}
		System.out.println(Arrays.toString(colunas));

		for (String[] valoresLinhas : linhasComando) {
			System.out.println(Arrays.toString(valoresLinhas));
			return Arrays.toString(valoresLinhas);
		}
		return null;
	}

	private static String retornaValorDigitado(String comandoTeclado) {
		int posicaoTerceiroComando = comandoTeclado.lastIndexOf(" ");
		int posicaoPropriedade = comandoTeclado.indexOf(" ");

		String valor = comandoTeclado.substring(posicaoTerceiroComando + 1);
		String propriedade = comandoTeclado.substring(posicaoPropriedade + 1);
		int posicao = propriedade.indexOf(" ");

		valor = propriedade.substring(posicao + 1);
		return valor;
	}

	@Override
	public Integer getCount() throws IOException {
		return comandoCount();
	}

	@Override
	public Integer getCountDistinct(String comandoTeclado) throws IOException {
		return comandoCountDistinct(comandoTeclado);
	}

	@Override
	public String getFilter(String comandoTeclado) throws IOException {
		return comandoFilter(comandoTeclado);
	}
}