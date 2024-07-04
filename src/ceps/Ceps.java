package ceps;

public class Ceps {
	private String cidade;
	private Long cepInicial, cepFinal;
	
	public Ceps(String cidade ,Long cepInicial, Long cepFinal) {
		this.cidade = cidade;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
	}
	
	public Long getCepInicial() {return cepInicial;}

	public void setCepInicial(Long cepInicial) {this.cepInicial = cepInicial;}

	public Long getCepFinal() {return cepFinal;}

	public void setCepFinal(Long cepFinal) {this.cepFinal = cepFinal;}
	
	public String getCidade() {return cidade;}

	public void setCidade(String cidade) {this.cidade = cidade;}

	@Override
	public String toString() {
		return "Ceps [cepInicial=" + cepInicial + ", cepFinal=" + cepFinal + "]";
	}
}