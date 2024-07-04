package freteErota;
import arq.Arquivo;
import ceps.Ceps;

public class CalculadoraRota {
	private Arquivo arquivo;
	private String cidadeSaida, cidadeDestino, cidadePonte;
	private Integer valorMaisBaixo = 100000;
	
	public CalculadoraRota() {
		arquivo = new Arquivo();
		arquivo.retornaCep();//baixa as informações do .txt
	}
	
	public void retornaMelhorRota() {
		this.identificaCidadePorCep();//primeira etapa, identificação dos ceps
		this.calculaPrimeiraRota();//segunda etapa, verifica qual rota inicial tem o valor mais baixo
		this.calculaSegundaRota();//terceira etapa, verifica se existe uma rota que tenha incluso a cidade ponte e faz a soma da rota
		
		if(cidadePonte.equalsIgnoreCase(cidadeDestino)) {//se a cidade ponte for igual a cidade de destino então foi usado somente 1 rota
			System.out.println(cidadeSaida + " Sem cidade ponte " + cidadeDestino +"\n"+valorMaisBaixo);
		}else {
			System.out.println(cidadeSaida+","+cidadePonte+","+cidadeDestino+"\n"+valorMaisBaixo);
		}
		
	}
	
	private void identificaCidadePorCep() {
		Long cepCidadeInicial = arquivo.cepBuscador().get(0);
		Long cepCidadeDestino = arquivo.cepBuscador().get(1);
		
		for(Ceps cep: arquivo.getList()) {
			if(cepCidadeInicial >= cep.getCepInicial() && cepCidadeInicial <= cep.getCepFinal()) {
				cidadeSaida = cep.getCidade();
			}
			if(cepCidadeDestino >= cep.getCepInicial() && cepCidadeDestino <= cep.getCepFinal()) {
				cidadeDestino = cep.getCidade();
			}
		}
	}
	
	private void calculaPrimeiraRota() {
		for(Rota r: arquivo.getRotas()) {
			if(cidadeSaida.equalsIgnoreCase(r.getRota1())) {
				
				if(valorMaisBaixo >= r.getValor()) {
					valorMaisBaixo = r.getValor();
					cidadePonte = r.getRota2();
				}	
			}
		}
	}
	private void calculaSegundaRota() {
		for(Rota r: arquivo.getRotas()) {
			if(cidadeDestino.equalsIgnoreCase(r.getRota2()) && cidadePonte.equalsIgnoreCase(r.getRota1())) {
				valorMaisBaixo += r.getValor();
			}
		}
	}
	
	@Override
	public String toString() {
		return "CalculadoraRota [arquivo=" + arquivo + "]";
	}
}