package RegExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Max Steblevskiy(JavaAbuser) on 10.01.2022
 * validation with regular expression
 */
public class Main {

    public static void main(String[] args) {
        validatePhoneNumber("+380645901236");
        validateEmailAddress("johny121@gmail.com");
        validateDate("23.05.2005");
    }
    public static void validatePhoneNumber(String number){
        Pattern pattern = Pattern.compile("^\\+?(380)\\d{9}");
        Matcher matcher = pattern.matcher(number);
        String result = matcher.find() ? "Number format is correct" : "Number format is not correct";
        System.out.println(result);
    }
    public static void validateEmailAddress(String email){
        Pattern pattern = Pattern.compile("^[a-z]+\\d*?@(gmail)\\.(com)");
        Matcher matcher = pattern.matcher(email);
        String result = matcher.find() ? "Email format is correct" : "Email format is not correct";
        System.out.println(result);
    }
   public static void validateDate(String date){
        Pattern pattern = Pattern.compile("([0-2][0-9] | [3][0-1])\\.[0-9][0-9]\\.\\d{4}");
        Matcher matcher = pattern.matcher(date);
        String result = matcher.find() ? "Date format is correct" : "Date format is not correct";
        System.out.println(result);
    }
}

