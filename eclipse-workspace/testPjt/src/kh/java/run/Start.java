//���� Ŭ����
package kh.java.run;
import kh.java.func.PrintMsg; 
public class Start {

	public static void main(String[] args) {
		PrintMsg pm = new PrintMsg(); //������ Ŭ���� �̸��� ����
		pm.printHello(); //������ �޼ҵ� �̸��� ����

		PrintMsg hi = new PrintMsg();
		hi.printHi();
		
		PrintMsg number = new PrintMsg(); //���ڿ� ���� �׽�Ʈ
		number.test();

	}

}

//1. �޾ƿ� �������Ŭ������ Import�� �ҷ��´�.
//2. �� ����Ѵٸ� �� �������� �������ش�. pm.printHello();

/*
pm.printHello(); ��� ����?
printHello �޼ҵ带 pm ���� �ҷ����� ��?
*/


//����Ŭ������ ������� Ŭ����
/* 1. ����Ŭ����
* ���θ޼ҵ�(����޼ҵ�)�� ������ �ִ� Ŭ����. (main�� ��ǥ���� ���� Ŭ����. ���� �޼ҵ带 ���� �ִ� Ŭ����)
* ���θ޼ҵ尡 ������Ʈ�� 1�� -> ����Ŭ������ ������Ʈ�� 1�� ����
* ����Ŭ������ ���� �޼ҵ忡���� ��� ���� ũ�������� �ۼ��� ����� �����ϴ� �뵵�θ� ���. ����� �������� ����
* 
* 2. �������Ŭ����
*/


/*
<<���� Variable>>

�ڷ��� ������;
int number;
������ ���� number�� ����

�ڷ��� : ������ ������ Ÿ��(����, �Ǽ�, ����, ���ڿ� ��)
������ : �ش� ���� ����ϱ� ���� ������ �̸�
int : ������ ����


<�ڷ���>
1. �⺻�� 
-���� ������(��)�� ����
-������ 1��, ������ 1��, ������ 4��, �Ǽ��� 2��. �� 8�� ����
-�� �ڷ��� �� �������� ���� ũ�Ⱑ �ٸ�

2.������(Reference Type)
-�⺻���� ������ ������(String ��), ��������� �ڷ���
-�����Ͱ� ����Ǿ� �ִ� �ּҸ� ����(��ü�� �ּ�)
-�ּҰ��� �����ϱ� ������ 4byte�� ����ũ�Ⱑ ����
(�ּҰ��� ���� �ּҰ��� ���󰡸� �޼����� �ִ� �� 0x12 -> Hello)
(���ǰ���? -> ����������152p -> �Լ�)
*/

/*
<�⺻ �ڷ���>
1. ������
-boolean : 1byte. true/false
2. ������ 
-char : 2byte. �� ���� ����
3. ������
-byte : 1byte. ���������͸� �ٷ�
-short : 2byte. c���� ȣȯ
-int : 4byte. ������ �����ϴµ� ���
-long : 8byte ������ �����ϴµ� ��� (���� �ʰ��� long)
4. �Ǽ���
-float : 4byte
-double : 8byte

������ ǥ�� ���
-> 1byte= 8bits. 8ĭ�� 2^8=256���� ǥ�� ����������, ù ĭ�� ��ȣ���� �����ϱ⿡ 7bit(2^7)�� ����
-> 1int=4byte=32bits=1+2^31

�Ǽ��� ǥ�� ���
->������ ���� double�� ����Ѵ�.

<���� �ڷ���>
String (�빮��. �ٸ��� ���� �� �ҹ���. ����� ���Ǵ� �빮��)
-�ϳ��� ���ڿ��� �����ϴµ� ���

<��������>
boolean bool;
char cha;
String str;

byte bNum;
double dNum;
float fNum;

<���� ���� ��Ģ 7����>
1. ��ҹ��� ���еǸ� ���� ������ ����.
2. ����� ��� X (new�� ���� �� ����ϴ� �͵�)
3. ���� ���� X
4. Ư�����ڴ� _�� $�� ���
5. ī��ǥ���
6. �ѱ��� ��밡���ϳ� ��� ����
7. �ǹ��ִ� �������� ����ϴ� ���� �ǰ�

<������ �ʱ�ȭ>
-������ ����ϱ� ���� ó������ ���� �����ϴ� ��
-������ ����ϱ� ���� �ݵ�� �ʱ�ȭ�� �ؾ���

<���� �ʱ�ȭ ���>
1. ���� ���� ���� ���� ����
int age;
age = 20;

2. ���� ����� ���ÿ� �ʱ�ȭ
int age = 20;

* =�� ��ȣ�� �ƴ϶� ���Կ����� -> ���Կ����ڸ� �������� ������ ���� ���ʿ� ����!

<Literal>
boolean bool = true;
char ch = 'A';
String str = "Hello";

byte bNum = 100;
int num = 2000;
long lNum = 1000000L;

float fNum = 1.123f;
double dNum = 3.14;

*long�� double�� ��� ����! 

<���>
-������ �ʴ� ��. �ʱ�ȭ ���� �ٸ� ���� ������ �� ����
-����� ������ final�� ���ְ�, ī��ǥ����� �ƴ� �빮�ڷ� ����

final double PI = 3.14 

final : �ش� ������ ������� �����ϱ� ���� �����
PI : ����� ������ ��� �빮�ڷ� ǥ��

<������ �޸� ����>
class, stack, heap���� ���� ��
�⺻���� stack�� ��
�������� stack�� ����, ������ ���� heap�� ����
����� class�� ����

*/