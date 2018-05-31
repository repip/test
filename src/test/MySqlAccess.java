package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MySqlAccess {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public MySqlAccess() {

		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://192.168.0.12/matrixintranet?" + "user=root&password=kaliffo");
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();

		} catch (Exception e) {

		}

	}
	

    public void ReadDbComp(String Cod, String Desc, String Tp, int Ci, List<DbDataNode> node) throws SQLException {

        resultSet = statement
                .executeQuery("SELECT COM, DES, TP, CI FROM DBCOMDES where ASS='"+ Cod + "' order by SEQ");
        List<DbDataNode> children = new ArrayList<DbDataNode>();
        while (resultSet.next()) {
			children.add(new DbDataNode(resultSet.getString("COM"), resultSet.getString("DES"),
					resultSet.getString("TP"), resultSet.getInt("CI"), null));
			ReadDbComp(resultSet.getString("COM"), resultSet.getString("DES"),
					resultSet.getString("TP"), resultSet.getInt("CI"),children);
        }
        
}

}
