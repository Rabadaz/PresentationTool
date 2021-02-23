package scheu.school.PresentationTool.Model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    private int language, content, media, focusGroup;
    private String message;
    private String author;
}
