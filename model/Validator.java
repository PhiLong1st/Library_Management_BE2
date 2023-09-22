
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public boolean validEmail(String mail_String) {
        boolean check = true;
        if (mail_String.isEmpty()) {
            check = false;
        }
        if (!mail_String.contains("@")) {
            check = false;
        }
        String[] parts = mail_String.split("@");
        if (parts.length != 2) {
            check = false;
        } else {
            String username = parts[0];
            String domain = parts[1];
            if (username.isEmpty()) {
                check = false;
            }
            if (domain.isEmpty()) {
                check = false;
            }
            if (!domain.contains(".")) {
                check = false;
            }
            if (domain.endsWith(".")) {
                check = false;
            }
        }
        return check;
    }

    public boolean validPhone(String phone_String) {
        boolean check = true;
        if (phone_String.length() != 10) {
            check = false;
        } else {
            for (int i = 0; i < phone_String.length(); i++) {
                char kyTu = phone_String.charAt(i);
                if (kyTu < '0' || kyTu > '9') {
                    check = false;
                }
            }
        }
        return check;
    }

    public boolean validDate(String date_String) {
        Pattern DATE_Pattern = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
        boolean check = true;
        if (DATE_Pattern.matcher(date_String).matches()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            simpleDateFormat.setLenient(false);
            try {
                simpleDateFormat.parse(date_String);
                check = true;
            } catch (ParseException pe) {
                check = false;
            }
        } else {
            check = false;
        }
        return check;
    }

    public boolean validUserID(String UserID_String) {
        Pattern UserID_Pattern = Pattern.compile("\\p{Alpha}{2}\\d{6}");
        Matcher matcher = UserID_Pattern.matcher(UserID_String);
        return matcher.matches();
    }

    public boolean validStaffID(String StaffID_String) {
        Pattern UserID_Pattern = Pattern.compile("\\d{8}");
        Matcher matcher = UserID_Pattern.matcher(StaffID_String);
        return matcher.matches();
    }

    public boolean validISBN(String ISBN_String) {
        Pattern ISBN_Pattern = Pattern.compile("^ISBN\\d{6}$");
        Matcher matcher = ISBN_Pattern.matcher(ISBN_String);
        return matcher.matches();
    }

    public boolean validPublisherID(String PublisherID_String) {
        Pattern PublisherID_Pattern = Pattern.compile("^NXB\\d{3}$");
        Matcher matcher = PublisherID_Pattern.matcher(PublisherID_String);
        return matcher.matches();
    }
}
