package runner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

	public static double average(double[] arr){
		double temp = 0;
		double length = arr.length;
		for(int i = 0; i < length;i++){
			temp+= arr[i];
		}
		
		return temp/length;
	}
	
	public static String[] getFileNames(){
		String date = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		
		String[] str = {date + " MENA_Report.csv", date + " MENA_Fail.csv"};
		return str;
	}
}
