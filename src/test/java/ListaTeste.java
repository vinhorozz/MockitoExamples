import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
//O Mock test nos permiterá ter facilidade para criarmos cenários com conexões de bancos de dados

@ExtendWith(MockitoExtension.class)
public class ListaTeste {
//Essa anotação indica que iremos realizar um teste
    @Mock
    private List<String> letras;

    @Test
    void adicionarItensNaLista(){
        // Definir o comportamento esperado do mock
        Mockito.when(letras.get(0)).thenReturn("B");

        // Verificar o resultado esperado
        Assertions.assertEquals("B", letras.get(0));
    }
}

