package projectD01;
 
  import java.sql.Connection;
  import java.sql.PreparedStatement;
  import java.sql.DriverManager;
  import java.sql.ResultSet;

public class projectDB01 {

	public static void main(String[] args) {
		Connection cn = null;
		PreparedStatement pe = null;
		ResultSet re = null;
		
		String dbURL="jdbc:mariadb://localhost:3306/user";
        String dbID="user";
        String dbPassword ="123456";
        
        try {
        	Class.forName("org.mariadb.jdbc.Driver");
        	cn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        	String SQL="CREATE TABLE userbTable("
        			 + "username VARCHAR(50),"
        			 + "userTel VARCHAR(50),"
        			 + "userAddress VARCHAR(255)"
        			 + ")";
        	
        	 pe = cn.prepareStatement(SQL);
        	 int result = pe.executeUpdate();
        	 System.out.println("테이블이 생성되었습니다.");
        	 pe.close();
        	 cn.close();
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
		

	}

}
