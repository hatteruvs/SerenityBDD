import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class TestSerenity
{
        String siteHomePage = "https://pn.com.ua/";
        @Steps
        StepsForSerenity stepsForSerenity;

        @Test
        public void verifySubCategory() throws InterruptedException
        {
            //GIVEN
            stepsForSerenity.a_user_visits_a_page(siteHomePage);
            //WHEN
            stepsForSerenity.the_user_adds_product_to_compare();
            //THEN
            stepsForSerenity.the_user_can_see_number_of_products("(2 модели)");
        }

}