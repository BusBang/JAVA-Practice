void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);   //통신 속도를 맞추는 것.
  
}

void loop() {
  if(Serial.available()>0) {
//    char ch = Serial.read();
//    Serial.println(ch);
    int num = Serial.parseInt();
    Serial.write(num);
  }
}
