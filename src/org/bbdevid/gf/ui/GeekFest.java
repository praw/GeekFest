package org.bbdevid.gf.ui;

import net.rim.device.api.ui.UiApplication;

/**
 * 
 * @author Prasetyo Andy W.
 *
 */
public class GeekFest extends UiApplication
{
    /**
     * Entry point for application
     * @param args Command line arguments (not used)
     */ 
    public static void main(String[] args)
    {
        // Create a new instance of the application and make the currently
        // running thread the application's event dispatch thread.
        GeekFest theApp = new GeekFest();       
        theApp.enterEventDispatcher();
    }
    

    /**
     * Creates a new MyApp object
     */
    public GeekFest()
    {        
        // Push a screen onto the UI stack for rendering.
        pushScreen(new HomeScreen());
    }    
}
