package userinterface;

import java.util.Scanner;

import static java.lang.System.*;

public interface InputValidator
{
    default int isInteger()
    {
        Scanner scanner = new Scanner(in);
        String choice;
        while(true)
        {
            try
            {
                choice = scanner.nextLine();

                if (choice.matches("[0-9]+"))
                    break;
                else throw new IllegalArgumentException();
            }
            catch (Exception e)
            {
                err.println("Integers only. Please try again!");
            }
        }
        return Integer.parseInt(choice);
    }

    default boolean containsSpecialCharacters(String str)
    {
        return str.matches(".*[^a-zA-Z0-9 ].*");
    }

}
