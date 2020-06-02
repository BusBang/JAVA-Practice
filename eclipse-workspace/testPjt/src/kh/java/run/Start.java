//실행 클래스
package kh.java.run;
import kh.java.func.PrintMsg; 
public class Start {

	public static void main(String[] args) {
		PrintMsg pm = new PrintMsg(); //가져올 클래스 이름과 변수
		pm.printHello(); //가져올 메소드 이름과 변수

		PrintMsg hi = new PrintMsg();
		hi.printHi();
		
		PrintMsg number = new PrintMsg(); //숫자와 정수 테스트
		number.test();

	}

}

//1. 받아올 기능제공클래스를 Import로 불러온다.
//2. 약어를 사용한다면 약어가 무엇인지 정의해준다. pm.printHello();

/*
pm.printHello(); 라는 것은?
printHello 메소드를 pm 으로 불러오는 것?
*/


//실행클래스와 기능제공 클래스
/* 1. 실행클래스
* 메인메소드(실행메소드)를 가지고 있는 클래스. (main이 대표적인 실행 클래스. 메인 메소드를 갖고 있는 클래스)
* 메인메소드가 프로젝트당 1개 -> 실행클래스도 프로젝트당 1개 존재
* 실행클래스의 메인 메소드에서는 기능 제공 크래스에서 작성한 기능을 실행하는 용도로만 사용. 기능은 구현하지 않음
* 
* 2. 기능제공클래스
*/


/*
<<변수 Variable>>

자료형 변수명;
int number;
정수형 변수 number를 선언

자료형 : 저장할 데이터 타입(정수, 실수, 문자, 문자열 등)
변수명 : 해당 값을 기억하기 위한 변수의 이름
int : 정수형 변수


<자료형>
1. 기본형 
-실제 데이터(값)을 저장
-논리형 1개, 문자형 1개, 정수형 4개, 실수형 2개. 총 8개 존재
-각 자료형 별 데이터의 저장 크기가 다름

2.참조형(Reference Type)
-기본형을 제외한 나머지(String 등), 사용자정의 자료형
-데이터가 저장되어 있는 주소를 저장(객체의 주소)
-주소값만 저장하기 때문에 4byte로 저장크기가 일정
(주소값을 적고 주소값을 따라가면 메세지가 있는 것 0x12 -> Hello)
(근의공식? -> 수학의정석152p -> 함수)
*/

/*
<기본 자료형>
1. 논리형
-boolean : 1byte. true/false
2. 문자형 
-char : 2byte. 한 개의 문자
3. 정수형
-byte : 1byte. 이진데이터를 다룸
-short : 2byte. c언어와 호환
-int : 4byte. 정수를 저장하는데 사용
-long : 8byte 정수를 저장하는데 사용 (범위 초과시 long)
4. 실수형
-float : 4byte
-double : 8byte

정수형 표현 방식
-> 1byte= 8bits. 8칸에 2^8=256개를 표현 가능하지만, 첫 칸은 부호값이 들어가야하기에 7bit(2^7)개 가능
-> 1int=4byte=32bits=1+2^31

실수형 표현 방식
->오차가 적은 double을 사용한다.

<참조 자료형>
String (대문자. 다른건 전부 다 소문자. 사용자 정의는 대문자)
-하나의 문자열을 저장하는데 사용

<변수선언>
boolean bool;
char cha;
String str;

byte bNum;
double dNum;
float fNum;

<변수 명명 규칙 7가지>
1. 대소문자 구분되며 길이 제한이 없다.
2. 예약어 사용 X (new와 같은 꼭 써야하는 것들)
3. 숫자 시작 X
4. 특수문자는 _과 $만 허용
5. 카멜표기법
6. 한글이 사용가능하나 사용 지양
7. 의미있는 변수명을 사용하는 것을 권고

<변수의 초기화>
-변수를 사용하기 전에 처음으로 값을 저장하는 것
-변수를 사용하기 위해 반드시 초기화를 해야함

<변수 초기화 방법>
1. 변수 선언 이후 값을 대입
int age;
age = 20;

2. 변수 선언과 동시에 초기화
int age = 20;

* =는 등호가 아니라 대입연산자 -> 대입연사자를 기준으로 오른쪽 값을 왼쪽에 대입!

<Literal>
boolean bool = true;
char ch = 'A';
String str = "Hello";

byte bNum = 100;
int num = 2000;
long lNum = 1000000L;

float fNum = 1.123f;
double dNum = 3.14;

*long과 double의 경우 주의! 

<상수>
-변하지 않는 값. 초기화 이후 다른 값을 대입할 수 없음
-상수형 변수는 final을 써주고, 카멜표기법이 아닌 대문자로 쓴다

final double PI = 3.14 

final : 해당 변수가 상수임을 선언하기 위한 예약어
PI : 상수형 변수는 모두 대문자로 표기

<변수의 메모리 저장>
class, stack, heap으로 구성 됨
기본형은 stack에 들어감
참조형은 stack에 들어가나, 참조형 값은 heap에 있음
상수는 class에 쌓임

*/