package mas.globalScheduling.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alee.extended.image.WebImage;
import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebButton;
import com.alee.laf.label.WebLabel;
import com.alee.laf.panel.WebPanel;
import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;
import com.alee.managers.hotkey.Hotkey;
import com.alee.managers.hotkey.HotkeyManager;
//http://www.java-tips.org/index.php?option=com_content&task=view&sectionid=&id=1838&Itemid=61&mosmsg=Thanks+for+your+vote%21
public class TransitionExample
{
	public static Logger log=LogManager.getLogger();
	  private static final GridBagConstraints gbc;
	    static {
	        gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.weightx = 1.0;
	        gbc.weighty = 1.0;
	        gbc.fill = GridBagConstraints.BOTH;
	        gbc.anchor = GridBagConstraints.CENTER;
	    }
	    
	    public static JPanel wrapInBackgroundImage(JComponent component,
	            Icon backgroundIcon) {
	        return wrapInBackgroundImage(
	                component,
	                backgroundIcon,
	                JLabel.TOP,
	                JLabel.LEADING);
	    }
	    
	    public static JPanel wrapInBackgroundImage(JComponent component,
	            Icon backgroundIcon,
	            int verticalAlignment,
	            int horizontalAlignment) {
	        
	        // make the passed in swing component transparent
	        component.setOpaque(false);
	        
	        // create wrapper JPanel
	        JPanel backgroundPanel = new JPanel(new GridBagLayout());
	        
	        // add the passed in swing component first to ensure that it is in front
	        backgroundPanel.add(component, gbc);
	        
	        // create a label to paint the background image
	        JLabel backgroundImage = new JLabel(backgroundIcon);
	        
	        // set minimum and preferred sizes so that the size of the image
	        // does not affect the layout size
	        backgroundImage.setPreferredSize(new Dimension(1,1));
	        backgroundImage.setMinimumSize(new Dimension(1,1));
	        
	        // align the image as specified.
	        backgroundImage.setVerticalAlignment(verticalAlignment);
	        backgroundImage.setHorizontalAlignment(horizontalAlignment);
	        
	        // add the background label
	        backgroundPanel.add(backgroundImage, gbc);
	        
	        // return the wrapper
	        return backgroundPanel;
	    }
	    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    public static double width = screenSize.getWidth();
	    public static double height = screenSize.getHeight();
	    
	    
	    public static void main(String[] args) {
	    	WebLookAndFeel.install();
	        JFrame frame = new JFrame("Background Image Panel Example");
	        
	        JPanel foregroundPanel = new JPanel(new BorderLayout(10, 10));
	        foregroundPanel.setBorder(
	                BorderFactory.createEmptyBorder(200,400,100,400));
	        foregroundPanel.setOpaque(false);
	        
	        
	        MigLayout layout = new MigLayout();
	        		 
	        
	        final WebPanel panel = new WebPanel (layout);
	        panel.setMargin(100,150, 100, 150);
	        
	        ImageIcon kushalLogo = new ImageIcon("resources/kushalLogo.png");
		    final WebImage kushalLogoimg = new WebImage (kushalLogo );
	        
	        panel.add(kushalLogoimg,"cell 0 0 8");
	        
	        
	        panel.add ( new WebLabel ( "Login:", WebLabel.TRAILING ),"cell 1 1" );
	        WebTextField username_text=new WebTextField("iitd", 10);

	        panel.add ( username_text ,"cell 2 1 2 1");
	        
	        panel.add ( new WebLabel ( "Password:", WebLabel.TRAILING ) ,"cell 1 2");
	        WebPasswordField passwordText=new WebPasswordField("password",10);
	        panel.add ( passwordText,"cell 2 2 2 1");

	        WebButton okButton = new WebButton ( "Ok" );
	        WebButton restButton = new WebButton ( "Reset" );

	        panel.add(okButton,"cell 2 3 1 1");
	        panel.add(restButton, "cell 3 3 1 1");
	         
	        HotkeyManager.registerHotkey ( frame, okButton, Hotkey.ESCAPE );
            HotkeyManager.registerHotkey ( frame, restButton, Hotkey.ENTER );
            
	        
	        foregroundPanel.add(panel,
	                BorderLayout.CENTER);
	
	        
	        frame.setContentPane(wrapInBackgroundImage(foregroundPanel,
	                new ImageIcon(
	                "resources/LoginBackground.png")));
	        
	        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	        frame.pack();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	    }
}
    

