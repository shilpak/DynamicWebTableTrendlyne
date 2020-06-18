package com.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.SkipException;

public class RemoteConfiguration {

	public static void remoteStartUp() {
		Runtime runtime=Runtime.getRuntime();
		if(ReadConfigurationFile.prop.getProperty("RemoteMode").equalsIgnoreCase("Selenium")) {
			try {
				runtime.exec("cmd /c start dockerUp.bat");
				verifyRemoteStart();
				runtime.exec("cmd /c start scaleChrome.bat");
				Thread.sleep(10000);
				runtime.exec("cmd /c start scaleFirefox.bat");
				Thread.sleep(10000);
				runtime.exec("taskkill /f /im cmd.exe") ;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

		else {
			try {
				throw new Exception("Please check your config file for remote mode value");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void verifyRemoteStart() throws IOException {
		// TODO Auto-generated method stub
		boolean check = false;
		String file = "output.txt";
		BufferedReader reader= new BufferedReader(new FileReader(file));
		String currentline=reader.readLine();
		while(currentline!=null) {
			if(currentline.contains("The node is registered to the hub and ready to use")) {
				check=true;
				break;
			}
			currentline=reader.readLine();
		}
		reader.close();
		if(!check) {
			throw new SkipException("Docker has not started");
		}

	}

	public static void remoteShutDown() {
		Runtime runtime=Runtime.getRuntime();
		if(ReadConfigurationFile.prop.getProperty("RemoteMode").equalsIgnoreCase("Selenium")) {
			try {
				runtime.exec("cmd /c start dockerDown.bat");				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				throw new Exception("Please check your config file for remote mode value");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		File file=new File("output.txt");
		if(file.exists()) {
			System.out.println("file deleted");
			file.delete();
		}
		try {
			Thread.sleep(20000);
			runtime.exec("taskkill /f /im cmd.exe") ;

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
