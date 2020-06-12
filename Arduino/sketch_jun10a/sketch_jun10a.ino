  int arr[] = {10, 8, 6};

void setup() {
  Serial.begin(9600);
  for(int i=0; i<3; i++) {
    pinMode(arr[i], OUTPUT);
  }
}

void loop() {

  if(Serial.available()>0) {
//....    int ch = Serial.parseInt();
//    char ch = Serial.read();
//    String ch = Serial.readString();
//    Serial.println(ch);
      String ch = Serial.readString();
      Serial.println(ch);
      for(int i=0; i<3; i++) {
        digitalWrite(arr[i], LOW);
      }
      if(ch=="red") {
        digitalWrite(arr[0], HIGH);
      }else if(ch=="green") {
        digitalWrite(arr[1], HIGH);       
      }else if(ch=="blue") {
        digitalWrite(arr[2], HIGH);
      }
  }
}
