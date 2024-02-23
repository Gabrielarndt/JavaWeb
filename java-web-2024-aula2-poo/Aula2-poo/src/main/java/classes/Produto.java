package classes;

public class Produto {
   private String descricao;
   private Double preco;
   
   //encapsulamento
   public void setPreco(Double preco) {
	  if(preco < 0) {
		 throw new RuntimeException("Preço não pode ser negativo");
	  }
	   this.preco = preco;  
   }
   
   public Double getPreco() {
	   return this.preco;
   }
   
   public String getDescricao() {
	   return this.descricao;
   }
   
   //construtor padrão
   public Produto(){
	   
   }
     
   //construtor sobrecarregado - inicializa valores para o objeto
   public Produto(String descricao, Double preco){
	  this.descricao = descricao;
	 // this.preco = preco;
	  this.setPreco(preco);
   }
}
