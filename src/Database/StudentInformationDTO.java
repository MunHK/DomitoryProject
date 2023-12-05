package Database;

public class StudentInformationDTO {
    private String universityNumber;
    private String name;
    private String sex;
    private String department;
    private String address;
    private String phoneNumber;
    private String birth;

    // 생성자
    public StudentInformationDTO(String universityNumber, String name, String sex, String department,
                                  String address, String phoneNumber, String birth) {
        this.universityNumber = universityNumber;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
    }

    // Getter 및 Setter 메서드

    public StudentInformationDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getUniversityNumber() {
        return universityNumber;
    }

    public void setUniversityNumber(String universityNumber) {
        this.universityNumber = universityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}