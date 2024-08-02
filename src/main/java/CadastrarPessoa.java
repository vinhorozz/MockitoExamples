import java.time.LocalDate;

public class CadastrarPessoa {
    private ApiDosCorreios apiDosCorreios;

    public CadastrarPessoa(final ApiDosCorreios apiDosCorreios) {
        this.apiDosCorreios = apiDosCorreios; // Corrigido para atribuir o parâmetro ao campo da classe
    }

    public Pessoa cadastrarPessoa(String nome, String sobrenome, String documento, LocalDate nascimento, String cep) {
        Pessoa pessoa = new Pessoa(nome, sobrenome,documento,nascimento);
        DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaDadosComBaseNoCep(cep);
        pessoa.adicionarDadosDeEndereco(dadosLocalizacao);
        return pessoa;
    }
}
