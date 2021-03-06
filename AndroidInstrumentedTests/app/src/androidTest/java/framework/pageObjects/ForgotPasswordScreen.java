package framework.pageObjects;

import android.support.test.espresso.ViewInteraction;

import com.sdxo.R;

import framework.helpers.ToastMatcher;
import framework.waits.Delay;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by vivek on 13/12/18.
 */

public class ForgotPasswordScreen {

    private ViewInteraction emailTextBox = onView(withId(R.id.inputEditText));
    private ViewInteraction button = onView(withId(R.id.actionButton));
    private ViewInteraction title = onView(withId(R.id.subTitleTextView));
    private ViewInteraction emailSentTitle = onView(withId(R.id.titleTextView));
    private ViewInteraction resetPasswordDialog = onView(withText(R.string.forgot_password_title));


    protected void clickSubmitButton(){
        button.perform(click());
    }

    protected void enterEmail(String email){
        emailTextBox.perform(clearText()).perform(typeText(email)).perform(closeSoftKeyboard());
    }


    protected boolean verifyTitle(String message){

        waitForResponse();
        title.check(matches(withText(message)));
        return true;

    }


    private void waitForResponse(){
        Delay.waitForElementUntilDisplayed(title);
    }

    protected void verifySuccessEmailSentMessage(String message){
        waitForResponse();
        emailSentTitle.check(matches(withText(message)));
    }

    protected void verifyToastMessage(String message){
        onView(withText(message)).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
    }

    public void doesResetPasswordDialogAppear(){

        resetPasswordDialog.check(matches(isDisplayed()));
    }
}

