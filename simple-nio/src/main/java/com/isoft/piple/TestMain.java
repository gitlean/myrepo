package com.isoft.piple;

import java.io.IOException;
import java.nio.channels.Pipe;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pipe pipe=null;
		try {
			pipe = Pipe.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyThread t1=new MyThread(pipe,1);
		MyThread t2=new MyThread(pipe,2);
		
		new Thread(t1).start();
		new Thread(t2).start();
	}

}
