void setup() {
  analogReference(INTERNAL);  //전압을 조정하는 명령어
  Serial.begin(9600);
}

void loop() {
  
  int val = analogRead(A0);
  float temp = val/9.31;  //섭씨 온도가 아니기 때문에 계산해준다
  Serial.println(temp);
  delay(500);

}
