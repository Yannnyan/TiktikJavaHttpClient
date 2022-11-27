import java.util.List;
import Models.*;

public interface ClientAPI {
    

    // #TODO sign up
    // #TODO sign in
    

    public List<Student> get_students();
    public List<Teacher> get_teachers();
    public List<Lesson> get_Lessons();
    public void post_student(Student student);
    public void post_teacher(Teacher teacher);
    public void post_lesson(Lesson lesson);
    public void update_student(Student student, int id);
    public void update_teacher(Teacher teacher, int id);
    public void update_lesson(Lesson lesson, int id);
    public void delete_student(int id);
    public void delete_teacher(int id);
    public void delete_lesson(int id);



}
