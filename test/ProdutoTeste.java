
import br.calebe.exemplos.ex01.CarrinhoVazioExpected;
import br.calebe.exemplos.ex01.Produto;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PauloPereira
 */
public class ProdutoTeste {
    
    private Produto produto;
    
     @Before
    public void criandoProduto() {
        produto = new Produto("C++",53.00);
     }
        
    @Test
    public void iniciaçaoCorreta() throws CarrinhoVazioExpected {
       
        Produto a = new Produto ("C++",53.00);
        assertArrayEquals(new Object[]{a.getPreco()}, new Object[]{53.00});
    }
}
