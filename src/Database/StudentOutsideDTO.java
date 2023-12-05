package Database;

import java.util.Objects;

public class StudentOutsideDTO {
    private String universityNumber;
    private String reason;
    private String atime;
    private String outing_date;
    private String returning_date;
    private String success;
	private String content;

    public StudentOutsideDTO(String universityNumber, String reason, String content, String atime, String outing_date, String returning_date, String success) {
        this.universityNumber = universityNumber;
        this.reason = reason;
        this.content = content;
        this.atime = atime;
        this.outing_date = outing_date;
        this.returning_date = returning_date;
        this.success = success;
    }
    
    public StudentOutsideDTO() {
    	
    }
    public String getUniversityNumber() {
        return universityNumber;
    }

    public void setUniversityNumber(String universityNumber) {
        this.universityNumber = universityNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return atime;
    }

    public void setTime(String atime) {
        this.atime = atime;
    }

    public String getOutingDate() {
        return outing_date;
    }

    public void setOutingDate(String outingdate) {
        this.outing_date = outingdate;
    }

    public String getReturningDate() {
        return returning_date;
    }

    public void setReturningDate(String returningdate) {
        this.returning_date = returningdate;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentOutsideDTO that = (StudentOutsideDTO) o;
        return atime == that.atime &&
                Objects.equals(universityNumber, that.universityNumber) &&
                Objects.equals(reason, that.reason) &&
                Objects.equals(content, that.content) &&
                Objects.equals(outing_date, that.outing_date) &&
                Objects.equals(returning_date, that.returning_date) &&
                Objects.equals(success, that.success);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityNumber, reason, content, atime, outing_date, returning_date, success);
    }

    @Override
    public String toString() {
        return "StudentOutsideDTO{" +
                "universityNumber='" + universityNumber + '\'' +
                ", reason='" + reason + '\'' +
                ", content='" + content + '\'' +
                ", time=" + atime +
                ", outingDate='" + outing_date + '\'' +
                ", returningDate='" + returning_date + '\'' +
                ", success='" + success + '\'' +
                '}';
    }
}
