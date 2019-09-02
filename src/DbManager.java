import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static DbManager dbManager;
    private String url = "jdbc:mysql://localhost:3306/janus_sell";
    private String user = "root";
    private String password = "root";

    private DbManager(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
        try {
            // 加载驱动
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void init(String url, String user, String password){
        if (dbManager != null) {
            return;
        }
        dbManager = new DbManager(url, user, password);
    }

    public static Connection getConnection() {
        if (dbManager == null) {
            throw new RuntimeException("未初始化DbManager.");
        }
        try {
            return DriverManager.getConnection(dbManager.url, dbManager.user, dbManager.password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("连接获取异常.");
        }
    }

}
