import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AServiceTest { 
	static String dbUrl = "jdbc:mysql://localhost:3306/segmenter?user=segmenter&password=segmenter";

// Neither @Before nor @BeforeClass helps when executing this after a test using fakeApplicationBase test in the console. 	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		//TODO goes  boink on in the Play  console when executed with Play test using fakeApplication
//		Class.forName("com.mysql.jdbc.Driver").newInstance();
//	}

	@Before
	public  void setUpBefore() throws Exception {
		//TODO goes  boink on in the Play  console when executed with Play test using fakeApplication
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	}
	
	@Test
	public void test() throws SQLException{
		DriverManager.getConnection(dbUrl);	
	}
	

}
