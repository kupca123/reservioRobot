package cz.homebrew.service;

import com.microsoft.playwright.*;
import jakarta.inject.Singleton;

@Singleton
public class RobotPerformer {

    public String findEventLink(String hledaneDatum) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            Page page = browser.newPage();
            page.navigate("https://cviceni-stepanovice.reservio.com/events");

            // Počkej na načtení událostí
            page.waitForSelector("a[href*='/events/']");

            // Získání všech odkazů na události
            for (ElementHandle link : page.querySelectorAll("a[href*='/events/']")) {
                String text = link.innerText();
                if (text.contains("16.11.")) {
                    String href = link.getAttribute("href");
                    return href;
                }
            }

            browser.close();
        }
        return "Nothing found";
    }

    public void performBooking() {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Otevři stránku
            page.navigate("https://cviceni-stepanovice.reservio.com/events/320368f3-d8c3-4ee4-b746-ce54b065ed68");

            // Klikni na tlačítko "Rezervovat"
            page.locator("button:has-text(\"Rezervovat\")").click();

            // Počkej na načtení nové stránky (např. podle URL nebo elementu)
            page.waitForURL("https://cviceni-stepanovice.reservio.com/order?what=event"); // uprav podle skutečné URL po kliknutí


            page.locator("button[data-test='btn-order-flow-continue']").nth(1).click();

            page.waitForURL("https://cviceni-stepanovice.reservio.com/order?what=checkout"); // uprav podle skutečné URL po kliknutí


            // Získej HTML celé stránky
            String htmlContent = page.content();

            // Nebo získej konkrétní text z elementu (např. nadpis)
            String headingText = page.locator("h1").innerText();

            System.out.println("HTML nové stránky:");
            System.out.println(htmlContent);

            System.out.println("Nadpis nové stránky:");
            System.out.println(headingText);
        }

    }


}
