package Server;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.List;

import Database.StudentInformationDTO;

public class Client {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    
    public Client() throws IOException {
        socket = new Socket("localhost", 12346);//"172.29.124.116", 12345
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }
    
    public boolean logIn(StudentInformationDTO information) throws IOException, ClassNotFoundException {

        String request = "로그인:" + information.getUniversityNumber() + ":" + information.getBirth();
        out.writeObject(request);

        try {
            // 서버가 데이터를 보낼 때까지 대기
            Object response = in.readObject();

            if (response instanceof String) {
                String result = (String) response;
                System.out.println(result);

                return result.equals("로그인 성공");
            }
        } catch (EOFException e) {
            // EOFException은 더 이상 읽을 데이터가 없을 때 발생하므로, 예외를 무시해도 됩니다.
        }

        return false;
    }
    public String bring(StudentInformationDTO information) throws IOException, ClassNotFoundException {

        String request = "개인정보조회:" + information.getUniversityNumber() + ":" + information.getBirth() +
        		":" + information.getName();
        out.writeObject(request);
        String result=null;
        try {
            // 서버가 데이터를 보낼 때까지 대기
        	//List<StudentInformationDTO>
            Object response = in.readObject();

            if (response instanceof List<StudentInformationDTO>) {
                result = (String) response;
                return result;
            }
        } catch (EOFException e) {
        	System.out.println(result);
            // EOFException은 더 이상 읽을 데이터가 없을 때 발생하므로ㄴ, 예외를 무시해도 됩니다.
        }
        System.out.println(result);
        return result;
    }
    public void endServer() {
       try {
         if (socket != null) socket.close();
         System.out.println("서버연결종료");
      } catch (IOException e) {
         System.out.println("소켓통신에러");
      }
    }
}