package Database;

public class StudentRecordDTO {
    private String university_number;
    private String name;
    private String reason;
    private String score;

    // 생성자
    public StudentRecordDTO(String university_number, String name, String reason, String score) {
        this.university_number = university_number;
        this.name = name;
        this.reason = reason;
        this.score = score;
    }

    public StudentRecordDTO() {
    }
    // Getter 및 Setter 메서드
    public String getUniversityNumber() {
        return university_number;
    }

    public void setUniversityNumber(String university_number) {
        this.university_number = university_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
