package Database;

public class StudentInfoCheckDTO {

    private String universityNumber;
    private String startDate;
    private String ing;
    private String inOut;

    private String name;
    private String sex;
    private String department;
    private String address;
    private String phoneNumber;
    private String birth;

    // 생성자
    public StudentInfoCheckDTO(String universityNumber, String startDate, String ing, String inOut,
            String name, String sex, String department, String address, String phoneNumber, String birth) {
        this.universityNumber = universityNumber;
        this.startDate = startDate;
        this.ing = ing;
        this.inOut = inOut;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
    }
    public StudentInfoCheckDTO() {
    }
    // Getter 메서드
    public String getUniversityNumber() {
        return universityNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getIng() {
        return ing;
    }

    public String getInOut() {
        return inOut;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getDepartment() {
        return department;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirth() {
        return birth;
    }

    // Setter 메서드
    public void setUniversityNumber(String universityNumber) {
        this.universityNumber = universityNumber;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    // 추가로 toString() 등의 메서드를 구현할 수 있습니다.
}