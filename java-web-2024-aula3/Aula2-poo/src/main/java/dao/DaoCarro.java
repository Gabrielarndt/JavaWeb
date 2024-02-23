package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classes.Carro;
import utils.Conexao;

public class DaoCarro {
	// public static List<Carro> carros = new ArrayList<>();

	public static boolean salvar(Carro carro) {
		Connection con = Conexao.getConexao();
		String sql = "insert into tb_carros(placa, modelo)values(?,?)";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, carro.getPlaca());
			stm.setString(2, carro.getModelo());
			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean alterar(Carro carro) {
		Connection con = Conexao.getConexao();
		String sql = "update tb_carros set placa = ?, modelo = ? where id = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, carro.getPlaca());
			stm.setString(2, carro.getModelo());
			stm.setInt(3, carro.getId());
			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

	public static List<Carro> consultar() {
		List<Carro> carros = new ArrayList<>();
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement stm = con.prepareStatement("select * from tb_carros");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Carro c = new Carro(rs.getInt("id"), rs.getString("placa"), rs.getString("modelo"));
				carros.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carros;
	}

	public static Carro consultarPorId(int id) {
		Connection con = Conexao.getConexao();
		Carro carro = null;
		try {
			PreparedStatement stm = con.prepareStatement("select * from tb_carros where id = ?");
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				carro = new Carro(rs.getInt("id"), rs.getString("placa"), rs.getString("modelo"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carro;
	}

	public static void excluir(int id) {
		Connection con = Conexao.getConexao();
		try {
			PreparedStatement stm = con.prepareStatement("delete from tb_carros where id = ?");
			stm.setInt(1, id);
			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
