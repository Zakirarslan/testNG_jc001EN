package myapp.tests.medunna_practice;


public class Day28_US003 {

    /*
        User Story: Book an Appointment
    As a user, I want to book an appointment by providing the required information, so that I can schedule a consultation with a doctor at my convenience.

    Acceptance Criteria:
    AC1: The user must be presented with fields to fill in their First Name, Last Name, SSN,
        Email, Phone number, and Appointment DateTime.
    AC2: All required fields (First Name, Last Name, SSN, Email, Phone,
        and Appointment DateTime) must be marked as mandatory.
        If any of these fields are empty upon submission,
        the system should display appropriate error messages.
    AC3: The SSN field must accept only a valid format (e.g., 000-00-0000).
        If the SSN is not provided or is invalid, an error message ("Your SSN is invalid")
            should be shown
    AC4: The Email field must validate that the input follows a proper email format (e.g., example@domain.com). If the email is missing or invalid, an error message should be displayed.
    AC5: The Phone number field must accept a valid phone number format (e.g., 000-000-0000).
        If the number is incorrect or incomplete, the system should display an error message and block the submission.
    AC6: The Appointment DateTime must allow the user to choose only future dates.
    Past dates should be disabled or unavailable for selection. If a past date is manually entered, an error message should be displayed.
    */

    /*
    Test Case ID: TC1_US3_AC5 (POSITIVE TEST CASE)
    Title: verify phone no. field accepts a valid phone number in the format 000-000-0000
    Objective: to ensure that user can add valid phone number successfully
    Pre-condition:
        1- user should be in the Book an appointment page
        2- other fields must be field with valid credentials
    Test Data: phone number (123-164-9331)
    Environment: Chrome
    Steps:
        1- Open the Browser and navigate to the Medunna website
        2- Navigate to the “Make an appointment” section on the website
        3- In the phone number input field, enter the phone number 123-164-9331
        4- Click on submit button
        5- Verify user make an appointment successfully
    Expected Result:
    No validation error or warning text is displayed below the phone number field
    The phone no. is accepted allowing the user to proceed with booking an appointment
    Test Priority: High
     */

    /*
       Test02: Verify that the user can successfully book an appointment valid details (POSITIVE TEST CASE)
       Pre-condition: user should be in the homepage
       Test Data: first name=john, Last name =Johny, SSN: 123-12-1234, E-mail=johnJohny@gmail.com, Phone number= 123-123-1234, use date 12/10/2024
       Test Steps:
        1- navigate to given url https://medunna.com/
        2- verify appointment button is working
        3- click the appointment button and verify you are in the correct area
        4- verify all fields are clickable
        5- Filed the form with given info
        6- Click the appointment button and verify appointment accepted
    */

    /*
    Test Case 03: Test Email Field with Empty, Invalid Data (NEGATIVE TEST CASE)
        Test Data:
            invalid data1= jon@gmailcom
            invalid data2= jon@gmailcom
        Steps:
        1- Navigate to the Make an Appointment  : https://medunna.com/#appointment
        2- Leave the email field empty.
        3- Verify error message is "Your email is required."
        4- Enter given invalid email formats.
        5- Verify error message is "This field is invalid"
     */



}
