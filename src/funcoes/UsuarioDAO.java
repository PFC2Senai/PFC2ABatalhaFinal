/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import atributos.Usuario;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WilhamJr
 */
public class UsuarioDAO {
    public static void CadUsuario(Usuario user){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabusuario(tipo_usuario, usuario, senha) VALUES(?,?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setString(1, user.getTipo());
                stmt.setString(2, user.getNome());
                stmt.setString(3, user.getSenha());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Usuário: ",ex);       
            }
    }
    
    public static ArrayList CarregaUsuario(int id) {
        
        Statement stmt;
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        
        try {            
            String Sql = "SELECT * FROM tabusuario where id_usuario = " + id + ";";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Usuario u = new Usuario();
                
                u.setIdUser(rs.getInt("id_usuario"));
                u.setTipo(rs.getString("tipo_usuario"));
                u.setNome(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                usuario.add(u);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao exibir os dados do usuario: ", ex);    
        }    
        return usuario;
    }
    
    public static int idUsuario(int id) {
        
        Statement stmt;
        Usuario u = new Usuario();
        
        try {            
            String Sql = "SELECT  id_usuario FROM tabusuario WHERE id_usuario = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){                                
                u.setIdUser(rs.getInt("id_usuario"));                             
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Usuário: ", ex);    
        }    
        return u.getIdUser();
    }
    
    
    public static void ExcluirUsuario(int id){
        
        CallableStatement stmt;
        try {   
            stmt = Conexao.getConnection().prepareCall("{call ExcluirUsuario(?)}");
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Usuário: ",ex);    
        }
    }
    
    public static void UpdateUsuario(Usuario user, int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabusuario SET tipo_usuario='" + user.getTipo()+
                                                               "', usuario='" + user.getNome() + 
                                                               "', senha='" + user.getSenha() + 
                                                               "' where id_usuario = '" + id + "';");
            
            stmt = Conexao.getConnection().prepareStatement(sql);                              
                                         
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar os dados do Usuário: ",ex);    
        }
    }
    
    public static ArrayList<Usuario> ListarUsuario(){
        Statement stmt;
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        try {            
            String Sql = "SELECT * FROM tabusuario";
            
            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Usuario u = new Usuario();
                
                u.setIdUser(rs.getInt("id_usuario"));
                u.setTipo(rs.getString("tipo_usuario"));
                u.setNome(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                usuarios.add(u);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar os dados dos Usuários: ",ex);
        }
        return usuarios;
    } 
    
}
