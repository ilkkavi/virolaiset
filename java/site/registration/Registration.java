package site.registration;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import spark.utils.StringUtils;

@DatabaseTable(tableName = "registration", daoClass = RegistrationDaoImpl.class)
public class Registration {
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField
	private String names;
	
	@DatabaseField
	private String email;
	
	@DatabaseField
	private int vegetarians;
	
	@DatabaseField
	private int vegans;
	
	@DatabaseField
	private int lactos;
	
	@DatabaseField
	private String allergies;
	
	@DatabaseField
	private String message;
	
	// Default constructor for ORMLITE
	public Registration() {}
	
	public Registration(String name, String email, int veg, int vegan, int lacto, String allergies, String message) {
		this.names = name;
		this.email = StringUtils.isBlank(email) ? null : email;;
		this.vegetarians = veg;
		this.vegans = vegan;
		this.lactos = lacto;
		this.allergies = StringUtils.isBlank(allergies) ? null : allergies;
		this.message = StringUtils.isBlank(message) ? null : message;
	}
}
