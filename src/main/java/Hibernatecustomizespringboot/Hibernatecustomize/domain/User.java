package Hibernatecustomizespringboot.Hibernatecustomize.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class User implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
		@Id
		@GeneratedValue( strategy= GenerationType.AUTO,generator="native")
		@GenericGenerator(name = "native",strategy = "native")
		
	    private long id;
		
	    @Column(name = "name")
	    private String name;
	    
	    @Column(name = "lastname")
	    private String lastName;
	    @Column(name = "address")
	    private String address;

	    public User() {
	    }
	    
		public User(String name, String lastName,String address) {
			super();
			this.name = name;
			this.lastName = lastName;
			this.address=address;
			
		}

		


		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
		
	    
	    
	    

}
