package Server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Database.DAO;
import Database.StudentInformationDTO;


public class Server {
	private DAO db;
    private List<ClientHandler> clientHandlers; // 클라이언트 핸들러들을 저장하는 리스트

    public Server() throws ClassNotFoundException, SQLException {
        db = new DAO();
        clientHandlers = new ArrayList<>();
    }

    public void startServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("서버 시작. 포트 " + port + "에서 대기 중");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress().getHostAddress());

                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;
        private ObjectOutputStream out;
        private ObjectInputStream in;

        public ClientHandler(Socket socket) throws IOException {
            clientSocket = socket;
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String request = (String) in.readObject();
                    String[] requestData = request.split(":");
                    String operation = requestData[0];
                    System.out.println(operation);
                    switch (operation) {
                        case "로그인":
                        	StudentInformationDTO information = new StudentInformationDTO();
                            information.setUniversityNumber(requestData[1]);
                            information.setBirth(requestData[2]);
                            boolean loginResult = db.login(information);
                            System.out.println(loginResult);
                            out.writeObject(loginResult ? "로그인 성공" : "로그인 성공");
                            break;
                        case "개인정보조회":
                        	StudentInformationDTO informationdata = new StudentInformationDTO();
                        	informationdata.setUniversityNumber(requestData[1]);
                        	informationdata.setBirth(requestData[2]);
                        	informationdata.setName(requestData[3]);
                            StudentInformationDTO CheckResult = db.Search_Student_Info2(informationdata);
                            System.out.println(CheckResult);
                            out.writeObject(CheckResult);
                            break;
                        // UPDATE, DELETE 등 다른 작업에 대한 case도 추가 가능
                        default:
                            out.writeObject("INVALID_OPERATION");
                            break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        int port = 12346; // 사용할 포트 번호로 변경
        Server server = new Server();
        server.startServer(port);
    }
}