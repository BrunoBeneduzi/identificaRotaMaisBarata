package arq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ceps.Ceps;
import freteErota.Rota;

public class Arquivo {
	BufferedReader br;
	private String path = "identificaRotaMaisBarata-main\\src\\cep.txt";
	
	private List<Long> cepBuscado = new ArrayList<>();
	private List<Rota> rotas = new ArrayList<>();
	private List<Ceps> listaCeps = new ArrayList<>();
	
	public void retornaCep() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			line = this.adicionaCidadeCep(line, br);
			
			line = br.readLine();
			line = this.adicionaRotas(line, br);
			
			line = br.readLine();
			this.adicionaCepBuscado(line, br);
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}	
	}
	
	public String adicionaCidadeCep(String line, BufferedReader br ) throws IOException {
		while (!line.equals("--")) {
			String[] recebe = line.split(",");
			String cidade = recebe[0];
			Long cepInicial = Long.parseLong(recebe[1]);
			Long cepFinal = Long.parseLong(recebe[2]);
			
			Ceps cep = new Ceps(cidade, cepInicial, cepFinal);
			listaCeps.add(cep);
			
			line = br.readLine();	
		}	
		return line;
	}
	
	private String adicionaRotas(String line, BufferedReader br )throws IOException {
		while(!line.equals("--")) {
			String[] recebe = line.split(",");
			String cepInicial = recebe[0];
			String cepFinal = recebe[1];
			Integer valor = Integer.parseInt(recebe[2]);
			
			Rota rota = new Rota(cepInicial, cepFinal, valor);
			rotas.add(rota);
			line = br.readLine();
		}
		return line;
	}
	
	private void adicionaCepBuscado(String line, BufferedReader br ) throws IOException {
		while(line != null) {
			String[] recebe = line.split(",");
			cepBuscado.add(Long.parseLong(recebe[0]));
			cepBuscado.add(Long.parseLong(recebe[1]));
			line = br.readLine();
		}
	}
	
	public List<Ceps> getList() {return listaCeps;}

	public List<Long> cepBuscador() {return this.cepBuscado;} //permite a busca do cep

	public List<Rota> getRotas() {return rotas;}

	@Override
	public String toString() {
		return "Arquivo cepBuscado=" + cepBuscado + ", rotas=" + rotas + ", list="
				+ listaCeps + "]";
	}
}
