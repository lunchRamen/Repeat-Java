/*
클래스= 특정 작업 처리하는 함수가 묶여있는 사용자 정의 자료형.
멤버(변수)=데이터 자료형
메서드(함수)=작업처리

object=instance=객체.
클래스를 프로그램 실행중에 사용할수 있도록 생성 한 것.
class=틀
object=틀로 빚어낸 내용물

함수=특정 작업을 처리하도록 만든 code block.
ex)덧셈하는 함수를 만들고 덧셈 할 일이 생길때마다
해당 함수를 호출(=함수 사용)해서 처리하는 것.
println:화면 출력
printf:서식에 맞춰 출력
next:서식에 맞춰 입력

함수에 전달하는 정보:parameter(매개변수)
함수로부터 받는 정보:return value 혹은 출력

함수 예시
returnType funcName(parameter){
    code;
    return type;
}
int add(int x1,int x2){
    return x1+x2;
}

object-oriented programming
=계층화,모듈화.

절차지향과 객체지향의 차이점
ex)차에 가솔린을 넣고 이동시킨다고 생각해보면?

절차지향
이동(move):함수
move의 파라미터:gasoline
-> 가솔린을 선언해놓고 인자로 move에 넘겨서 작동.
이럴 때 gasoline과 move가 분리되어 있기때문에,
인자를 잘 못 넘겨줄 경우, 인자의 값을 잘못 설정한 경우등등이
있을 수 있음.

객체지향
변수+함수를 class라는 빵틀 안에 같이 둠.
 */
//절차지향 코드
/*void move(double gas){

}
double gasloine=20.0;
move(gasoline);*/
//객체지향코드
/*
class Car {
    double gasoline;

    void move() {
        System.out.println("MOVE");
    }
}

Car A= new Car();
*/

/*
절차지향의 경우 파라미터의 새로운 정의,매핑이 필요.
객체지향의 경우 클래스로 함수와 변수를 지정해서 재사용성 높아짐.

기능을 함수로 만들고 함수의 데이터는 변수로 구성.
함수와 속성을 함께 묶어 객체를 구성.

Encapsulation:겉만 보고 사용 할 수 있게끔 만드는 작업.
->데이터와 함수들을 클래스 내에 담고 프로그래머가 사용할 땐
사용할 수 있는 부분만 보이도록 하는 것.

사용자는 사용할 부분만 확인해서 쉽게 사용가능.
         내부 데이터 보호
         내부코드의 복잡함X
->클래스에서 제공하는 방법 외에 외부에서 클래스 내부의 속성들을 변경시키지
  못하게끔 하기위해서.
  클래스 내부에 구성된 함수의 구현 방법들을 외부에 노출시키지
  않고 사용 방법만 제공.
  접근 제어자를 이용해서 지정.

객체지향: 추상화 캡슐화 상속 다형성(가장 큰 4가지 특징)
->이런 객체 사용 패턴이 있음.
 */

class num1{
    int num1;
    void num1(){

    }
}
//객체지향 프로그래밍의 예시.
class Number{
    int add(int a,int b){
        return a+b;
    }
}
//Number numEx=new Number();
//numEx.add(2,3); -> 객체 생성 후 add함수 사용.

//class:상품 설계도
//object:실제 상품

//instance:from class make object
//클래스로부터 객체를 만드는 과정.
//자동차 클래스에서 속성들을 정해 만드는게 객체를 생성.

//attribute of class
//->객체의 속성은 만들면서 혹은 수정하면서 정해짐.(이름,인자등을 통해)
