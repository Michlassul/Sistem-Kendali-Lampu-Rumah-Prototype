package org.appinventor;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.ListPicker;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.BluetoothClient;
import com.google.appinventor.components.runtime.SpeechRecognizer;
import com.google.appinventor.components.runtime.util.YailList;
class Screen2 extends Form implements HandlesEventDispatching {
  private Image Image1;
  private ListPicker ListPicker1;
  private HorizontalArrangement HorizontalArrangement1;
  private Button Button1;
  private Label Label1;
  private Button Button3;
  private Label Label3;
  private BluetoothClient BluetoothClient1;
  private SpeechRecognizer SpeechRecognizer1;
  protected void $define() {
    this.AlignHorizontal(3);
    this.AppName("Bluetooth_copy");
    this.BackgroundImage("workfeatured-data.webp");
    Image1 = new Image(this);
    Image1.Height(-1030);
    Image1.Width(-1090);
    Image1.Picture("360_F_297339148_mWXfsFzk6wb1cDnMYa2OO98IHLCO68uj.jpg");
    ListPicker1 = new ListPicker(this);
    ListPicker1.BackgroundColor(0xFF00FFFF);
    ListPicker1.FontBold(true);
    ListPicker1.FontSize(20);
    ListPicker1.Width(LENGTH_FILL_PARENT);
    ListPicker1.Text("Bluetooth");
    HorizontalArrangement1 = new HorizontalArrangement(this);
    HorizontalArrangement1.AlignHorizontal(3);
    HorizontalArrangement1.AlignVertical(2);
    HorizontalArrangement1.BackgroundColor(0x00FFFFFF);
    HorizontalArrangement1.Height(150);
    HorizontalArrangement1.Width(300);
    Button1 = new Button(HorizontalArrangement1);
    Button1.Height(150);
    Button1.Width(140);
    Button1.Image("png-clipart-mic-microphone-icon-game-electronics.png");
    Label1 = new Label(HorizontalArrangement1);
    Label1.TextColor(0xFF00FF00);
    Button3 = new Button(this);
    Button3.BackgroundColor(0xFFFF0000);
    Button3.FontBold(true);
    Button3.FontSize(20);
    Button3.Width(LENGTH_FILL_PARENT);
    Button3.Text("Disconnect");
    Label3 = new Label(this);
    Label3.FontBold(true);
    Label3.Width(LENGTH_FILL_PARENT);
    Label3.Text("Bluetooth is connected");
    Label3.Visible(false);
    BluetoothClient1 = new BluetoothClient(this);
    SpeechRecognizer1 = new SpeechRecognizer(this);
    EventDispatcher.registerEventForDelegation(this, "BeforePickingEvent", "BeforePicking" );
    EventDispatcher.registerEventForDelegation(this, "AfterPickingEvent", "AfterPicking" );
    EventDispatcher.registerEventForDelegation(this, "ClickEvent", "Click" );
    EventDispatcher.registerEventForDelegation(this, "BeforeGettingTextEvent", "BeforeGettingText" );
    EventDispatcher.registerEventForDelegation(this, "AfterGettingTextEvent", "AfterGettingText" );
  }
  public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params){
    if( component.equals(ListPicker1) && eventName.equals("BeforePicking") ){
      ListPicker1BeforePicking();
      return true;
    }
    if( component.equals(ListPicker1) && eventName.equals("AfterPicking") ){
      ListPicker1AfterPicking();
      return true;
    }
    if( component.equals(Button3) && eventName.equals("Click") ){
      Button3Click();
      return true;
    }
    if( component.equals(Button1) && eventName.equals("Click") ){
      Button1Click();
      return true;
    }
    if( component.equals(SpeechRecognizer1) && eventName.equals("BeforeGettingText") ){
      SpeechRecognizer1BeforeGettingText();
      return true;
    }
    if( component.equals(SpeechRecognizer1) && eventName.equals("AfterGettingText") ){
      SpeechRecognizer1AfterGettingText();
      return true;
    }
    return false;
  }
  public void ListPicker1BeforePicking(){
    ListPicker1.Elements(YailList.makeList(BluetoothClient1.AddressesAndNames()));
  }
  public void ListPicker1AfterPicking(){
    if(BluetoothClient1.Connect(ListPicker1.Selection())){
      Label1.Visible(0);
      Button3.Visible(true);
      true
    }
  }
  public void Button3Click(){
  }
  public void Button1Click(){
  }
  public void SpeechRecognizer1BeforeGettingText(){
    Label1.Text("");
  }
  public void SpeechRecognizer1AfterGettingText(){
    Label1.Text(SpeechRecognizer1.Result());
    BluetoothClient1.SendText(SpeechRecognizer1.Result());
  }
}