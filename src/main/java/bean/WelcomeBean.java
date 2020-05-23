package bean;

import com.fasterxml.classmate.util.ConcurrentTypeCache;
import controller.Controller;
import model.Member;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean (name = "welcomeBean")
@ViewScoped
public class WelcomeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Member> members;

    public WelcomeBean(){
        Controller con = new Controller();
        this.members = con.getMemberDAO().findAll();
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> member) {
        this.members = member;
    }
}
