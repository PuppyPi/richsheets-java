package rebound.richsheets.api.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import rebound.richshets.model.cell.RichshetCellContents;

public class RichsheetsRow
{
	protected List<RichshetCellContents> cells;
	protected @Nullable Integer height;
	
	public RichsheetsRow()
	{
		this(new ArrayList<>(), null);
	}
	
	public RichsheetsRow(List<RichshetCellContents> cells, Integer height)
	{
		this.cells = cells;
		this.height = height;
	}
	
	
	
	public static RichsheetsRow newFilled(RichshetCellContents newCellValues, int n, Integer height)
	{
		List<RichshetCellContents> cells = new ArrayList<>(n);
		
		for (int i = 0; i < n; i++)
			cells.add(newCellValues);
		
		return new RichsheetsRow(cells, height);
	}
	
	
	
	public List<RichshetCellContents> getCells()
	{
		return cells;
	}
	
	public void setCells(List<RichshetCellContents> singleValuedColumns)
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
