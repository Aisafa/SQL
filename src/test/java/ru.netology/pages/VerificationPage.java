package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.AuthCode;
import ru.netology.data.DataHelper;
import ru.netology.pages.DashboardPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public DashboardPage validVerify(String verCode) {
        codeField.setValue(verCode);
        verifyButton.click();
        return new DashboardPage();
    }
}
