import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //firstSelectInDB();
        createTableFromConsole();
    }


    private static void createTableFromConsole() {
        Map<String, String> columns = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        String tableName = scanner.nextLine();

        System.out.println("Please insert the numbers of columns for " + tableName + " table: ");
        Integer columnNumber = Integer.valueOf(scanner.nextLine());

        for (int index = 1; index <= columnNumber; index++) {
            System.out.println("Please insert column " + index + " name: ");
            String columnName = scanner.nextLine();

            System.out.println("Please insert column " + index + " definition: ");
            String columnDefinition = scanner.nextLine();

            if (index != columnNumber) {
                columnDefinition += ", ";
            } else {
                columnDefinition += ")";
            }
            columns.put(columnName, columnDefinition);
        }

        String createTableSql = "Create table " + tableName + "( ";
        for (Map.Entry<String, String> element : columns.entrySet()) {
            createTableSql += element.getKey() + " " + element.getValue();
        }
        System.out.println(createTableSql);
        Connection connection = DBService.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createTableSql);
            preparedStatement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void firstSelectInDB() {
        //primul pas: realizam o conexiune la baza de date
        Connection connection = DBService.getConnection();

        //al doilea pas: create / prepare statement
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from movies");
            //al treilea pas: execut
            ResultSet resultSet = preparedStatement.executeQuery();

            //al patrulea pas: iterez prin rezultat
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String producer = resultSet.getString("producer");
                System.out.println(title + " " + producer);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
