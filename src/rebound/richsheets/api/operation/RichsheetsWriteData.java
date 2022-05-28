package rebound.richsheets.api.operation;

import static java.util.Objects.*;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import rebound.richsheets.api.model.RichsheetsTable;

public class RichsheetsWriteData
{
	protected final @Nullable RichsheetsTable table;
	protected final @Nonnull Set<Integer> columnsToAutoresize;  //zero-based indexes; can be empty but not null
	
	public RichsheetsWriteData(RichsheetsTable table, Set<Integer> columnsToAutoresize)
	{
		this.table = table;
		this.columnsToAutoresize = requireNonNull(columnsToAutoresize);
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
