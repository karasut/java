package in.spark.model;

import java.io.Serializable;

public class Address implements Serializable {
	public Address() {
    }
	public Address(String street, String city, String primary) {
        super();
        this.street = street;
        this.city = city;
        this.primary = primary;
    }

	 private String street;
	    
	    private String city;
	    
	    private String primary;

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getPrimary() {
			return primary;
		}

		public void setPrimary(String primary) {
			this.primary = primary;
		}
	    
}
