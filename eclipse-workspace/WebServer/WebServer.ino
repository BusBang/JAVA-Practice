/*
 WiFiEsp example: WebServer

 A simple web server that shows the value of the analog input 
 pins via a web page using an ESP8266 module.
 This sketch will print the IP address of your ESP8266 module (once connected)
 to the Serial monitor. From there, you can open that address in a web browser
 to display the web page.
 The web page will be automatically refreshed each 20 seconds.

 For more details see: http://yaab-arduino.blogspot.com/p/wifiesp.html
*/

#include "WiFiEsp.h"

// Emulate Serial1 on pins 6/7 if not present
#ifndef HAVE_HWSERIAL1
#include "SoftwareSerial.h"
SoftwareSerial Serial1(2, 3); // RX, TX
#endif

char ssid[] = "A_CLASS";            // your network SSID (name)
char pass[] = "khacademy*";        // your network password
int status = WL_IDLE_STATUS;     // the Wifi radio's status
int reqCount = 0;                // number of requests received

WiFiEspServer server(80);


void setup()
{
  //핀모드
  pinMode(8,OUTPUT);  //파란불
  pinMode(9,OUTPUT);  //빨간불
  // initialize serial for debugging
  Serial.begin(9600);
  // initialize serial for ESP module
  Serial1.begin(9600);
  // initialize ESP module
  WiFi.init(&Serial1);

  // check for the presence of the shield
  if (WiFi.status() == WL_NO_SHIELD) {
    Serial.println("WiFi shield not present");
    // don't continue
    while (true);
  }

  // attempt to connect to WiFi network
  while ( status != WL_CONNECTED) {
    Serial.print("Attempting to connect to WPA SSID: ");
    Serial.println(ssid);
    // Connect to WPA/WPA2 network
    status = WiFi.begin(ssid, pass);
  }

  Serial.println("You're connected to the network");
  printWifiStatus();
  
  // start the web server on port 80
  server.begin();
}


void loop(){
  if(Serial1.available()) {
    if(Serial1.find("+IPD,")) {               //"+IPD, 가 존재하면 그쪽으로 이동"
       int connectId = Serial1.read() - 48;   //접속 아이디. ASCI 코드로 만들기 위해 -48
       Serial.print("connectId : ");
       Serial.println(connectId);
       //1 : 파란 LED ON,
       //2 : 파란 LED OFF,
       //3 : 빨간 LED ON,
       //4 : 빨간 LED OFF
       Serial1.find("led=");                  //파라미터 부분으로 이동.
       int val = Serial1.parseInt();           //파라미터 값 읽어서 변수에 저장
       if(val == 1){
          digitalWrite(8, HIGH);
       }else if(val == 2){
          digitalWrite(8, LOW);        
       }else if(val == 3){
          digitalWrite(9, HIGH);
       }else if(val == 4){
          digitalWrite(9, LOW);
       }
    }
  }
}


void printWifiStatus()
{
  // print the SSID of the network you're attached to
  Serial.print("SSID: ");
  Serial.println(WiFi.SSID());

  // print your WiFi shield's IP address
  IPAddress ip = WiFi.localIP();
  Serial.print("IP Address: ");
  Serial.println(ip);
  
  // print where to go in the browser
  Serial.println();
  Serial.print("To see this page in action, open a browser to http://");
  Serial.println(ip);
  Serial.println();
}
