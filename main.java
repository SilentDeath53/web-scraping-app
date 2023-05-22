import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the URL to scrape: ");
        String url = scanner.nextLine();

        try {
            Document document = Jsoup.connect(url).get();

            // Extract the desired data from the HTML using CSS selectors
            Elements titles = document.select("h2.title");
            Elements descriptions = document.select("p.description");

            for (int i = 0; i < titles.size(); i++) {
                Element title = titles.get(i);
                Element description = descriptions.get(i);
                System.out.println("Title: " + title.text());
                System.out.println("Description: " + description.text());
                System.out.println("------------------------");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while scraping the website: " + e.getMessage());
        }

        scanner.close();
    }
}
