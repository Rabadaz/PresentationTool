package scheu.school.PresentationTool.UI.Views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import scheu.school.PresentationTool.Model.Feedback;
import scheu.school.PresentationTool.Model.Presentation;
import scheu.school.PresentationTool.Service.PresentationService;


public class FeedbackView extends VerticalLayout {
    private final TextArea textArea = new TextArea();
    private final Button submitFeedback = new Button();
    private final IntegerField langField = new IntegerField();
    private final IntegerField contentField = new IntegerField();
    private final IntegerField mediaField = new IntegerField();
    private final IntegerField focusGroupField = new IntegerField();
    private final Grid<Feedback> feedbackGrid = new Grid<>(Feedback.class);

    private final PresentationService presentationService;
    private Presentation presentation;

    public FeedbackView(PresentationService presentationService){
        this.presentationService = presentationService;

        this.setVisible(false);
        submitFeedback.setText("Submit");
        submitFeedback.addClickListener(this::submitClicked);

        langField.setLabel("Language");
        contentField.setLabel("Content");
        mediaField.setLabel("Media");
        focusGroupField.setLabel("Focus-Group oriented");
        textArea.setLabel("Feedback");

        HorizontalLayout feedbackLayout = new HorizontalLayout();
        VerticalLayout pointFeedbackLayout = new VerticalLayout();


        add(feedbackGrid);


        pointFeedbackLayout.add(langField,contentField,mediaField,focusGroupField);
        pointFeedbackLayout.add(submitFeedback);

        feedbackLayout.add(pointFeedbackLayout);
        feedbackLayout.add(textArea);

        add(feedbackLayout);


    }

    private void submitClicked(ClickEvent<Button> buttonClickEvent) {
        //Prevent Empty Feedback
        if(langField.isEmpty() || textArea.isEmpty()|| contentField.isEmpty() || mediaField.isEmpty() || focusGroupField.isEmpty()){
            //TODO: Display Error Message
            return;
        }
        Presentation p = presentationService.addFeedback(
                presentation.getId(),
                new Feedback(
                        langField.getValue(),
                        contentField.getValue(),
                        mediaField.getValue(),
                        focusGroupField.getValue(),
                        textArea.getValue(),""));

        langField.clear();
        contentField.clear();
        mediaField.clear();
        focusGroupField.clear();
        textArea.clear();
        this.setPresentation(p);
        submitFeedback.setVisible(false);
    }


    public void setPresentation(Presentation p){
        presentation = p;
        feedbackGrid.setItems(p.getFeedbackList());
        this.submitFeedback.setVisible(true);
        this.setVisible(true);
    }
}
