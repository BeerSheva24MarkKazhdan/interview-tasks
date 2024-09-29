package telran.interview;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ConnectionPool {
    private final int size;
    private final LinkedList<Connection> connections;

    public ConnectionPool(int size) {
        this.size = size;
        this.connections = new LinkedList<>();
    }

    public void addConnection(Connection connection) {
        connections.stream()
                .filter(c -> c.connectionId().equals(connection.connectionId()))
                .findAny()
                .ifPresent(c -> {
                    throw new IllegalStateException();
                });

        if (connections.size() >= size) {
            connections.removeFirst();
        }

        connections.add(connection);
    }

    public Connection getConnection(String connectionId) {
        return connections.stream()
                .filter(c -> c.connectionId().equals(connectionId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException());
    }
}