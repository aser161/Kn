package kr_task.task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {


    public static final LocalDate TODAY = LocalDate.now();
    public static final LocalDate TOMORROW = LocalDate.now().plusDays(1);
    private static List<Task> taskList = new ArrayList<>();

    public static boolean isDataTask (LocalDate date) {

        for (Task task : taskList) {
            isTask(task,date);
        }
        return false;
    }

    public static boolean isTask (Task task, LocalDate date_) {

        switch (task.getTimeTask()) {
            case ONE:
                if (TODAY.equals(date_)) {
                    return true;
                }
                break;
            case EVERY_DAY:
                if (TODAY.getDayOfYear() <= date_.getDayOfYear()) {
                    return true;
                }
                break;
            case EVERY_WEEK:
                if (TODAY.getDayOfYear() % 7 == date_.getDayOfYear() % 7
                        && TODAY.getDayOfYear() <= date_.getDayOfYear()) {
                    return true;
                }
                break;
            case EVERY_MONTH:
                if (TODAY.getDayOfMonth() == date_.getDayOfMonth()
                        && TODAY.getDayOfYear() <= date_.getDayOfYear()) {
                    return true;
                }
                break;
            case EVERY_YEAR:
                if (TODAY.getDayOfYear() == date_.getDayOfYear()) {
                    return true;
                }
                break;
        }
        return false;
    }

    public static boolean isTodayTask (){
        return isDataTask(TODAY);
    }

    public static void printDataTask (LocalDate date1) {
        getAllByTask(date1)
                .forEach(System.out::println);
    }

    public static void printTodayTask () {
        printDataTask(TODAY);
    }

    public static void printTomorrowTask () {
        printDataTask(TOMORROW);
    }

    public static void printAllTask () {
        taskList.forEach(System.out::println);
    }

    public static LocalDate returnNextDate (int i) throws IndexOutOfBoundsException{
        LocalDate date = null;
        try {
            date = taskList.get(i).returnNextDate();

        } catch (IndexOutOfBoundsException e){
            System.err.println("???????????? ???????????????? ??????????????");
        }
        return date;
    }

    public static void addTask (Task task){
        taskList.add(task);
    }

    public static void remove (int i){
        try {
            taskList.remove(i);
        } catch (IndexOutOfBoundsException e){
            System.err.println("???????????? ???????????????? ??????????????");
        }
    }

    public static Collection<Task> getAllByTask (LocalDate date1){
        Collection<Task> collect = taskList.stream()
                .filter(task -> isTask(task, date1))
                .collect(Collectors.toList());
        return collect;
    }




}
