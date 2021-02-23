package scheu.school.PresentationTool.UI.Views;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import scheu.school.PresentationTool.Model.Presentation;
import scheu.school.PresentationTool.Service.PresentationService;
import scheu.school.PresentationTool.UI.MainLayout;


@PageTitle("Presentation Tool")
@Route(value = "", layout = MainLayout.class)
public class PresentationView extends HorizontalLayout {
    private PresentationDetailView detailView;


    public PresentationView(PresentationService presentationService){
        detailView = new PresentationDetailView(presentationService);

        ListBox<Presentation> listBox = new ListBox<>();
        listBox.setItems(presentationService.getAllPresentations());
        listBox.addValueChangeListener(this::valueChangeListener);


        add(listBox);
        add(detailView);
    }

    private void valueChangeListener(AbstractField.ComponentValueChangeEvent<ListBox<Presentation>, Presentation> listBoxPresentationComponentValueChangeEvent) {
        detailView.setPresentation(listBoxPresentationComponentValueChangeEvent.getValue());
    }


}
