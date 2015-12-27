package atributos;


public class PessoaContato {
    
    private int idPessoaContato;
    private String nomeContato;
    private int codTabEstrangeira;
    private int codContato; // tabela contato no banco

    /**
     * @return the idPessoaContato
     */
    public int getIdPessoaContato() {
        return idPessoaContato;
    }

    /**
     * @param idPessoaContato the idPessoaContato to set
     */
    public void setIdPessoaContato(int idPessoaContato) {
        this.idPessoaContato = idPessoaContato;
    }

    /**
     * @return the nomeContato
     */
    public String getNomeContato() {
        return nomeContato;
    }

    /**
     * @param nomeContato the nomeContato to set
     */
    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    /**
     * @return the codTabEstrangeira
     */
    public int getCodTabEstrangeira() {
        return codTabEstrangeira;
    }

    /**
     * @param codTabEstrangeira the codTabEstrangeira to set
     */
    public void setCodTabEstrangeira(int codTabEstrangeira) {
        this.codTabEstrangeira = codTabEstrangeira;
    }

    /**
     * @return the codContato
     */
    public int getCodContato() {
        return codContato;
    }

    /**
     * @param codContato the codContato to set
     */
    public void setCodContato(int codContato) {
        this.codContato = codContato;
    }    
}
