import gerador.GeradorDeNumeros;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GeraradorDeNumerosTeste {
    @Test
    void testargerarNumeroComTamanhoDefinido(){

/// adicionamos a classe MockedStatic tendo como Tipo a classe que queromos testar.
        MockedStatic<GeradorDeNumeros>mockedStatic= Mockito.mockStatic(GeradorDeNumeros.class);
    }
    }
