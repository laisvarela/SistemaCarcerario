package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cela;
import model.Guarda;

public class CelaDAO {

    Connection connection = null;
    PreparedStatement stmt = null;
    Cela c = null;
    ResultSet rs = null;

    public void inserirCela(Cela cela) {
        String sql = "INSERT INTO cela(numero, capacidade, guarda_diurno, guarda_noturno, lotado) "
                + "VALUES(?,?,?,?,?)";

        try {
            connection = ConexaoDAO.conectorBD();
            stmt = connection.prepareStatement(sql);

            // preenche os valores da String sql
            stmt.setInt(1, cela.getNumero());
            stmt.setInt(2, cela.getCapacidade());

            if (cela.getGuardaDiurno() != null) {
                stmt.setString(3, cela.getGuardaDiurno().getMatricula());
            }
            if (cela.getGuardaNoturno() != null) {
                stmt.setString(4, cela.getGuardaNoturno().getMatricula());
            }
            stmt.setBoolean(5, cela.isLotado());

            //adicionar no bando de dados
            stmt.executeUpdate();

            System.out.println("Dados de cela inseridos no banco de dados.");
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

    public ArrayList<Cela> listarCelas() {
        ArrayList<Cela> listaCelas = new ArrayList<>();

        String sql = "SELECT c.*, gd.matricula as guarda_diurno, gn.matricula as guarda_noturno "
                + "FROM cela c "
                + "JOIN guarda gd ON c.guarda_diurno = gd.matricula "
                + "JOIN guarda gn ON c.guarda_noturno = gn.matricula";
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs != null) {
                listaCelas = new ArrayList<>();
                while (rs.next()) {
                    c = new Cela();
                    c.setNumero(rs.getInt("numero"));
                    c.setCapacidade(rs.getInt("capacidade"));
                    c.setLotado(rs.getBoolean("lotado"));
                    if (rs.getString("guarda_diurno") != null) {
                        Guarda diurno = new Guarda(null, null, null);
                        diurno.setMatricula(rs.getString("guarda_diurno"));
                        c.setGuardaDiurno(diurno);
                    }

                    if (rs.getString("guarda_noturno") != null) {
                        Guarda noturno = new Guarda(null, null, null);
                        noturno.setMatricula(rs.getString("guarda_noturno"));
                        c.setGuardaNoturno(noturno);
                    }

                    listaCelas.add(c);
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
        return listaCelas;
    }

    public String buscarCela(String numero) {
        String sql = "SELECT * FROM cela WHERE numero LIKE ?";
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, numero);
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    return rs.getString("numero");
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

    public void editarCela(Cela celaNovo) {
        String sql = "UPDATE cela SET capacidade = ?, guarda_diurno = ?, guarda_noturno = ? WHERE numero = ?";

        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, celaNovo.getCapacidade());

            if (celaNovo.getGuardaDiurno() != null) {
                stmt.setString(2, celaNovo.getGuardaDiurno().getMatricula());
            }

            if (celaNovo.getGuardaNoturno() != null) {
                stmt.setString(3, celaNovo.getGuardaNoturno().getMatricula());
            }
            stmt.setInt(4, celaNovo.getNumero());
            stmt.executeUpdate();
            System.out.println("Cela editado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao editar cela. \nErro: " + e);
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

    public void removerCela(int numero) {
        String sql = "DELETE FROM cela WHERE numero = " + numero;
        try {
            connection = new ConexaoDAO().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Cela removida com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao remover cela. \nErro: " + e);
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
