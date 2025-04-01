package LanHouse;

import java.util.Scanner;

public class Main
{
	static Maquina[] pcArrey = new Pc[5];
	static Maquina[] playStationArrey = new PlayStation[5];
	static Maquina[] xboxArrey = new Xbox[5];

	public static void iniciaMaquinas() {
		for (int i = 0; i < 5; i++) {
			pcArrey[i] = new Pc("Pc " + (i + 1));
			playStationArrey[i] = new PlayStation("Play " + (i + 1));
			xboxArrey[i] = new Xbox("Xbox " + (i + 1));
		}
	}

	public static void limparTela() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (Exception e) {
			System.out.println("Erro ao limpar tela.");
		}
	}


	public static void main(String[] ignoredArgs) throws InterruptedException {

		iniciaMaquinas();

		Scanner sc = new Scanner(System.in);
		while (true) {

			limparTela();

			System.out.println("=== Escolha uma opção ===");
			System.out.println("=== 1- alugar máquina ===");
			System.out.println("=== 2- pagamento ===");
			System.out.println("=== 3- plano ===");
			System.out.println("=== 4- sair ===");

			int opcao = sc.nextInt();
			sc.nextLine();

			switch(opcao){
				case 1:
					AlugarMaquinas.alugarMaquinas(sc);
					break;
				case 2:
					RealizarPagamento.realizarPagamento(sc);
					break;
				case 3:
					// Adicione o código para plano aqui
					break;
				case 4:
					System.out.println("Saindo...");
					sc.close();
					Thread.sleep(1000);
					limparTela();
					System.exit(0);
					break;
				default:
					System.out.println("Opção inválida");
					Thread.sleep(1000);
					break;
			}
		}
	}
}