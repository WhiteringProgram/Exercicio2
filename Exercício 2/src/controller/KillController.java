package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController () {
		super();
	}
	//Definição do SO e Método OS a fim de retorná-lo via console
	private String os = System.getProperty("os.name");
	//Acesso ao atributo privado	
	public void setOS (String os) {
		this.os = os;
	}
	//Retorno da String
	public String getOS () {
		return os;
	}
	//Linhas de processo ativas
	public void listaProcessos (String Processo) {
		try { //Tentativa de execução de processo por meio de buffers
			Process Identificador = Runtime.getRuntime().exec(Processo);
			InputStream passaDados = Identificador.getInputStream();
			InputStreamReader r = new InputStreamReader(passaDados);
			BufferedReader buffer = new BufferedReader(r);
			String line = buffer.readLine();
			while (line != null) {
				System.out.println(line);
				line = buffer.readLine();
			}//Fim da Estrutura de repetição
			buffer.close();
			passaDados.close();
			r.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}//Fim do Catch
	 }
	
	public void mataPID (String Param) {
		String Pid = "TASKKILL /PID";
		String cmd = "TASKKILL /IM";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		try {
		pid = Integer.parseInt(Param);
		buffer.append(Pid);
		buffer.append(" ");
		buffer.append(pid);
		} catch (NumberFormatException e) {
			buffer.append(cmd);
			buffer.append(" ");
			buffer.append(Param);
		}
		listaProcessos(buffer.toString());
	
		}
	public void mataNome (String name) {
		String cmd = "TASKKILL /IM";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		try {
		pid = Integer.parseInt(name);
		buffer.append(" ");
		buffer.append(pid);
		} catch (NumberFormatException e) {
			buffer.append(cmd);
			buffer.append(" ");
			buffer.append(name);
		}
		listaProcessos(buffer.toString());
	}
}
