package cz.homebrew;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;


public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

//    public static void main(String[] args) {
//        try (ApplicationContext context = ApplicationContext.run()) {
//            // Získání beany
//            RobotPerformer robotPerformer = context.getBean(RobotPerformer.class);
//
//            // Zavolání metody
//            String eventLink = robotPerformer.findEventLink("16.11.");
//        System.out.println("Found event link: " + eventLink);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }


//        public static void main(String[] args) {
//            try (Playwright playwright = Playwright.create()) {
//                Browser browser = playwright.chromium().launch();
//                Page page = browser.newPage();
//                page.navigate("https://example.com");
//                System.out.println(page.title());
//                browser.close();
//            }
//    }
}
