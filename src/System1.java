import java.util.Scanner;
import java.util.Random;

public class System1 {
    // EmplyeeList emplyeeList = new EmplyeeList();
    //ProfessorList professorList =new ProfessorList();
    //  StudentList studentList = new StudentList();
    // Scanner scanner;
    private String name;
    private String date;
    private String nationalCode;
    private String user;
    private String password;
    private Random rand = new Random();
    private Scanner scanner = new Scanner(System.in);
    private String id;
    private String user1;
    private String password1;
    private System0 system0  = new System0();

    public System1() {
        system0.insertEmployee("admin", "admin", "majid", "admin", "admin", "admon");
        system0.insertStudent("m","m","m","Sm","m","m","m");
        system0.insertCourse(1,"a",3,"a","m");
        system0.insertProfessor("q","q","q","q","q","q,","ht","m");
        system0.insertProfessor("f","f","q","q","q","f","ft","m");
        system0.insertStudent("w","w","m","Sm","m","m","m");

    }

    //_____***********************************____________
    public void doIt() {
        while (true) {
            System.out.println("please insert user");
            user = scanner.next();
            System.out.println("please inser password");
            password = scanner.next();
            System.out.println();
            System.out.println("plese insert your type 'e','p','s");
            if(user.equals("admin") && password.equals("admin"))
                empolyee(user,password);
            char type = scanner.next().charAt(0);
            if (search(user, password, type)) {
                if (type == 'e' || user.equals("admin")) {
                    empolyee(user, password);
                } else if (type == 's') {
                    student(user);
                } else if (type == 'p') {
                    professor(user);

                } else
                    continue;
            }
        }
    }

    public void empolyee(String user, String password) {
        boolean isTrue = true;
        while (isTrue) {
            showEmployeeAction();
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    giving();
                    id = "E";
                    id = id + (rand.nextInt(1000));
                    system0.insertEmployee(this.user, this.password, this.name, id, this.date, this.nationalCode);
                    System.out.println("your employee add");
                    break;
                case 2:
                    System.out.println("plese insert id");
                    String idn = scanner.next();
                    system0.removeEmplyee(idn);
                    System.out.println("your Employee remove");
                    break;
                case 3:
                    giving();
                    System.out.println("please insert Status full-timd --> 'ft' or half-time-->'ht'");
                    String status = scanner.next();
                    System.out.println("please insert faculty between 'math' and 'computer'");
                    String faculty = scanner.next();
                    id = "P";
                    id = id + (rand.nextInt(1000));
                    system0.insertProfessor(this.user, this.password, this.name, id, this.date, this.nationalCode, status, faculty);
                    break;
                case 4:
                    System.out.println("please insert id");
                    String id = scanner.next();
                    system0.removeProfessor(id);
                    break;
                case 5:
                    giving();
                    id = "S";
                    id = id + (rand.nextInt(1000));
                    System.out.println("insert faculty between 'computer' or 'math'");
                    String fac = scanner.next();
                    system0.insertStudent(this.user, this.password, this.name, id, this.date, this.nationalCode, fac);
                    break;
                case 6:
                    System.out.println("insert id");
                    id = scanner.next();
                    system0.removeStudent(id);
                    break;

                case 7:
                    System.out.println("plese insert course name");
                    this.name = scanner.next();
                    System.out.println("please insert unit insert integer");
                    int unit = scanner.nextInt();
                    System.out.println("please insert professor");
                    String pro = scanner.next();
                    System.out.println("please insert your faculty between 'math' or 'computer'");
                    String fc = scanner.next();
                    int ids = (rand.nextInt(1000));
                    system0.insertCourse(ids, this.name, unit, pro, fc);
                    break;

                case 8:
                    System.out.println("insert id course");
                    int ide = scanner.nextInt();
                    system0.removeCourse(ide);
                    break;
                case 9:
                    System.out.printf("please insert id");
                    String nowId=scanner.next();
                    System.out.printf("please insert new name");
                    this.name=scanner.next();
                    system0.modifyEmplyee(nowId,name);
                    break;
                case 10:
                    System.out.printf("please insert id");
                    String idi=scanner.next();
                    System.out.printf("insert new date");
                    this.date=scanner.next();
                    system0.modifyDateStudent(idi,date);
                    break;
                case 11:
                    System.out.printf("plaese insert new nationalCode ");
                    this.nationalCode = scanner.next();
                    System.out.printf("please insert professot id");
                    this.id=scanner.next();
                    system0.changeNatianalCodeProfessor(this.id,this.nationalCode);
                    break;
                case 12:
                    System.out.printf("please insert id course");
                    int d =scanner.nextInt();
                    System.out.printf("please insert new professor");
                    String p =scanner.next();
                    system0.changeProfessorCourse(d,p);
                case 13:
                    system0.informationEmployee(user);
                    system0.salary(user);
                case 14:
                    isTrue = false;


            }
        }


    }

    public void student(String user) {
        String ids = system0.idStudent(user);
        System.out.println(ids);
        boolean isRun = true;
        String faculty = system0.myFaculty(ids);
        int select;
        while (isRun) {
            System.out.println("for see your information insert 1");
            System.out.println("for select course insert 2");
            System.out.println("for see your course insert 3");
            System.out.println("please insert number ");
            select = scanner.nextInt();
            switch (select) {
                case 1:
                    system0.showInfoStuden(ids);
                    break;
                case 2:
                    system0.myFacultyCourse(faculty);
                    int d  =scanner.nextInt();
                    system0.selecrCourse(d,ids);
                case 3:
                    system0.showCourse(ids);
                    break;


            }
        }

    }


    public void professor(String user) {
        String id = system0.idProfessor(user);
        String fc = system0.facultyProfessor(id);
        String select1;
        double score;
        boolean isused = true;
        int selection;
        while (isused){
            System.out.println("for see your info insert 1");
            System.out.println("for insert Score insert 2");
            System.out.println("for see your salary insert 3");
            System.out.println("for exit insert 4");
            selection = scanner.nextInt();
            switch (selection){
                case 1:
                    system0.showInformationProfessor(id);
                    break;
                case 2:
                    system0.showMyStudent(fc);
                    System.out.println("insert id of student");
                    select1 = scanner.next();
                    System.out.println();
                    System.out.println("please insert Score");
                    score=scanner.nextDouble();
                    system0.insertScore(score,select1);
                    break;
                case 3:
                    system0.salary(this.user);
                    break;
                case 4:
                    isused =false;




            }
        }


    }

    public boolean search(String user, String password, char e) {
        if (e == 'e')
            if (system0.isCheckEmployee(user, password))
                return true;
            else
                return false;
         else if (e == 's')
            if (system0.isCheckerStudent(user, password))
                return true;
            else
                return false;
         else if (e == 'p')
            if (system0.isCheckProfessor(user, password))
                return true;
            else
                return false;

        return false;

    }

    public void showEmployeeAction() {
        System.out.println("for sing up Employee insert 1");
        System.out.println("for remove Employee insert 2");
        System.out.println("for sing up professor insert 3");
        System.out.println("for remove professor insert 4");
        System.out.println("for sing up Student insert 5");
        System.out.println("for remove Student insert 6");
        System.out.println("for add course insert 7");
        System.out.println("for remove course insert 8");
        System.out.println("for modify employee insert 9");
        System.out.println("for modify student insert 10");
        System.out.println("for modify professor insert 11");
        System.out.println("for modify course insert 12");
        System.out.println("for see your information insert 13");
        System.out.println("exit 14");
        System.out.println("plese insert number");
    }

    public void giving() {
        System.out.println("please insert user");
        this.user = scanner.next();
        System.out.println("please insert password");
        this.password = scanner.next();
        System.out.println("please insert name");
        this.name = scanner.next();
        System.out.println("please insert date");
        this.date = scanner.next();
        System.out.println("please insert national code");
        this.nationalCode = scanner.next();
    }


}
