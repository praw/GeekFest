package org.bbdevid.gf.ui;

import java.util.Timer;
import java.util.TimerTask;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.container.MainScreen;

/**
 * 
 * @author Prasetyo Andy W
 *
 */
public class SplashScreen extends MainScreen {
	private GeekFest app;
	
	public SplashScreen(GeekFest gf) {
		app = gf;
		BitmapField logo = new BitmapField(Bitmap.getBitmapResource("img/splash.jpg"), FIELD_VCENTER);
		
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
