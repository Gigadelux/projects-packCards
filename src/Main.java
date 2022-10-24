
import bustina.bustina;
import org.json.JSONArray;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;
import bustina.cartaYugi;

public class Main {
    public static void main(String[] args) {
        System.out.println("scartando la tua bustina...");
        //String strJson = getJSONFromFile("C:/Users/BoostMyTool/Desktop/example.json");
        String strJson = callURL(
                "https://raw.githubusercontent.com/overworked/yugioh-cards/master/output/cards.json"
        );

        //System.out.println(strJson);
        try {

            JSONArray serverCarte = new JSONArray(strJson);
            cartaYugi[] perBustina=new cartaYugi[5];
            for (int i=0;i<5;i++){
                Random rn = new Random();
                int m = rn.nextInt(serverCarte.length());
                String name= (String) serverCarte.getJSONObject(m).get("name");
                int atk= (int) serverCarte.getJSONObject(m).get("atk");
                int def= (int) serverCarte.getJSONObject(m).get("def");
                cartaYugi carta=new cartaYugi(name,atk,def);
                perBustina[i]=carta;
            }
            bustina bustina= new bustina(perBustina);
            System.out.println("la tua bustina:  "+bustina);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }


    public static String callURL(String myURL) {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:"+ myURL, e);
        }
        return sb.toString();
    }
}