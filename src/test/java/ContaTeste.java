import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaTeste {

    @Spy
    private Conta conta= new Conta(1000);

    @Test
    void validarOrdemDeChamadas(){
        conta.pagarBoleto(300);


        InOrder inOrder= Mockito.inOrder(conta);

        inOrder.verify(conta).pagarBoleto(300);
        inOrder.verify(conta).validaSaldo(300);
        inOrder.verify(conta).debita(300);
        inOrder.verify(conta).enviaCreditoParaEmissor(300);

    }

    // um teste pode verificar até mesmo, quantas vezes o método foi chamado
  @Test
    void validarQuantidadeDeChamadas(){
      conta.validaSaldo(300);
      conta.validaSaldo(300);
      conta.validaSaldo(300);

      //utilizamos a estrutura padrão para verificar e no argumento informamos, o objeto e o que desejamos espiar
      //nessa caso, Mockito.times com argumento que indica quantas vezes você deseja confirmar
      // em seguida, chamamos o mesmo método e passamos o argumento "argumentMachers"
      // pedindo que ele valide apenas com inteiros, através do método ".anyInt"
    Mockito.verify(conta, Mockito.times(3)).validaSaldo(ArgumentMatchers.anyInt());

  }


}
