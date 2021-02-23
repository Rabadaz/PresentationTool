package scheu.school.PresentationTool.UI.Views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import scheu.school.PresentationTool.Model.Presentation;
import scheu.school.PresentationTool.Service.PresentationService;

public class PresentationDetailView extends VerticalLayout {
    private final H1 title = new H1();
    private final Paragraph date = new Paragraph();
    private final Paragraph student= new Paragraph();
    private FeedbackView feedback;


    public PresentationDetailView(PresentationService presentationService){
        this.feedback = new FeedbackView(presentationService);
        add(title);
        add(date);
        add(student);
        add(feedback);
    }


    public void setPresentation(Presentation p){
        title.setText(p.getTitle());
        date.setText(p.getDate());
        student.setText(p.getStudent());
        feedback.setPresentation(p);
    }





}
