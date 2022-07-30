import java.sql.Connection;
import java.sql.SQLException;
import mantovan.progettonuovo.Home;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HomeTest{
    Connection conn;
    
    
    Home h = new Home();
    
    @Test
    public void testGetConnection() throws SQLException{
        conn = h.getConnection();
        assertNotNull(conn);
        assertTrue(conn.isValid(0));
    }
}