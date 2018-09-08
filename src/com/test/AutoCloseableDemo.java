package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AutoCloseableDemo implements AutoCloseable{
	
	
	BufferedReader reader;

	public AutoCloseableDemo(){
		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("sampleFile.txt");
		reader = new BufferedReader(new InputStreamReader(stream));
	}
	public static void main(String[] args) {
		try(AutoCloseableDemo demo= new AutoCloseableDemo()){
			String line = null;
			try {
				line = demo.reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(line);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void close() throws Exception {
		reader.close();
		System.out.println("Closed buffered stream reader");
	}

}
