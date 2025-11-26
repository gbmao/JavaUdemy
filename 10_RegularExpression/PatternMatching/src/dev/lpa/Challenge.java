package dev.lpa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {
    public static void main(String[] args) {

        String emails = """
                john.boy@valid.com
                jane.doe-smith@valid.co.uk
                jane-Doe1976@valid.co.uk
                bob-1964@valid.net
                elaine@valid-test.com.au
                david@valid.io
                john.boy@invalid
                bob!@invalid.com
                elaineinvalid1983@.com
                david@invalid..com
                """;


        Pattern pattern = Pattern.compile("([\\w.-]+)@([\\w-]+)(\\.)(\\w+)(\\.)?(\\w)+");

        Matcher matcher = pattern.matcher(emails);

        matcher.results()
                .forEach(m ->
                        System.out.println(
                                "User: " + m.group(1) + " Email: " + m.group(0)
                        ));
    }
}
