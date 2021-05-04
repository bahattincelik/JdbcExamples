package bahattin.jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcQuery01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1) Ilgili driver'i yuklemeliyiz
		Class.forName("oracle.jdbc.drive.OracleDriver");

		//2) Baglanti olusturmaliyiz
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain",
				"bahattin", "1234");
	}

}
