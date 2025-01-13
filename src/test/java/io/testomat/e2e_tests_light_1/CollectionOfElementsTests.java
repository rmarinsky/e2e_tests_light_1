package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class CollectionOfElementsTests extends BaseTest {

    @Test
    @DisplayName("find all product experiments")
    void findAllProductExperiments() {
        var labelCountOfTests = $$("ul li p")
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        for (SelenideElement labelCountOfTest : labelCountOfTests) {
            labelCountOfTest.shouldHave(Condition.text("14 tests").or(Condition.text("0 tests")));
        }

        $$(Selectors.byText("14 tests")).shouldHave(CollectionCondition.size(1));
        $$(Selectors.byText("0 tests")).shouldHave(CollectionCondition.size(68));

        labelCountOfTests.filter(Condition.text("14 tests")).shouldHave(CollectionCondition.size(1));
        labelCountOfTests.filter(Condition.text("0 tests")).shouldHave(CollectionCondition.size(68));
    }

    @Test
    @DisplayName("clipboard")
    void clipboard() {
        Selenide.clipboard().setText("olo");
        Selenide.clipboard().shouldHave(ClipboardConditions.content("olo"));

        Selenide.localStorage().shouldHave(LocalStorageConditions.itemWithValue("name", "terget name"));
    }

    public static void main(String[] args) {
        List<String> olo1 = Arrays.asList("Olo1", "Olo2", "Olo3");
        System.out.println("olo1 = " + olo1);
        olo1.forEach(System.out::println);

        Integer[] sdfkjdf = {1, 12, 34, 45, 5};

        System.out.println("sdfkjdf = " + sdfkjdf.toString());
        System.out.println("sdfkjdf = " + Arrays.toString(sdfkjdf));

        for (int i = 0; i < olo1.size(); i++) {
            System.out.println("sdfkjdf[i] = " + sdfkjdf[i]);
        }

        for (int i : sdfkjdf) {
            System.out.println("sdfkjdf[i] = " + i);
        }



        String[] olo = {"Olo1", "Olo2", "Olo3"};

        System.out.println("olo = " + olo);

        for (String olitem : olo) {
            System.out.println("olitem = " + olitem);
        }

        System.out.println("olo to string = " + Arrays.toString(olo));

    }

}
