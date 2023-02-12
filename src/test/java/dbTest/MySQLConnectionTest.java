package dbTest;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionTest {

    // MySQL Connector의 클래스, DB 연결 드라이버 정의
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // DB 경로
    private static final String URL = "jdbc:mysql://localhost:3306/데이터베이스?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "testUser";
    private static final String PASSWORD = "user1234";

    @Test
    public void testConnection() throws Exception{
        Class.forName(DRIVER);
        try{
            Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("conn = " + conn);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
