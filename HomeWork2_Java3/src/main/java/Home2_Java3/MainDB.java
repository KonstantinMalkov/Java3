package Home2_Java3;

import java.sql.*;

// 1. Сделать методы для работы с БД (CREATE, UPDATE, DELETE, INSERT, SELECT)

public class MainDB {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        try {
            connect();

            // выборка с условием
            ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id = '1'");
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
            // добавляем строку
            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('unknow', 10)");
            // меняем значение строки
            stmt.executeUpdate("UPDATE students SET score=20 WHERE id = 3");
            // удаляем строку с ид = 3
            stmt.executeUpdate("DELETE  FROM students WHERE id = 3");
            // создаем таблицу
            stmt.executeUpdate("CREATE TABLE studetsTest ('id' INT(10) UNSIGNED NOT NULL AUTO_INCREMENT," +
                    " 'name' VARCHAR(255) NOT NULL, 'group' VARCHAR(255) NULL DEFAULT NULL, PRIMARY KEY (`id`)");
            // удаляем таблицу
            stmt.executeUpdate("DROP TABLE studetsTest");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
