package bahattin.jdbcExamples;

import java.sql.*; //Tum JDBC metotlarini eklemek icin.


public class JdbcQuery02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain";
		
		Connection con = DriverManager.getConnection(url, "bahattin", "1234");

		Statement st = con.createStatement();
		
		/*=======================================================================
		 ORNEK1: Bolumler tablosundaki tum kayitlari listeleyen bir sorgu yaziniz.
		========================================================================*/ 
		
		String selectQuery = "SELECT * FROM bolumler";
		ResultSet bolumlerTablosu = st.executeQuery(selectQuery);
		
		while (bolumlerTablosu.next()) {
			System.out.println(bolumlerTablosu.getInt(1)+" "+
								bolumlerTablosu.getString(2)+" "+
								bolumlerTablosu.getString(3));
		}

		System.out.println("=====================================");
		
		/*=======================================================================
		 ORNEK2: SATIS ve MUHASABE bolumlerinde calisan personelin isimlerini ve 
 		 maaslarini, maas ters sirali olarak listeleyiniz
		========================================================================*/ 
		
		String selectQuery2="SELECT personel_isim, maas FROM personel  WHERE bolum_id IN (10, 30) ORDER BY maas DESC";
							
		
		ResultSet rs = st.executeQuery(selectQuery2);
		while (rs.next()) {
			System.out.println("Isim"+rs.getString(1)+"\t" +"Maas" +rs.getDouble(2));
		}
		
		
		
		
		
		
		
		
		con.close();
		st.close();
		bolumlerTablosu.close();
	}

}
