package org.bbdevid.gf.ui;

import org.bbdevid.ui.comp.BitmapButtonField;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;

/**
 * Home screen implementation
 * @author Prasetyo Andy W.
 */
public final class HomeScreen extends MainScreen {
    /**
     * Creates a new HomeScreen object
     */
    public HomeScreen() {        
    	this.getMainManager().setBackground(BackgroundFactory.createBitmapBackground(
    			Bitmap.getBitmapResource("img/homeBG.jpg")));
    	
    	HorizontalFieldManager menu = new HorizontalFieldManager(Field.USE_ALL_WIDTH);
        
        //menu component
        BitmapButtonField scheduleButton = new BitmapButtonField("img/scheduleButtonActive.png", 
        		"img/scheduleButton.png", "");
        BitmapButtonField venueButton = new BitmapButtonField("img/venueButtonActive.png", 
        		"img/venueButton.png", "");
        BitmapButtonField communityButton = new BitmapButtonField("img/communityButtonActive.png", 
        		"img/communityButton.png", "");
        BitmapButtonField blogButton = new BitmapButtonField("img/blogButtonActive.png", 
        		"img/blogButton.png", "");
        BitmapButtonField aboutButton = new BitmapButtonField("img/aboutButtonActive.png", 
        		"img/aboutButton.png", "");
        
        scheduleButton.setChangeListener(new FieldChangeListener() {
			
			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				UiApplication.getUiApplication().pushScreen(new ScheduleScreen());
			}
		});
        
        venueButton.setChangeListener(new FieldChangeListener() {
			
			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				UiApplication.getUiApplication().pushScreen(new VenueScreen());
			}
		});
        
        communityButton.setChangeListener(new FieldChangeListener() {
			
			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				UiApplication.getUiApplication().pushScreen(new CommunityScreen());
			}
		});
        
        blogButton.setChangeListener(new FieldChangeListener() {
			
			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				UiApplication.getUiApplication().pushScreen(new BlogScreen());
			}
		});
        
        aboutButton.setChangeListener(new FieldChangeListener() {
			
			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				UiApplication.getUiApplication().pushScreen(new AboutScreen());
			}
		});
        
        menu.add(scheduleButton);
        menu.add(venueButton);
        menu.add(communityButton);
        menu.add(blogButton);
        menu.add(aboutButton);
        
        menu.setPadding(new XYEdges(833/10000*Display.getHeight(), 46875/100000*Display.getWidth(), 
        		0, 46875/100000*Display.getWidth()));
        
        add(menu);
    }
}
