package br.calebe.exemplos.ex01;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

public class CarrinhoTest {

    private Carrinho carrinho;

    @Before
    public void criandoCarrinho() {
        carrinho = new Carrinho();
    }

    @Test(expected = CarrinhoVazioExpected.class)
    public void colocandoZeroProduto() throws CarrinhoVazioExpected {
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{null}, new Object[]{menor});
    }

    @Test
    public void colocandoUmProduto() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void colocandoMaisProdutos() throws CarrinhoVazioExpected {
        Produto livro = new Produto("Java em 24 horas", 50.00);
        carrinho.add(livro);
        Produto deitel = new Produto("Java: como programar", 150.00);
        carrinho.add(deitel);
        Produto menor;
        menor = carrinho.menorProduto();
        assertArrayEquals(new Object[]{livro}, new Object[]{menor});
    }

    @Test
    public void identidadeDeProdutos() throws CarrinhoVazioExpected {
        Produto original = new Produto("Java em 24 horas", 50.00);
        carrinho.add(original);
        Produto copia = new Produto("Java em 24 horas", 50.00);
        original = carrinho.menorProduto();
        assertArrayEquals(new Object[]{original}, new Object[]{copia});
    }

    //adicionar outros tipos de produtos ao carrinho
    @Test
    public void adcinonarNovosTiposProdutos() {
        String tipo = "Eletrônico";
        assertArrayEquals(new Object[]{tipo}, new Object[]{"Eletrônico"});
    }
    
    //listar todos os produtos do carrinho
    @Test
    public void listarProdutos(){
        
        List<String> lista = new ArrayList<>();
        
        lista.add("CD Victor Léo");
        lista.add("Bicicleta");
        lista.add("Geladeira");
        
        assertArrayEquals(new Object[]{lista.get(0)}, new Object[]{"CD Victor Léo"});
        assertArrayEquals(new Object[]{lista.get(1)}, new Object[]{"Bicicleta"});
        assertArrayEquals(new Object[]{lista.get(2)}, new Object[]{"Geladeira"});
        
    }
    
   //remover um produto do carrinho
    @Test
    public void removerProduto(){
        
        List<String> lista = new ArrayList<>();
        
       
        lista.add("CD Victor Léo");
        lista.add("Bicicleta");
        lista.add("Geladeira");
       
        
        lista.remove("Geladeira");
        
        
        assertArrayEquals(new Object[]{lista.size()}, new Object[]{2});
        
    }
    
    //Calcular o total que deve ser pago pelos produtos no carrinho
    @Test
    public void totalPago(){
        
        List<Double> lista = new ArrayList<>();
        
        double total = 0.0;
        
        lista.add(40.00);
        lista.add(40.00);
        lista.add(50.00);
        
        //calcula o total de valores dentro da lista
        for(Double x : lista){
            total = total + x.doubleValue();
        }
        
        assertArrayEquals(new Object[]{total}, new Object[]{130.00});
        
    }
}
