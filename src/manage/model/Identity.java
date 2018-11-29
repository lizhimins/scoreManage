package manage.model;

public class Identity {
	private static String Identity;

	public static String getIdentity() {
		return Identity;
	}

	public static void setAdmin() {
		Identity = "Admin";
	}
	
	public static void setTeacher() {
		Identity = "Teacher";
	}
	
	public static void setStudent() {
		Identity = "Student";
	}
}
