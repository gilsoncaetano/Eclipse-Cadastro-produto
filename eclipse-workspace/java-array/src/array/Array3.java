package array;

import java.util.ArrayList;

public class Array3 {

	public static void main(String[] args) {
		// ArrayList � um tipo especial de array que trabalha com objeticos e tamb�m permite o amarzenamento temporario din�mico
		ArrayList<String> lista = new ArrayList<>();
		lista.add("Antonio");
		lista.add("11 99653-9898");
		lista.add("antonio@gmail.com");
		System.out.println(lista);
		System.out.println("Tamanho do Array: " + lista.size());
		System.out.println("Indice[2]: " + lista.get(2));
		
		
	}

}
