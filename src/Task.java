import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Objects;

public abstract class Task {

    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private String heading;
    private String description;
    private TypeTask typeTask;
    private Repeat repeat;
    private LocalDateTime dayCreation;
    private final Integer id;

    public Task(String heading, String description, TypeTask typeTask, LocalDateTime date) throws EmptyStringValueException {
        setHeading(heading);
        setDescription(description);
        setTypeTask(typeTask);
        setDayCreation(date);
        this.id = COUNTER.getAndIncrement();
    }

    public String getHeading() {
        return heading;
    }

    public abstract boolean getTheNextDate(LocalDateTime date);

    public void setHeading(String heading) throws EmptyStringValueException {
        if (heading == null || heading.isEmpty()) {
            throw new EmptyStringValueException("Не заполнено поле заголовок.");
        }
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws EmptyStringValueException{
        if (heading == null || heading.isEmpty()) {
            throw new EmptyStringValueException("Не заполнено поле описание.");
        }
        this.description = description;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(TypeTask typeTask) throws EmptyStringValueException {
        if (typeTask == null) {
            throw new EmptyStringValueException("Не заполнено поле тип задачи.");
        }
        this.typeTask = typeTask;
    }

    public Repeat getRepeat() {
        return repeat;
    }

    public void setRepeat(Repeat repeat) throws EmptyStringValueException {
        if (repeat == null) {
            throw new EmptyStringValueException("Не заполнено поле признак повторяемости.");
        }
        this.repeat = repeat;
    }

    public LocalDateTime getDayCreation() {
        return dayCreation;
    }

    public void setDayCreation(LocalDateTime dayCreation){
        this.dayCreation = dayCreation;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "heading='" + heading + '\'' +
                ", repeat=" + getRepeat().getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", typeTask=" + getTypeTask().getName()+'\'' +
                ", dayCreation=" + dayCreation.getDayOfMonth() + " "+dayCreation.getMonth() +" "+ dayCreation.getYear()
                + " " + dayCreation.getHour() + " " + dayCreation.getMinute() +'\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(heading, task.heading) && Objects.equals(description, task.description) && Objects.equals(typeTask, task.typeTask) && Objects.equals(repeat, task.repeat) && Objects.equals(dayCreation, task.dayCreation) && Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heading, description, typeTask, repeat, dayCreation, id);
    }
}
