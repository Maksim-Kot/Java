import java.util.ArrayList;

public class ReportBook implements Comparable<ReportBook>
{
    private String lastName, firstName, patronymic;
    private int course;
    private int group;
    //subjectName, sessionNumber, examGrade;

    private ArrayList<Session> sessions = new ArrayList<Session>();

    public ReportBook(String lastName, String firstName, String patronymic, int course, int group)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.course = course;
        this.group = group;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setSessions(int sessionNumber, int numberOfExams, ArrayList<String> nE, ArrayList<String> nT, ArrayList<Integer> eG)
    {
        Session s = new Session(sessionNumber, numberOfExams);
        for (int i = 0; i < numberOfExams; i++)
        {
            s.setExam(nE.get(i), nT.get(i), eG.get(i));
        }
        sessions.add(s);
    }

    public Boolean isBadStudent()
    {
        for (int i = 0; i < sessions.size(); i++)
        {
            if(sessions.get(i).badStudent()) return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        String res = "Last name: " + lastName +"\nFirst name: "+firstName
                +"\nPatronymic: "+ patronymic+ "\nCourse: "+course+"\nGroup: "+group+"\n";
        res += "Amount of session: "+ sessions.size()+"\n\n";
        for (int i = 0; i < sessions.size(); i++)
        {
            res +=sessions.get(i).toString();
            if(sessions.get(i).excellent()) res+= "Excellent: yes\n\n";
            else res+= "Excellent: no\n\n";
        }
        return res;
    }

    @Override
    public int compareTo(ReportBook o)
    {
        return lastName.compareTo(o.lastName);
        //return Number_Bradebook > o.Number_Bradebook ? 1 : Number_Bradebook == o.Number_Bradebook ? 0 : -1;
    }




    class Session
    {
        private int sessionNumber, numberOfExams/*, numberOfTests*/;
        private ArrayList<Exam> exams = new ArrayList<>();
        /*private ArrayList<Test> tests = new ArrayList<>();*/

        public Session(int sessionNumber, int numberOfExams/*, int numberOfTests*/)
        {
            this.sessionNumber = sessionNumber;
            this.numberOfExams = numberOfExams;
            /*this.numberOfTests = numberOfTests;*/
        }

        @Override
        public String toString()
        {
            String res = "Session number: "+ sessionNumber+"\nAmount of exams: "+numberOfExams+"\n";
            for (int i = 0; i < exams.size(); i++)
            {
                res += exams.get(i).toString();
            }
            return res;
        }

        public Boolean excellent()
        {
            for (int i = 0; i < exams.size(); i++)
            {
                if(exams.get(i).getExamGrade() < 9) return false;
            }
            return true;
        }

        public Boolean badStudent()
        {
            for (int i = 0; i < exams.size(); i++)
            {
                if(exams.get(i).getExamGrade() == 2) return true;
            }
            return false;
        }

        public void setExam(String nameOfExam, String nameOfTeacher, int examGrade)
        {
            Exam e = new Exam(nameOfExam, examGrade, nameOfTeacher);
            exams.add(e);
        }



        class Exam
        {
            private String nameOfExam, nameOfTeacher;
            private int examGrade;

            public Exam(String nameOfExam, int examGrade, String nameOfTeacher) {
                this.nameOfExam = nameOfExam;
                this.nameOfTeacher = nameOfTeacher;
                this.examGrade = examGrade;
            }

            public int getExamGrade()
            {
                return examGrade;
            }

            @Override
            public String toString()
            {
                return nameOfExam + " " + examGrade + " " + nameOfTeacher + "\n";
            }
        }

        class Test
        {
            private String nameOfTest, nameOfTeacher;
            private int testGrade;
        }

    }
}
