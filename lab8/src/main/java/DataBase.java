
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class DataBase {
    private static SessionFactory db;
    private void createSession() {
        db = new AnnotationConfiguration().configure("");
    }
}
