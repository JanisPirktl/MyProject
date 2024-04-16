package test;

import java.util.List;
import java.util.Optional;

public class Opt
{
  public Optional<Double> average(List<Double> list) {

    if (list == null || list.isEmpty()) {
      return Optional.empty();
    }

    Double avg = list.stream().reduce(0.0, Double::sum) / list.size();

    return Optional.of(avg);

    // return list.isEmpty() ? Optional.empty() : Optional.of(list.stream().reduce(0.0, Double::sum) / list.size());
  }


  public static void main( String[] args ) {

    Opt opt = new Opt() ;

    List<Double> numbers = List.of(1.0, 2.0, 3.0);

    // Berechnet den Durchschnitt einer Liste und gebt ihn aus
    Optional<Double> result = opt.average(numbers);
    result.ifPresent(System.out::println);

    // Berechnet den Durchschnitt einer leeren Liste und gebt nichts aus
    List<Double> emptyList = List.of();
    Optional<Double> emptyResult = opt.average(emptyList);
    emptyResult.ifPresent(System.out::println);

    // Wenn es einen Durchschnitt gibt soll er auf die Konsole
    // geschrieben werden, ansonsten "Kein Resultat"
    emptyResult.ifPresentOrElse(System.out::println, () -> System.out.println("Kein Resultat"));

    // das Resultat mit map in einen String konvertieren und ausgeben.
    // Ohne Resultat soll "Kein Resultat" ausgegeben werden.
    String resultString = result.map(r -> "Durchschnitt: " + r).orElse("Kein Resultat");
    System.out.println(resultString);

    String emptyResultString = emptyResult.map(r -> "Durchschnitt: " + r).orElse("Kein Resultat");
    System.out.println(emptyResultString);

  }
}
