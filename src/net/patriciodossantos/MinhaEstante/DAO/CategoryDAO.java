package net.patriciodossantos.MinhaEstante.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.patriciodossantos.MinhaEstante.DB.ConnectionFactory;
import net.patriciodossantos.MinhaEstante.Model.Category;

public class CategoryDAO {

	public static void save(Category category) {
		try (Connection connection = new ConnectionFactory().getConnection()) {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO categories (name) VALUES (?)");
			ps.setString(1, category.getName());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
