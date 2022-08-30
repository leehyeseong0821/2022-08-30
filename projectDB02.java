package projectD01;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class projectDB02 {

	public static void main(String[] args) {
		  
		Connection cn= null;
		PreparedStatement pe=null;
		ResultSet re=null;
		
		String dbURL="jdbc:mariadb://localhost:3306/user";
        String dbID="user";
        String dbPassword ="123456";
        
        try {
        	Class.forName("org.mariadb.jdbc.Driver");
        	cn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        	String SQL="INSERT INTO useratable(userName,userTel,userAddress)VALUES('홍길동','010-1234-1234','부산시 북구');";
        	String SQL1="INSERT INTO useratable(userName,userTel,userAddress)VALUES('홍길자','010-5678-5678','부산시 남구');";
        	String SQL2="INSERT INTO useratable(userName,userTel,userAddress)VALUES('홍길순','010-1357-1357','부산시 서구');";
        	
        	
        	
        	pe = cn.prepareStatement(SQL);
        	int result = pe.executeUpdate();
        	
        	pe = cn.prepareStatement(SQL1);
        	int result1 = pe.executeUpdate();
        	
        	pe = cn.prepareStatement(SQL2);
        	int result2 = pe.executeUpdate();
        	
        	pe.close();
        	cn.close();
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

}
