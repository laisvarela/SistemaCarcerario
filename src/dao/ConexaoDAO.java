package dao;

import java.sql.*;
import java.sql.Statement;

public class ConexaoDAO {

    public static Connection conectorBD() {
        java.sql.Connection conexao = null;

        String url = "jdbc:mysql://localhost:3306/mysql";
        String user = "laisv";
        String password = "lais1234";

        // estabelece conexão com o banco de dados
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // executa o arquivo de driver
            conexao = DriverManager.getConnection(url, user, password);
            Statement stmt = conexao.createStatement();

            //criar banco de dados
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS sistemacarcerario");
            stmt.execute("USE sistemacarcerario");

            //criar tabelas
            stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS guarda (
                        idguarda INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        nome VARCHAR(100) NOT NULL,
                        cpf VARCHAR(11) UNIQUE NOT NULL,
                        dataNascimento DATE NOT NULL,
                        matricula VARCHAR(20) UNIQUE NOT NULL,
                        turno VARCHAR(10) NOT NULL,
                        dataAdmissao DATE NOT NULL,
                        atribuido BOOLEAN NOT NULL DEFAULT false
                    )""");

            stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS cela (
                        idcela INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        numero INT UNIQUE NOT NULL,
                        capacidade INT NOT NULL,
                        guarda_diurno VARCHAR(20), 
                        guarda_noturno VARCHAR(20),
                        FOREIGN KEY (guarda_diurno) REFERENCES guarda(matricula),
                        FOREIGN KEY (guarda_noturno) REFERENCES guarda(matricula)
                    )""");
            stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS prisioneiro (
                        idprisioneiro INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        nome VARCHAR(100) NOT NULL,
                        cpf VARCHAR(11) UNIQUE NOT NULL,
                        dataNascimento DATE NOT NULL,
                        numRegistro INT UNIQUE NOT NULL,
                        dataPrisao DATE NOT NULL,
                        pena INT NOT NULL,
                        num_cela INT NOT NULL,
                        FOREIGN KEY (num_cela) REFERENCES cela(numero)
                    )""");
            
            stmt.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS cela_prisioneiro (
                        numero_cela INT NOT NULL,          
                        numero_registro INT NOT NULL,      
                        PRIMARY KEY (numero_cela, numero_registro),
                        FOREIGN KEY (numero_cela) REFERENCES cela(numero) ON UPDATE CASCADE,
                        FOREIGN KEY (numero_registro) REFERENCES prisioneiro(numRegistro) ON UPDATE CASCADE
                    )""");
           
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro em ConexaoDAO.\nErro: " + e);
            return null;
        }
    }
}
