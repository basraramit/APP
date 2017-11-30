package Model;
import java.io.OutputStream;
import java.io.Serializable;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

// TODO: Auto-generated Javadoc
/**
 * Used to wrapper a window.
 * This is utilized in order to allow easy printing of messages on the Risk GUI.
 * @author yaomeng
 *
 */
public class TextAreaOutputStream extends OutputStream implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5l;

    /** The text area. */
    public JTextArea textArea;
    
    /** The string builder. */
    public StringBuilder stringBuilder = new StringBuilder();

    /**
     * Instantiates a new text area output stream.
     *
     * @param textArea the text area
     */
    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }
	
	
	
	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(int)
	 */
	public void write(int b) {
	//Writes the specified byte to this output stream	
		
		if (b == '\n') {
		//If text is on a new line, creates a new String
			final String text = stringBuilder.toString();
			
			SwingUtilities.invokeLater(new Runnable() {
				public void run()
				{
					textArea.append(text);
				}
            });
			
            stringBuilder.setLength(0);
        }

        stringBuilder.append((char) b);
    }
}