package scheu.school.PresentationTool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scheu.school.PresentationTool.Service.PresentationService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private PresentationService presentationService;

    @Test
    public void contextLoads() {
        assertThat(presentationService).isNotNull();
    }
}
