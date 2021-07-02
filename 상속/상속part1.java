/*
상속
기존 클래스의 변수나 메소드를 재사용 하면서
자신의 새로운 속성이나 기능을 추가해서 "확장"하거나 "개선"한 구현방식.

부모클래스
자식클래스->상속 된 클래스

자식클래스는 부모클래스의 모든 속성과 함수들을 상속 받지만,
부모 클래스에서는 자식클래스가 접근할 수 있는 속성과 메소드 지정가능.
->부모클래스의 모든 변수와 함수는 기본적으로 자식클래스가 가지고 있음.
다만, 그 내용을 사용,접근 할 수 있느냐는 부모클래스에서 허용 해주는지 문제.

Layer structure.
부모클래스:superclass 자식클래스:subclass derived class.

유사한 클래스들의 공통부분을 따로 빼서 부모클래스로 만들고,
이 부모클래스를 상속받게끔 디자인 하면 더 간결한 코딩 가능.

자식클래스는 부모클래스의 모든 멤버와 메소드를 굳이 선언하지 않아도
자동으로 상속받기때문에, 그냥 쓸 수 있고, 자식생성자에서
부모클래스 변수도 같이 초기화 해줘야한다.

UML에서 빈화살표 from 자식 to 부모

**부모클래스에서 변수 또는 함수가 private인 경우
자식클래스일지라도 접근이 불가능하다.

ex)학생 클래스(부모) -> 초등학생 중학생 고등학생 대학생(자식)
이런식의 개념.

기존의 클래스는 두고 거기에 확장적으로 기능을 추가하고 싶을때
자식클래스를 만들고 쓴다.
ex)대학생 클래스:학과 학번 학위과정 등등을 추가하면 됨.

상속관계에 정답은 없음. 우리 상식선에서 굳이 부모 자식관계를 정의하려 하지않아도됨.

ex)         Person
    Student     Professor

클래스를 구성할때 "현재"주어진 상태에서 생각 할 수 있는
가장 일반적인 클래스를 설계하는것부터 시작.

기본에 만들어진 클래스가 있다면 재사용 가능성 계산.
기존 클래스들이 Student와 Person처럼 공통부분이 많다면
이것들을 따로 정리해서 새로운 관계를 만드는것을 고려해보는것.
->refactoring(기존의 코드를 다시 설계하고 개선해나가는 과정)

->Greedy알고리즘처럼 당장 현재의 최선의 layer에서 부모 자식관계를 설정.
각 상황이 변할때마다 다시 계산해보는 것.

ex)                 동물
            척추동물        무척추동물
포유류 양서류 조류  파충류     연체동물    환형동물
이런 계층구조, 자식의 자식관계가 꼬리를 무는 구조가 있을수 있다.

this를 이용해서 다른 생성자를 호출 할 수 있음.
혹은 변수명이 겹칠때 클래스의 변수를 가르키는 용도.

super:부모클래스를 가르키는 참조변수.
->super(~~) 부모의 생성자를 호출해서 부모의 name이란 변수를 초기화.
super도 생성자의 첫번째줄에서만 쓸 수 있음.
->this도 생성자의 첫번쨰줄에서만 사용가능
=super와 this는 둘다 쓸수 없다.
super.변수 super.메소드 -> 부모클래스의 변수 함수 호출 가능.
***부모클래스의 생성자나 멤버함수가 private이 아닌 경우에 가능.
->이런경우 굳이 super를 안써도 .찍으면 자동으로 부모클래스 변수 함수 사용 가능.

super(인자); ->여기서 인자는 부모클래스 생성자의 파라미터.

자식클래스의 생성자 호출시,부모클래스 생성자 또한 호출 및 초기화가 되어야
되기때문에, 부모클래스 -> 자식클래스 생성자 순으로 호출 된다.(무조건)
**자식클래스 생성자엔 무조건 부모클래스 생성자도 호출 되어야함.
cf)부모클래스의 생성자가 default constructor면, 자식 클래스에서
호출 안해도 에러가 안남. custom인 경우 에러남.

자식 객체는 부모클래스의 확장된 클래스 형태이므로(=부모클래스의 모든 내용 포함)
->부모 클래스형 객체인 것처럼 사용 가능.(리스코프 치환 법칙)
*이렇게 부모 클래스에 자식 객체 생성시, 부모클래스의 변수,함수만 사용가능.
 Parent c2=new Child("derived parent",0);
        System.out.println(c2.getName());
부모클래스의 자식클래스 생성시, 생성자엔 자식 생성자를 추가하지만,
부모클래스의 변수,함수만 사용 가능.
이 경우, upcasting(부모 클래스형 변수에 자식 클래스 객체를 저장)
부모클래스 자식객체의 경우, 다시 자식 클래스로 wrapped up해도 자식클래스
변수,함수를 사용 할 수 없다. 이미 생성할때 생성자에서 부모클래스로 못 박아놨기때문.

instanceof:객체가 부모,자식 또는 어떤 클래스에서 생성됐는지 확인.

p instanceof Parent -> 객체 p가 Parent클래스에서 만들어진 객체라면, True
                                Parent클래스에서 만들어진 객체가 아니라면 False.
  부모클래스에 자식객체가 생성된 경우?-?Parent Child 둘다 O.

  ex)coffee bean class.
  Robusta   Arabica.
  재배 고도 카페인 함유량 가격 원두모양 재배지역 주사용원도 등이 Attribute.

  공통부분을 CoffeeBean에 넣음(Parent 클래스)
  Arabica는 상속받지만, 확장내용 X
  Robusta는 상속해서 species 변수를 새로 추가.(CoffeeBean의 species변수와 다른 개념)
  ->자식 클래스를 만들때 부모클래스와 똑같은 변수명은 쓰지 않는게 좋다.

자바의 모든 클래스는 Object클래스를 자동으로 상속받음.
Object클래스에는 getClass()메소드가 있음.
Class 자료형을 반환.
System.out.println(p.getClass())하면, 객체가 어떤 클래스 자료형인지 알수가 있어서 알려줌.

자식클래스가 부모클래스보다 더 큰 개념.(부모+확장이라서) 부모가 더 큰집합이 아님.

Method overriding.
->부모 클래스에 있는 함수를 동일하게 자식클래스에서 다시 구현 하는 것.
다형성때문에 존재.(자식객체의 동일 메소드를 다르게 구현하고 싶을때)
ex)동물의 울음소리->포유류의 울음소리->개의 울음소리
                                     ->고양이의 울음소리
                                     ->양의 울음소리
울음소리라는 메소드는 동일하지만, 각 동물 종류마다 다른 울음소리를 가지고 있을 것이기 때문.

@Override @Deprecated           @supresswarnings
       생성자나 메소드 지원X     컴파일러에게 경고 메세지 출력X.

오버로딩 vs 오버라이딩.
공통점:함수이름이 같다.
다른점:입력받는 파라미터가 오버로딩은 다르고,오버라이딩은 같다.
       구별시점이 오버라이딩은 runtime 오버로딩은 compile time에 결정.
오버로딩의 경우 인자의 갯수,타입에 따라 구별 가능하기때문에
동일한 함수이름을 써도 가능한듯.

업캐스팅 vs 오버라이딩
부모클래스형 변수에 자식클래스 객체가 저장된 경우,
자식클래스에 오버라이딩 된 함수 호출했을때, 자식클래스 함수가 실행됨.

ex) CoffeeBean ca;
    ca=new Arabica();
    ca.print();->Arabica의 print함수 호출.
    why? ca는 부모 껍데기를 쓴 자식 클래스 함수이고, 오버라이딩의 경우
         runtime에서 구별이 결정되기때문에, 실행중에 ca=new Arabica();를 인지하고
         ca.print()를 Arabica의 print()로 구별한다.

함수이름이 같다고해도, 오버라이딩 된 함수가 아니면,업캐스팅시 제외된다.

toString()함수 오버라이딩.
->원래의 toString()함수는 String을 반환하는 함수.
->우리가 toString()을 한건, Object클래스의 toString()함수를 오버라이딩 한것.

LSP(Liscov Substitution Principle):상속에서 지켜야하는 원칙.
클래스(객체)의 관계는 3가지가 있음.
1.아무런 관계가 아님
2.불완전한 상속관계
3.완전한 상속관계
->3번의 경우로 설계해야한다는 것.
=자식 클래스를 부모클래스처럼 사용 할때, 아무런 문제가 발생하지 않아야함.
(자식이 부모를 포함하고 있는 형태니까.)
자식클래스는 부모클래스와 똑같은 형태로 동작하되, 확장된 개념이 붙어있는 형태로 존재해야함.
ex)직사각형과 정사각형.
직사각형이 정사각형을 "완전히" 포함한 관계.

**다른 클래스를 포함 하는 클래스를 자식클래스로 만들어야함.(부모클래스가 아니라)

다중상속:c++은 가능하지만, java는 허용 안함. 다만,interface로 흉내는 낼 수 있음.
why?다이아몬드 문제.
    두개 이상의 parent class를 상속받고, 두 parent class의 함수 이름이 같은 경우
    어떤 부모클래스의 함수를 쓸지에 대해 결정하지 못한다.

접근제어자와 상속
클래스 속성(attribute,변수)는 자신 외에는 사용 못하게끔(private)
다른 클래스가 사용할 수 있게끔?->최소한의 권한만(protected=다른 패키지여도 상속관계면 사용가능.)
메소드의 경우, 클래스 내부에서만 쓸건지, 외부에서도 쓸건지에 따라 접근제어자 지정.

private:클래스 자신만 default:같은 패키지내에서만 protected:같은 패키지+다른패키지 상속관계 public:모두

ex) 거북이 ->바다거북
           ->육지거북
공통부분과 다른부분을 어떻게 구현하는지.
새롭게 확장된 부분은 어떤걸 구현할지.

다리의 수는 두 거북이에게 공통된 속성.->private
먹이는 Turtle로 구현 후 상속받아서 override.->protected
swim은 바다거북의 확장된 메서드. walk()는 육지거북의 확장된 메서드.

상속을 통한 접근제어자 수정.
자식 클래스에서 부모클래스의 "메서드"를 오버라이딩 하면서
접근제어자 수정 가능.(private->public쪽으로만 가능. 역으로 불가능)



 */
class Parent{
    private String name;
    Parent(String n){
        System.out.println("Parent Constructor");
        name=n;
    }
    public String getName(){return name;}
    public void setName(String n){name=n;}
}
class Child extends Parent{
    private int value;
    Child(String n,int v){
        super(n);//Parent 생성자 호출
        System.out.println("Child Constructor");
        value=v;
    }
    public int getValue(){return value;}
    public void setValue(int v){value=v;}
}
class CoffeeBean{
    String species="Coffee";
    void print(){
        System.out.println(species);
    }
    void setSpecies(String s){
        species=s;
    }
}
class Arabica extends CoffeeBean{
    @Override
    void print(){
        System.out.println("Arabica Coffee");
    }
}
class Robusta extends CoffeeBean{
    String species="Robusta";
    //위 species는 이름이 겹치지만, 다른 변수임.
    void print(){
        super.print();
        System.out.println("Robusta Coffee");
        //이 경우엔 부모클래스의 print 먼저 호출 후
        //override된 Robusta Coffee가 호출 된다.
        //override한 경우, super없이 print호출하면, 재귀호출(자기 자신 호출)로 에러남.
    }
    void print(String s){
        System.out.println(s);
    }
}
class Turtle{
    private int legs=4;
    protected String food;
    public void setFood(String f){food=f;}
    public void eat(){System.out.println(food);}
}
class SeaTurtle extends Turtle{
    public void swim(){System.out.println("Swimming");}
}
class LandTurtle extends Turtle{
    public void walk(){System.out.println("Walking");}
}
public class 상속 {
    public static void main(String[] args) {
        Parent p=new Parent("parent");
        Child c=new Child("child",0);
        System.out.println(c.getName());
        System.out.println(c.getValue());
        Parent c2=new Child("derived parent",0);
        System.out.println(c2.getName());
        //System.out.println(c2.getValue()); 못씀. 자식클래스의 함수라서.
        CoffeeBean c3=new CoffeeBean();
        Arabica a=new Arabica();
        Robusta r=new Robusta();
        c3.print();
        a.print();
        r.print();
        r.print("High Quality Coffee");
    }
}
