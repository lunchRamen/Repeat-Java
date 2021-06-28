/*
foreach문이 우용한 경우
인덱스 번호가 필요없는 경우
배열의 각 요소에 반복적인 작업을 하는경우
배열 요소의 값 수정을 하는게 아니라 사용만 할 때
for(type 임시변수:자료구조)
->타입만 맞춰서 임시변수 설정하면
배열뿐만 아니라 HashMap,Stack,Queue,ArrayList등등
다양한 자료구조를 iterator가 반복해서 방문한다.
혹은 배열에 객체를 넣었을때 어떤 객체를 넣든
클래스 명(자료형)을 맞춰주면 이것도 반복 순회 가능
why? 객체는 배열에 포인터값으로 들어가 있으니까.

자료형에 맞춰서 출력하고싶으면 printf로 c++처럼 쓰면됨.


switch문
if else if문과 비슷함.
switch-> if else if 는 가능
if else if ->switch는 불가능한 경우도 있음.
switch문이 더 효율적.
근데 값을 비교해서 같은경우(==)에 대해 처리하는것만 주로 사용.
근데 이 비교도 문자,정수,enum,String만 비교 가능.
-> 적은 경우에서 효율성을 높이기위해 씀. 가끔씩 써보면 좋을듯.
switch(ch)
case1:
    ex1;
    break;
case2:
case3:
    ex2;
    break;
case4:
    ex3;
    break;
case5:
    ex4;
    break;
default:
    ex5;
    break;
-> if else if문으로 바꾸면
if(ch==1) ex1;
else if(ch==2 || ch==3) ex2;
else if(ch==4) ex3;
else if(ch==5) ex4;
else ex5;
이렇게 쓸 수 있음.

enum
열거형. 상수들을 변수로 포함.클래스의 일종.
 */
enum Day{SUNDAY,MONDAY,TUESDAY,WENDESDAY,THURSDAY,FRIDAY,SATURDAY}

public class for_eachAndEnum {
    public static void main(String[] args) {
            String[] cities={"seoul","tokyo","london"};
            boolean check=false;
            String str="beijing";
            for(String s:cities){
                if(s.equals(str)){
                    check=true;
                    System.out.println(s+"가 있습니다.");
                }
            }
            if(check==false) System.out.println(str+"가 없습니다.");
            System.out.println(Day.MONDAY);
            //System.out.printf("%d",Day.MONDAY);
            System.out.printf("%s",Day.MONDAY);
    }
}
