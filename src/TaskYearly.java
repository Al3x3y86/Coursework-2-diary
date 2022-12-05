import java.time.LocalDateTime;

public class TaskYearly extends Task {

    public TaskYearly(String heading, String description, TypeTask typeTask, LocalDateTime date) throws EmptyStringValueException {
        super(heading, description, typeTask, date);
    }

    public boolean getTheNextDate(LocalDateTime date) {
        boolean getOnCurrenDate;
        getOnCurrenDate = (getDayCreation().getDayOfMonth() == (date.getDayOfMonth())) &&
                (getDayCreation().getDayOfYear() == date.getDayOfYear());
        return getOnCurrenDate;
    }
}