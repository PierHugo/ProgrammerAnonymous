package bean;

import controller.Controller;
import model.Member;
import org.apache.commons.codec.digest.DigestUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean(name = "registerBean")
@RequestScoped
public class RegisterBean implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Member member;

    public RegisterBean()
    {
        this.member = new Member();
    }

    public void addMember()
    {
        this.member.setPassword(DigestUtils.sha256Hex(this.member.getPassword()));

        Controller con = new Controller();
        boolean isCreate = con.getMemberDAO().saveOrUpdate(this.member);

        if (!isCreate)
        {
            // TODO: message erreur
        }
    }

    public Member getMember()
    {
        return member;
    }

    public void setMember(Member member)
    {
        this.member = member;
    }
}
