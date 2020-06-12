void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(8, INPUT);  //기울기 센서
  pinMode(7, OUTPUT);  //전구
}

void loop() {
  int val = digitalRead(8);
  Serial.println(val);
  if(val == 1) {
    digitalWrite(7 , HIGH);
  }else {
    digitalWrite(7 , LOW);
    
  }

}
