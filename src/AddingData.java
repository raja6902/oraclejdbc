import java.util.*;
import java.sql.*;
public class AddingData{
    public static void main(String[] args)throws Exception{

        String driver = "oracle.jdbc.OracleDriver";
        String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "rajadb";
        String pwd = "tiger";

        Class.forName(driver);

        Connection conn = DriverManager.getConnection(jdbc_url,user,pwd);
        Statement st = conn.createStatement();
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter Employee number");
            int eno = scan.nextInt();
            System.out.println("Enter Employee name");
            String ename = scan.next();
            System.out.println("Enter Employee salary");
            double esal = scan.nextDouble();
            System.out.println("Enter Employee address");
            String eaddr = scan.next();
            String sqlQuery="insert into employees values(" + eno + ",'" + ename +"',"+ esal+ ",'"+ eaddr+"')";
            st.executeUpdate(sqlQuery);
            System.out.println("Record Inserted Successfully");
            System.out.println("Do you want to insert one more record [yes/no]:");
            String option = scan.next();
            if(option.equalsIgnoreCase("No"))
            {
                break;
            }

        }
        conn.close();
    }
}

