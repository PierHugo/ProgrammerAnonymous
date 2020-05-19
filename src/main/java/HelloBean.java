import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean(name = "hello")
@ViewScoped
public class HelloBean implements Serializable
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getResponse()
    {
        if (name != null && !name.isEmpty())
        {
            return "Hello " + name;
        } else
        {
            return null;
        }
    }

}