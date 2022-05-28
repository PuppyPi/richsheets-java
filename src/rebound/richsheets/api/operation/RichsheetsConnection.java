package rebound.richsheets.api.operation;

import static java.util.Collections.*;
import java.io.IOException;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import rebound.richsheets.api.model.RichsheetsTable;
import rebound.richsheets.api.operation.RichsheetsOperation.RichsheetsOperationWithDataTimestamp;

public interface RichsheetsConnection
{
	public default RichsheetsTable read(@Nullable Integer maxRowsToRead) throws IOException
	{
		RichsheetsTable[] c = new RichsheetsTable[1];
		perform(maxRowsToRead, d -> {c[0] = d; return null;});
		return c[0];
	}
	
	
	/**
	 * Override this with a more efficient implementation that doesn't read it unnecessarily if you like! XD
	 */
	public default void write(RichsheetsTable contents) throws IOException
	{
		perform(null, d -> new RichsheetsWriteData(contents, emptySet()));  //if reading the sheet is actually unnecessary if not used by the client code (and thus inefficient)..then override write()!  XD  :3
	}
	
	
	/**
	 * @return null if unknown (an exception is thrown like it would be in {@link #read(Integer)} if the data isn't there!)
	 */
	public default @Nullable Date getCurrentLastModifiedTimestamp() throws IOException
	{
		//if reading the sheet is unnecessary if not used by the client code (and thus inefficient)..then override write()!  XD  :3
		Date[] c = new Date[1];
		perform(0, (RichsheetsOperationWithDataTimestamp)(d, t) -> {c[0] = t; return null;});
		return c[0];
	}
	
	
	
	public void perform(@Nullable Integer maxRowsToRead, @Nonnull RichsheetsOperation operation) throws IOException;
	
	
	
	public boolean isCapableOfAutoresizingColumns();
}
