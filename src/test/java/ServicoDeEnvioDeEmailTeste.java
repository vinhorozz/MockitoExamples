import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoDeEnvioDeEmailTeste {
    @Mock  // Criação de uma simulação (mock) da classe "PlataformaDeEnvio"
    private PlataformaDeEnvio plataforma;

    @InjectMocks //Injeta o mock criado (plataforma) no campo "servico" da classe "ServicoEnvioDeEmail".
    // Isso permite que o "serviço" utilize o mock como "dependência".
    private ServicoEnvioDeEmail servico;

    @Captor
    private ArgumentCaptor<Email> captor; // criação de um objeto para armazenar valores dos argumentos capturados
    //para o método "enviaEmail()" que está dentro de  "plataforma"

    @Test
    void validarDadosEnviadosParaAPlataforma() {
        // Dados de exemplo para o teste
        String enderecoDeEmail = "usuário@test.com.br";
        String mensagem = "Olá, mundo";
        boolean ehFormatoHtml = false;

        // Chamada do método a ser testado (enviaEmail) com os dados de exemplo
        servico.enviaEmail(enderecoDeEmail, mensagem, ehFormatoHtml);

        // Verificação: verifica se o método enviaEmail da plataforma foi chamado com o argumento capturado
        Mockito.verify(plataforma).enviaEmail(captor.capture());

        // Obtém o valor capturado (argumento passado para o método enviaEmail)
        Email emailCapturado = captor.getValue();

        // Verificações dos dados capturados
        Assertions.assertEquals(enderecoDeEmail, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
        Assertions.assertEquals(Formato.TEXTO, emailCapturado.getFormato());
    }
}



