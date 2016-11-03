
package credentialapp;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Michael Cavallaro
 */
public class MainController {
    private MainModel model;
    private MainView view;
    
    public MainController(MainModel model, MainView view) {
        this.model = model;
        this.view = view;
        
    }
    
}

