package dev.lpa;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Path.of("music.properties"),
                    StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String albumname = "tapestry";
        String query = "SELECT * FROM music.albumview WHERE album_name='%s'"
                .formatted(albumname);


        var dataSource = new MysqlDataSource();
        dataSource.setServerName(props.getProperty("serverName"));
        dataSource.setPort(Integer.parseInt(props.getProperty("port")));
        dataSource.setDatabaseName(props.getProperty("databaseName"));


        try (var connection = dataSource.getConnection(
                props.getProperty("user"),
                props.getProperty("password"));
             Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(query);

            var meta = resultSet.getMetaData();
            for (int i = 1; i < meta.getColumnCount(); i++) {
                System.out.printf("%d %s %s%n",
                        i,
                        meta.getColumnName(i),
                        meta.getColumnTypeName(i)
                );
            }

            System.out.println("=========================");


            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
            }

            System.out.println();

            while(resultSet.next()) {
//                System.out.printf("%d %s %s %n",
//                        resultSet.getInt("track_number"),
//                        resultSet.getString("artist_name"),
//                        resultSet.getString("song_title")
//                );

                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.printf("%-15s", resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
