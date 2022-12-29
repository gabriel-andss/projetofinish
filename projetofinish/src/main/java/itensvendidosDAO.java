import java.sql.*;
        
public class itensvendidosDAO {
    Connection conn;

    public itensvendidosDAO(){
        conn = new ConexaoDAO().getConexao();        
    }
    
    public void inserirVenda(Produto p){
        try{
            PreparedStatement ps = conn.prepareStatement("insert into itensvendidos (codigo) values ( ? )");
            ps.setString(1, p.getCodigo());
            ps.executeUpdate();            
            System.out.println("\n Item vendido inserida com sucesso");
                           
        }catch(Exception e){
          System.out.println("Erro: "+e);

        }
    }
    
    public void consultarTudo(){
        String sql="select * from ITENSVENDIDOS;";
        try {
            PreparedStatement sttmt=conn.prepareStatement(sql);
            ResultSet rst=sttmt.executeQuery();
            while(rst.next()){
                String n = rst.getString("codigo");
                int i = rst.getInt("id");
                System.out.println("Dados do banco: "+n+" "+i);
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta: "+ex);
        }
    }
    
    
}