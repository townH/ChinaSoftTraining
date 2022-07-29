package homework;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        String dir = Main.class.getResource("/db.properties").getPath();
        properties.load(new BufferedReader(new FileReader(dir)));

        //
        String driver = (String) properties.getProperty("jdbc.driver") ;
        String url = (String) properties.get("jdbc.url");
        String username= (String) properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");

        // 1.加载数据访问驱动
        Class.forName(driver);
        //2.连接到数据"库"上去
        Connection conn= DriverManager.getConnection(url,username,password);

        //3.构建SQL命令
        Properties sqlPro = new Properties();
        InputStream resourceAsStream = Main.class.getResourceAsStream("/jdbc.properties");
        properties.load(resourceAsStream);

        String sql = properties.getProperty("product.query");
//        System.out.println("property = " + sql);

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("resultSet = " + resultSet);


//        Statement state=conn.createStatement();
//        String s="insert into test values('male',100,'HHH')";
//        state.executeUpdate(s);


//        Properties properties = new Properties();
//        String dir = Main.class.getResource("/jdbc.properties").getPath();
//        properties.load(new BufferedReader(new FileReader(dir)));
//        String username = properties.getProperty("jdbc.username");
//        System.out.println(username);
    }


}
