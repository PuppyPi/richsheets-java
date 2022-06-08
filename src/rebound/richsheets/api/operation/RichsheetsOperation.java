package rebound.richsheets.api.operation;

import java.util.Date;
import javax.annotation.Nullable;
import rebound.richsheets.api.model.RichsheetsTable;

@FunctionalInterface
public interface RichsheetsOperation
{
	/**
	 * @param data  this is created especially for this invocation and never used by Datashets again (so feel free to keep hold of it after {@link RichsheetsConnection#perform(Integer, RichsheetsOperation)} or similar returns!   (null means it's absent and if you return a value, a backing store will be created!)
	 * @return null meaning don't write anything, otherwise it may be the same Java Object (referencewise identical) as was given to it or not!  (whatever is return is only used briefly, then forgotten once {@link RichsheetsConnection#perform(Integer, RichsheetsOperation)} or similar returns, so feel free to keep hold of it afterward or have brought it in from beforehand!)
	 * @throws RuntimeException  anything thrown by this will be caught and handled properly (maintenance will write its changes, but no client code changes will be written)
	 */
	public @Nullable RichsheetsWriteData performInMemory(@Nullable RichsheetsTable data) throws RuntimeException;
	
	
	
	public static interface RichsheetsOperationWithDataTimestamp
	extends RichsheetsOperation
	{
		public @Nullable RichsheetsWriteData performInMemory(@Nullable RichsheetsTable data, @Nullable Date lastModifiedTimeOfOriginalData) throws RuntimeException;
		
		@Override
		public default RichsheetsWriteData performInMemory(RichsheetsTable data) throws RuntimeException
		{
			return performInMemory(data, null);
		}
	}
}
