import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scraper {

    public static List<Info> ListAll () {

        try {

            Document doc = Jsoup.connect("https://ms.wikipedia.org/wiki/Malaysia").get();
            Elements table = doc.getElementsByClass("wikitable");
            Elements m = table.get(1).getElementsByClass("wikitable");
            Elements col1 = m.select("th");
            Elements col2 = m.select("td");

            List<Info> infoList= new ArrayList<>();

            for (int a = 0; a < col1.size(); a++) {

                infoList.add(new Info("" + col1.get(a).text(), "" + col2.get(a).text()));
            }

            System.out.println("extracting the data . . . . .");
            Thread.sleep(4000);

            for (Info data : infoList) {
                System.out.println(data.getCol1() + "     :       " + data.getCol2());
            }

            return infoList;

        } catch (IOException e) {
            e.printStackTrace();

        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Successfully Extracted");

        return null;
    }
}
