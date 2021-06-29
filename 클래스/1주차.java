/*
자바는 변수,함수 모두 클래스 내부에서만 만들 수 있음.
main함수조차 class안에서 호출 가능.
JShell같은 경우 제외.

좋은 클래스
다른 프로그램에서도 사용가능.
확장성 좋음. 재사용성 좋음. 수정 쉬움.
->일관성과 결합성을 잘 조절해서 구현해야함.
일관성:클래스의 목적에 부합하게끔.
        클래스를 구성하는 요소들의 응집성,연관성.
        클래스가 어떤 데이터를 가지고 있어야 하는지 생각.
        그 자료를 처리하는 코드를 멤버함수로 구현.
결합성:다른 클래스와의 의존성이 적게끔.(독립성)
        클래스가 서로 연결되면서 발생.
        결합성이 낮을수록 좋은 클래스.
        ->어떤 클래스의 코드 수정이 다른 클래스에 미치는 영향이 적은 방향으로.
        why?이러면 꼬리에 꼬리를 물고 코드를 다 뜯어고쳐야함.
        클래스를 단순화,최소화 하는게 중요.

**문제에서 클래스를 뽑아내는 방법
문제에 있는 "명사를" 클래스 후보로 인식.
클래스 후보 가운데 서로 포함되는 명사가 있으면, 멤버변수로 인식.
클래스가 수행하는 기능(메서드)보다 데이터(변수)를 먼저 고려.
"응집성"에 따라 함께 묶을수 있는 데이터를 이용해 클래스 구성.
프로그램의 대상이 되는지 관련이 있는지가 클래스로 인식하는 기준이 됨.

ex)Rectangle의 면적 계산.

class Rectangle{
    double height;
    double width;

    Rectangle(double h,double w){
    height=h; width=w;
    }

    double getArea(){return height*width}
}
클래스의 캡슐화와 접근제어자

캡슐화:객체 자체가 연관된 메서드와 데이터를 같이 넣음.->보호하려는 이유도 있음.
        인터페이스를 제공해서 클래스를 사용할 수 있게끔.
        ->인터페이스는 클래스의 더 큰 빵틀 형태.(구현한 기능들의 집합)
        사용자가 내부 데이터,내부 동작을 수정하지 못하도록 만들려고 하는 것.
        ->응집성,무결성 보장.
        내부동작 수정X? 내부 동작 방법을 몰라도 사용가능.
        클래스를 설계할 때부터 사용자가 접근 할 수 있는 멤버변수,함수를 정해놓고 설계.
        ->사용 권한을 제어하는 방법:접근제어자.

접근제어자의 종류
public  protected   default(아무것도 지정x)   private
public: 모두 o
protected:클래스 내부, 패키지 내부, 서브클래스(자식,패캐지)
default:클래스 내부, 패키지 내부, 서브클래스X(패키지)
private:클래스 내부만.
->보통 변수는 데이터니까 보호하려고 private씀.
변수를 쓰거나 수정하려면 get,set함수를 쓴다.

보통은 변수는 private 함수는 public으로 만들지만
때에따라 얼마든지 경우가 달라질 수 있음.

변수는 각 객체마다 따로따로 가지고 있음(instance 변수)
함수는 하나의 공간에 참조값 형태로 있음.(같은 함수를 쓴다)

정적 메소드
static을 붙여줌. 객체를 생성하지 않고 메소드를 직접 호출함.
그냥 클래스.함수()형태로 쓸 수 있음.
객체를 따로 안만들고 함수를 바로 쓰고 싶을때 사용.

정적 멤버변수
클래스를 사용하는 모든 객체에 공통된(공유하는) 변수.
ex)객체가 생성될때마다 수를 +1하는 static 변수->생성자에 ++;하면
객체 만들때마다 +1씩 한다.

static은 상수화가 아님. 상수화는 final.
static은 class의 전역변수 느낌.
컴파일될때 생성됨.
클래스로 된 객체 생성 안해도 쓸 수 있음.

왜 main함수가 public static void main(String[] args)인가?
public static:어디서나 생성 가능. 컴파일시 바로 생성됨.
               main함수 내의 코드 실행.
               Main.main(args);와 같은 역할.
자바에서 문자열 입력받을때 띄어쓰기를 기존으로 나눠져 들어감.(문자열배열로 나눌때)

final:변수의 상수화. 선언 후 수정 불가.
선언만 해도 생성자에서 초기화 된다.
보통 static과 같이 쓰는데, 그 이유는 시작하자마자 생성되니까.

 */
class Rectangle{
    private double height;
    private double width;
    private double area;

    Rectangle(double h,double w){
        height=h; width=w;
    }
    double getHeight(){return height;}
    double getWidth(){return width;}
    double getArea(){return height*width;}
    void setHeight(double d){height=d;}
    void setWidth(double d){width=d;}
}

public class 클래스 {
}
