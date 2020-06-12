#include<LiquidCrystal_I2C.h>         //임포트

LiquidCrystal_I2C lcd(0x27, 16, 2);   //생성자에게 매개변수 주기

//특수문자 만들어서 사용하기
byte test[8] = {
  B01000,
  B10100,
  B01000,
  B00000,
  B00000,
  B00000,
  B00000,
  B00000
};
void setup() {
  analogReference(INTERNAL);  //전압을 조정하는 명령어
  Serial.begin(9600);
  pinMode(12, INPUT);         //버튼의 위치, 입력값 : 0 or 1
  lcd.init();                 //lcd 시작 선엉
  lcd.backlight();            //배경 불 on
  lcd.createChar(0, test);  //바이트 배열의 문자 선언  
}

float sumTemp = 0;     //온도 총합     
int count = 1;

void loop() {
  int val = analogRead(A0);
  int switchVal = digitalRead(12);
  float temp = val/9.31;  //섭씨 온도가 아니기 때문에 계산해준다


  if(switchVal == 1) {
    lcd.setCursor(0,0);
    lcd.print(count);
    sumTemp += temp;
    delay(1000);
    count++;
    if(count>5){
      lcd.setCursor(0,0);        //커서 위치 설정
      lcd.print(sumTemp/5);        //온도 프린트    
      lcd.setCursor(5,0);       //커서 위치 설정 - 두 번째 줄    
      lcd.write(byte(0));       //바이트 배열 문구 작성 
      lcd.print("C");    
      delay(5000);
      lcd.clear();
      count = 1;
      sumTemp=0;
    }
  }else {
    count = 1;
    sumTemp=0;
    lcd.clear();    
  }

 

}
