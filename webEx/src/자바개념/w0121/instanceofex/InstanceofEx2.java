package w0121.instanceofex;

//직군별로 보너스를 다르게 지급
/* 
클래스명:Employee 
   name:String
   salary:int
 
  +Employee()
  +Employee(name:String,salary:int)
  +toString():String
  +getBonus():int  <-- abstract
 
클래스명: Engineer   <-- Employee상속
 +Engineer()
 +Engineer(name:String,salary:int)
 +getBonus():int   <--- 150000 리턴
 +toString():String
 
클래스명: Developer  <-- Employee상속
 +Developer()
 +Developer(name:String,salary:int)
 +getBonus():int   <--- 100000 리턴
 +toString():String
*/

abstract class Employee{
	String name;
	int salary;
	
	public Employee() {
		super();
	}
	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return name + " "+salary;
	}
	abstract public int getBonus();         //정규보너스
}
//-------------------------------------------------------------
class Engineer extends Employee{
	public Engineer() {
		super();
	}
	public Engineer(String name, int salary) {
		super(name, salary);
	}
	@Override
	public int getBonus() {
		return 150000;
	}
	@Override
	public String toString() {
		return super.toString()+"  "+getBonus();
	}
}
//-------------------------------------------------------------
class Developer extends Employee{
	public Developer() {
		super();
	}
	public Developer(String name, int salary) {
		super(name, salary);
	}
	@Override
	public int getBonus() {
		return 100000;
	}
	@Override
	public String toString() {
		return super.toString()+"  "+getBonus();
	}
}
//-----------------------------------------------------------------------------
public class InstanceofEx2 {
	public static void main(String[] args) {
		Employee[] ob=new Employee[] {new Engineer("kim",1200000),
									  new Developer("lee",1750000),
									  new Engineer("park",2500000),
									  new Developer("hong",2350000)};
		// Engineer는 의 정규보너스는 150000, Developer의 정규 보너스 10000
		// Engineer는 의 특별보너스는 급여의 20%, Developer의 특별 보너스 급여의 10%
		for(Employee m :ob) {
			if(m instanceof Engineer) {
				System.out.println(m.toString() +"  " +(int)(m.salary*0.2));
			}else if(m instanceof Developer) {
				System.out.println(m.toString()+"  " +(int)(m.salary*0.1));
			}else {
				System.out.println(m.toString());
			}
		}
	}
}
//========================================================================
/*
abstract class Employee {
	String name;
	int salary;

	public Employee() {
	}
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	public String toString() {
		return String.format("%-4s\t%-7d\t", name, salary);
	}
	abstract public int getBonus();
}
//----------------------------------------------------------------
class Engineer extends Employee {
	public Engineer() {
	}
	public Engineer(String name, int salary) {
		super(name, salary);
	}
	@Override
	public int getBonus() {
		return salary / 5;
	}
	@Override
	public String toString() {
		return String.format("%s%-7d\t%-7d", super.toString(), 150000, getBonus());
	}
}
//----------------------------------------------------------------
class Developer extends Employee {
	public Developer() {
	}
	public Developer(String name, int salary) {
		super(name, salary);
	}
	@Override
	public int getBonus() {
		return salary / 10;
	}
	@Override
	public String toString() {
		return String.format("%s%-7d\t%-7d", super.toString(), 100000, getBonus());
	}
}
//----------------------------------------------------------------
public class InstanceofEx2 {
	public static void main(String[] args) {
		Employee[] ob=new Employee[] {new Engineer("kim",1200000),
									  new Developer("lee",1750000),
									  new Engineer("park",2500000),
									  new Developer("hong",2350000)};
		// Engineer는 의 정규보너스는 150000, Developer의 정규 보너스 100000
		// Engineer는 의 특별보너스는 급여의 20%, Developer의 특별 보너스 급여의 10%
		for(Employee var : ob) {
	         System.out.println(var);
	    }
	}
}
*/
/*   
[출력 결과]
kim 1200000 150000  240000
lee 1750000 100000  175000
park 2500000 150000  500000
hong 2350000 100000  235000
*/