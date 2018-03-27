package User

import com.daraghhiggins.shareprofile.User.User
import com.daraghhiggins.shareprofile.Utils.HibernateUtil
import org.hibernate.Session
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class CreateUserSpec extends Specification {

    def 'setup' () {

    }

    def 'Create and delete user' () {
        given:
            Session session = HibernateUtil.getSession().openSession()
            session.beginTransaction()
        and:
            User user = new User();
            user.setUser_name("admin5515");
            user.setFirstName("Daragh");
            user.setSurnName("Higgins");
            user.setPassword("password");
        when:
            i = i + 1
        then:
            i == 4
    }
}
