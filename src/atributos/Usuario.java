package atributos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static funcoes.Conexao.getConnection;


public class Usuario {
    
    private int idUser;
    private String nome;
    private String tipo;
    private String senha;
    private static int CodUsuario;

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
 
    
    public boolean validaSenha(Usuario usuario){
        
        ResultSet rs; 
        String user = "";
        String senhaUser = "";
        String tipoUser = "";
        
        try {     
            String sql = "select * from tabusuario;";
            Statement s = getConnection().createStatement();
            s.executeQuery (sql);
            rs = s.getResultSet();
                while (rs.next ()){
                    CodUsuario = rs.getInt("id_usuario");
                    user = rs.getString("USUARIO");
                    senhaUser = rs.getString("SENHA");
                    tipoUser = rs.getString("TIPO_USUARIO");
                        if (user.equals(usuario.getNome()) && senhaUser.equals(usuario.getSenha()) && tipoUser.equals(usuario.getTipo())){
                            return true;
                        }
                }
            rs.close ();
            s.close ();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }
    
    public static int idUsuario(){       
        return CodUsuario;        
    }
}
