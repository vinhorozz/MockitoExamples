import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private String documento;
    private LocalDate nascimento;
    private DadosLocalizacao endereco;

    public Pessoa(final String nome,final String sobrenome, final String documento,  final LocalDate nascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.nascimento = nascimento;
    }

    public void adicionarDadosDeEndereco(DadosLocalizacao dadosLocalizacao){
        this.endereco =dadosLocalizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public DadosLocalizacao getEndereco() {
        return endereco;
    }

    public void setEndereco(DadosLocalizacao endereco) {
        this.endereco = endereco;
    }

    public boolean ehMaiorDeIdade(){
        return ChronoUnit.YEARS.between(this.nascimento, LocalDate.now())>18L;
    }
}