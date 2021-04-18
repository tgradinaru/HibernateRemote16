import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private static final String url  = "jdbc:mysql://localhost:3306/practical2_cinema";
    private static final String username = "root";
    private static final String password = "password";

    private static Connection instance = null;

    public static Connection getConnection(){ //facem un sigleton de tip lazy
        if(instance == null){
            try {
                instance = DriverManager.getConnection(url, username, password);
                /**
                 * pentru getConnection afisat cu rosu am ales right-click show action->try catch
                 * si am inlocuit variabila "throwable" cu "exception"
                 */
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        return instance;
    }
}
