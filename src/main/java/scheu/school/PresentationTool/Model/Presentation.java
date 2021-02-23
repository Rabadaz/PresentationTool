package scheu.school.PresentationTool.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Presentation", propOrder = {})

public class Presentation implements Comparable<Presentation>{
    @XmlAttribute(name="id")
    private int id;
    @XmlAttribute(name = "title")
    private String title;
    @XmlAttribute(name="date")
    private String date;
    @XmlAttribute(name="student")
    private String student;
    @XmlTransient
    private List<Feedback> feedbackList = new LinkedList<>();


    public Presentation(int id, String title, String date, String student) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.student = student;
    }

    @Override
    public String toString() {
        return  title + "@" + date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Presentation o) {
        return this.id - o.id;
    }
}
