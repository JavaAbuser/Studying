package RegExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        validatePhoneNumber("+380666293160");
    }
    public static void validatePhoneNumber(String number){
        Pattern pattern = Pattern.compile("^\\+?(380)\\d{9}");
        Matcher matcher = pattern.matcher(number);
        String result = matcher.find() ? "Number format is correct" : "Number format is not correct";
        System.out.println(result);
    }
}
