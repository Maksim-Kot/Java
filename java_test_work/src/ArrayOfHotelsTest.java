import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MainComparator implements Comparator<Hotel>
{
    @Override
    public int compare(Hotel o1, Hotel o2)
    {
        if(o1.getCity().compareTo(o2.getCity()) != 0)
        {
            return o1.getCity().compareTo(o2.getCity());
        }
        else
        {
            if(o1.getName().compareTo(o2.getName()) != 0)
            {
                return o1.getName().compareTo(o2.getName());
            }
            else 
            {
                return Integer.compare(o1.getStars(), o2.getStars());
            }
        }
    }
}

class ArrayOfHotelsTest {

    @Test
    void sortingByTask() throws IOException{
        ArrayOfHotels a = new ArrayOfHotels();
        a.AddHotel("Minsk","Ubileana", 3);
        a.AddHotel("Minsk", "Mariot", 4);
        a.AddHotel("Soligorsk", "Amal", 3);
        a.AddHotel("Orsha", "Zule", 2);
        a.AddHotel("Soligorsk", "Zule", 2);
        a.SortingByTask();
        ArrayList<Hotel> k = a.ReturnHotels();
        ArrayList<Hotel> test = new ArrayList<>();
        Hotel b = new Hotel("Minsk", "Mariot", 4);
        test.add(b);
        b = new Hotel("Minsk","Ubileana", 3);
        test.add(b);
        b = new Hotel("Orsha", "Zule", 2);
        test.add(b);
        b = new Hotel("Soligorsk", "Amal", 3);
        test.add(b);
        b = new Hotel("Soligorsk", "Zule", 2);
        test.add(b);
        Collections.sort(test);
        assertArrayEquals(test, k);
    }

    @Test
    void sameCity1() throws IOException {
        ArrayOfHotels a = new ArrayOfHotels();
        a.AddHotel("Minsk", "", 1);
        a.AddHotel("Orsha", "", 0);
        a.AddHotel("Minsk", "", 2);
        a.AddHotel("Soligorsk", "", 0);
        ArrayList<Hotel> k = a.SameCity("Minsk");
        ArrayList<Hotel> test = new ArrayList<>();
        Hotel b = new Hotel("Minsk", "", 2);
        test.add(b);
        b = new Hotel("Minsk", "", 1);
        test.add(b);
        Collections.sort(k);
        Collections.sort(test);
        assertArrayEquals(test, k);
    }

    @Test
    void sameCity2() throws IOException {
        ArrayOfHotels a = new ArrayOfHotels();
        a.AddHotel("Minsk", "", 1);
        a.AddHotel("Orsha", "", 0);
        a.AddHotel("Minsk", "", 2);
        a.AddHotel("Soligorsk", "", 0);
        ArrayList<Hotel> k = a.SameCity("Orsha");
        ArrayList<Hotel> test = new ArrayList<>();
        Hotel b = new Hotel("Orsha", "", 0);
        test.add(b);
        Collections.sort(k);
        Collections.sort(test);
        assertArrayEquals(test, k);
    }

    @Test
    void sameCity3() throws IOException {
        ArrayOfHotels a = new ArrayOfHotels();
        a.AddHotel("Minsk", "", 1);
        a.AddHotel("Orsha", "", 0);
        a.AddHotel("Minsk", "", 2);
        a.AddHotel("Soligorsk", "", 0);
        ArrayList<Hotel> k = a.SameCity("Test");
        ArrayList<Hotel> test = new ArrayList<>();
        Collections.sort(k);
        Collections.sort(test);
        assertArrayEquals(test, k);
    }

    private void assertArrayEquals(ArrayList<Hotel> test, ArrayList<Hotel> k) throws IOException{
        if(test.size() != k.size()) throw new IOException();
        if(!test.equals(k)) throw new IOException();
    }

    @Test
    void sameName1() throws IOException{
        ArrayOfHotels a = new ArrayOfHotels();
        a.AddHotel("", "Tag", 1);
        a.AddHotel("", "Zule", 1);
        a.AddHotel("", "Hygo", 2);
        a.AddHotel("", "Zule", 6);
        ArrayList<Hotel> k = a.SameName("Zule");
        ArrayList<Hotel> test = new ArrayList<>();
        Hotel b = new Hotel("", "Zule", 6);
        test.add(b);
        b = new Hotel("", "Zule", 1);
        test.add(b);
        Collections.sort(k);
        Collections.sort(test);
        assertArrayEquals(test, k);
    }

    @Test
    void sameName2() throws IOException{
        ArrayOfHotels a = new ArrayOfHotels();
        a.AddHotel("", "Tag", 1);
        a.AddHotel("", "Zule", 1);
        a.AddHotel("", "Hygo", 2);
        a.AddHotel("", "Zule", 6);
        ArrayList<Hotel> k = a.SameName("Hygo");
        ArrayList<Hotel> test = new ArrayList<>();
        Hotel b = new Hotel("", "Hygo", 2);
        test.add(b);
        Collections.sort(k);
        Collections.sort(test);
        assertArrayEquals(test, k);
    }

    @Test
    void sameName3() throws IOException{
        ArrayOfHotels a = new ArrayOfHotels();
        a.AddHotel("", "Tag", 1);
        a.AddHotel("", "Zule", 1);
        a.AddHotel("", "Hygo", 2);
        a.AddHotel("", "Zule", 6);
        ArrayList<Hotel> k = a.SameName("Test");
        ArrayList<Hotel> test = new ArrayList<>();
        Collections.sort(k);
        Collections.sort(test);
        assertArrayEquals(test, k);
    }
}