//1. Добавить ф-ю авторизации пользователей.
//2. Добавить ф-ю приватных сообщений.
//3. Добавить ф-ю получения списка всех пользователей.
//4. Добавить ф-ю чат-комнат.
//5. Добавить ф-ю проверки статуса пользователя.

package ua.kiev.prog;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {

            Service.authorization(scanner);
            //Service.rooms(scanner);
            Service.messages(scanner);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }


    }
}


//Enter your/new login:
//Bogdan
//Enter password:
//1111
//Hello Bogdan (online)
//
//Command: "@getusers" "@username" "@logout"
//
//Enter your message:
//[Wed Aug 01 21:34:01 EEST 2018, From: Bogdan, To: null] Hy
//[Wed Aug 01 21:34:09 EEST 2018, From: Bogdan, To: null] by
//[Wed Aug 01 21:34:14 EEST 2018, From: Bogdan, To: null] @logout
//[Wed Aug 01 21:35:18 EEST 2018, From: Bogdan, To: null] Hello World!
//[Wed Aug 01 21:35:42 EEST 2018, From: System Bot, To: null]
//Bogdan (online)
//
//[Wed Aug 01 21:36:04 EEST 2018, From: Bogdan, To: username] @username
//[Wed Aug 01 21:36:34 EEST 2018, From: Bogdan, To: null] @logout
//[Wed Aug 01 21:37:47 EEST 2018, From: Anatoliy, To: null] Wonderfull day
//[Wed Aug 01 21:37:50 EEST 2018, From: Anatoliy, To: null] @logout
//
//
//
//Process finished with exit code 0