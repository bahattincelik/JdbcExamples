package bahattin.jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc4DMLInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain";
	
	Connection con = DriverManager.getConnection(url, "bahattin", "1234");

	Statement st = con.createStatement();	
	
	/*=======================================================================
	 ORNEK1: Bolumler tablosuna yeni bir kayit ((80, ‘ARGE’, ‘ISTANBUL’) 
	 ekleyelim ve eklenen kaydi teyit icin sorgulayalim.
	========================================================================*/
	
//	String insertQuery = "INSERT INTO bolumler VALUES "
//			+ "	(80, 'ARGE', 'ISTANBUL')";
//	st.execute(insertQuery);
//	System.out.println("Bilgiler eklendi...");
	
//	String selectQuery = "SELECT * FROM bolumler";
//	
//	ResultSet rs = st.executeQuery(selectQuery);
//	
//	while (rs.next()) {
//		System.out.println("Bolum Id : "+rs.getInt(1)+" "
//							+"Bolum Isimi : "+ rs.getString(2)+ " "
//							+"Konum : "+rs.getString(3));
//		
//	}
	
	/*=======================================================================
		ORNEK2: Bolumler tablosuna birden fazla yeni kayıt ekleyelim.
	 ========================================================================*/
	 // 1.YONTEM
    // -----------------------------------------------
    // Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin 
    // yavas yapilmasina yol acar. 10000 tane veri kaydi yapildigi dusunuldugunde
    // bu kotu bir yaklasimdir.
    
//    String [] sorgular = {"INSERT INTO bolumler VALUES(95, 'YEMEKHANE', 'ISTANBUL')",
//                         "INSERT INTO bolumler VALUES(85, 'OFIS','ANKARA')",
//                         "INSERT INTO bolumler VALUES(75, 'OFIS2', 'VAN')"};
//	
//    
//    for (String each : sorgular) {
//		st.executeQuery(each);
//	}
//    String selectQuery2 = "SELECT * FROM bolumler";
//	
//	ResultSet rs1 = st.executeQuery(selectQuery2);
//	
//	while (rs1.next()) {
//		System.out.println("Bolum Id : "+rs1.getInt(1)+" "
//							+"Bolum Isimi : "+ rs1.getString(2)+ " "
//							+"Konum : "+rs1.getString(3));
//		
//	}
    
	// 2.YONTEM (addBath ve excuteBatch() metotlari ile)
   	// ----------------------------------------------------
   	// addBatch metodu ile SQL ifadeleri gruplandirilabilir ve exucuteBatch()
   	// metodu ile veritabanina bir kere gonderilebilir.
   	// excuteBatch() metodu bir int [] dizi dondurur. Bu dizi her bir ifade sonucunda 
   	// etkilenen satir sayisini gosterir.
	
	 
    String [] sorgular1 = {"INSERT INTO bolumler VALUES(81, 'YEMEKHANE2', 'MUS')",
                         "INSERT INTO bolumler VALUES(82, 'OFIS3','ORDU')",
                         "INSERT INTO bolumler VALUES(73, 'OFIS4', 'MUGLA')"};
	
    
	for (String each : sorgular1) {
		st.addBatch(each);
	}
	
	int[] s3 = st.executeBatch();
	
	System.out.println(s3.length+" satir eklendi");
	
	// 3. YONTEM
	//-----------------------------------------------------
	// batch metoduyla birlikte PreparedStatement kullanmak en efektif yontemdir.
	// bir sonraki ornekte bunu gerceklestirecegiz.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
    con.close();
	st.close();
	//rs1.close();
	
	}

}


	
	

