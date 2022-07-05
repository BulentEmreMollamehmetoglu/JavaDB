import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connection {
    private String db_name = "demo";
    private String username= "root";
    private String password= "";
    private String host = "localhost";
    private int port = 3306;

    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
        Statement st = con.createStatement();
//        String q1 = "select * from users";
//        ResultSet r1 = st.executeQuery(q1);
//        String q2 = "select * from users order by lastname desc";
//        ResultSet r2 = st.executeQuery(q2);
//        while(r1.next()){
//            System.out.println(r1.getString("name"));
//        }
//        while(r2.next()){
//            System.out.println(r2.getString("lastname"));
//        }
//        String q3 = "insert into users VALUES(5,'y','z','k')";
//        int r2 = st.executeUpdate(q3);
//
//        System.out.println(r2 + " row inserted");
        List<MyCompaniesPojo> records = new ArrayList<>();
        records.add(new MyCompaniesPojo(104, "HUAVEI", "sams", "a"));
        records.add(new MyCompaniesPojo(105, "SAMSUNG","hms","b"));
        records.add(new MyCompaniesPojo(106, "LG","kams","c"));
        int counter = 0;
        for(MyCompaniesPojo w : records) {

            String q7 = "INSERT INTO users VALUES("+w.getCompanyID()+",'" + w.getCompanyName() +"',"+ "'"+ w.getCompanyLastName()+ "',"+ "'"+ w.getCompanyEmail() +"')";
            counter = counter + st.executeUpdate(q7);

        }

        System.out.println(counter + " rows inserted");
    }
    static class MyCompaniesPojo{
        private int id;
        private String s1;
        private String s2;
        private String s3;

        public MyCompaniesPojo(){
            id = 0;
            s1 = "";
            s2 = "";
            s3 = "";
        }
        public MyCompaniesPojo(int id,String s1,String s2,String s3){
            this.id = id;
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }
        public int getCompanyID(){
            return this.id;
        }
        public String getCompanyName(){
            return this.s1;
        }
        public String getCompanyLastName(){
            return this.s2;
        }
        public String getCompanyEmail(){
            return this.s3;
        }
    }
}
