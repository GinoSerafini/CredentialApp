
package credentialapp;

import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author Group 5
 */
public class MainFrame extends JFrame {
    MainView mainView;
    MainController mainCont;
    MainModel mainModel;
    
    public MainFrame() throws SQLException {
        super("Credential Application");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize (250, 300);
        
        
        mainModel = new MainModel();
        mainView = new MainView(mainModel);
        mainCont = new MainController(mainModel, mainView);
        
        add(mainView);
    }

    public MainView getMainView() {
        return mainView;
    }
    
    
}
