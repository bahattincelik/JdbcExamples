package bahattin.jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Jdbc5CRUD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain";
		
		Connection con = DriverManager.getConnection(url, "bahattin", "1234");

		Statement st = con.createStatement();
		
		/*=======================================================================
		ORNEK1: urunler adinda bir tablo olusturalim id(NUMBER(3), 
		isim VARCHAR2(10) fiyat NUMBER(7,2) 
		========================================================================*/

//		String createQuery = "CREATE TABLE urunler("
//							+ "	id NUMBER(3),"
//							+ " isim VARCHAR2(10),"
//							+ " fiyat NUMBER(7,2))";
//		
//		st.execute(createQuery);
//		System.out.println("Urunler tablosu olusturuldu...");
		
		/*=======================================================================
		ORNEK2: urunler tablosuna asagidaki kayitlari toplu bir sekilde ekleyelim
		========================================================================*/ 
		// Cok miktarda kayit eklemek icin PreparedStatement metodu kullanilabilir. 
		// PreparedStatement hem hizli hem de daha guvenli (SQL injection saldirilari icin) bir yontemdir. 
		// Bunun icin; 
		// 	1) Veri girisine uygun bir POJO(Plain Old Java Object) sinifi olusturulur.
		// 	2) POJO Class nesnelerini saklayacak bir collection olusturulur
		// 	3) bir dongu ile kayitlar eklenir.
		
//		List<Urun> kayitlar = new ArrayList<>();
//		
//		kayitlar.add(new Urun(101,"laptop",6500));
//		kayitlar.add(new Urun(102,"PC", 4500));
//		kayitlar.add(new Urun(103,"Telefon", 4500));
//		kayitlar.add(new Urun(104,"AnaKart", 1500));
//		kayitlar.add(new Urun(105,"Klavye", 200));
//		kayitlar.add(new Urun(106,"Fare", 100));
//		
//		String insertQuery = "INSERT INTO urunler VALUES (?,?,?)";
//		
//
//		PreparedStatement pst = con.prepareStatement(insertQuery);
//		
//		for (Urun each : kayitlar) {
//			pst.setInt(1, each.getId());
//			pst.setString(2, each.getIsim());
//			pst.setDouble(3, each.getFiyat());
//			pst.addBatch();
//		}
//		int [] sonuc = pst.executeBatch();
//		System.out.println(sonuc.length+" kayit eklendi");
		/*=======================================================================
		    ORNEK3: urunler tablosundaki PC’nin fiyatini %10 zam yapiniz
		   ========================================================================*/
		
//		String updateQuery1 = "UPDATE urunler"
//							+ "	SET fiyat = fiyat*1.1"
//							+ " WHERE isim='PC'";
//		
//		int s1 = st.executeUpdate(updateQuery1);
//		System.out.println(s1+" satir guncellendi...");
//		
		
		
		/*=======================================================================
		     ORNEK4: urunler tablosuna 107, Monitor, 1250 sekilnde bir kayit ekleyiniz
		   ========================================================================*/
//		
//		String insertQuery = "INSERT INTO urunler VALUES (107,'Monitor',1250)";
//		
//		int s2 = st.executeUpdate(insertQuery);
//		System.out.println(s2+" satir eklendi");
		
		
		
		/*=======================================================================
		     ORNEK5: urunler tablosundaki Klavyeyi siliniz.
		   ========================================================================*/
		
//		String deleteQuery = "DELETE FROM urunler WHERE id=105";
//		int s3 = st.executeUpdate(deleteQuery);
//		System.out.println(s3+" satir silindi");
		
		
		
		/*=======================================================================
		     ORNEK6: urunler tablosuna Marka adinda ve Default degeri ASUS olan yeni 
		     bir sutun ekleyiniz.
		    ========================================================================*/
		
//		String alterQuery = "ALTER TABLE urunler"
//								+ "	ADD Marka VARCHAR2(20) DEFAULT 'ASUS'";
//		
//		int s4 = st.executeUpdate(alterQuery);
//		System.out.println(s4+ " sutun eklendi");
		
		
		
		/*=======================================================================
		     ORNEK7: urunler tablosundaki kayitlari sorgulayiniz.
		   ========================================================================*/
		
		
		String seletQuery = "SELECT * FROM urunler";
		
		ResultSet satirlar = st.executeQuery(seletQuery);
		
		while (satirlar.next()) {
			System.out.println(satirlar.getInt(1)+" "+satirlar.getString(2)+" "+ satirlar.getDouble(3)+" "+satirlar.getString(4));
					
					
					
					
		}
		
		/*=======================================================================
		     ORNEK8: urunler tablosunu siliniz.
		   ========================================================================*/
	
		String dropQuery = "DROP TABLE urunler";
		int s5 = st.executeUpdate(dropQuery);
		System.out.println("Urunler tablosu silindi...");
	
	
	
	
	
	
	
	
	
	
	}

}
