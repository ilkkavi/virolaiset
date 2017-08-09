package site.util;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class DB {
	private static final String DBURL = "jdbc:mysql://localhost:3306/databasename";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	
	
	private static ConnectionSource connectionSource = null;
	
	public static ConnectionSource getConnectionSource() throws SQLException {
		if (connectionSource == null)
			initConnection();
		
		return connectionSource;
	}

	private static void initConnection() throws SQLException {
		connectionSource = new JdbcPooledConnectionSource(DBURL, USERNAME, PASSWORD);
		
	}
}
