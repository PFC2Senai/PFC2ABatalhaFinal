package atributos;


import static java.lang.String.format;


public class Cliente {
    
    private int id;
    private int idContato;
    private String empresa;
    private String cnpj;
    private String email;
    private int codSetor;
    private String setor;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

//    /**
//     * @return the tel
//     */
//    public String getTel() {
//        return tel;
//    }
//
//    /**
//     * @param tel the tel to set
//     */
//    public void setTel(String tel) {
//        this.tel = tel;
//    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        format("#####-###", "81580200");
        String format = format(this.cnpj = cnpj);
    }


    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the codSetor
     */
    public int getCodSetor() {
        return codSetor;
    }

    /**
     * @param codSetor the codSetor to set
     */
    public void setCodSetor(int codSetor) {
        this.codSetor = codSetor;
    }

    /**
     * @return the idContato
     */
    public int getIdContato() {
        return idContato;
    }

    /**
     * @param idContato the idContato to set
     */
    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }
}
