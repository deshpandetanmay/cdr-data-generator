package in.co.hadooptutorials.data.generator.cdr;


import java.util.Random;
import java.util.UUID;

import org.fluttercode.datafactory.impl.DataFactory;
import org.joda.time.DateTime;
/**
 * 
 * Telecom Call Data/Detail Record Generator.
 * @author Tanmay Deshpande
 * 
 */

public class App {
	public static void main(String[] args) {
		DataFactory df = new DataFactory();
		Random r = new Random();
		for (int i = 0; i < 100; i++) {

			UUID id = UUID.randomUUID();
			
			String calling_num = df.getNumberText(10);
			String called_num = df.getNumberText(10);
		
		    long t1 = System.currentTimeMillis() + r.nextInt();
		    long t2 = t1 + 2 * 60 * 1000 + r.nextInt(60 * 1000) + 1;
		    DateTime d1 = new DateTime(t1);
		    DateTime d2 = new DateTime(t2);
			String callType = "";
			if ( r.nextInt() % 2 == 0){
				callType = "VOICE";
			} else {
				callType = "SMS";
			}
			if ("SMS" == callType) {
				d2 = new DateTime(t1);	
			}
			String callResult = "ANSWERED";
			if ((i % 10 )== 0 && callType == "VOICE") {
				callResult = "BUSY";
				d2 = new DateTime(t1);	
			}
			Float charge = r.nextFloat();
			System.out.println(id.toString()+"|"+calling_num+"|"+called_num+"|"+d1.toString()+"|"+d2.toString()+"|"+callType+"|"+charge+"|"+callResult);
		}
	}
}
