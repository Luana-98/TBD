import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import mantovan.progettonuovo.Home;
import mantovan.progettonuovo.Prodotti;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProdottiTest{
    Home h = new Home();
    Connection conn = h.getConnection();
    Prodotti p = new Prodotti(conn);
    
    @Test    
    void riempiTabellaTest(){
        int nRows = p.riempiTabella();
        String q = "SELECT * FROM PRODOTTO_NEGOZIO";
        int count = 0;
        try{
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while(rs.next()){
                count++;
                System.out.println(count);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        assertEquals(count, nRows);
    }
    
    @Test
    void svuotaListaTest(){
        int nRows = p.svuotaLista();
        assertEquals(0, nRows);
    }
    
    
}