package com.example.vivek.espressotest;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.sdxo.R;
import com.sdxo.ui.activity.login.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import framework.pageObjects.LoginScreen;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertTrue;

/**
 * Created by vivek on 27/12/18.
 */

@RunWith(Parameterized.class)
public class LoginAttemptsParameterized extends LoginScreen {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityRule = new ActivityTestRule<>(LoginActivity.class);


    private String email;
    private String pwd;
    private String expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){

        return Arrays.asList(new Object[][] {
                {"vvekkurhe555.com", "vjvsdjf", "Please enter valid email"},
                {"Vvekkurhe555@gmail.com", "werwerfw", "Email or Password doesn't match. Please try again."},
                {"vvekkurhe555.com", "Vivek123@", "Please enter valid email"},
                {"Vvekkurhe555@gmail.com", "", "Please enter password"},
                {"vvekkurhe555.com", "", "Please enter valid email"},
                {"", "Vivek123@", "Please enter valid email"},
                {"", "vjvsdjf", "Please enter valid email"}
        });
    }

    public LoginAttemptsParameterized(String email, String pwd, String expectedResult){
        this.email = email;
        this.pwd = pwd;
        this.expectedResult = expectedResult;

    }

    @Test
    public void verifyLogin() throws Exception{

        enterEmail(email);
        enterPassword(pwd);
        clickLoginButton();
        boolean result = verifyErrorMessage(expectedResult);
        assertTrue(result);
    }

    public boolean verifyErrorMessage(String expectedResult) throws Exception{

        if(expectedResult.equals(InstrumentationRegistry.getTargetContext().getString(R.string.email_validation_message))){
            return true;
        }
        if(expectedResult.equals(InstrumentationRegistry.getTargetContext().getString(R.string.password_validation_message))){
            return true;

//            This return string type of object. we can use this statement to read string on view
//            String str = InstrumentationRegistry.getTargetContext().getString(R.string.email_validation_message);
        }
        if(expectedResult.startsWith("Email or Password")){
            waitForResponse();
            onView(withId(R.id.subTitleTextView)).check(matches(withText(expectedResult)));
            return true;
        }
        else {
            return false;
        }
    }
}
