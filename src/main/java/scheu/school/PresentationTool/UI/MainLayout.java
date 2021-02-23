package scheu.school.PresentationTool.UI;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Paragraph;
import scheu.school.PresentationTool.Service.PresentationService;

//@PWA()

public class MainLayout extends AppLayout {
    public MainLayout(){
        Paragraph p = new Paragraph();
        p.setText("Presentation Tool");
        addToNavbar(p);

    }
}
