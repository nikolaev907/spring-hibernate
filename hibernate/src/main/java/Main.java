import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.easyum.HibernateSessionSingleton;
import ru.easyum.domain.Course;
import ru.easyum.domain.Student;
import ru.easyum.service.StudentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(final String[] args) {

        Session session = HibernateSessionSingleton.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Course junior = new Course("Java junior", 64);
        Course middle = new Course("Java middle", 85);

        List<Course> courses = new ArrayList();
        courses.add(junior);
        courses.add(middle);

        Student student = new Student("John", new Date(123456), 1000L, courses);
        junior.setStudent(student);
        middle.setStudent(student);

        StudentService studentService = new StudentService();
        studentService.saveStudent(student);

        tx.commit();
        session.close();

    }
}