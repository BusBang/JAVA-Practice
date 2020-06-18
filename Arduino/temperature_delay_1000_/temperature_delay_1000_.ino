#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27, 16, 2);

byte t[8] ={
  B00111,
  B00101,
  B00111,
  B00000,
  B00000,
  B00000,
  B00000,
  B00000
};

void setup() {
  analogReference(INTERNAL);
  lcd.init();
  lcd.createChar(0,t);
  lcd.backlight();
  lcd.setCursor(0, 0);
  lcd.print("Temperature");
}

void loop(){
  float tem = (analogRead(A0)/9.31);
  
  lcd.setCursor(0, 1);
  lcd.print(tem);
  lcd.write(byte(0));
  lcd.print("C");
  delay(1000);
}
