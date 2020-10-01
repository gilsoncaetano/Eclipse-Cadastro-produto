package array;

public class Array1 {

	public static void main(String[] args) {
		//[][] linha | colunas
		String [][] agenda = {{"Antonio cesa","2222-2222","antonio@gmail.com"},{"josé de Assis","3333-3333","jose@gmail.com"},{"Luis Souza","4444-4444","luis@gmail.com"}};
		//System.out.println(agenda[0][1]);
		System.out.println("===============================");
		System.out.println("====== Agenda de Contato ======");
		System.out.println("===============================");
		System.out.println("");
		for (int i = 0; i < agenda.length; i++) {
			System.out.println("_____________________________");
			for (int m = 0; m < agenda[i].length; m++) {
				System.out.println(agenda[i][m]);
				
				
			}

		}
	}

}
