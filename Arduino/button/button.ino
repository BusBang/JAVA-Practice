void setup() {

  Serial.begin(9600);
  pinMode(12, INPUT); //버튼의 위치, 입력값 : 0 or 1
  pinMode(7, OUTPUT); //전구의 위치, 출력
}

void loop() {
  int val = digitalRead(12);
//  Serial.println(val);
  if(val == 1) {
    digitalWrite(7, HIGH);
  }else {
    digitalWrite(7, LOW);    
  }
//  delay(1000);

}
