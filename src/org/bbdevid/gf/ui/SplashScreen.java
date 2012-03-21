package org.bbdevid.gf.ui;

import java.util.Timer;
import java.util.TimerTask;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.decor.BackgroundFactory;

/**
 * 
 * @author Prasetyo Andy W
 *
 */
public class SplashScreen extends MainScreen {
	private GeekFest app;
	
	public SplashScreen(GeekFest gf) {
		int c1 = 0xE6E6E6;
		int c2 = 0xD0D0D0;
		int c3 = 0xE1E1E1;
		int c4 = 0xC2C2C2;
		
		app = gf;
		getMainManager().setBackground(BackgroundFactory.createLinearGradientBackground(c1, c2, c3, c4));
		BitmapField logo = new BitmapField(Bitmap.getBitmapResource("logoSplash.png"), FIELD_VCENTER);
		
		logo.setMargin(new XYEdges(Display.getHeight()/4, 20, 5, 20));
		
		this.add(logo);
		kill();
	}

	public void kill() {
		Timer a = new Timer();
		TimerTask b;
		b = new TimerTask(){
			public void run() {
				try
				{
					getApplication().invokeAndWait(closeScreen);
				} 
				catch(NullPointerException npe)
				{
					System.out.println(npe);
				}
			}     
		};
		a.schedule(b,3000);
	}



	Runnable closeScreen=new Runnable(){
		public void run() {
			closeScr();
		}
	};

	private void closeScr() {                                                      
		app.pushScreen(new MainScreen());
	}
}
