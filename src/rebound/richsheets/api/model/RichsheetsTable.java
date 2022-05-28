package rebound.richsheets.api.model;

import static java.util.Objects.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import rebound.richshets.model.cell.RichshetCellContents;

/**
 * Note: while row indexes match up perfectly with the Google Sheet (after the frozen header rows), column indexes certainly don't generally!!<br>
 * They're only useful here in this object!<br>
 * (I mean there are two different kinds that both start at zero so that could never be XD )<br>
 */
public class RichsheetsTable
{
	protected List<RichsheetsRow> rows;
	protected int frozenRows = 0;
	protected int frozenColumns = 0;
	
	
	public RichsheetsTable()
	{
		this(0, 0);
	}
	
	public RichsheetsTable(int numberOfColumns, int numberOfRows)
	{
		this(numberOfColumns, numberOfRows, RichshetCellContents.Blank);
	}
	
	public RichsheetsTable(int numberOfColumns, int numberOfRows, RichshetCellContents newCellValues)
	{
		this.rows = new ArrayList<>(numberOfRows);
		
		for (int i = 0; i < numberOfRows; i++)
		{
			RichsheetsRow row = RichsheetsRow.newFilled(newCellValues, numberOfColumns, null);
			rows.add(row);
		}
	}
	
	
	/**
	 * @param rows  this will be kept as a live reference!
	 */
	public RichsheetsTable(List<RichsheetsRow> rows)
	{
		this.rows = rows;
	}
	
	
	
	
	
	
	public int getNumberOfColumns()
	{
		return rows.isEmpty() ? 0 : rows.get(0).getCells().size();
	}
	
	public int getNumberOfRows()
	{
		return rows.size();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @return it's just a plain list of rows, fully writable and {@link #setRows(List) changeable}!  but each row must be the same size and none can be null (unlike in [rich]datashets)!
	 */
	public @Nonnull List<RichsheetsRow> getRows()
	{
		return rows;
	}
	
	/**
	 * @param rows  (a live reference will be kept to it!)
	 */
	public void setRows(@Nonnull List<RichsheetsRow> rows)
	{
		this.rows = rows;
	}
	
	public int getFrozenRows()
	{
		return frozenRows;
	}
	
	public void setFrozenRows(int frozenRows)
	{
		this.frozenRows = frozenRows;
	}
	
	public int getFrozenColumns()
	{
		return frozenColumns;
	}
	
	public void setFrozenColumns(int frozenColumns)
	{
		this.frozenColumns = frozenColumns;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param columnIndex  starts at 0
	 * @param rowIndex  starts at 0
	 * @throws IndexOutOfBoundsException  if columnIndex or rowIndex is too small or large
	 */
	public @Nonnull RichshetCellContents getCell(int columnIndex, int rowIndex) throws IndexOutOfBoundsException
	{
		return rows.get(rowIndex).getCells().get(columnIndex);
	}
	
	/**
	 * @param columnIndex  starts at 0
	 * @param rowIndex  starts at 0
	 * @throws IndexOutOfBoundsException  if columnIndex or rowIndex is too small or large
	 */
	public void setCell(int columnIndex, int rowIndex, @Nonnull RichshetCellContents value) throws IndexOutOfBoundsException
	{
		requireNonNull(value);
		rows.get(rowIndex).getCells().set(columnIndex, value);
	}
	
	
	
	
	
	
	
	
	/**
	 * Adds a new blank row to the end, returning it in case you want to edit it!<br>
	 * (Its index will be = {@link #getNumberOfRows()} just before this is called :3 )<br>
	 * <br>
	 * The lists in multivalued columns will be writable but (initially) empty lists.<br>
	 */
	public RichsheetsRow addRow()
	{
		return addRow(RichshetCellContents.Blank);
	}
	
	/**
	 * Like {@link #addRow()} but you get to set the value of newly-created cells (single-valued ones; multi-valued ones still start with each their own separate empty mutable list)
	 */
	public RichsheetsRow addRow(RichshetCellContents newCellValues)
	{
		RichsheetsRow row = RichsheetsRow.newFilled(newCellValues, getNumberOfColumns(), null);
		rows.add(row);
		return row;
	}
	
	
	
	
	public RichsheetsRow removeRow(int index) throws IndexOutOfBoundsException
	{
		return getRows().remove(index);
	}
	
	
	
	
	
	
	
	
	
	//Todo add column, remove column, get column as vertical list snapshot
}
