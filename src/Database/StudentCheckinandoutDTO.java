package Database;

import java.sql.Timestamp;

public class StudentCheckinandoutDTO {
    private String universityNumber;
    private String startDate;
    private String ing;
    private String inOut;

    // 기본 생성자
    public StudentCheckinandoutDTO() {
    }

    // 모든 필드를 초기화하는 생성자
    public StudentCheckinandoutDTO(String universityNumber, String startDate, String ing, String inOut) {
        this.universityNumber = universityNumber;
        this.startDate = startDate;
        this.ing = ing;
        this.inOut = inOut;
    }

    // Getter 및 Setter 메서드
    public String getUniversityNumber() {
        return universityNumber;
    }

    public void setUniversityNumber(String universityNumber) {
        this.universityNumber = universityNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }
}