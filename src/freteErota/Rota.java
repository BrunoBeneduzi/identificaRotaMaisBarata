package freteErota;

public class Rota {
	private String cidade1, cidade2;
	private Integer valor;
	
	public Rota(String cidade1, String cidade2, Integer valor) {
		this.cidade1 = cidade1;
		this.cidade2 = cidade2;
		this.valor = valor;
	}
	public String getRota1() {return cidade1;}
	
	public void setRota1(String rota1) {this.cidade1 = rota1;}
	
	public String getRota2() {return cidade2;}
	
	public void setRota2(String rota2) {this.cidade2 = rota2;}
	
	public Integer getValor() {return valor;}
	
	public void setValor(Integer valor) {this.valor = valor;}
	
	@Override
	public String toString() {
		return "Rota [rota1=" + cidade1 + ", rota2=" + cidade2 + ", valor=" + valor + "]";
	}
}