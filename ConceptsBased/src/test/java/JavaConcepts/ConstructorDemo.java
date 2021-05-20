package JavaConcepts;

public class ConstructorDemo {
     String Emp_name;
     int emp_id;
    ConstructorDemo(){
        System.out.println("This is no argument constructor"+"\n");
    }
    ConstructorDemo(String name, int num){
        this.Emp_name=name;
        this.emp_id=num;
    }
    public void testEmployee(){
        System.out.println("These are the Employee details :"+ Emp_name  +":" + emp_id);
    }
    public static void main(String[] args) {
        ConstructorDemo dm = new ConstructorDemo();
        ConstructorDemo emp = new ConstructorDemo("Jay",101);
        emp.testEmployee();

    }
}
