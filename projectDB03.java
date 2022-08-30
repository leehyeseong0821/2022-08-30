package projectD01;

  import java.sql.Connection;
  import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.PreparedStatement;
  import java.sql.DriverManager;

public class projectDB03 {

	public static void main(String[] args) {
		  
		Connection cn=null;
	    PreparedStatement pe = null;
	    ResultSet re =null;
	    String dbURL="jdbc:mariadb://127.0.0.1:3306/user";
	    String dbID="user";
	    String dbPassword ="123456";
	       
	       try {
	    	   Class.forName("org.mariadb.jdbc.Driver");
		       cn=DriverManager.getConnection(dbURL, dbID, dbPassword);
		       Scanner in =new Scanner(System.in);
		       System.out.println("이름을 입력하세요:");
		       String name = in.nextLine();
		       System.out.println("전화번호를 입력하세요:");
		       String tel = in.nextLine();
		       System.out.println("주소를 입력하세요:");
		       String address = in.nextLine();
		       
		       String SQL = "INSERT INTO useratable( userName,userTel,userAddress)VALUES(?,?,?);";
		       
		       pe = cn.prepareStatement(SQL);
		       pe.setString(1, name);
		       pe.setString(2, tel);
		       pe.setString(3, address);
		       
		       int result = pe.executeUpdate();
		       String SQL1 ="SELECT * FROM useratable";
		       pe = cn.prepareStatement(SQL1);
		       re = pe.executeQuery();
		       while(re.next()){
		    	   System.out.println(re.getString(1));
		    	   System.out.println(re.getString(2));
		    	   System.out.println(re.getString(3));
		    	   
		    	   
		       }
		       
		       
	    	   
	    	   
	    	   
	    	   
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
	}

}
