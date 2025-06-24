package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cela;
import model.Prisioneiro;

public class PrisioneiroDAO {

    Connection connection = null;
    PreparedStatement stmt = null;
    Prisioneiro p = null;
    ResultSet rs = null;

    public void inserirPrisioneiro(Prisioneiro prisioneiro) {
        String sql = "INSERT INTO prisioneiro(nome, cpf, dataNascimento, "
                + "numRegistro, dataPrisao, pena, num_cela) "
                + "VALUES(?,?,?,?,?,?,?)";

        try {
            connection = ConexaoDAO.conectorBD();
            stmt = connection.prepareStatement(sql);

            //formata LocalDate para SQL Date
            java.sql.Date dataNascSql = java.sql.Date.valueOf(prisioneiro.getDataNascimento());
            java.sql.Date dataPrisao = java.sql.Date.valueOf(prisioneiro.getDataPrisao());

            // preenche os valores da String sql
            stmt.setString(1, prisioneiro.getNome());
            stmt.setString(2, prisioneiro.getCpf());
            stmt.setDate(3, dataNascSql);
            stmt.setInt(4, prisioneiro.getNumRegistro());
            stmt.setDate(5, dataPrisao);
            stmt.setInt(6, prisioneiro.getPena());
            stmt.setInt(7, prisioneiro.getCela());

            //adicionar no bando de dados
            stmt.executeUpdate();

            System.out.println("Dados inseridos no banco de dados.");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco. \nErro: " + e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar o stmt. \nErro: " + e);
            }
        }

    }

    public ArrayList<Prisioneiro> listarPrisioneiros() {
        ArrayList<Prisioneiro> listaPrisioneiros = null;

        String sql = "SELECT p.*, c.numero as numero_cela, c.capacidade "
                + "FROM prisioneiro p LEFT JOIN cela c ON p.num_cela = c.numero";
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs != null) {
                listaPrisioneiros = new ArrayList<>();
                while (rs.next()) {
                    p = new Prisioneiro(null, null, null);
                    p.setNome(rs.getString("nome"));
                    p.setCpf(rs.getString("cpf"));
                    p.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                    p.setNumRegistro(rs.getInt("numRegistro"));
                    p.setDataPrisao(rs.getDate("dataPrisao").toLocalDate());
                    p.setPena(rs.getInt("pena"));
                    // Cria a Cela apenas se houver associação
                    if (rs.getObject("numero_cela") != null) {
                        Cela cela = new Cela();
                        cela.setNumero(rs.getInt("numero_cela"));
                        cela.setCapacidade(rs.getInt("capacidade"));
                        p.setCela(cela);
                    }
                    listaPrisioneiros.add(p);
                }
            }
            System.out.println("Dados coletados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha em extrair dados. \n Erro: " + e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar stmt. \n Erro: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar conexão. \n Erro: " + e);
            }
        }
        return listaPrisioneiros;
    }

    public String buscarPrisioneiro(String numRegistro) {
        String sql = "SELECT * FROM prisioneiro WHERE numRegistro LIKE ?";
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, numRegistro);
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    return rs.getString("numRegistro");
                }
                System.out.println("Busca realizada com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fazer a busca. \nErro: " + e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar stmt. \n Erro: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar conexão. \n Erro: " + e);
            }
        }
        return "";
    }

    public void editarPrisioneiro(Prisioneiro prisioneiroNovo) {
        String sql = "UPDATE prisioneiro SET nome = ?, pena = ? WHERE numRegistro = ?";

        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, prisioneiroNovo.getNome());
            stmt.setInt(2, prisioneiroNovo.getPena());
            stmt.setInt(3, prisioneiroNovo.getNumRegistro());
            stmt.executeUpdate();
            System.out.println("Prisioneiro editado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao editar prisioneiro. \nErro: " + e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar stmt. \n Erro: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar conexão. \n Erro: " + e);
            }
        }
    }

    public void removerPrisioneiro(int numRegistro) {
        String sql = "DELETE FROM prisioneiro WHERE numRegistro = " + numRegistro;
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Prisioneiro removido com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao remover prisioneiro. \nErro: " + e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar stmt. \n Erro: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar conexão. \n Erro: " + e);
            }
        }
    }

    public boolean existePrisioneiroNaCela(int numeroCela) {
        String sql = "SELECT COUNT(*) FROM prisioneiro WHERE num_cela = ?";

        try (Connection conn = ConexaoDAO.conectorBD(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, numeroCela);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true se houver algum prisioneiro
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
