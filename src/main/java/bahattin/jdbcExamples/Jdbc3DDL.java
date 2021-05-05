package bahattin.jdbcExamples;

import java.sql.*;

public class Jdbc3DDL {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
			String url = "jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain";
		
		Connection con = DriverManager.getConnection(url, "bahattin", "1234");

		Statement st = con.createStatement();	
		
		/*
	 	A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet) 
	 	 dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC’de 2 alternatif bulunmaktadir.  
	 	  1) execute() metodu 
	 	  2) excuteUpdate() metodu.  
	 	  
	 	B) - execute() metodu hertur SQL ifadesiyle kullanibilen genel bir komuttur. 
	 	 - execute(), Boolean bir deger dondurur. DDL islemlerin false dondururken, 
	 	 - DML islemlerinde true deger dondurur. 
	 	 - Ozellikle hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi 
	 	  durumlarda tercih edilmektedir.  
	 	   
	 	C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
	 	 - bu islemlerde islemden etkilenen satir sayisini dondurur.
	 	 - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
	 */
		
		/*=======================================================================
		 ORNEK2:isciler adinda bir tablo olusturunuz id NUMBER(3), 
		 birim VARCHAR2(10), maas NUMBER(5)
		========================================================================*/
		
		String createQuery = "CREATE TABLE isciler"
				+ " (id NUMBER(3),"
				+ " birim VARCHAR2(10),"
				+ " maas NUMBER(5))";
		
		// 1. YONTEM (execute() metodu ile)
		
//		boolean s1 = st.execute(createQuery);//false deger dondurecek DDL
//		System.out.println("Isciler tablosu olusturuldu "+s1);
	
		
//		st.execute(createQuery);//false deger dondurecek DDL
//		System.out.println("Isciler tablosu olusturuldu ");
		
		// 2. YONTEM (executeUpdate() metodu ile)

	 	int s2 = st.executeUpdate(createQuery);// DDL islemleri icin ) degerini dondurur.
		System.out.println("Isciler tablosu olusturuldu "+s2);

		/*======================================================================
		ORNEK1:isciler tablosunu kalici olarak siliniz 		
		========================================================================*/
		
		
		
		
		

	}
}
