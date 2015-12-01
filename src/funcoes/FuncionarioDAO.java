/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import atributos.Funcionario;
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
public class FuncionarioDAO {
    public static void CadFuncionario(Funcionario func){
        
        PreparedStatement stmt;
        try {   
            String sql = ("INSERT INTO tabfuncionario(funcionario, rg, cpf, cargo, salario, tabContato_id_contato, tabUsuario_id_Usuario, data_admicao) VALUES(?,?,?,?,?,?,?,?)");
            stmt = Conexao.getConnection().prepareStatement(sql);      
  
                stmt.setString(1, func.getFuncionario());  
                stmt.setString(3, func.getRg());
                stmt.setString(2, func.getCpf());               
                stmt.setString(4, func.getCargo());
                stmt.setString(5, (String.valueOf(func.getSalario())));
                stmt.setString(6, (String.valueOf(func.getIdContato())));
                stmt.setString(7, (String.valueOf(func.getIdUsuario())));
                stmt.setString(8, func.getDataAdmicao());
                              
                stmt.executeUpdate();
                stmt.close();  

            } catch (SQLException ex) {      
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao Cadastrar Cliente: ",ex);       
            }
    }
    
    public static int idContato(int id) {
        
        Statement stmt;
        Funcionario f = new Funcionario();
        
        try {            
            String Sql = "SELECT idfuncionario FROM tabfuncionario WHERE idfuncionario = '"+ id +"';";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){                                
                f.setIdContato(rs.getInt("idfuncionario"));                             
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Cliente: ", ex);    
        }    
        return f.getIdContato();
    }
    
    public static ArrayList CarregaFuncionario(int id) {
        
        Statement stmt;
        ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
        
        try {            
            String Sql = "SELECT * FROM tabfuncionario ";
            
            ResultSet rs;            
            stmt = Conexao.getConnection().createStatement();            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Funcionario f = new Funcionario();
                
                f.setId(rs.getInt("idfuncionario"));
                f.setFuncionario((rs.getString("funcionario")));
                f.setRg(rs.getString("rg"));
                f.setCpf(rs.getString("cpf"));
                f.setCargo(rs.getString("cargo"));  
                f.setSalario(Double.parseDouble(rs.getString("salario")));
                f.setIdContato(Integer.parseInt(rs.getString("tabContato_id_contato")));
                f.setIdUsuario(Integer.parseInt(rs.getString("tabUsuario_id_usuario")));
                f.setDataAdmicao(rs.getString("data_admicao"));
                f.setId(id);
                funcionario.add(f);                
            }            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {      
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Cliente: ", ex);    
        }    
        return funcionario;
    }
    
    public static void ExcluirFuncionario(int id){
        
        CallableStatement stmt;
        try {   
            stmt = Conexao.getConnection().prepareCall("{call ExcluirFuncionario(?)}");
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao excluir os dados do Funcionario: ",ex);    
        }
    }
    
    public static void UpdateFuncionario(Funcionario func, int id){
        
        PreparedStatement stmt;
        
        try {   
            String sql = ("UPDATE tabfuncionario SET funcionario='"+func.getFuncionario()
                    + "' , rg='"+func.getRg()+ "' , cpf='"+func.getCpf()+"' , cargo='"+func.getCargo()
                    + "' , salario='"+func.getSalario()+"' , tabContato_id_contato'"+func.getIdContato()
                    +"' , tabUsuario_id_Usuario'"+func.getIdUsuario()+"' , data_admicao'"+func.getDataAdmicao()
                    +"where idfuncionario = '"+ id + "';");
            stmt = Conexao.getConnection().prepareStatement(sql);                              
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException ex) {      
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Alterar os dados do Fucionario: ",ex);    
        }
    }
    
    public static ArrayList<Funcionario> ListarFuncionario(){
        Statement stmt;
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        
        try {            
            String Sql = "SELECT * FROM tabfuncionario";
            
            ResultSet rs;
            
            stmt = Conexao.getConnection().createStatement();
            
            rs = stmt.executeQuery(Sql); 
            
            while(rs.next()){
                Funcionario f = new Funcionario();
                
                f.setFuncionario(String.valueOf(rs.getInt("funcionario")));
                f.setRg((rs.getString("rg")));
                f.setCpf(rs.getString("cpf"));
                f.setCargo(rs.getString("cargo"));
                f.setSalario(Double.parseDouble(rs.getString("salario")));
                f.setIdContato(Integer.parseInt(rs.getString("tabContato_id_contato")));
                f.setIdUsuario(Integer.parseInt(rs.getString("tabUsuario_id_usuario")));
                f.setDataAdmicao(String.valueOf(rs.getString("data_admicao")));
                
                //c.setTel(rs.getString("telefone"));
                //c.setEmail(rs.getString("email"));
                
                funcionarios.add(f);
                
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao Listar os dados do Funcionario: ",ex);
        }
        return funcionarios;
    }    
    
}
