package ba.team12;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "firstName") 
	String firstName;
	
	@Column(name = "lastName") 
	String lastName;
	
	@Column(name = "username") 
	String username;
	
	@Column(name = "password") 
	String password;
	
	public User(String fname, String lname, String usern, String pass) {
		firstName = fname;
		lastName = lname;
		username = usern;
		password = pass;
	}

}
