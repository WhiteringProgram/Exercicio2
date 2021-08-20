package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {
	public static void main(String[] args) 
	{
		// Instância de classe
		KillController kc = new KillController();
		String os = kc.getOS();
		System.out.println(os);
		//Janela de escolhas para o usuário
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Listagem de Processos \n2- Mata Processo PID \n3- Mata Processo por Nome \n9 - Finaliza"));
			
			switch (opc) {
			
			case 1: String Processo = " TASKLIST /FO TABLE";
					kc.listaProcessos(Processo);
					break;
			case 2: String Param = "cmd.exe";
					kc.mataPID(Param);
					break;
			case 4: String name = "cmd.exe";
					kc.mataNome(name);
			case 9:
					JOptionPane.showMessageDialog(null, "Finaliza");
					break;
			default: 
					JOptionPane.showMessageDialog(null, "Opção Inválida");
				}//Fim do switch
			}//Fim da estrutura de repetição
	}
}

