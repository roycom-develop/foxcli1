package linux;

import static org.junit.Assert.*;

import java.io.IOException;

public class Test {

	@org.junit.Test
	public void test() throws IOException, InterruptedException {
		String re = Common.exeShell("ls");
		System.out.println(re);
		fail("Not yet implemented");
	}

}
