package DesignPatterns.Factory;

public class Main {
  public static void main(String[] args) {

    Dialog dialog = DialogFactory.createDialog(DialogType.CONSOLE);

    String input = dialog.readString("Gib deinen Namen ein: ");
    System.out.println("Dein Name ist: " + input);
  }
}
