package scheu.school.PresentationTool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scheu.school.PresentationTool.Model.Feedback;
import scheu.school.PresentationTool.Service.PresentationService;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PresentationServiceTests {

    @Autowired
    private PresentationService presentationService;

    @Test
    public void listGetsLoaded() {
        var presentations = presentationService.getAllPresentations();
        assertThat(presentations).isNotNull();
    }

    @Test
    public void XMLGetsLoaded(){
        var presenations = presentationService.getAllPresentations();
        assertThat(presenations.size()).isGreaterThan(0);
    }

    @Test
    public void entityGetsLoaded(){
        var presentatons = presentationService.getAllPresentations();
        if(presentatons.size() == 0)
            return;

        var presi = presentatons.iterator().next();

        assertThat(presi).isNotNull();
        assertThat(presi.getStudent()).isNotNull();
    }

    @Test
    public void feedbackTest(){
        Feedback f = new Feedback(0,0,0,0,"Well Done","");
        var presi = presentationService.getAllPresentations().iterator().next();
        var result = presentationService.addFeedback(presi.getId(), f);
        assertThat(result.getFeedbackList()).contains(f);
    }




}
