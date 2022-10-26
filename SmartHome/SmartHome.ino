String voice;
int LED1 = 4;
int LED2 = 5;
void Upon(){
    digitalWrite (LED1, HIGH);
    digitalWrite (LED2, LOW);
    delay(500);
}
void Downon(){
    digitalWrite (LED1, LOW);
    digitalWrite (LED2, HIGH);
    delay(500);
}
void ALLon(){
    digitalWrite (LED1, HIGH);
    digitalWrite (LED2, HIGH);
    delay(500);
}
void ALLoff(){
    digitalWrite (LED1, LOW);
    digitalWrite (LED2, LOW);
    delay(500);
}
void setup() {
  Serial.begin(9600);
  pinMode(LED1, OUTPUT);
  pinMode(LED2, OUTPUT);  
}
void loop() {
  while(Serial.available()){
    delay(10);
    char c = Serial.read();
    if(c=='#'){
      break;
    }
    voice += c;
  }
  
  if(voice.length() > 0){
    Serial.println(voice);
    if(voice == "atas" || voice == "atap"){
      Upon();
    }
    else if(voice == "bawah"){
      Downon();
    }
    else if(voice == "menyala"){
      ALLon();
    }
    else if(voice == "stop"){
      ALLoff();
    }
    voice = "";
  }
      

}
