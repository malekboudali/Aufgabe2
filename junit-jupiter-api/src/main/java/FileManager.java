import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileManager {
    public void initializeDatabaseFromTextFile(String filePath, Connection connection) throws IOException, SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String sql = "INSERT INTO books (id, title, author, isbn, available) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setInt(1, Integer.parseInt(parts[0].trim()));
                        statement.setString(2, parts[1].trim());
                        statement.setString(3, parts[2].trim());
                        statement.setString(4, parts[3].trim());
                        statement.setBoolean(5, Boolean.parseBoolean(parts[4].trim()));
                        statement.executeUpdate();
                    }
                }
            }
        }
    }
}

