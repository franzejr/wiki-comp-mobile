package br.ufc.engsoft.util;

import java.util.HashMap;

public class StringNormalizer {

	// Create a hash map
	HashMap hm = new HashMap();
	String[][] dic = {
			{ "algebra linear", "Álgebra Linear" },
			{ "calculo i", "Cálculo I" },
			{ "circuitos digitais", "Circuitos Digitais" },
			{ "fundamentos de programação", "Fundamentos de Programação" },
			{ "matematica discreta", "Matemática Discreta" },

			{ "calculo ii", "Cálculo II" },
			{ "estrutura de dados", "Estrutura de Dados" },
			{ "fisica i", "Física I" },
			{ "programaçao", "Programação" },
			{ "programacao", "Programação" },
			{ "tranmissao de dados", "Transmissão de Dados" },

			{ "algoritmos em grafos", "Algoritmos em Grafos" },
			{ "arquitetura de computadores", "Arquitetura de Computadores" },
			{ "introduçao a logica matematica",
					"Introdução à Lógica Matemática" },
			{ "introduçao a probabilidade e estatistica",
					"Introdução à Probabilidade e Estatística" },
			{ "tecnicas de programaçao", "Técnicas de Programação" },

			{ "construçao e analise de algoritmos",
					"Construção e Análise de Algoritmos" },
			{ "computaçao grafica i", "Computação Gráfica" },
			{ "computacao grafica i", "Computação Gráfica" },
			{ "fundamentos de banco de dados", "Fundamentos de Banco de Dados" },
			{ "linguagens de programaçao i", "Linguagens de Programação I" },
			{ "linguagens de programacao i", "Linguagens de Programação I" },
			{ "metodos numericos i", "Métodos Numéricos I" },

			{ "engenharia de software", "Engenharia de Software" },
			{ "metodos numericos ii", "Métodos Numéricos II" },
			{ "redes de computadores", "Redes de Computadores" },
			{ "sistema de gerenciamento de banco de dados",
					"Sistema de Gerenciamento de Banco de Dados" },

			{ "automatos e linguagens formais",
					"Autômatos e Linguagens Formais" },
			{ "inteligencia artificial", "Inteligência Artificial" },
			{ "analise e projeto de sistemas", "Análise e Projeto de Sistemas" },
			{ "sistemas operacionais", "Sistemas Operacionais" },

			{ "teoria da computaçao", "Teoria da Computação" },
			{ "teoria da computacao", "Teoria da Computação" },
			{ "construçao de compiladores", "Construção de Compiladores" },
			{ "construcao de compiladores", "Construção de Compiladores" },
			{ "informatica e sociedade", "Informática e Sociedade" }

	};

	public StringNormalizer() {
		for (int i = 0; i < dic.length; i++) {
			hm.put(dic[i][0], dic[i][1]);
		}
	}

	public String getName(String search) throws NullPointerException {
		String search_lower = search.toLowerCase();
		search = removerAcentos(search_lower);

		return (String) hm.get(search);
	}

	// O Normalizer do Android nao esta funcionando
	// public String removerAcentos(String str) {
	// str = Normalizer.normalize(str, Normalizer.Form.NFD);
	// str = str.replaceAll("[^\\p{ASCII}]", "");
	// return str;
	// }
	// Normalizer sem funcionar, tivemos que apelar
	private static final String PLAIN_ASCII = "AaEeIiOoUu" // grave
			+ "AaEeIiOoUuYy" // acute
			+ "AaEeIiOoUuYy" // circumflex
			+ "AaOoNn" // tilde
			+ "AaEeIiOoUuYy" // umlaut
			+ "Aa" // ring
			+ "Cc" // cedilla
			+ "OoUu" // double acute
	;

	private static final String UNICODE = "\u00C0\u00E0\u00C8\u00E8\u00CC\u00EC\u00D2\u00F2\u00D9\u00F9"
			+ "\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DD\u00FD"
			+ "\u00C2\u00E2\u00CA\u00EA\u00CE\u00EE\u00D4\u00F4\u00DB\u00FB\u0176\u0177"
			+ "\u00C3\u00E3\u00D5\u00F5\u00D1\u00F1"
			+ "\u00C4\u00E4\u00CB\u00EB\u00CF\u00EF\u00D6\u00F6\u00DC\u00FC\u0178\u00FF"
			+ "\u00C5\u00E5" + "\u00C7\u00E7" + "\u0150\u0151\u0170\u0171";

	/**
	 * remove accented from a string and replace with ascii equivalent
	 */
	public String removerAcentos(String s) {
		if (s == null)
			return null;
		StringBuilder sb = new StringBuilder(s.length());
		int n = s.length();
		int pos = -1;
		char c;
		boolean found = false;
		for (int i = 0; i < n; i++) {
			pos = -1;
			c = s.charAt(i);
			pos = (c <= 126) ? -1 : UNICODE.indexOf(c);
			if (pos > -1) {
				found = true;
				sb.append(PLAIN_ASCII.charAt(pos));
			} else {
				sb.append(c);
			}
		}
		if (!found) {
			return s;
		} else {
			return sb.toString();
		}
	}

}