package DesignPatterns.Factory;

abstract public class DialogFactory {
  public static Dialog createDialog(DialogType dialogType) {

    return switch( dialogType ) {
      case CONSOLE -> new ConsoleDialog();
      case SWING   -> new SwingDialog();
      default      -> throw new RuntimeException("Unsupported type");
    };
  }
}
