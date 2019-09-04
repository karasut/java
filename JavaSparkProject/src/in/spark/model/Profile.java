package in.spark.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Profile implements Serializable {

	public Profile() {

	}

	public Profile(Profile_ profile) {
        super();
        this.profile = profile;
    }

	private Profile_ profile;

	public Profile_ getProfile() {
		return profile;
	}

	public void setProfile(Profile_ profile) {
		this.profile = profile;
	}

}
