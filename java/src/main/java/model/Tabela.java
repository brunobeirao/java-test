package model;
import java.util.ArrayList;

public class Tabela {
	public static ArrayList<String> ibge_id = new ArrayList<String>();
	public static ArrayList<String> uf = new ArrayList<String>();
	public static ArrayList<String> name = new ArrayList<String>();
	public static ArrayList<String> capital = new ArrayList<String>();
	public static ArrayList<String> lon = new ArrayList<String>();
	public static ArrayList<String> lat = new ArrayList<String>();
	public static ArrayList<String> no_accents = new ArrayList<String>();
	public static ArrayList<String> alternative_names = new ArrayList<String>();
	public static ArrayList<String> microregion = new ArrayList<String>();
	public static ArrayList<String> mesoregion = new ArrayList<String>();
	public static Integer quantidadeLinhas;
	public static String [] colunas;

	public static ArrayList<String> getIbge_id() {
		return ibge_id;
	}

	public void setIbge_id(ArrayList<String> ibge_id) {
		Tabela.ibge_id = ibge_id;
	}

	public static ArrayList<String> getUf() {
		return uf;
	}

	public void setUf(ArrayList<String> uf) {
		Tabela.uf = uf;
	}

	public static ArrayList<String> getName() {
		return name;
	}

	public void setName(ArrayList<String> name) {
		Tabela.name = name;
	}

	public static ArrayList<String> getCapital() {
		return capital;
	}

	public void setCapital(ArrayList<String> capital) {
		Tabela.capital = capital;
	}

	public static ArrayList<String> getLon() {
		return lon;
	}

	public void setLon(ArrayList<String> lon) {
		Tabela.lon = lon;
	}

	public static ArrayList<String> getLat() {
		return lat;
	}

	public void setLat(ArrayList<String> lat) {
		Tabela.lat = lat;
	}

	public static ArrayList<String> getNo_accents() {
		return no_accents;
	}

	public void setNo_accents(ArrayList<String> no_accents) {
		Tabela.no_accents = no_accents;
	}

	public static ArrayList<String> getAlternative_names() {
		return alternative_names;
	}

	public static void setAlternative_names(ArrayList<String> alternative_names) {
		Tabela.alternative_names = alternative_names;
	}

	public static ArrayList<String> getMicroregion() {
		return microregion;
	}

	public void setMicroregion(ArrayList<String> microregion) {
		Tabela.microregion = microregion;
	}

	public static ArrayList<String> getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(ArrayList<String> mesoregion) {
		Tabela.mesoregion = mesoregion;
	}

	public static Integer getQuantidadeLinhas() {
		return quantidadeLinhas;
	}

	public void setQuantidadeLinhas(Integer quantidadeLinhas) {
		Tabela.quantidadeLinhas = quantidadeLinhas;
	}

	public static String[] getColunas() {
		return colunas;
	}

	public static void setColunas(String[] colunas) {
		Tabela.colunas = colunas;
	}
}