package rebound.richsheets.api.operation;

import java.util.Set;
import javax.annotation.Nonnull;
import rebound.richsheets.api.model.RichsheetsTable;

public class RichsheetsWriteData
{
	protected final @Nonnull RichsheetsTable table;
	protected final @Nonnull Set<Integer> columnsToAutoresize;  //zero-based indexes; can be empty but not null
	
	public RichsheetsWriteData(RichsheetsTable table, Set<Integer> columnsToAutoresize)
	{
		this.table = table;
		this.columnsToAutoresize = columnsToAutoresize;
	}
	
	public RichsheetsTable getTable()
	{
		return table;
	}
	
	public Set<Integer> getColumnsToAutoresize()
	{
		return columnsToAutoresize;
	}
}
