  int arr1[] = {10, 8, 6};  //자동자 신호
  int arr2[] = {4, 2};  //보행자 신호
void setup() { 
  for(int i=0; i<3; i++) {
    pinMode(arr1[i], OUTPUT);
  }
  for(int i=0; i<2; i++) {
    pinMode(arr2[i], OUTPUT);
  }

}

void loop() {
  digitalWrite(arr1[2], HIGH);  //자동차 파란불 온
  digitalWrite(arr2[0], HIGH);  //보행자 빨간불130
  delay(1500);                  //2초
  digitalWrite(arr1[2], LOW);   
  digitalWrite(arr1[1], HIGH);  //자동차 주황불 온
  delay(800);                  //1초
  digitalWrite(arr1[1], LOW);
  digitalWrite(arr1[0], HIGH);  //자동차 빨간불 온
  digitalWrite(arr2[0], LOW);   //보행자 빨간불 오프
  digitalWrite(arr2[1], HIGH);  //보행자 파란불 온
  delay(900);
  for(int i=0; i<3; i++) {
    digitalWrite(arr2[1], LOW);
    delay(300);
    digitalWrite(arr2[1], HIGH);
    delay(300);
  }
  digitalWrite(arr1[0], LOW);
  digitalWrite(arr2[1], LOW);

  

}
