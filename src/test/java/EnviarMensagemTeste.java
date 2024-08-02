import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {

    @Spy//ao invés de @Mock colocaremos o @Spy
    //assim o objeto enviarMensagem poderá ser "espiado" de perto!
    private EnviarMensagem enviarMensagem;

    @Test
    void verificarComportamentoDaClasse() {
        //Mockito.verifyNoInteractions(enviarMensagem);
        //Mockito.verifyNoMoreInteractions(enviarMensagem);

      Mensagem mensagem = new Mensagem("Hello World");
        enviarMensagem.adicionarMensagem(mensagem);

//aqui solicitamos ao Mockito verificar se o "objeto espiado" recebeu algum mensagem
        Mockito.verify(enviarMensagem).adicionarMensagem(mensagem);
//aqui, com a Classe Assertions verificamos se o "objeto espiado" está vazio
        Assertions.assertFalse(enviarMensagem.getMensagens().isEmpty());
    }
}