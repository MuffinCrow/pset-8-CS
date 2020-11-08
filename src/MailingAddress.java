import java.lang.String;

public class MailingAddress {
    String pstreet = "";
    String sstreet = "";
    String city = "";
    String state = "";
    String code = "";
    public MailingAddress(String primaryStreet,
                          String secondaryStreet,
                          String city,
                          String state,
                          String postalCode) {
        pstreet = primaryStreet;
        sstreet = secondaryStreet;
        this.city = city;
        this.state = state;
        code = postalCode;
    }

    public String getFormattedAddress() {
        if (check() == false) {
            return "N/A";
        }
        String output = pstreet + " " + sstreet + " " + city + ", " + state + " " + code;
        return output;
    }

    private boolean check() {
        if (validateStreet(pstreet) == null) return false;
        if (validateCity(city) == null) return false;
        if (validateState(state) == null) return false;
        if (validatePostalCode(code) == null) return false;
        return true;
    }

    public String validateStreet(String street) {
        if (street == null) return null;

        String[] temp = street.split(" ");
        int num = Integer.parseInt(temp[0]);

        if (num < 1) return null;

        return street;
    }

    public String validateCity(String city) {
        if (city == null) return null;
        if (city.length() < 1) return null;
        return city;
    }

    public String validateState(String state) {
        if (stateCheck(state) == false) {
            return null;
        }
        if (state.length() != 2) abbreviate();
        return this.state;
    }

    public String validatePostalCode(String postalCode) {
        if (postalCode.length() != 5) return null;
        return postalCode;
    }

    public String getPrimaryStreet() {
        return pstreet;
    }

    public void setPrimaryStreet(String primaryStreet) {
        pstreet = primaryStreet;
    }

    public String getSecondaryStreet() {
        return sstreet;
    }

    public void setSecondaryStreet(String secondaryStreet) {
        sstreet = secondaryStreet;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public String getPostalCode() {
        return code;
    }

    public void setPostalCode(String postalCode) {
        code = postalCode;
    }

    private boolean stateCheck(String state) {
        state = state.toLowerCase();
        switch (state) {
            case "alabama":
            case "alaska":
            case "arizona":
            case "arkansas":
            case "california":
            case "colorado":
            case "connecticut":
            case "delaware":
            case "florida":
            case "georgia":
            case "hawaii":
            case "idaho":
            case "illinois":
            case "indiana":
            case "iowa":
            case "kansas":
            case "kentucky":
            case "louisiana":
            case "maine":
            case "maryland":
            case "massachusetts":
            case "michigan":
            case "minnesota":
            case "mississippi":
            case "missouri":
            case "montana":
            case "nebraska":
            case "nevada":
            case "new hampshire":
            case "new jersey":
            case "new mexico":
            case "new york":
            case "north carolina":
            case "north dakota":
            case "ohio":
            case "oklahoma":
            case "oregon":
            case "pennsylvania":
            case "rhode island":
            case "south carolina":
            case "south dakota":
            case "tennessee":
            case "texas":
            case "utah":
            case "vermont":
            case "virginia":
            case "washington":
            case "west virginia":
            case "wisconsin":
            case "wyoming":
            case "al":
            case "ak":
            case "az":
            case "ar":
            case "ca":
            case "co":
            case "ct":
            case "de":
            case "fl":
            case "ga":
            case "hi":
            case "id":
            case "il":
            case "in":
            case "ia":
            case "ks":
            case "ky":
            case "la":
            case "me":
            case "md":
            case "ma":
            case "mi":
            case "mn":
            case "ms":
            case "mo":
            case "mt":
            case "ne":
            case "nv":
            case "nh":
            case "nj":
            case "nm":
            case "ny":
            case "nc":
            case "nd":
            case "oh":
            case "ok":
            case "or":
            case "pa":
            case "ri":
            case "sc":
            case "sd":
            case "tn":
            case "tx":
            case "ut":
            case "vt":
            case "va":
            case "wa":
            case "wv":
            case "wi":
            case "wy":
                return true;
            default:
                return false;
        }
    }

    private void abbreviate() {
        this.state = this.state.toLowerCase();
        switch (this.state) {
            case "alabama":
                this.state = "AL";
                break;
            case "alaska":
                this.state = "AK";
                break;
            case "arizona":
                this.state = "AZ";
                break;
            case "arkansas":
                this.state = "AR";
                break;
            case "california":
                this.state = "CA";
                break;
            case "colorado":
                this.state = "CO";
                break;
            case "connecticut":
                this.state = "CT";
                break;
            case "delaware":
                this.state = "DE";
                break;
            case "florida":
                this.state = "FL";
                break;
            case "georgia":
                this.state = "GA";
                break;
            case "hawaii":
                this.state = "HI";
                break;
            case "idaho":
                this.state = "ID";
                break;
            case "illinois":
                this.state = "IL";
                break;
            case "indiana":this.state = "IN";
                break;
            case "iowa":
                this.state = "IA";
                break;
            case "kansas":
                this.state = "KS";
                break;
            case "kentucky":
                this.state = "KY";
                break;
            case "louisiana":
                this.state = "LA";
                break;
            case "maine":
                this.state = "ME";
                break;
            case "maryland":
                this.state = "MD";
                break;
            case "massachusetts":
                this.state = "MA";
                break;
            case "michigan":
                this.state = "MI";
                break;
            case "minnesota":
                this.state = "MN";
                break;
            case "mississippi":
                this.state = "MS";
                break;
            case "missouri":
                this.state = "MO";
                break;
            case "montana":
                this.state = "MT";
                break;
            case "nebraska":
                this.state = "NE";
                break;
            case "nevada":
                this.state = "NV";
                break;
            case "new hampshire":
                this.state = "NH";
                break;
            case "new jersey":
                this.state = "NJ";
                break;
            case "new mexico":
                this.state = "NM";
                break;
            case "new york":
                this.state = "NY";
                break;
            case "north carolina":
                this.state = "NC";
                break;
            case "north dakota":
                this.state = "ND";
                break;
            case "ohio":
                this.state = "OH";
                break;
            case "oklahoma":
                this.state = "OK";
                break;
            case "oregon":
                this.state = "OR";
                break;
            case "pennsylvania":
                this.state = "PA";
                break;
            case "rhode island":
                this.state = "RI";
                break;
            case "south carolina":
                this.state = "SC";
                break;
            case "south dakota":
                this.state = "SD";
                break;
            case "tennessee":
                this.state = "TN";
                break;
            case "texas":
                this.state = "TX";
                break;
            case "utah":
                this.state = "UT";
                break;
            case "vermont":
                this.state = "VT";
                break;
            case "virginia":
                this.state = "VA";
                break;
            case "washington":
                this.state = "WA";
                break;
            case "west virginia":
                this.state = "WV";
                break;
            case "wisconsin":
                this.state = "WI";
                break;
            case "wyoming":
                this.state = "WY";
                break;
        }
    }
}
