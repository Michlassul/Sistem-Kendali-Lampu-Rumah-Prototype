package org.appinventor;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.Slider;
import com.google.appinventor.components.runtime.Clock;
import android.content.Intent;
class Screen1 extends Form implements HandlesEventDispatching {
  private Image Image1;
  private Label Label1;
  private Slider Slider1;
  private Clock Clock1;
  protected void $define() {
    this.AlignHorizontal(3);
    this.AlignVertical(2);
    this.AppName("Bluetooth");
    this.BackgroundImage("minimalist-phoneandroid-iphone-desktop-hd-backgrounds-wallpapers-1080p-4k-86iwx-1080x1920.jpg");
    this.Icon("icons8-smart-home-automation-100.png");
    this.Title("Smart House");
    Image1 = new Image(this);
    Image1.Picture("icons8-smart-home-automation-100.png");
    Label1 = new Label(this);
    Label1.FontBold(true);
    Label1.FontSize(24);
    Label1.Text("Smart House");
    Label1.TextColor(0xFFFFFFFF);
    Slider1 = new Slider(this);
    Slider1.ColorLeft(0xFFFFFFFF);
    Slider1.Width(-1050);
    Slider1.MaxValue(100);
    Slider1.MinValue(0);
    Slider1.ThumbEnabled(false);
    Slider1.ThumbPosition(0);
    Clock1 = new Clock(this);
    Clock1.TimerInterval(1);
    EventDispatcher.registerEventForDelegation(this, "TimerEvent", "Timer" );
  }
  public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params){
    if( component.equals(Clock1) && eventName.equals("Timer") ){
      Clock1Timer();
      return true;
    }
    return false;
  }
  public void Clock1Timer(){
    Slider1.ThumbPosition((Slider1.ThumbPosition() + 1));
    if(Slider1.ThumbPosition()==100){
      startActivity(new Intent().setClass(this, Screen2.class));
    }
  }
}