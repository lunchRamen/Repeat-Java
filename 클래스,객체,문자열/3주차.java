/*
클래스에 속성 추가하기.
속성=변수=data.

속성_이름:자료형
함수_이름(매개변수):return type.

아래처럼 클래스를 수정하면 생성되는 모든 객체가 영향.
->클래스의 이름을 바꿔 여러개 만듬
->객체를 생성한 후 객체의 toWhom속성을 바꿈.

클래스를 바꾼게 아니라, 객체 생성후 그 객체의 정보(속성)를
수정하는 방법.
->클래스 수정!=객체 수정.

그렇다면, 객체의 내용은 어떻게 바꿀까?
->사용하는 사람이 바꿔야하는가, 객체가 스스로 바꿔야 하는가

객체지향 프로그래밍에서는
*데이터(변수)를 보호하기 위해 수정 못하게끔(캡슐화)
*클래스 내부에서만 값을 바꿀수 있게끔.
*대신 값을 변경해달라고 요청할 수 있는 함수를 만들어서 제공.
->getter,setter가 필수적이다.

클래스의 변수는 각 객체의 메모리 공간에 따로 존재.
객체마다 동일한 코드의 함수를 공유하지만, 변수는 따로 존재.

변수를 만들 때 위치에 상관없이 함수에서 사용 가능(클래스 내에서)
->클래스 내부에선 변수 먼저 변수를 쓸 함수를 나중에 안해도 됨.

클래스 멤버 변수는 초기값을 설정 안해주면 default값으로 됨.
null or 0 or false.

생성자
객체 생성시 호출. 객체 멤버변수 초기화 하기 위해 사용.
생성시 1번만 실행, 그 이후 사용 안됨.
생성자를 통해 값을 초기화 하는 것들은 한번 정하면 되는거나
초기값이 필요한 경우.
클래스 이름과 동일. 이름만 있는 함수.
접근제어자 설정 가능. 매개변수 있을수 있음.
abstract,final,static 사용X.
생성자가 없으면 default constructor가 자동 호출.
객체 생성시 호출 가능.
Hello h= new Hello(여기에).

기본 생성자: 매개변수가 없는 생성자. 자동으로 만들어짐.
멤버변수들은 default value로 초기화.
생성자 여러개 가능. 각 경우마다 overloading됨.

this:클래스 내부 생성자나 함수에서만 사용 가능.
     객체 자신을 참조하는 변수.(클래스를 참조하는게 아님)
     멤버 함수 내에서 이름이 중복되는 변수를 사용할 때 사용.
ex) setWhom(String toWhom){
        this.toWhom=toWhom;(멤버변수와 매개변수 이름 겹칠때)
    }
this.toWhom은 멤버변수로 명시하는 것.

생성자 코드 내에서 같은 클래스의 다른 생성자 호출 가능.
ex)아래 Summation에서
this(value1)은 Summation(int value1)을 가져온것.
this(value1)은 다른 생성자를 호출해서 value1 수정.

조건:위같은 this를 다른 생성자 호출용으로 쓸때는 항상 첫번째 줄이여야함.
이럴바엔, setValue1으로 각 생성자에 적용하면 되는데 굳이?
-> this는 멤버변수와 겹칠때 주로 쓴다.

클래스 배열
Hello h1=new Hello();
Hello h2=new Hello();
Hello h3=new Hello();
Hello[] hArr={h1,h2,h3}; 1번 방법
객체 먼저 생성 후 배열 생성

Hello[] hArr2=new Hello[3];
hArr[0]=new hello();
hArr[1]=new hello();
hArr[2]=new hello(); 2번 방법
객체가 들어갈 배열 생성 후 각 원소에 객체 생성.

 */
class Summation{
    int value1,value2;
    Summation(int value1,int value2){
        this(value1);
        this.value2=value2;
    }
    Summation(int value1){
        this.value1=value1;
    }
    Summation(){

    }
}
class Hello{
    String toWhom="world";
    Hello(){
        System.out.println("기본 생성자 호출");
    }
    Hello(String whom){
        this.toWhom=whom;
        System.out.println("toWhom수정 생성자 호출");
    }
    void sayHello(){
        System.out.println("hello "+toWhom);
    }
    void setToWhom(String s){
        this.toWhom=s;
    }
}
class Hello2{
    String toWhom="jsl";
    void sayHello(){
        System.out.println("hello "+toWhom);
    }
}

public class 클래스다루기 {
    public static void main(String[] args) {
        Hello h=new Hello();
        h.sayHello();
        Hello h2=new Hello("jsl");
        h2.sayHello();
        h.setToWhom("java");
        h.sayHello();
    }
}
