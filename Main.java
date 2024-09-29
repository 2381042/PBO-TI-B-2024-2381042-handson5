import java.util.Scanner;

public class Main {
    public static String[] todos = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addTodoList("Belajar");
        addTodoList("Menggambar");
        addTodoList("Menulis");
        addTodoList("Menyetir");
        showTodoList();
        System.out.println("Length todos: " + todos.length);
    }

    public static void showTodoList() {
        System.out.println("TODO LIST");
        for (int i = 0; i < todos.length; i++){
            String todo = todos[i];
            if (todo != null){
                System.out.println((i+1) + ". " + todo);
            }
        }
    }

    public static void addTodoList(String todo){
        resizeIfFull();

        //add todo to array that has null element
        for (int i = 0; i < todos.length; i++){
            if (todos[i] == null){
                todos[i] = todo;
                break;
            }
        }
    }

    private static void resizeIfFull() {
        // check if full
        Boolean isFull = true;
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                isFull = false;
                break;
            }
        }
        // resize twice its size if full
        if (isFull) {
            resizeArrayToTwoTimesBigger();
        }
    }

    private static void resizeArrayToTwoTimesBigger() {
        String[] temp = todos;
        todos = new String[todos.length * 2];
        for (int i = 0; i < temp.length; i++) {
            todos[i] = temp[i];
        }
    }

    public static boolean removeTodoList(Integer number){
        //check if the number is 0 or less than zero
        if (number <= 0){
            return true;

        }
        //check if the number is greater than the todos length
        if (number - 1 > todos.length - 1){
            return false;
        }
        //check whether the element is already null
        if (todos[number - 1] == null){
            return false;
        }

        for (int i = number - 1; i < todos.length; i++){
            if (i == (todos.length - 1)){
                todos[i] = null;
            }else{
                todos[i] = todos[i + 1];
            }
        }
        return true;
    }


}