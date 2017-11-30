package View;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import Model.Risk_Model;

// TODO: Auto-generated Javadoc
/**
 * The Class TournamentPlay_View.
 */
public class TournamentPlay_View extends JDialog{
	
	/** The model. */
	private Risk_Model model;
	
	/** The main layout. */
	private GridBagLayout mainLayout;
	
	/** The c. */
	private GridBagConstraints c;
	
	/** The message panel. */
	private JPanel messagePanel;
	
	/** The message layout. */
	private GridBagLayout messageLayout;
	
	/** The print text area. */
	private JTextArea printTextArea;
	
	/** The caret. */
	private DefaultCaret caret;
	
	/** The message scroll pane. */
	private JScrollPane messageScrollPane;

	/**
	 * Tournament play view.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void TournamentPlay_View() throws IOException {
		setTitle("**Risk Game**--Tournament Mode--");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);

        model = new Risk_Model();
        mainLayout = new GridBagLayout();
        setLayout(mainLayout);

        c = new GridBagConstraints();

        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        add(messagePanel());

        setLocationRelativeTo(null);

        pack();
	}

	/**
	 * Message panel.
	 *
	 * @return the j panel
	 */
	private JPanel messagePanel() {
		messagePanel = new JPanel();
        messagePanel.setPreferredSize(new Dimension(350, 700));
        messageLayout = new GridBagLayout();
        messagePanel.setLayout(messageLayout);

        printTextArea = new JTextArea();
        printTextArea.setFocusable(false);
        printTextArea.setLineWrap(true);
        printTextArea.setWrapStyleWord(true);
        caret = (DefaultCaret) printTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        messageScrollPane = new JScrollPane(printTextArea);
        
        c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 0.5;
        c.weighty = 18;
        c.gridx = 0;
        c.gridy = 4;
        messagePanel.add(messageScrollPane, c);
        return messagePanel;
	}
	
	/**
	 * Display log.
	 *
	 * @param logDetail the log detail
	 */
	public static void displayLog(String logDetail) {
    	// The name of the file to open.
        String fileName = "C:/Users/yaome/workspace/Risk_Game/src/Map_Info/TournamentModeLogs.txt";

        // This will reference one line at a time
        String line = null;
        StringBuilder sb = new StringBuilder();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            if(logDetail.equalsIgnoreCase("repaint")) {
            	sb.append("");
            }else {
            	while((line = bufferedReader.readLine()) != null) {
                    sb.append(line+"\n");
                }
            }
               

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("TournamentModeLogs.txt")))) {
        	if(logDetail.equalsIgnoreCase("repaint")) {
        		out.print(sb.append("").toString() + "\n");	
        	}else {
        		out.print(sb.append(logDetail).toString() + "\n");
        	}
        	
        	out.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
