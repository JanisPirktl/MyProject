package DesignPatterns.Factory;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleDialog extends Dialog {
  private static final Scanner scanner = new Scanner(System.in);
  public String readString(String input) {
    System.out.println(input);
    return scanner.nextLine();
  }
}
