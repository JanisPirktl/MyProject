package Datenstrukturen_und_Algorithmen;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;


public class LinkedList_Iterator {

    Set<String> gemuese = new HashSet<>(List.of("Brokkoli", "Blumenkohl", "Paprika"));
    List<String> lebensmittel = new LinkedList<>(List.of("Gnocci",
            "Brokkoli",
            "Pfeffer",
            "Steak",
            "Blumenkohl",
            "Paprika"));

    public void modifyLebensmittel() {
        ListIterator<String> iterator = lebensmittel.listIterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (gemuese.contains(item)) {
                iterator.previous();
                iterator.add("Käse");
                iterator.next();
                iterator.add("Käse");
            }
        }
    }

    public static void main(String[] args) {
        LinkedList_Iterator task = new LinkedList_Iterator();
        task.modifyLebensmittel();
        System.out.println(task.lebensmittel);
    }
}
