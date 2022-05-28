package rebound.richsheets.api.operation;

import java.io.IOException;
import javax.annotation.Nullable;
import rebound.richsheets.api.model.RichsheetsTable;

public interface RichsheetsConnection
{
	public default RichsheetsTable read() throws IOException
	{
		RichsheetsTable[] c = new RichsheetsTable[1];
		perform(d -> {c[0] = d; return null;});
		return c[0];
	}
	
	
	/**
	 * Override this with a more efficient implementation that doesn't read it unnecessarily if you like! XD
	 */
	public default void write(RichsheetsTable contents) throws IOException
	{
		perform(d -> contents);
	}
	
	
	public void perform(@Nullable RichsheetsOperation operation) throws IOException;
}
