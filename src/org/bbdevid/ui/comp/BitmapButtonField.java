package org.bbdevid.ui.comp;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;


/**
 * 
 * @author Prasetyo Andy W.
 *
 */
public class BitmapButtonField extends BaseButtonField
{
    private Bitmap[] _bitmaps;
    private static final int NORMAL = 0;
    private static final int FOCUS = 1;
    public boolean isActive;
    public boolean isPlayed;
    String inactiveOn;
    String inactiveOff;
    String activeOn;
    String activeOff;
    private String _tooltip;
    
    /**
     * Make image button from image url
     * @param picture
     * @param tooltip
     */
    public BitmapButtonField( String picture, String tooltip )
    {        
        this( picture, picture, 0, tooltip );
    }
    
    /**
     * Make image button with different image when onFocus and with tooltip text
     * @param on
     * @param off
     * @param tooltip
     */
    public BitmapButtonField( String on, String off, String tooltip) {        
    	this( on, off, 0, tooltip );
    }
    
    /**
     * Make image button with different image when onFocus and with tooltip text. 
     * Plus style
     * @param on
     * @param off
     * @param style
     * @param tooltip
     */
    public BitmapButtonField( String on, String off, long style, String tooltip ) {        
        super( Field.FOCUSABLE | style );
        _tooltip = tooltip;
        System.out.println("Tooltip: "+_tooltip);
        
        Bitmap normalState = Bitmap.getBitmapResource(off);
        Bitmap focusState = Bitmap.getBitmapResource(on);
        
        /*
        if( (normalState.getWidth() != focusState.getWidth())
            || (normalState.getHeight() != focusState.getHeight()) ){
            
            throw new IllegalArgumentException( "Image sizes don't match" );
        }
        */
        
        _bitmaps = new Bitmap[] { normalState, focusState };
    }
    
    public void setImage( Bitmap normalState ) {
        _bitmaps[NORMAL] = normalState;
        invalidate();
    }
    
    public void setFocusImage( Bitmap focusState ) {
        _bitmaps[FOCUS] = focusState;
        invalidate();
    }
    
    public int getPreferredWidth() {
        return _bitmaps[NORMAL].getWidth();
    }
    
    public int getPreferredHeight() {
        return _bitmaps[NORMAL].getHeight();
    }
    
    protected void layout( int width, int height ) {
        setExtent( _bitmaps[NORMAL].getWidth(), _bitmaps[NORMAL].getHeight() );
    }
    
    protected void drawFocus(Graphics g, boolean on) {
        paint(g);
    }
    
    public String getTooltip() {
    	return _tooltip;
    }
    
    protected void paint( Graphics g ) {
        int index = g.isDrawingStyleSet( Graphics.DRAWSTYLE_FOCUS ) ? FOCUS : NORMAL;
        g.drawBitmap( 0, 0, _bitmaps[index].getWidth(), _bitmaps[index].getHeight(), _bitmaps[index], 0, 0 );
    }
}

