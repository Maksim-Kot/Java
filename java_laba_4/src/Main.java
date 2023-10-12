import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("./input.txt");
        try
        {
            String lastname, firstname, patronymic;
            int course, group;
            int amountOfSession;
            int numberOfSession, numberOfExam, mark;
            String examName, teacherName;
            ArrayList <String> nameOfExam = new ArrayList<>(), nameOfTeacher = new ArrayList<>();
            ArrayList <Integer> grade = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            int amountOfStudent = scanner.nextInt();
            scanner.nextLine();
            ArrayList<ReportBook> groupOfStudent = new ArrayList<>();

            for(int i = 0; i < amountOfStudent; i++)
            {
                lastname = scanner.nextLine();
                firstname = scanner.nextLine();
                patronymic = scanner.nextLine();
                course = scanner.nextInt();
                group = scanner.nextInt();


                ReportBook first = new ReportBook(lastname, firstname, patronymic, course, group);

                amountOfSession = scanner.nextInt();

                for(int k = 0; k < amountOfSession; k++)
                {
                    numberOfSession = scanner.nextInt();
                    numberOfExam = scanner.nextInt();
                    for(int j = 0; j < numberOfExam; j++)
                    {
                        scanner.nextLine();
                        examName = scanner.nextLine();
                        teacherName = scanner.nextLine();
                        mark = scanner.nextInt();
                        nameOfExam.add(examName);
                        nameOfTeacher.add(teacherName);
                        grade.add(mark);
                    }
                    first.setSessions(numberOfSession, numberOfExam, nameOfExam, nameOfTeacher, grade);
                    nameOfTeacher.clear();
                    nameOfExam.clear();
                    grade.clear();
                }
                groupOfStudent.add(first);
                if(scanner.hasNextLine())
                {
                    scanner.nextLine();
                    scanner.nextLine();
                }
            }


            boolean hasBadStudent = false;
            System.out.println("Bad student:");
            for(int i = 0; i < amountOfStudent; i++)
            {
                if(groupOfStudent.get(i).isBadStudent())
                {
                    System.out.println(groupOfStudent.get(i).getLastName());
                    hasBadStudent = true;
                }
            }
            if(!hasBadStudent) System.out.println("No such students");





        /*System.out.println(groupOfStudent.get(1).toString());
        if(groupOfStudent.get(1).isBadStudent()) System.out.println("Bad student!");
        else System.out.println("Good student!");*/

            FileWriter writer = new FileWriter("output.txt");
            writer.write(groupOfStudent.get(2).toString());
            writer.flush();
        }

        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}