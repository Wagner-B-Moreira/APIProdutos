package Wagnermoreirabastos16.gmail.com.ProdutosApi.repository;

import Wagnermoreirabastos16.gmail.com.ProdutosApi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produto, String> {

    List<Produto> findbyNome(String nome);

}
