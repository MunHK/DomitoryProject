package Database;

public class StudentRoomDTO {
    
	private String universityNumber;
	private int room;
	private String startDate;
    private String endDate;

    public StudentRoomDTO(String universityNumber, int room, String startDate, String endDate) {

    	this.universityNumber = universityNumber;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

	public StudentRoomDTO() {
			// TODO Auto-generated constructor stub
		}
	
	public String getUniversityNumber() {
	        return universityNumber;
	    }
	
	public void setUniversityNumber(String universityNumber) {
		this.universityNumber = universityNumber;
    }
    public int getRoom() {

    	return room;
    }

    public void setRoom(int room) {
        
   
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
    
}