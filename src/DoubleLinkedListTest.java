import java.util.*;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<Album> list = new DoubleLinkedList<>();

        Album a1 = new Album(1, List.of("Artist1"), "Album1", 10);
        Album a2 = new Album(2, List.of("Artist2"), "Album2", 5);
        Album a3 = new Album(3, List.of("Artist3"), "Album3", 8);

        // Test append
        list.append(a1);
        list.append(a2);
        assert list.toString().contains("Artist2");

        // Test insert
        list.insert(1, a3);
        assert list.getIndex(a3) == 1;

        // Test delete
        list.delete(1);
        assert list.getIndex(a3) == -1;

        // Test getIndex
        assert list.getIndex(a1) == 0;
        assert list.getIndex(new Album(99, List.of("None"), "None", 0)) == -1;
    }
}
