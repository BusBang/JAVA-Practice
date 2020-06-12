  int arr[] = {10, 8, 6};
  
void setup() {
  for(int i=0; i<3; i++) {
    pinMode(arr[i], OUTPUT);
  }
}

void loop() {
  digitalWrite(arr[2], HIGH);
  delay(5000);
  digitalWrite(arr[2], LOW);
  digitalWrite(arr[1], HIGH);
  delay(1000);
  digitalWrite(arr[1], LOW);
  digitalWrite(arr[0], HIGH);
  delay(3000);
  digitalWrite(arr[0], LOW);
  delay(500);
}
