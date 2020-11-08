import java.lang.String;

public class AccountOwner {
    String sur = "";
    String first = "";
    String last = "";
    String email = "";
    long phone = 0;
    MailingAddress mail;

    public AccountOwner(String salutation,
                        String firstName,
                        String lastName,
                        String emailAddress,
                        long phoneNumber,
                        MailingAddress mailingAddress) {
        sur = salutation;
        first = firstName;
        last = lastName;
        email = emailAddress;
        phone = phoneNumber;
        mail = mailingAddress;
    }

    public String getName(int format) {
        String temp = "";
        if (format == 2) {
            temp = sur + ". " + last;
        } else if (format == 3) {
            temp = last + ", " + first;
        } else {
            temp = first + " " + last;
        }
        return temp;
    }

    public String getFormattedPhoneNumber() {
        if (phone == 0) {
            return "N/A";
        }
        String a = String.valueOf(phone);
        String temp = "(" + a.substring(0, 3) + ")";
        temp += a.substring(3, 6) + "-";
        temp += a.substring(6);

        return temp;
    }

    public String validateSalutation(String salutation) {
        if (salutation == null || salutation.length() < 1) return null;
        return salutation;
    }

    public String validateEmailAddress(String emailAddress) {
        String[] temp = emailAddress.split("");
        if (temp.length < 7 || temp.length > 254) return null;

        if (!(emailAddress.contains("@"))) return null;
        if (!(emailAddress.contains("."))) return null;

        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals("@")) {
                if (i == 0) return null;
                if (temp[i + 1] == ".") return null;
            }
            if (temp[i].equals(".")) {
                if (i + 3 >= temp.length) return null;
            }
        }
        return emailAddress;
    }

    public long validatePhoneNumber(long phoneNumber) {
        if (String.valueOf(phoneNumber).length() != 10) return 0;
        return phoneNumber;
    }

    public String getSalutation() {
        return sur;
    }

    public void setSalutation(String salutation) {
        sur = salutation;
    }

    public String getFirstName() {
        return first;
    }

    public void setFirstName(String firstName) {
        first = firstName;
    }

    public String getLastName() {
        return last;
    }

    public void setLastName(String lastName) {
        last = lastName;
    }

    public String getEmailAddress() {
        return email;
    }

    public void setEmailAddress(String emailAddress) {
        email = emailAddress;
    }

    public long getPhoneNumber() {
        return phone;
    }

    public void setPhoneNumber(long phoneNumber) {
        phone = phoneNumber;
    }

    public MailingAddress getMailingAddress() {
        return mail;
    }

    public void setMailingAddress(MailingAddress mailingAddress) {
        mail = mailingAddress;
    }
}
