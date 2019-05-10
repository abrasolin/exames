package br.com.brasolin.exame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.brasolin.exame.entity.Agenda;

public class DaoAgenda {

	public static Connection myconnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/exames", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String incluirAgenda(Agenda agenda) throws SQLException, Exception {
		try {
			String sql = "INSERT INTO AGENDA VALUES (?,?,?,?,?)";
			PreparedStatement ps = myconnection().prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(agenda.getData().getTime()));
			ps.setString(2, agenda.getCodigoCliente());
			ps.setString(3, agenda.getNomeCliente());
			ps.setString(4, agenda.getCodigoExame());
			ps.setString(5, agenda.getNomeExame());
			ps.executeUpdate();
			return "Agenda Incluida com sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		} finally {
			if (myconnection() != null) {
				myconnection().close();
			}
		}
	}

	public ResultSet listarAgenda() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM AGENDA";
			PreparedStatement ps = myconnection().prepareStatement(sql);
			rs = ps.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (myconnection() != null) {
				myconnection().close();
			}
		}
	}

	public String alterarAgenda(Agenda agenda)
			throws SQLException, Exception {
		try {
			String sql = "UPDATE AGENDA SET DATA=?,CODIGOCLIENTE=?,NOMECLIENTE?, CODIGOEXAME=?, NOMEEXAME=? WHERE UEMAIL=?";
			PreparedStatement ps = myconnection().prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(agenda.getData().getTime()));
			ps.setString(2, agenda.getCodigoCliente());
			ps.setString(3, agenda.getNomeCliente());
			ps.setString(4, agenda.getCodigoExame());
			ps.setString(5, agenda.getNomeExame());
			ps.setInt(6, agenda.getId());
			ps.executeUpdate();
			return "Agenda Alterada com sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		} finally {
			if (myconnection() != null) {
				myconnection().close();
			}
		}
	}

	public String excluirAgenda(Integer id) throws SQLException, Exception {
		try {
			String sql = "DELETE FROM AGENDA WHERE ID=?";
			PreparedStatement ps = myconnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			return "Agenda Excluida com Sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		} finally {
			if (myconnection() != null) {
				myconnection().close();
			}
		}
	}
}