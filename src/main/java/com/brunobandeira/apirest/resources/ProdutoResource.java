package com.brunobandeira.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunobandeira.apirest.models.Produto;
import com.brunobandeira.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;

@RestController //recebe as requisições HTTP
@RequestMapping(value = "/api") //Mostra o endereço de uma aplicação
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*") //Libera o dominio para todos da API
public class ProdutoResource {
	
	@Autowired //Podemos utilizar os métodos de outro classe atravéz desta notação
	ProdutoRepository produtoRepository;
	
	  // Pega todos os produtos já salvos no BD, e mostra no POSTMAN
	  
		@GetMapping("/produtos")
		public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
		}
	 
	//Pega apenas o produto pelo id que ele possui.
	
	@GetMapping("/produto/{id}") //{id} mostra que quer pegar o ID
	public  Produto  listaProdutoUnico(@PathVariable(value = "id") long id){
		return produtoRepository.findById(id); 
	}
	
	//@PathVariable(value = "id") Mostra o caminho e o e o value oq deve ser pego
	//Como quero pegar um produto especifico, preciso ir na class P rodutoRepository
	 
	
	/*
	 * Salva os produtos no BD
	 * 
	@PostMapping("/produto") //Salva algum produto
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	*/
	
	/*
	@DeleteMapping("/produto") 
	public void deletaProduto(@RequestBody Produto produto) {
		 produtoRepository.delete(produto);
	}
	*/
	/*
	@PutMapping("/produto") //Atualiza um produto
	@ApiOperation(value = "Deleta um dado do BD") //Mostra oq o método faz, é apenas uma descrição
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	*/
}








