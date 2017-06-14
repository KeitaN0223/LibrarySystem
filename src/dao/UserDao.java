package dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.User;
import exception.SQLRuntimeException;


public class UserDao {
	public void insert(Connection connection, User user) {

		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO users ( ");
			sql.append(" card_number");
			sql.append(", name");
			sql.append(", address");
			sql.append(", tel");
			sql.append(", mail");
			sql.append(", register_time");
			sql.append(", password");
			sql.append(", library_id");
			sql.append(", is_admin");
			sql.append(") VALUES (");
			sql.append(" ?"); // card_number
			sql.append(", ?"); // name
			sql.append(", ?"); // address
			sql.append(", ?"); // tel
			sql.append(", ?"); // mail
			sql.append(", CURRENT_TIMESTAMP"); // register_time
			sql.append(" ?"); // password
			sql.append(" ?"); // library_id
			sql.append(" ?"); // is_admin
			sql.append(")");

			ps = connection.prepareStatement(sql.toString());

			ps.setLong(1, user.getCardNumber());
			ps.setString(2, user.getName());
			ps.setString(3, user.getAddress());
			ps.setLong(4, user.getTel());
			ps.setString(5, user.getMail());
			ps.setString(6, user.getPassword());
			ps.setInt(7, user.getLibraryId());
			ps.setInt(8, user.getIsAdmin());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new SQLRuntimeException(e);
		} finally {
			close(ps);
		}
	}
}
