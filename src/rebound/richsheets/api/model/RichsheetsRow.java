package rebound.richsheets.api.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import rebound.richshets.model.cell.RichshetsCellContents;

public class RichsheetsRow
{
	protected List<RichshetsCellContents> cells;
	protected @Nullable Integer height;
	
	public RichsheetsRow()
	{
		this(new ArrayList<>(), null);
	}
	
	public RichsheetsRow(List<RichshetsCellContents> cells, Integer height)
	{
		this.cells = cells;
		this.height = height;
	}
	
	
	
	public static RichsheetsRow newFilled(RichshetsCellContents newCellValues, int n, Integer height)
	{
		List<RichshetsCellContents> cells = new ArrayList<>(n);
		
		for (int i = 0; i < n; i++)
			cells.add(newCellValues);
		
		return new RichsheetsRow(cells, height);
	}
	
	
	
	public List<RichshetsCellContents> getCells()
	{
		return cells;
	}
	
	public void setCells(List<RichshetsCellContents> singleValuedColumns)
	{
		this.cells = singleValuedColumns;
	}
	
	public Integer getHeight()
	{
		return height;
	}
	
	public void setHeight(Integer height)
	{
		this.height = height;
	}
}
