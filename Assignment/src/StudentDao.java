import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	 public static Connection getConnection()
	 {
		 Connection con=null;
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc.mysql://192.168.100.26:3306/group003","group003                    ","welcome");
		}         
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 
		 return con;
	 }
	 
	 
	 public static int getStudentbyPRN(int prn)
	 {
		 Student s=new Student();
		 
		 try
		 {
			 Connection con=StudentDao.getConnection(); 
	            PreparedStatement ps=con.prepareStatement("select * from Student_PRN where PRN=?");  
	            ps.setInt(1,prn);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                s.setPRN(rs.getInt(1));  
	                s.setName(rs.getString(2));  
	                s.setS1(rs.getDouble(3));  
	                s.setS2(rs.getDouble(4));  
	                s.setS3(rs.getDouble(5));  
	            }  
	            con.close();  
		 }catch(Exception ex){ex.printStackTrace();}  
	          
	        return prn;  
	 }
	 
	 public static List<Student> getAllStudents(){  
	        List<Student> list=new ArrayList<Student>();  
	          
	        try{  
	            Connection con=StudentDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from Student_PRN");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Student s=new Student();  
	                s.setPRN(rs.getInt(1));  
	                s.setName(rs.getString(2));  
	                s.setS1(rs.getDouble(3));  
	                s.setS2(rs.getDouble(4));  
	                s.setS3(rs.getDouble(5));  
	                list.add(s);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
}
