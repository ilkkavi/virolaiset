package site.registration;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class RegistrationDaoImpl extends BaseDaoImpl<Registration, Integer> implements RegistrationDao {
	public RegistrationDaoImpl(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, Registration.class);
	}
}
