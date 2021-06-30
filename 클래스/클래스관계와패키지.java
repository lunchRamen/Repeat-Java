import java.util.Random;
import java.util.Scanner;

/*
클래스를 만들때
->응집성(일관성) 결합성
클래스를 일관성 있게 만들면, 관련 되어있지않은 "개념"을 분리해서
새로운 클래스에 구성. 이러면 원래 클래스와 떼어낸 클래스가
서로 어떤 연관성(association)이 존재하게 된다.

연관성=관계.
두 클래스가 연결. 클래스 간에 참조가 사용.
클래스의 멤버변수로 다른 클래스가 저장.
UML에서 실선 형태.
ex)주사위를 굴리는 경우
Dice 객체, Random 객체.
주사위의 난수생성을 Random객체를 생성자 파라미터에서 받아서
만든다.
->떨어져 있는 분리된 클래스 2개이지만, Dice에서 Random에 대한 참조를 가지고 있다
->연관관계가 있다.

의존관계(dependency)
연관과 비슷하지만 참조를 사용하는 시기가 짧음.
UML에서 점선 형태.
ex)주사위 확률을 구하는 클래스.
->주사위 확률을 구할때만 씀.

주사위는 객체 생성(함수 호출)이 빈번하지만
->연관관계
주사위의 확률을 구하는 객체(함수)는 한번만 구하면 될듯?
->의존관계

의존관계 발생 생황
메소드 내부에서 다른 클래스 객체를 사용하는 경우.
->DiceProbability의 roll 메서드에서 Random 객체를 사용하는 경우.
메서드에 인자로 다른 클래스 객체를 전달 받아
함수 내부에서 다른 클래스의 메소드 호출

집합과 구성(aggregation and composition)
->전체와 부분의 생명주기로 따짐.(다르면 집합 같으면 구성)
생명주기? 객체의 생성과 소멸까지의 기간.

집합:한 클래스가 다른 클래스를 포함하는 관계.(전체와 부분)
UML에서 전체를 나타내는쪽에 비어있는 마름모 화살표가 붙어있음.
생성자나 메소드에 입력으로 다른 객체를 전달 받아서
멤버 변수에 저장하는 경우를 집합으로 보면 됨.

구성:전체와 부분의 생명주기가 일치.
생성자와 메소드에서 객체를 생성해서 멤버 변수에 저장->구성
전체를 나타내는 쪽에 차있는 마름모 화살표.

ex)신체와 눈: 구성(생성과 소멸이 일치)
          렌즈:집합(생성과 소멸이 다름)
눈은 몸이 없어지면 같이 없어지지만, 렌즈는 남는다.

실습문제 1
pc를 class로 구성해보기.
pc는 본체,모니터만 있다고 가정.
본체엔 power,cpu,memory,hdd를 속성으로 포함
모니터엔 power,size,color를 속성으로

PersonalComputer에 본체,모니터 속성을 다 때려박을 수 있지만
각각 따로 class 생성해서 PC의 속성으로 객체를 생성하면
연관관계로써 세 클래스가 존재한다.

실습문제 2
수강신청하는 프로그램 작성.
조건:객체지향수강 인원 30명 강사 김갑돌 강의실 G416
목적: 클래스 사이의 연관 관계를 살펴보는 것.
"객체지향"강의만 수강하는 수강신청이 아니라
강의 수강이 가능하게끔 보편화 시키는게 중요.

sol:클래스(명사)찾기.
클래스 이름:ObjectOrientedCourse
속성:학기 개설 강좌 실습과목 강의실 강사 인원.
인원은 30명으로(배열) 등록인원을 공유(print)

ver1 강좌 클래스 구현.
학생수 30명: 상수로 지정
등록 할때마다 학생 수를 늘리고 취소하면 학생 수를 줄임
->변수로 관리.
학생에게 공유 할 수 있도록 메소드 제공.
강의실은 강좌가 만들어질 때 정해지도록.
재 지정 메소드도 만들어서 강의실 수정 가능하게끔.

ver2
문제점:등록 취소할 때 학생 이름을 사용. 강사이름도 저장만 됨.
        클래스 이름도 너무 특화되어있음->course로.
sol:학생 클래스 추가 및 이름 변경.

ver3
강사와 교재 클래스 추가.

패키지
관련된 클래스들으르 묶어서 관리.
소스 코드와 클래스 파일들을 폴더로 나누어서 관리
->클래스 이름이 같아 충돌하는 경우를 막기위해서 나눠 관리.
커스텀 패키지랑 기본 확장 패키지랑 이름이 겹칠수 있으니까.

import=패키지 가져오는거.
java는 기본 패키지
javax는 확장 패키지.

java.~~
javax.~~
~~에 해당하는 부분은 하위 폴더들.(특정 기능이 필요할수록 하위폴더로 내려감)
*:해당 폴더 모든 클래스 다 사용 가능.

패키지 이름 결정 방법
따로 없는데, 관례적으로 URL을 .기준 거꾸로 써서 사용.

패키지는 소스코드나 class파일을 폴더에 넣어서 관리.
폴더가 .의 기준.
java.util.Scanner;
->java폴더의 util폴더에 Scanner클래스 파일과 코드를 import해서 쓴다.

src는 소스코드 컴파일된 코드는 classes에 있다.

패키지 사용법: 어떤 패키지에 속한 클래스인지 정확하게 표기해야함.
import로 첫줄에 쓰면 맨 마지막 폴더명(클래스 이름)만 쓰면 됨.

패키지 이름이 다르지만 클래스 이름이 다르다면?
->import를 했더라도 java.util.Random r1;이렇게 다 써줘야함.

패키지 만들기
소스코드와 클래스파일을 적절한 폴더구조에 만들어서 넣어야함.
폴더(디렉토리)를 해당 경로에 미리 만들어놔야함.
프로젝트에서 src에 패키지선택 후 이름 설정.
해당 패키지 폴더 안에 java 클래스 생성.


접근제어자
default: package private
패키지 내부에서 private. 패키지 내부에서만 쓸 수 있음
패키지 외부에서 참조 불가능.

jar파일: 연관된 클래스를 압축해놓은 형태. java archive.
쓰는 이유:여러군데 나눠져있는 클래스들을 한꺼번에 import하고 싶을때.
장점:배포 용이. 패키지를 사용하면 폴더구조 유지가능. 바로 실행 가능.

jar파일을 실행하려면 manifest파일이 필요.(txt파일 형태로)
주의사항:두번째에 빈줄이 있어야함.

jar실행 명령 c:create v:erbose(출력) f:생성할 jar파일 이름 지정.
             m:manifest 파일 이름 지정.

jar파일 생성
file:projet structure-> artifacts -> + -> jar 선택
->from module to dependency. -> 어디다 저장할지 설정.
->output dir확인하고 ok누르면 생성. 이후에 build->build artifacts하면 생성.

 */
class Student{
    private String stNo;
    private String name;

    Student(String stNo,String name){
        this.name=name;
        this.stNo=stNo;
    }
    String getStNo(){return stNo;}
    String getName(){return name;}
    void setStNo(String s){this.stNo=s;}
    void setName(String s){this.name=s;}
    public String toString(){
        return "Name : "+name+", Student Num : "+stNo;
    }
}
class Course{
    private final static int MAX_STUDENTS=30;
    private String lecturer;
    private String room;
    private int numEnrolled=0;
    private Student[] students=new Student[MAX_STUDENTS];

    Course(String lecturer,String room){
        this.lecturer=lecturer;
        this.room=room;
    }
    public void setRoom(String room){this.room=room;}
    public void enroll(String s){
        if(numEnrolled<MAX_STUDENTS){
            students[numEnrolled].setName(s);
            numEnrolled++;
        }
    }
    public void drop(Student s){
        if(numEnrolled>0){
            for(int i=0;i< students.length;i++){
                if(students[i]==s){
                    for(int j=i+1;j< students.length;j++){
                        students[j-1]=students[j];
                    }
                    numEnrolled--;
                    break;
                }
            }
        }
    }
    public int getNumEnrolled(){return numEnrolled;}
    public void printEnrolled(){
        for(int i=0;i<students.length;i++){
            System.out.println(students[i]);
        }
    }
}
class ObjectOrientedCourse{
    private final static int MAX_STUDENTS=30;
    private String lecturer;
    private String room;
    private int numEnrolled=0;
    private String[] students=new String[MAX_STUDENTS];

    ObjectOrientedCourse(String lecturer,String room){
        this.lecturer=lecturer;
        this.room=room;
    }
    public void setRoom(String room){this.room=room;}
    public void enroll(String s){
        if(numEnrolled<MAX_STUDENTS){
            students[numEnrolled]=s;
            numEnrolled++;
        }
    }
    public void drop(String s){
        if(numEnrolled>0){
            for(int i=0;i< students.length;i++){
                if(students[i]==s){
                    for(int j=i+1;j< students.length;j++){
                        students[j-1]=students[j];
                    }
                    numEnrolled--;
                    break;
                }
            }
        }
    }
    public int getNumEnrolled(){return numEnrolled;}
    public void printEnrolled(){
        for(int i=0;i<students.length;i++){
            System.out.println(students[i]);
        }
    }
}
class PersonalComputer{
    Computer computer;
    Monitor monitor;

    PersonalComputer(Computer c,Monitor m){
        this.computer=c;
        this.monitor=m;
    }
}
class Computer{
    private String cpu;
    private String memory;
    private String hardDisk;
    private String color;
    private String power;

    Computer(){

    }
    public void turnOn(){

    }
}
class Monitor{
    private String monitorSize;
    private String color;
    private String power;

    Monitor(){

    }
    public void turnOn(){

    }
}
class Dice{
    private Random random;
    public Dice(Random random){
        this.random=random;
    }
    public int roll(){
        return random.nextInt(6)+1;
    }
}
class DiceProbability{
    private int[] values;
    private int num;
    DiceProbability(int num){
        this.num=num;
        values=new int[num];
        for(int i=0;i<values.length;i++){
            values[i]=0;
        }
    }
    void roll(){
        Random random=new Random();
        for(int i=0;i<num;i++){
            values[random.nextInt(6)+1]++;
        }
    }
    void printValues(){
        for(int i=0;i<num;i++){
            System.out.printf("%d\t",values[i]);
        }
    }
}

public class 클래스와패키지 {
    public static void main(String[] args) {
        Random random= new Random();
        Dice d1=new Dice(random);
        d1.roll();
        Dice d2=new Dice(random);
        d2.roll();
    }
}
