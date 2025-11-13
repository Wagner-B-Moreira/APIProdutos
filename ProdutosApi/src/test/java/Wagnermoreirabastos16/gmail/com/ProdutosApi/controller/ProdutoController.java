package Wagnermoreirabastos16.gmail.com.ProdutosApi.controller;

import Wagnermoreirabastos16.gmail.com.ProdutosApi.model.Produto;
import Wagnermoreirabastos16.gmail.com.ProdutosApi.repository.ProdutosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController 
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutosRepository produtosRepository;


    // constructor
    public ProdutoController(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @PostMapping
    public Produto  salvar(@RequestBody Produto produto) {
        System.out.println("Produtos recebido" + produto);
       var id =  UUID.randomUUID().toString();
        produto.setId(id);
        produtosRepository.save(produto);
        return produto;

    }

    @GetMapping("/{id}")
   public Produto obterPorId(@PathVariable("id")  String id) {
       Optional<Produto> byId = produtosRepository.findById(id);
            return produtosRepository.findById(id).orElse(null);

   }

   @DeleteMapping("{id}")
   public void deletar(@PathVariable("id")  String id ){
        produtosRepository.deleteById(id);

   }
   @PutMapping("{id}")
   public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto) {

        produto .setId(id);
        produtosRepository.save(produto);
   }

   @GetMapping
   public List<Produto> buscar(@RequestParam("nome") String nome) {
       return produtosRepository.findbyNome(nome);
   }
}





















