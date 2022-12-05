import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskDaily extends Task{

    public TaskDaily(String heading, String description, TypeTask typeTask, LocalDateTime date) throws EmptyStringValueException {
        super(heading, description, typeTask, date);
    }

    @Override
    public boolean getTheNextDate(LocalDateTime date) {
        boolean getOnCurrenDate;
        LocalDate compareDate = date.toLocalDate();
        LocalDate compareDateTask = getDayCreation().toLocalDate();
        boolean equalOfDates = compareDateTask.isEqual(compareDate);
        getOnCurrenDate =getDayCreation().isBefore(date) || equalOfDates;
        return getOnCurrenDate;
    }
}
