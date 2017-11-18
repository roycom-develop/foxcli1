package linux.storage.instrument;

import java.io.IOException;

public interface Dev {
	public void fillAttr() throws IOException, InterruptedException;
}
