import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
/*
Object Class
모든 클래스가 자동으로 상속 받는 클래스
object class의 구조(메서드만 있음)
protected obj.clone():object ->객체를 복사해서 반환
obj.equals(Object):boolean ->객체와 같은지 비교해서 True,False반환(내부 내용 확인용)
protected obj.finalize():void
obj.getClass():class ->객체의 클래스타입 반환
obj.hashCode():int ->객체의 해시코드(고유값) 반환(JVM이 부여하는 정수값)
obj.notify():void
obj.notifyAll():void
obj.toString():String ->객체를 문자열 표현으로 반환.
obj.wait():void
obj.wait(timeout:long):void
obj.wait(timeout:long,nanos:int):void

hashCode와 equals
compareTo:두 객체의 대소관계 비교
equals:두 객체 비교
==:참조값 비교.
equals가 overriding되지 않으면 ==(단순한 참조값 비교)랑 똑같음.
overriding하면 속성이 같은지 검사 할 수 있다.

근데 우린 문자열의 내용 비교에 있어서 equals로 참조값이 아닌 내용(값)이 같은지 확인함.
why? 문자열 상수는 어딘가에 저장되어있는데, 이걸 String형 변수에 참조값형태로 넣어놓는것.
->그래서 변수가 다르고 내용이 같은 문자열의 경우, 문자열은 상수라서 같은 참조값을 지녀 ==와 equals가 True.
그렇다면,
String a="abc";
String b="abc";
String c= new String("abc");
String d= new String("abc");
->새로운 객체 공간이 생성됨.(문자열 상수를 배정한게 아님)
c==d false c.equals(d) true.
why?==는 참조값 equals는 참조값이 아닌 객체값 비교니까.

근데 a,b,c,d를 hashCode해보면 다 같은 값이 나옴.
why?hashCode도 overriding되어있음.(String class에 대해서는)
결론적으로 String은 equals와 hashCode를 overriding해서 그렇다.
 
ex)고양이 클래스를 만들고, 비교

equals를 overriding하는 이유: 객체가 가지고있는 속성들을 비교하기 위해서.
***이때는, hashCode도 같이 overriding해서 같은 객체 속성을 가지고있으면, 같은 hashCode를 반환 할 수 있게끔 설정해야함.


JAVA의 자료형들(ArrayList,Generic,Map)

Data Structure
자료들이 저장되고 사용되는 방식.
->각 자료구조별로 "정해진 방식"에 따라 자료를 저장,자료간 관계 정의,이를 효과적으로 사용.
자료 저장 방법:순서,key & value,layer
배열을 제외한 자료구조들은 자료의 개수에 제한 없음.

순서에 따른 구조:인덱스로 읽고 저장.(Array,List,Vector,ArrayList,LinkedList,Stack,Queue)
키에 따른 구조:고유 키에 대응해서 자료가 연동.Key는 unique.(HashMap,TreeMap,HashTable,Properties)
집합 구조:순서에 상관없이 저장.(HashSet,TreeSet)
계층 구조: 자료가 하위 자료를 가지는 계층적 구조.(TreeSet,TreeMap)

우리가 보통 생각하는것: index(int형)체계로 움직임.
String형으로 mapping되는걸 원한다->map사용.(key->value)

자바에선 자료구조 클래스를 묶어서 Collection으로 묶어놓음.

           I Iterable(반복자)       I Map             Object
           I Collection            HashMap       Arrays      Collections
I Set        I List          Queue
HashSet     ArrayList
자료구조들의 대략적 계층구조.

Collection은 3가지로 분류 가능.
List:순서대로 R/W
Map:Key를 사용해서 Value를 R/W(Key중복 불가)
Set:순서없이 R/W(Key 중복 불가) Key로만 구성된 Map이라 생각.

각 자료구조의 추가 사용 수정 삭제 크기
ArrayList 추가:.add() 접근:.get(index) 수정:.set(index,value) 삭제:.reomove(index) 크기:.size()
Queue 추가:.add() 접근:peek() 수정:priority queue라 remove & insert. 삭제:remove() 크기:size()
Set 추가:add() 접근:전체 접근 수정:remove and insert 삭제:remove() 크기:size()
Map 추가:put() 접근:get(key),values() 수정:put(key,value) 삭제:remove(key) 크기:size()

배열 vs 컬렉션
배열은 기본형도 저장 가능. 컬렉션에 있는 자료구조들은 객체만 저장 가능.
배열은 생성될때 크기를 선언하고 변경 불가. 컬렉션은 가변길이.
배열은 인덱스로만 접근 가능. iterator론 접근 불가. 컬렉션은 정렬, 반복자가 제공. 접근 저장할때 메소드를 이용.
배열은 공간복잡도 높고 시간복잡도 낮음. 컬렉션은 공간복잡도 낮고 시간복잡도 높음.

Arrays class:배열의 정렬 복사 검색 제공.
Collection class:자료구조의 메소드들 제공.

다차원 배열:행 열로 구성. 1차원 배열을 하나의 원소로 갖는 배열.
int[3][5]-> 3행 5열 -> 3개의 원소를 갖고있고 각 원소는 5개의 원소를 갖고있음.

ArrayList:배열과 비슷하게 인덱스를 이용해서 요소에 접근.
          배열과 달리 가변길이 배열. 객체만 넣을 수 있음.
          size(),get(i)로 길이,원소 접근.
          ArrayList<String> list=new ArrayList<>();.
Generic:ArrayList를 만들때 <Type>을 지정 안해주면, 어떤 클래스타입이라도 저장 가능.
이때 <>에 한가지 종류의 타입만 넣을수 있게 하는게 Generic.
numList.add(3);
이렇게 Integer타입 ArrayList에 int형 변수 넣어도 알아서 boxing(wrapped up)해서 넣어줌.

배열과 ArrayList는 각각 변환 가능.
배열->list Arrays.asList():수정할 수 없는 list(가변 list가 아님),객체타입 배열만 변환가능.
list->배열: List.toArray()

반복자(Iterator)
컬렉션 클래스의 요소를 한개씩 접근해서 작업을 처리하는데 도와주는 클래스.
Iterator는 컬렉션의 모든 클래스에서 같은 방법을 통해 각 요소에 대한 작업 수행.

.iterator() .hasNext()->존재 확인 .next()->다음 원소로 이동.
Iterator it=arr.iterator();
while(it.hasNext()){
    String s=(String) it.next();
}
->이 형태에서 it은 arr의 0번째 요소 앞에 위치해있고,
next로 인해서 0번째~n-1번재 요소를 방문하는것.
next()호출 안하면 가르키는 컬렉션 객체 없음.

반복자 대신 foreach문
for(자료형 변수이름:컬렉션 객체이름)

 */
class Cat implements Cloneable{
    private String name;
    private String breed;
    private LocalDateTime birthDay;

    Cat(String name,String breed){
        this.name=name;
        this.breed=breed;
        birthDay=LocalDateTime.now();
    }
    @Override
    public String toString(){
        return name+":"+breed+":"+birthDay.toString();
    }
    @Override
    public boolean equals(Object o){//eqauls는 원래 protected니까
        if(o==null) return false;
        if(!(o instanceof Cat)) return false;
        Cat d=(Cat) o;//자식 클래스로 형변환.
        return d.name.equals(name) &&d.breed.equals(breed)
                &&d.birthDay.equals(birthDay);
        //인자로 받은 Object객체를 Cat으로 upcasting하고
        //이 객체의 모든 멤버와 class의 멤버를 비교해서 T/F형태로 return.
    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(name,breed,birthDay);
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        Cat catClone=(Cat)super.clone();
        //현재 클래스는 상속받는게 없는데 super를 썼다? Object클래스의 clone함수를 쓰겠다.
        //거기다가 Cat클래스 타입으로 upcasting or wrapped up.
        catClone.birthDay=birthDay;
        catClone.breed=breed;
        catClone.name=name;
        return catClone;
    }
}
public class 나머지자바기능들 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cat cat1=new Cat("js","Turkish Angora");
        Cat cat2=new Cat("js","Turkish Angora");
        System.out.println(cat1==cat2);
        System.out.println(cat1.equals(cat2));
        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());
        //cat1과 cat2가 ==, equals 둘다 false로 나오고
        //hashCode값도 다름. 내용물이 같은데 왜 equals에서 false가 나오냐?
        //Cat 객체에 맞게 멤버들 비교하게끔 overriding을 안했으니까.
        //cat1과 cat2의 equals와 hashCode의 return이 true가 되게끔 하려면
        //두 함수를 class Cat에서 override해야한다.

        Cat d1=new Cat("d1","Turkish Angora");
        Cat d2=new Cat("d2","Turkish Angora");
        //이렇게 overriding한 후 equals와 hashCode를 써도, 똑같이 false와 다른값이 나옴
        //why?->birthday의 자료형이 LocalDateTime이라 그럼.
        //->같은시간에 만들어진 객체여야 true를 반환하는데, 그럴리가 없다.
        Cat d3=(Cat)d1.clone();
        //d3는 d1과 같은 birthDay를 가지므로, true를 return한다.

        ArrayList arr= new ArrayList();
        ArrayList<String> list=new ArrayList<>();
        ArrayList<Integer> numList=new ArrayList<>();
        numList.add(3);
    }
}
