package view;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.Tabela;

public class Calculo {
	Integer calculoDiferentes;

	Tabela tabela = new Tabela();

	public static Scanner lerComando = new Scanner(System.in);
	public static String[] colunas = null;

	public Integer processaDistintos(String coluna) {

		switch (coluna) {
		case "ibge_id":
			return valoresDistintos(Tabela.getIbge_id(), coluna);
		case "uf":
			return valoresDistintos(Tabela.getUf(), coluna);
		case "name":
			return valoresDistintos(Tabela.getName(), coluna);
		case "capital":
			return valoresDistintos(Tabela.getCapital(), coluna);
		case "lon":
			return valoresDistintos(Tabela.getLon(), coluna);
		case "lat":
			return valoresDistintos(Tabela.getLat(), coluna);
		case "no_accents":
			return valoresDistintos(Tabela.getNo_accents(), coluna);
		case "alternative_names":
			return valoresDistintos(Tabela.getAlternative_names(), coluna);
		case "microregion":
			return valoresDistintos(Tabela.getMicroregion(), coluna);
		case "mesoregion":
			return valoresDistintos(Tabela.getMesoregion(), coluna);

		default:
			break;
		}
		return null;
	}

	public Integer valoresDistintos(ArrayList<String> valores, String coluna) {
		String[] distintos = new String[valores.size()];
		int quantidade = 0;
		for (int i = 0; i < valores.size(); i++) {
			boolean existe = false;
			for (int j = 0; j < quantidade; j++) {
				if (distintos[j].equals(valores.get(i))) {
					existe = true;
					break;
				}
			}
			if (!existe) {
				distintos[quantidade++] = valores.get(i);
			}
		}
		distintos = Arrays.copyOf(distintos, quantidade);
		System.out.println("Existem " + (distintos.length - 1) + " resultados diferentes para coluna " + coluna + ".");
		return (distintos.length - 1);
	}

	public ArrayList<String[]> processaPropriedade(String propriedade, String valor)
			throws IOException, FileNotFoundException {

		ArrayList<String> ibge_id = new ArrayList<String>();
		ArrayList<String> uf = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> capital = new ArrayList<String>();
		ArrayList<String> lon = new ArrayList<String>();
		ArrayList<String> lat = new ArrayList<String>();
		ArrayList<String> no_accents = new ArrayList<String>();
		ArrayList<String> alternative_names = new ArrayList<String>();
		ArrayList<String> microregion = new ArrayList<String>();
		ArrayList<String> mesoregion = new ArrayList<String>();

		ArrayList<String[]> linhasComando = new ArrayList<String[]>();

		String separador = ",";
		BufferedReader arquivo = retornaArquivo();
		int quantidadeColunas = retornaColunas().length;

		if (propriedade != null && valor != null) {
			calculaPropriedadeValor(valor, ibge_id, uf, name, capital, lon, lat, no_accents, alternative_names,
					microregion, mesoregion, linhasComando, separador, quantidadeColunas, arquivo);
		} else {
			calculaDistintos(valor, ibge_id, uf, name, capital, lon, lat, no_accents, alternative_names, microregion,
					mesoregion, linhasComando, separador, quantidadeColunas, arquivo);
		}
		return linhasComando;
	}

	private void calculaPropriedadeValor(String valor, ArrayList<String> ibge_id, ArrayList<String> uf,
			ArrayList<String> name, ArrayList<String> capital, ArrayList<String> lon, ArrayList<String> lat,
			ArrayList<String> no_accents, ArrayList<String> alternative_names, ArrayList<String> microregion,
			ArrayList<String> mesoregion, ArrayList<String[]> linhasComando, String separador, int quantidadeColunas,
			BufferedReader arquivo) throws IOException {

		String linha;

		while ((linha = arquivo.readLine()) != null) {
			String[] linhas = linha.split(separador);

			for (int i = 0; i < quantidadeColunas; i++) {

				switch (i) {
				case 0:
					if (linhas[i].contains(valor)) {
						ibge_id.add(linhas[i]);
						linhasComando.add(linhas);
					}
					break;
				case 1:
					if (linhas[i].contains(valor)) {
						uf.add(linhas[i]);
						linhasComando.add(linhas);
					}
					break;
				case 2:
					if (linhas[i].contains(valor)) {
						name.add(linhas[i]);
						linhasComando.add(linhas);
					}
					break;
				case 3:
					if (linhas[i].contains(valor)) {
						capital.add(linhas[i]);
						linhasComando.add(linhas);
					}
					break;
				case 4:
					if (linhas[i].contains(valor)) {
						lon.add(linhas[i]);
						linhasComando.add(linhas);
					}
					break;
				case 5:
					if (linhas[i].contains(valor)) {
						lat.add(linhas[i]);
						linhasComando.add(linhas);
					}
					break;
				case 6:
					if (linhas[i].contains(valor)) {
						no_accents.add(linhas[i]);
						linhasComando.add(linhas);
					}
					break;
				case 7:
					if (linhas[i].contains(valor)) {
						alternative_names.add(linhas[i]);
						linhasComando.add(linhas);
					}
					break;
				case 8:
					if (linhas[i].contains(valor)) {
						microregion.add(linhas[i]);
						linhasComando.add(linhas);
					}
					break;
				case 9:
					if (linhas[i].contains(valor)) {
						mesoregion.add(linhas[i]);
						linhasComando.add(linhas);
					}
					break;

				default:
					break;
				}
			}
		}
	}

	private void calculaDistintos(String valor, ArrayList<String> ibge_id, ArrayList<String> uf, ArrayList<String> name,
			ArrayList<String> capital, ArrayList<String> lon, ArrayList<String> lat, ArrayList<String> no_accents,
			ArrayList<String> alternative_names, ArrayList<String> microregion, ArrayList<String> mesoregion,
			ArrayList<String[]> linhasComando, String separador, int quantidadeColunas, BufferedReader arquivo)
			throws IOException {

		String linha;
		int quantidadeLinhas = 0;

		while ((linha = arquivo.readLine()) != null) {
			String[] linhas = linha.split(separador);

			for (int i = 0; i < quantidadeColunas; i++) {

				switch (i) {
				case 0:
					ibge_id.add(linhas[i]);
					break;
				case 1:
					uf.add(linhas[i]);
					break;
				case 2:
					name.add(linhas[i]);
					break;
				case 3:
					capital.add(linhas[i]);
					break;
				case 4:
					lon.add(linhas[i]);
					break;
				case 5:
					lat.add(linhas[i]);
					break;
				case 6:
					no_accents.add(linhas[i]);
					break;
				case 7:
					alternative_names.add(linhas[i]);
					break;
				case 8:
					microregion.add(linhas[i]);
					break;
				case 9:
					mesoregion.add(linhas[i]);
					break;

				default:
					break;
				}
				quantidadeLinhas++;
			}
		}
		setaValores(quantidadeLinhas, ibge_id, uf, name, capital, lon, lat, no_accents, alternative_names, microregion,
				mesoregion);
	}

	public BufferedReader retornaArquivo() throws IOException {
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+ "/resources/cidades.csv");
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader bufferedReader = new BufferedReader(reader);
		return bufferedReader;
	}

	public String[] retornaColunas() throws IOException {
		BufferedReader br = retornaArquivo();
		String linha = br.readLine();
		return colunas = linha.split(",");
	}

	public int retornaQuantidadeRegistros() throws IOException {
		BufferedReader br = retornaArquivo();
		int quantidadeLinhas = 0;
		while (br.readLine() != null) {
			quantidadeLinhas++;
		}
		System.out.println("Existem " + (quantidadeLinhas - 1) + " registros.");
		return (quantidadeLinhas - 1);
	}

	private static void setaValores(Integer quantidadeLinhas, ArrayList<String> ibge_id, ArrayList<String> uf,
			ArrayList<String> name, ArrayList<String> capital, ArrayList<String> lon, ArrayList<String> lat,
			ArrayList<String> no_accents, ArrayList<String> alternative_names, ArrayList<String> microregion,
			ArrayList<String> mesoregion) {

		Tabela tabela = new Tabela();
		tabela.setIbge_id(ibge_id);
		tabela.setUf(uf);
		tabela.setName(name);
		tabela.setCapital(capital);
		tabela.setLon(lon);
		tabela.setLat(lat);
		tabela.setNo_accents(no_accents);
		tabela.setMicroregion(microregion);
		tabela.setMesoregion(mesoregion);
		tabela.setQuantidadeLinhas(quantidadeLinhas);
	}
}