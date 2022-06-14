package Lesson7;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Введите 1 для получения погоды на сегодня;" +
                    "Введите 5 для прогноза на 5 дней; Для выхода введите 0:");

            String command = scanner.nextLine();

            //TODO* Сделать метод валидации пользовательского ввода

            if (command.equals("0")) break;
            //System.out.println(Period.NOW +  " " + Period.FIVE_DAYS );
            if (command.equals("1") || command.equals("5")) {
                System.out.println("Введите имя города: ");
                //String city = scanner.nextLine();
                //URLEncoder.encode(city, "UTF-8");
                String city = URLEncoder.encode(scanner.nextLine(), "UTF-8");
                if (city.length() > 0) {

                    try {
                        controller.getWeather(command, city);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else { System.out.println("Город не введен. ");}
            }
        }
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        UserInterfaceView userInterfaceView = new UserInterfaceView();
        userInterfaceView.runInterface();
    }
}
