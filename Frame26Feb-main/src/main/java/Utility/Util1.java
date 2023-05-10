package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class Util1 extends TestBase {

	
	public static void screenShot(String name, String date) throws IOException
	{
		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File dest = new File("/Users/Zenith/eclipse-workspace/Framework26feb2022/Screenshots/"+name+ date + ".png");
		 FileHandler.copy(source, dest);
	}
	
	public static String getDateTime()
	{
		Date date = new Date();
		return date.toString();
	}	
}
