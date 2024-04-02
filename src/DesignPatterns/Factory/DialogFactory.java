package DesignPatterns.Factory;

public class DialogFactory {

  public static Dialog createDialog(DialogType type) {
    if (type.equals(DialogType.CONSOLE)) {
      return new ConsoleDialog();
    } else if (type.equals(DialogType.WINDOWS)) {
      return new SwingDialog();
    }
    throw new IllegalArgumentException("Unbekannter Dialogtyp: " + type);
  }
}
