package interview;

import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;
import telran.interview.Connection;
import telran.interview.ConnectionPool;

public class ConnectionPoolTest {
    @Test
    void addConnectionTest() {
        ConnectionPool pool = new ConnectionPool(2);
        Connection conn1 = new Connection("ID1");
        Connection conn2 = new Connection("ID2");

        pool.addConnection(conn1);
        pool.addConnection(conn2);

        assertEquals(conn1, pool.getConnection("ID1"));
        assertEquals(conn2, pool.getConnection("ID2"));
    }

    @Test
    void addExistingConnectionTest() {
        ConnectionPool pool = new ConnectionPool(2);
        Connection conn1 = new Connection("ID1");
        pool.addConnection(conn1);

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            pool.addConnection(conn1);
        });
        assertEquals(null, exception.getMessage());
    }

    @Test
    void removeOldConnectionTest() {
        ConnectionPool pool = new ConnectionPool(2);
        Connection conn1 = new Connection("ID1");
        Connection conn2 = new Connection("ID2");
        Connection conn3 = new Connection("ID3");

        pool.addConnection(conn1);
        pool.addConnection(conn2);
        pool.addConnection(conn3);

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            pool.getConnection("ID1");
        });
        assertEquals(null, exception.getMessage());

        assertEquals(conn2, pool.getConnection("ID2"));
        assertEquals(conn3, pool.getConnection("ID3"));
    }

    @Test
    void getConnectionTest() {
        ConnectionPool pool = new ConnectionPool(1);
        Connection conn1 = new Connection("ID1");
        pool.addConnection(conn1);

        assertEquals(conn1, pool.getConnection("ID1"));
    }

    @Test
    void noSuchConnectionTest() {
        ConnectionPool pool = new ConnectionPool(1);

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            pool.getConnection("unknownId");
        });
        assertEquals(null, exception.getMessage());
    }
}