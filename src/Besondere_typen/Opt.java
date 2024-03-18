package Besondere_typen;

import java.util.* ;

public class Opt
{
  public static Optional<Double> average(List<Double> list) {
    if (list == null || list.isEmpty()) {
      return Optional.empty();
    }

    Double avg = list.stream().reduce(0.0, Double::sum) / list.size();

    return Optional.of(avg);
  }

  public static void main( String[] args )
  {
    Opt opt = new Opt() ;

    List<Double> values = Arrays.asList(10.0, 20.0, 30.0, 40.0);

    Optional<Double> avg = average(values);


    // Berechnet den Durchschnitt einer Liste und gebt ihn aus
    avg.ifPresentOrElse(
        a -> System.out.println("The average is: " + a),
        () -> System.out.println("Cannot calculate the average.")
    );


    // Berechnet den Durchschnitt einer leeren Liste und gebt nichts aus
    List<Double> emptyValues = Collections.emptyList();

    Optional<Double> avgEmpty = average(emptyValues);

    avgEmpty.ifPresentOrElse(
        a -> System.out.println("The average is: " + a),
        () -> System.out.println("Cannot calculate the average for an empty list.")
    );


    // Wenn es einen Durchschnitt gibt soll er auf die Konsole geschrieben werden, ansonsten "Kein Resultat"

    // das Resultat mit map in einen String konvertieren und ausgeben. Ohne Resultat soll "Kein Resultat" ausgegeben werden.
  }
}