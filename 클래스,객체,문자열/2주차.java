/*
UML로 클래스 다이어그램을 먼저 사용하면,
가시적인 설계에 용이하다.

C Name 클래스이름
data 변수
func() 함수

www.planttext.com

ex)커피를 클래스로 표현

class Coffee{
    origin
    degreeOfRoast;
    grade

    roast();
    grind();
    brew();
}
*/
//hello 출력하는 클래스를 만들고 객체 생성후 함수로 출력.

class sayHello{
    void printHello(){
        System.out.println("Hello");
    }
}

public class 객체_클래스_문자열2 {
    String s;
    void printString(){
        System.out.println(s);
    }
    public static void main(String[] args) {
        sayHello h1=new sayHello();
        h1.printHello();
        sayHello h2=new sayHello();
        h2.printHello();
        //h1과 h2에서 만들어진 객체는 '다른' 객체이다.
        //같은 붕어빵틀에서 나온 같은맛 다른 붕어빵.
        String s= "Hello";
        객체_클래스_문자열2 it=new 객체_클래스_문자열2();
        it.printString();
        String str="abc";
        String str2="abd";
        System.out.println(str.length());
        System.out.println(str.indexOf('c'));
        System.out.println(str.indexOf("bc"));
        System.out.println(str.charAt(2));
        System.out.println(str.equals(str2));
        System.out.println(str.compareTo(str2));
        System.out.println(str.contains(str2));
        System.out.println(str.concat(str2));

        String fileName="java.jpg";
        System.out.println(fileName.endsWith(".jpg"));
        System.out.println(fileName.endsWith(".png"));
        //System.out.println(fileName.isEmpty());

        String[] ss=fileName.split(".");
        for(int i=0;i<ss.length;i++){
            System.out.println(ss[i]);
        }
    }
}

/*
객체 생성,메모리 할당.
className var1 = new className();
()안에는 생성자에 있는 파라미터 설정해줌.

new는 heap에 있는 메모리 공간을 할당(동적 할당)후
참조값(포인터 값=메모리 주소값)을 반환.
*heap:동적 메모리 할당 공간

자바에서는 사용되지 않는 메모리 영역을
JVM에서 garbage collection기능으로 메모리 반환을 자동으로 한다.
->프로그램 실행 중 메모리의 할당과 반환이 자동으로 이뤄진다.

static memory
컴파일시 결정, 런타임동안 변하지 않음.
static,literal,멤버함수

stack
멤버 함수 내 생성된 멤버 변수들과 파라미터들.
함수 호출시 할당되었다가 종료되면 free.
아래 클래스의 calc 함수 실행시
calc에 x, y, result 가 할당
result로 add할당 -> a,b가 할당.
*/
class c1 {
    int add(int a, int b) {
        return a + b;
    }

    void calc() {
        int x = 3;
        int y = 5;
        int result = add(x, y);
        System.out.println(result);
    }
}
/*
heap
메모리 공간을 동적으로 할당 반환하는 공간.
연속적으로 메모리 공간을 할당 및 반환 함.

아래 c2클래스의 allocateObj에서
함수는 code.-> data
h:함수 내 변수-> stack
Hello: 객체 ->heap.
어떤게 어디 가는지 잘 생각해둬야함.

객체를 생성하려면 이름을 붙여줘야함.(그래야 구별 가능)
이름을 붙여준다? 객체가 생성된 메모리 주소를 가르키는
레퍼런스(포인터)를 변수명에 붙여준다.

이게 기본형(int,double)과 차이점.
기본형은 값자체를 저장.
객체는 참조형이라 reference type(메모리 주소값)을
변수명에 저장. 변수명을 호출하면 해당 객체의 주소값을 호출.

변수명에는 객체의 주소값.(stack)
객체는 다른 메모리 공간에 할당(heap)

변수명에 어떤 객체를 가르키냐에따라 달라짐.

객체 사용=클래스로 만들어진 객체의 변수,함수를 사용한다.
.으로 함수를 접근함.(변수는 보통 private으로 보호해놓음)
why? 캡슐화를 해침.(정보의 안전성)
그래서 getter setter같은 객체의 함수를 사용해서 객체의 변수 호출,수정
 */

class c2{
    void allocateObj(){
        sayHello h=new sayHello();
    }
}

/*
문자열
한개 이상의 문자,숫자,기호의 나열.
""안에 넣어 표현.
문자열 내부에서 "표현:\

자바에 문자열!=문자배열.
String s="hello"
s[0]으로 h접근을 못함.

java에선 문자열 덧셈 가능.
문자열+다른타입인 경우 다른타입을 문자열로 바꿔서 더함.
연산 순서:왼->오

String str="hello";
str="world"
이랬을때 hello 메모리 값이 world로 바뀌는게 아닌
hello를 참조하던 str이 새롭게 생성된 world 메모리공간을
참조하는것.
->string은 참조이기때문에 string 내용 자체 수정 불가.
새로 할당된 문자열값을 재참조하는것.

배열은 기본형 같은 경우 값이 들어가있고, 다른 객체나 문자열
같은 경우 해당 값이 들어있는 메모리 참조값이 들어간다.

대표적 string func
s.length():문자열의 길이를 반환
s.charAt(idx):s의 index위치를 반환(index체계)
s.compareTo(str):s와 str를 비교. 글자 단위로 비교해서 같으면 0
str이 앞에 있으면 양수 뒤에 있으면 음수.
s가 앞에 있으면 음수 뒤에 있으면 양수.

s-str값을 따지는 것. 음수->str이 더 큰 문자열
                     양수->str이 더 작은 문자열
s.equals(str) 문자열이 같은지 확인후 T or F반환.
s.concat(str) s+str해서 s에 넣음.
s.contains(str) s에 str이 들어있는지 T or F반환.
s.endsWith(str) s가 str로 끝나는지 T or F
s.isEmpty() s가 빈 문자열인지 T or F
s.indexOf(ch),s.indexOf(str)
문자에 해당하는 index반환 or 문자열에 해당하는 시작index반환.
index체계는 일상생활 숫자체계 -1임을 명시.
없으면? -1 반환.
s.substring(idx) idx 글자부터 끝까지 복사해서 새로운 문자열로 반환.
->복사해서 새로운 문자열 생성.
s.substring(start,end) start~end-1까지 복사해서 반환.
s.trim() 시작과 끝의 공백문자를 제거한 후 반환.
s.split(ch) ch로 구분해서 문자열을 분리. 문자열 배열로 반환.
s.split(ch,num) ch로 구분해서 분리하는데 num개수까지만 분리.

문자열을 직접 수정하고 싶다면
StringBuffer나 StringBuilder클래스를 사용.
StringBuffer는 multi thread 프로그램 작성시 동기화 지원!
multi thread 프로그램이 뭔지 찾아보기.

StringBuilder sb=new StringBuilder("hello");
sb.append(" world")'
-> sb=hello world.

String s="1 2";
sc=new Scanner(s);
System.out.println(sc.next());
System.out.println(sc.nextInt());
new Scanner(System.in);
이땐 키보드의 입력을 받아오는건데
new Scanner(s)면
s를 입력으로 하나씩 받아오는것(공백문자나 줄바꿈문자 기준)
그래서 sc.next()하면 1이 sc.nextInt()하면 줄바꿈뒤의 2가.
 */
