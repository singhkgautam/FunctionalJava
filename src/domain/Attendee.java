package domain;

public class Attendee {
	private final String firstName;
	private final String lastName;
	private final String email;
	private final int age;
	private final String organization;

	public Attendee(String firstName, String lastName, String email, String organization, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.organization = organization;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public String getOrganization() {
		return organization;
	}
	
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + " Age: " + getAge() + " Email: " + getEmail();
	}
}
