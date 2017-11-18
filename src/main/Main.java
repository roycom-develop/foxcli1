package main;
import java.io.IOException;

import linux.Common;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arg = "";
		for(int i=0;i<args.length;i++){
			arg =arg + " " + args[i];
		}
		try {
			String str = Common.exeShell(arg);
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
