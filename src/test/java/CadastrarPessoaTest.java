import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTest {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro() {
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("SP", "São Paulo", "Rua Humaitá 97", "Bela Vista");

        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("111111")).thenReturn(dadosLocalizacao);

        Pessoa pessoa1 = cadastrarPessoa.cadastrarPessoa("Flávio", "Queiroz", "1234556", LocalDate.of(1982, 8, 16), "111111");

        assertEquals("Flávio", pessoa1.getNome());
        assertEquals("Queiroz", pessoa1.getSobrenome());
        assertEquals("1234556", pessoa1.getDocumento());
        assertEquals("SP", pessoa1.getEndereco().getUf());
        assertEquals("Rua Humaitá 97", pessoa1.getEndereco().getLogradouro());
    }
}
