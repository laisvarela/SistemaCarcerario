package dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Guarda;

public class GuardaDAO {

    Connection connection = null;
    PreparedStatement stmt = null;
    Guarda g = null;
    ResultSet rs = null;

    public void inserirGuarda(Guarda guarda) {
        String sql = "INSERT INTO GUARDA(nome, cpf, dataNascimento, "
                + "matricula, turno, dataAdmissao, atribuido) "
                + "VALUES(?,?,?,?,?,?,?)";

        try {
            connection = ConexaoDAO.conectorBD();
            stmt = connection.prepareStatement(sql);

            //formata LocalDate para SQL Date
            java.sql.Date dataNascSql = java.sql.Date.valueOf(guarda.getDataNascimento());
            java.sql.Date dataAdmissaoSql = java.sql.Date.valueOf(guarda.getDataAdmissao());

            // preenche os valores da String sql
            stmt.setString(1, guarda.getNome());
            stmt.setString(2, guarda.getCpf());
            stmt.setDate(3, dataNascSql);
            stmt.setString(4, guarda.getMatricula());
            stmt.setString(5, String.valueOf(guarda.getTurno()));
            stmt.setDate(6, dataAdmissaoSql);
            stmt.setBoolean(7, guarda.isAtribuido());

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

    public ArrayList<Guarda> listarGuardas() {
        ArrayList<Guarda> listaGuardas = null;

        String sql = "SELECT * FROM guarda";
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs != null) {
                listaGuardas = new ArrayList<>();
                while (rs.next()) {
                    g = new Guarda(null, null, null);
                    g.setNome(rs.getString("nome"));
                    g.setCpf(rs.getString("cpf"));
                    g.setDataNascimento(LocalDate.parse(rs.getString("dataNascimento")));
                    g.setMatricula(rs.getString("matricula"));
                    g.setTurno(rs.getString("turno"));
                    g.setDataAdmissao(LocalDate.parse(rs.getString("dataAdmissao")));
                    g.setAtribuido(rs.getBoolean("atribuido"));
                    listaGuardas.add(g);
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
        return listaGuardas;
    }

    public String buscarGuarda(String matricula) {
        String sql = "SELECT * FROM guarda WHERE matricula LIKE ?";
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, matricula);
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    return rs.getString("matricula");
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

    public void editarGuarda(Guarda guardaNovo) {
        String sql = "UPDATE guarda SET nome = ?, turno = ? WHERE matricula = ?";

        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, guardaNovo.getNome());
            stmt.setString(2, guardaNovo.getTurno());
            stmt.setString(3, guardaNovo.getMatricula());
            stmt.execute();
            System.out.println("Guarda editado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao editar guarda. \nErro: " + e);
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

    public void removerGuarda(String matricula) {
        String sql = "DELETE FROM guarda WHERE matricula = " + matricula;
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Guarda removido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao remover guarda. \nErro: " + e);
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
}
