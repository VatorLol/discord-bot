public class RiotAPITokenProvider {

    public static String TOKEN;

    public static RiotAPITokenProvider instance = new RiotAPITokenProvider();

    private RiotAPITokenProvider(){

    }

    public String getTOKEN() {
        return TOKEN;
    }

    public void setTOKEN(String TOKEN) {
        RiotAPITokenProvider.TOKEN = TOKEN;
    }

    public static RiotAPITokenProvider getInstance(){
        return instance;
    }
}
