package rebound.richsheets.api.operation;

/**
 * Some formatting (eg, superscript/subscript) can't be encoded in a Write operation into the underlying implementation/backing.
 */
public class RichsheetsUnencodableFormatException
extends RuntimeException
{
	private static final long serialVersionUID = 1l;
	
	public RichsheetsUnencodableFormatException()
	{
		super();
	}
	
	public RichsheetsUnencodableFormatException(String message)
	{
		super(message);
	}
	
	public RichsheetsUnencodableFormatException(Throwable cause)
	{
		super(cause);
	}
	
	public RichsheetsUnencodableFormatException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
