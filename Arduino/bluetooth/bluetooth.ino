#include<SoftwareSerial.h>



byte rxPin=2;   //수신
byte txPin=3;   //발신
SoftwareSerial BTSerial(rxPin, txPin);  //아두이노에는 반대로 되어있다
//수신과 발신은 상대적인것.

void setup() {
  pinMode(7, OUTPUT);
  Serial.begin(9600);   //시리얼 속도 조정
  BTSerial.begin(9600); //블루투스 속도 조정
  analogReference(INTERNAL);  //전압을 조정하는 명령어
}

void loop() {

    //온도가 30'C 가 넘으면 불 들어오게 하기  
  int tempVal = analogRead(A0);
  float temp = tempVal/9.31;  //섭씨 온도가 아니기 때문에 계산해준다
  if(temp>30.00) {
    BTSerial.print(String(temp)+"'C");
    digitalWrite(7, HIGH);
    delay(1000);
  }else {
    digitalWrite(7, LOW);
    delay(1000);
  }      
  
  if(BTSerial.available()) {
    String val = BTSerial.readString();
    Serial.print(val + "123");

//    //ON/OFF로 불 끄고 켜기
//    if(val=="ON") {
//      digitalWrite(7, HIGH);
//    }
//    
//    if(val=="OFF") {
//      digitalWrite(7, LOW);
//    }




  }

  if(Serial.available()) {
    BTSerial.print(Serial.readString());
  }

}
