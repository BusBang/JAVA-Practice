//WifiESP 라이브러리 설치
#include <SoftwareSerial.h>
SoftwareSerial mySerial(2,3);

void setup() {
  Serial.begin(9600);
//  mySerial.begin(115200);   //와이파이 모듈의 기본 속도 115200. 
  //하지만 ESP는 지원하지 않기 때문에 낮춰야한다.
  //115200으로 AT+UART_DEF=9600,8,1,0,0 실행 후 9600 다시 실행.
  mySerial.begin(9600);
  //AT 다시 실행.
  //AT+CWMODE=1
  //AT+CWLAP  -> 현재 잡을 수 있는 와이파이 목록
  //AT+CWJAP="A_CLASS","khacademy*"   --> 와이파이 연결
  //AT+CIFSR
  //cmd 창에 ip + ping 친다
  //ex) ping 192.168.10.37
}

void loop() {
  if(mySerial.available()) {
    Serial.write(mySerial.read());
  }
  if(Serial.available()) {
    mySerial.write(Serial.read());
  }
}
