//
int arr[] = {10, 8, 6, 4, 2};


void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  for(int i=0; i<5; i++) {
    pinMode(arr[i], OUTPUT);
  }
}

void loop() {
  if(Serial.available()>0) {
    int inputNumber = Serial.parseInt();
    Serial.print("불킨다");
    for(int i=0;i<5;i++) {
      digitalWrite(arr[i], LOW);
    }
    digitalWrite(arr[inputNumber-1], HIGH);
  }
  
  
//  // put your main code here, to run repeatedly:
//  for(int i=0; i<3; i++) {
//    digitalWrite(arr[2*i], HIGH);
//    delay(300);
//  }
//  for(int i=1; i>=0; i--) {
//    digitalWrite(arr[2*i+1], HIGH);
//    delay(300);
//  }  
//  for(int i=0; i<2; i++) {
//    digitalWrite(arr[2*i+1], LOW);
//    delay(300);
//  }     
//  for(int i=2; i>=0; i--) {
//    digitalWrite(arr[2*i], LOW);
//    delay(300);
//  } 


}
