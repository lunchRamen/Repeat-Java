/*
interface,abstract class,polymorphism,Object.

인터페이스:서로 다른 두 시스템,장치,소프트웨어를 서로 "이어주는 부분"
ex)usb. usb를 통해 키보드,마우스,프린터등을 연결.

자바의 인터페이스:함수를 "미리 선언" 구현은 비워놓은 추상화 메소드.
함수의 선언:그 함수가 어떻게 입력받고 어떤 결과값을 반환할지에 대해 정의"만" 먼저 해놓는 것.
위의 선언규칙(return type,func name, parameters)를 지켜서 구현하는 규칙을 만들어 놓는 것.
->함수의 규칙을 만들어 놓는 것.
->함수를 사용하는 사람의 코드 변경을 최소화하기 위함.

인터페이스의 장점
1.구현된 것을 교체하기 쉬움 2."다중 상속"을 해야하는 경우에 사용

interface name{
    접근제어자 return type func1(parameters);
}->이 인터페이스를 implements해서 func1을 구현하는 경우, 위의 규칙을 지켜야함.

interface의 경우 default(접근제어자 안붙임)가 public임.(구현해야되니까)
interface의 경우 접근제어자가 무조건 public만 가능.
interface의 경우 class에서 implements한 경우 해당 interface의 모든 메서드를 반드시 구현해야함.

인터페이스는 부모클래스처럼 사용가능.
ex) IShape i;
    i=new IShapeIm();이 가능하다.
    IShape i=new IShapeIm();이 가능.
근데 인터페이스는 실제 클래스가 아니기때문에, 인터페이스만으로 객체 생성은 안됨.
그리고 인터페이스는 클래스가 아니기때문에 Object의 자동상속을 받지 않음.

그런데, 인터페이스를 구현하는 클래스의 경우, 클래스이기때문에 Object클래스를 자동 상속.
->인터페이스 구현 클래스의 경우 인터페이스 구현,Object class 상속(다른 부모 클래스도 상속 가능)
->결과적으로 interface로 다중상속 구현이 가능함.

두개가 같이 되는 경우
class Child extends Parent implements Interface1,Interface2{

} 이런식으로 코드를 짜면 됨.

interface끼리의 상속도 가능. 이 경우는 extends로 상속함.

interface끼리 상속된 interface를 class로 구현하는 경우,
상속된 모든 interface의 method를 구현한다.(자주 쓰진 않음)

interface에서 정의된 함수에 쓸 변수들을 interface내에 정의 가능.
->이 변수들은 public이기때문에 접근 가능.
이 변수 선언은, 전역 상수로 지정 된다.
interface Coin{
    int front=1;
}
-> static final int front=1;
"전역" "상수" 이기때문에 정의와 선언 및 초기화를 같이 해줘야함.

ex)직사각형 면적.

기존 클래스를 상속하면서 인터페이스 구현
->클래스의 상속은 자동상속. 인터페이스는 override해서 무조건 구현.
(차이점)

default method
->인터페이스에서 함수 코드를 구현하는 것.(원래는 함수,상수 "선언"만 가능)
->클래스에서 다른 작업 처리하면 override해서 다시 구현.

지금은 인터페이스에 default,static,private,private static 함수 모두 구현 가능.
근데 자주 쓰이는건 default method(먼저 선언과 정의해놓고,때에따라 재정의(오버라이딩))

ex)동물들의 소리 구현. 대부분이 같은 함수의 기능을 가지고있고, 일부만 다름
->default를 만들어 놓고, 때에따라 재정의해서 같은 함수를 다른 기능으로 작동하게끔.
->    default String getSound(){
        return "squeak";
    }
    이런식으로 만든다. getSpecies()와 차이점 잘 봐두기.
getSound를 override 안한 경우, default method가 실행.

default method는 interface의 확장성을 보장해준다는 것.
(interface임에도,필수적으로 구현을 안해도 되는 함수니까)

interface의 static method.=클래스의 정적 메소드.
특징:구현 클래스가 같은 이름의 메소드를 구현 못함.
interface이름.method()로 호출 가능(객체로 호출 못함)

객체 복사(clone)
shallow copy(얕은 복사)
deep copy(깊은 복사)

shallow copy:참조값만 복사 되는것.-> 복사본을 수정시 원본도 수정된다.
why?참조값=가르키는곳 -> 원본과 복사본이 가르키는 객체가 같은 객체니까.

ex) A a= new A(); A b=a; -> a와 b는 같은곳을 가르킴.

deep copy:새로운 객체 공간을 만들고, 객체내용을 똑같이 복사해서 두개의 객체를 생성.
근데, java는 기본적으로 "값"만 복사 가능하고, 객체의 경우 무조건 참조값.
(실제 객체가 생성되는 공간은 다름.)-> deep copy 하려면? clone()함수를 써서 복사.
clone함수는 protected로 보호되어있어서, Cloneable interface를 구현하고,
이 interface의 clone함수를 public으로 재지정해줘서 사용하면 된다.

이때, 주의사항
clone함수가 구현되는 클래스 자료형으로 변수를 선언해야함.
부모클래스의 clone()함수를 호출해서 변수에 저장.
멤버 변수중에서 기본형은 값을 복사해서 저장.
                참조형은 주의해서 복사본 생성.
멤버변수가 String:기본형처럼 값 복사.
나머지:public으로 지정된 clone함수가 있다면, 이 함수를 호출해서 복사본 생성.
                                     없다면, 새로운 객체를 생성하고 get,set함수를 이용해서 복사.

추상 클래스(Abstract class)
선언만 하고 구현하지 않은 추상메소드를 한 개이상 포함 한 클래스.
추상메소드: abstract func1();
추상 메소드 존재->클래스도 abstract이 되고, 클래스 이름 앞에 붙여줘야함.

추상클래스는 추상메소드와 일반메소드가 같이 존재 가능.
추상클래스는 객체 생성을 못함.(다형성 때문에 만들어 놓음)
->자식클래스가 상속받고, 부모 추상 클래스의 추상메소드를 override해서 다양하게 써먹으려고.

추상클래스 vs 인터페이스
공통점: 함수 포함. 객체 생성
차이점:추상클래스만 속성 포함. 추상클래스만 함수를 구현.(후에 interface default메소드)

두개를 설계할때 가장 중요하게 보는점
->여러개를 상속받아야 하느냐(interface), 속성이 필요하느냐.(abstract class)
인터페이스가 범용성이 훨씬 넓어서 멤버변수를 사용하는 경우가 아니라면, interface우선.

다형성(Ploymorphism)
한가지 모양의 코드가 여러가지 방법으로 동작하는 것.
->변수나 객체에 여러 자료형이 할당 될 수 있는 것.
한개의 인터페이스로 되어있는 코드가 실제 실행될때 다양한 형태로 실행 되는 것.

ex) int x로 선언-> x엔 int형만 가능->단형적.
    Object x로 선언->x엔 객체로 선언되는 모든 클래스 가능->다형적.
==>다형성은 upcasting,overriding등의 개념등이 통합된 개념.
이렇게 해서 클래스를 부품화 해서 교체 가능한 형태로 만들어, 객체지향적 프로그래밍을 가능하게 만듬.

다형성을 위한 조건
상속관계(extends,implements)
자식 클래스에서 오버라이딩 된 함수가 있어야함.(이래야 실행 될 때에따라 다양한 형태로 동작)
상위클래스에서 선언된 "변수"를 사용 할 때 하위 클래스에서 오버라이딩 된 메소드가 호출되는
dynamic binding이 가능해야함.->실행할 때 어떤 클래스의 코드를 실행할지 지원하는 것.

아래 ShapeTag와 RectangleShapeTag에서
각각의 클래스로 객체 생성시, toString함수가 각 클래스로 호출.
부모 객체 변수에 자식 객체를 넣었을때->부모 클래스의 toString호출.
자식 객체 변수에 부모 객체를 넣었을때->오류 발생(다 못담음)

ex) ShapeTag s1= new ShapeTag("tag");
    RectangleTag r=new RectangleTag("tag,"rect");
    s1=r;
    ->부모 변수에 자식 객체를 넣는것
    이 경우 부모클래스의 참조(변수)가 자식 클래스를 가르킴
    이 경우 s1의 메소드 중 r에서 override 된 함수 호출시
    r의 함수가 호출 된다.(동적바인딩이 사용돼서)

동적바인딩 동작 원리
가상 메소드 표(virtual method table)사용.
->자바에서 생성되는 모든 객체들은 가상 메소드 표를 가지고 o.
(클래스마다 1개씩 존재)
->같은 클래스로 생성된 모든 객체는 같은 가상메소드 표를 공유한다.
->동적바인딩은 자식 클래스의 가상 메소드표상의 메소드 주소를 부모클래스와
바꿔치기해서, s1의 변수로 toString호출시 자식클래스의 toString이 호출 되게끔한다.

final->상수화.(override가 안됨)

다형성과 클래스의 부품화.
ex)사진에 다양한 필터를 적용시킬 수 있는 모바일 프로그램 개발.
컬러->흑백 노이즈추가.

로직플로우
1.사용자가 필터 선택
2.필터 적용(이게 다형성으로 적용 되어야 하는 부분)
3.사진 저장 혹은 1로 돌아감.

이경우 ImageApp으로 객체를 만들고
filterName변수를 통해서
filterName이 gray면
imageApp.apply(new GrayFilter());
로 imageApp을 상속받은 grayFilter로 실행하고
imageApp.apply(new NoiseFilter());하면
상속받은 noiseFilter실행.

ex)여러나라 언어로 sayHello하기.
아래처럼 만든 후에
Hello클래스 변수에 HelloFrench 객체를 넣고
sayHello를 실행시켜보면, Bonjour가 나옴.
부모클래스로 변수를 만들었지만 자식 객체를 넣었고
자식에게 override된 함수를 호출시, 부모클래스의
해당 메서드가 호출되는게 아닌, 자식 클래스의 오버라이딩
된 메서드가 호출됨=다형성.
 */
abstract class Hello3{
    private String toWhom;
    public Hello3(String whom){
        toWhom=whom;
    }
    public void setToWhom(String s){toWhom=s;}
    public String getToWhom(){return toWhom;}
    public abstract void sayHello();
}
class HelloFrench extends Hello3{
    HelloFrench(String whom){
        super(whom);
    }
    @Override
    public void sayHello() {
        System.out.println("Bonjour"+getToWhom());
    }
}


class ShapeTag{
    private String tag;
    public ShapeTag(String tag){this.tag=tag;}
    public String getShapeTag(){return tag;}
    @Override
    public String toString(){
        return "#"+tag;
    }//overriding. 이게 다형성을 만드는 코드.
}
class RectangleTag extends ShapeTag{
    private String rectangleTag;
    public RectangleTag(String tag,String rectangleTag){
        super(tag);//부모클래스의 tag변수를 따라 내려오게끔.
        this.rectangleTag=rectangleTag;
    }
    public String getRectangleTag(){return rectangleTag;}
    @Override
    public String toString(){
        return "#"+rectangleTag+" "+super.toString();
    }
}
class Dog implements Cloneable{
    int age;
    String name;
    String breed;
    public Dog(int age,String name,String breed){
        this.age=age;
        this.name=name;
        this.breed=breed;
    }
    public String getName(){return name;}
    public void setName(String s){name=s;}
    public int getAge(){return age;}
    public void setAge(int a){age=a;}
    public String getBreed(){return breed;}
    public void setBreed(String s){breed=s;}

    @Override
    public Object clone() throws  CloneNotSupportedException{//clone함수의 기본. thorws~~까지가 기본.
        Dog dog=(Dog) super.clone();//부모 클래스 객체의 복사본 만들어 저장.
        //Dog의 경우 상속받는 class가 없음->Object를 자동 상속받음.
        //그렇다면 super.clone()->Object의 clone함수 호출 후 그걸 Dog 객체로 Wrapped up해서
        //Dog 클래스 객체 변수에 저장하면? deep copy로 객체를 복사해서 저장 가능하다.
        dog.age=age;//기본형은 값만 복사
        dog.name=name;//String의 경우 기본형 취급하면 됨.
        dog.breed=breed;
        return dog;
    }
}
interface IAnimal{
    String getSpecies();
    default String getSound(){
        return "squeak";
    }
}
class Pig implements IAnimal{

    @Override
    public String getSpecies() {
        return "pig";
    }
    @Override
    public String getSound(){
        return "oink";
    }
}
class Cow implements IAnimal{

    @Override
    public String getSpecies() {
        return "cow";
    }

    @Override
    public String getSound() {
        return "moo";
    }
}
class Hamster implements IAnimal{

    @Override
    public String getSpecies() {
        return "Hamster";
    }
}

interface  IShape{
    double getArea();
    double getPerimeter();
}
class RectangleImpl implements IShape{
    private double width,height;
    public RectangleImpl(double w,double h){
        width=w;
        height=h;
    }
    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return 2*(width+height);
    }
}
public class 상속part2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        IShape r=new RectangleImpl(10.,20.);
        System.out.printf("%f",r.getArea());
        System.out.printf("%f",r.getPerimeter());
        Dog dog1=new Dog(2,"js","Poodle");
        Dog dog2=(Dog) dog1.clone();
        Dog dog3=dog1;
        //dog2는 deep copy. dog3는 shallow copy.
    }
}
