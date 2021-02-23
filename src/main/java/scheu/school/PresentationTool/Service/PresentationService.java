package scheu.school.PresentationTool.Service;

import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.stereotype.Service;
import scheu.school.PresentationTool.Model.Feedback;
import scheu.school.PresentationTool.Model.Presentation;
import scheu.school.PresentationTool.Model.XMLModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.*;

@Service
public class PresentationService {
    public Set<Presentation> presentationList = new TreeSet<>();

    public PresentationService(){
        File f = new File("./Data/Presentations.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(XMLModel.class);
            XMLModel m = (XMLModel) jaxbContext.createUnmarshaller().unmarshal(f);
            presentationList = m.getPresentations();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }



    public Collection<Presentation> getAllPresentations(){
        return presentationList;
    }

    public Presentation addFeedback(int id, Feedback feedback){
        Presentation presentation = presentationList.stream().filter(p -> p.getId() == id).findFirst().orElseThrow();
        presentation.getFeedbackList().add(feedback);
        return presentation;
    }



}
