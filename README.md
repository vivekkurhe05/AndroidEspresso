# android-test-suite-seed
Minimal Test Suite Project Config with best defaults


Ui Automator

Ui Automator is a tool used to locate path of Android view like selenium locators

Steps for Ui Automator

1. Install Android in your system

2. open Android Studio in your system

3. Install Emulator

4. Run app on Emulator

5. Open the screen the elements of which you want to capture

6. Take screenshot of the screen

7. Open terminal

8. Redirect to path /Android/Sdk/platform-tools

9. Take a dump of screen shot with the command  ./adb shell uiautomator dump

10. Now go to /Android/Sdk/tools/bin directory

11. Open Ui Automator with the command './uiautomatorviewer &' or just './uiautomatorviewer'

12. Load screenshot by pressing 2nd upper button on the left panel

13. This will show taken screenshot and its elements

Note: You need to take every activity or fragments screenshot to get its element without looking into source code.
      You don't need to take screenshot for same screen again and agian just open the existing taken screenshot of the
      screen on emulator and take its dump as in step 9 and load the screen on Ui Automator.
