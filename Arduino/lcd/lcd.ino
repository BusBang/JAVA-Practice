#include<LiquidCrystal_I2C.h>         //임포트

LiquidCrystal_I2C lcd(0x27, 16, 2);   //생성자에게 매개변수 주기

//특수문자 만들어서 사용하기
byte test[8] = {
  B01010,
  B10101,
  B01010,
  B10101,
  B01010,
  B10101,
  B01010,
  B10101
};

void setup() {
  lcd.init();             //lcd 시작 선엉
  lcd.backlight();        //배경 불 on
  lcd.setCursor(0,0);     //커서 위치 설정
  lcd.print("Hello LCD (1)"); //문구 작성 
//  delay(1500);
//  lcd.clear();            //삭제하기

  lcd.createChar(0, test);  //바이트 배열의 문자 선언  
  lcd.setCursor(0,1);       //커서 위치 설정 - 두 번째 줄
  lcd.write(byte(0));       //바이트 배열 문구 작성 
}

void loop() {
//  for(int i=0; i<16; i++) {
//    lcd.scrollDisplayRight();
//    delay(200);
//  }
//  for(int i=0; i<16; i++) {
//    lcd.scrollDisplayLeft();
//    delay(200);
//  }

}
