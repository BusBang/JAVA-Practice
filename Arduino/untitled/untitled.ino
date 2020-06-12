  int arr[] = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
  int arr1[] = {11, 10, 9, 8, 7};
  int arr2[] = {2, 3, 4, 5, 6};
  int red[] = {9, 6, 3};
  int green[] = {11, 8, 5, 2};
  int blue[] = {10, 7, 4};
  
void setup() {
  for(int i=0; i<10; i++) {
    pinMode(arr[i], OUTPUT);
  }
}

void loop() {
  for(int j=0; j<4; j++) {
    for(int i=0; i<4; i++) {
      digitalWrite(red[i], HIGH);
      digitalWrite(green[i], HIGH);
      digitalWrite(blue[i], HIGH);
    }     
    delay(500);    
    for(int i=0; i<4; i++) {
      digitalWrite(red[i], LOW);
      digitalWrite(green[i], LOW);
      digitalWrite(blue[i], LOW);
    }     
    delay(50);         
  }
  for(int i=0; i<10; i++) {
    digitalWrite(arr[i], HIGH);
    delay(30);    
  }
  for(int i=9; i>=0; i--) {
    digitalWrite(arr[i], LOW);
    delay(30);
  }
  for(int i=10; i>=0; i--) {
    digitalWrite(arr[i], HIGH);
    delay(30);
  }  
  for(int i=0; i<10; i++) {
    digitalWrite(arr[i], LOW);
    delay(30);
  }  
  for(int j=0; j<10; j++) {
    for(int i=j; i<10; i++) {
      digitalWrite(arr[i], HIGH);
      delay(30);
      digitalWrite(arr[i], LOW);
      delay(30);
    }    
  }
  //10회 번쩍
  for(int j=0; j<10; j++) {
    for(int i=0; i<10; i++) {
      digitalWrite(arr[i], HIGH);
    }
    delay(30);
    for(int i=0; i<10; i++) {
      digitalWrite(arr[i], LOW);
    }    
    delay(30);
  }
  
  for(int j=9; j>=0; j--) {
    for(int i=j; i>=0; i--) {
      digitalWrite(arr[i], HIGH);
      delay(30);
      digitalWrite(arr[i], LOW);
      delay(30);
    }    
  }  
  //20회 번쩍
  for(int j=0; j<20; j++) {
    for(int i=0; i<10; i++) {
      digitalWrite(arr[i], HIGH);
    }
    delay(30);
    for(int i=0; i<10; i++) {
      digitalWrite(arr[i], LOW);
    }    
    delay(30);
  }

  for(int i=0; i<5; i++) {
    digitalWrite(arr1[i], HIGH);
    digitalWrite(arr2[i], HIGH);
    delay(30);    
  }
  for(int j=0; j<20; j++) {
    for(int i=0; i<10; i++) {
      digitalWrite(arr[i], HIGH);
    }
    delay(30);
    for(int i=0; i<10; i++) {
      digitalWrite(arr[i], LOW);
    }    
    delay(30);
  }
  for(int i=4; i>=0; i--) {
    digitalWrite(arr1[i], HIGH);
    delay(30);    
    digitalWrite(arr2[i], LOW);
    delay(30);    
  }
  // red 3
  // green 4
  // blue 3
  for(int j=0; j<10; j++) {
    for(int i=0; i<4; i++) {
      digitalWrite(red[i], HIGH);
      digitalWrite(green[i], HIGH);
      digitalWrite(blue[i], HIGH);
      delay(30);    
      digitalWrite(red[i], LOW);
      digitalWrite(green[i], LOW);
      digitalWrite(blue[i], LOW);
      delay(30);         
    }    
  }
  for(int j=0; j<10; j++) {
    for(int i=3; i>=0; i--) {
      digitalWrite(red[i], HIGH);
      digitalWrite(green[i], HIGH);
      digitalWrite(blue[i], HIGH);
      delay(30);    
      digitalWrite(red[i], LOW);
      digitalWrite(green[i], LOW);
      digitalWrite(blue[i], LOW);
      delay(30);         
    }    
  }
  //9회 번쩍
  for(int j=0; j<9; j++) {
    for(int i=0; i<10; i++) {
      digitalWrite(arr[i], HIGH);
    }
    delay(30);
    for(int i=0; i<10; i++) {
      digitalWrite(arr[i], LOW);
    }    
    delay(30);    
  }
  for(int j=0; j<8; j++) {
    for(int i=0; i<10; i++) {
      digitalWrite(arr[i], HIGH);
    }
    delay(500);
    for(int i=0; i<10; i++) {
      digitalWrite(arr[i], LOW);
    }
    delay(100);   
  }

}
