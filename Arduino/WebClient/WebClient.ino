/*
 WiFiEsp example: WebClient

 This sketch connects to google website using an ESP8266 module to
 perform a simple web search.

 For more details see: http://yaab-arduino.blogspot.com/p/wifiesp-example-client.html
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

char server[] = "192.168.10.179";

// Initialize the Ethernet client object
WiFiEspClient client;

void setup()
{
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

  // you're connected now, so print out the data
  Serial.println("You're connected to the network");
  
  printWifiStatus();
//  삭제
//  Serial.println();
//  Serial.println("Starting connection to server...");
//  // if you get a connection, report back via serial
//  if (client.connect(server, 80)) {
//    Serial.println("Connected to server");
//    // Make a HTTP request
//    client.println("GET /asciilogo.txt HTTP/1.1");
//    client.println("Host: arduino.cc");
//    client.println("Connection: close");
//    client.println();
//  }
}

void loop(){
  if(client.connect(server,80)){  //서버, 포트번호
    Serial.println("Connected to server");
    client.print("GET /arduinoTest.do?str=");
    client.print("testMsg");
    client.println(" HTTP/1.1");
    client.println("Host:192.168.10.179:80");
    client.println("cache-Control: no-cache");
    client.println("User0Agent: Arduino");
    client.println("Connection: close");
    client.println();
  }
  while(client.available()) {
    char c = client.read();
    Serial.write(c);
  }
  Serial.println();
  delay(10*1000);
  //정해진 시간마다 DB에 저장하고, 결과 값을 화면에 출력해주는 것임.
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

  // print the received signal strength
  long rssi = WiFi.RSSI();
  Serial.print("Signal strength (RSSI):");
  Serial.print(rssi);
  Serial.println(" dBm");
}
