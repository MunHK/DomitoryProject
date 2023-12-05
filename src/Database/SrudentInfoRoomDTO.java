package Database;

public class SrudentInfoRoomDTO {

	private String universityNumber;
    private String name;
    private String sex;
    private String department;
    private String address;
    private String phoneNumber;
    private String birth;
	private String room;
	private String startDate;
    private String endDate;
    
    // 생성자
    public SrudentInfoRoomDTO(String universityNumber, String name, String sex, String department,
                                  String address, String phoneNumber, String birth, String room, String startDate, String endDate) {
        this.universityNumber = universityNumber;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getter 및 Setter 메서드

    public SrudentInfoRoomDTO() {
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

	public String getRoom() {
	
		return room;
	}
	
	public void setRoom(String room) {
	    
	
		this.room = room;
	}
	
	public String getStartDate() {
	
		return startDate;
	}
	
	public void setStartDate(String startDate) {
	    this.startDate = startDate;
	}
	
	public String getEndDate() {
	    return endDate;
	}
	
	public void setEndDate(String endDate) {
	    this.endDate = endDate;
	}
	public String getContent() {
	    return endDate;
	}
}
