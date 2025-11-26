package dev.lpa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatGPTexerc {
    public static void main(String[] args) {

        String userData = """
                User: John Doe | Email: john.doe@example.com | Phone: +55 (11) 91234-5678
                User: Maria Silva | Email: maria.silva@empresa.com.br | Phone: (21) 4002-8922
                User: Pedro | Email: pedro123@gmail | Phone: 99876-5432
                
                """;

        Pattern matching = Pattern.compile("([\\w.-]+@[a-z]+(.com|br))+");


        Matcher matcher = matching.matcher(userData);

         matcher.results().forEach(
                m -> System.out.println(
                        m.group()
                )
        );
    }
}
