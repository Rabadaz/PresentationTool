package scheu.school.PresentationTool.Model;

import lombok.Data;
import net.bytebuddy.implementation.MethodAccessorFactory;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name="XMLModel")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="XMLModel", propOrder = {})

public class XMLModel {
    @XmlElement(name="Presentation")
    @XmlElementWrapper(name = "Presentations")
    private Set<Presentation> presentations;

    public Set<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(Set<Presentation> presentations) {
        this.presentations = presentations;
    }
}
