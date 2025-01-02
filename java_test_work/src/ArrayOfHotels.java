import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class CityComparator implements Comparator<Hotel>
{
    @Override
    public int compare(Hotel o1, Hotel o2)
    {
        return o2.getCity().compareTo(o1.getCity());
    }
}

class NameComparator implements Comparator<Hotel>
{
    @Override
    public int compare(Hotel o1, Hotel o2)
    {
        return o1.getName().compareTo(o2.getName());
    }
}
public class ArrayOfHotels
{
    private ArrayList<Hotel> hotels;

    public ArrayOfHotels()
    {
        hotels = new ArrayList<>();
    }

    public void AddHotel(String city, String name, int stars)
    {
        Hotel a = new Hotel(city, name, stars);
        hotels.add(a);
    }

    public ArrayList<Hotel> ReturnHotels()
    {
        return hotels;
    }

    public ArrayList<Hotel> GetHotel()
    {
        return hotels;
    }

    public void SortingByTask()
    {
        Collections.sort(hotels);
    }

    public ArrayList<Hotel> SameCity(String b)
    {
        Hotel needed = new Hotel(b, "", 0);
        ArrayList<Hotel> a = new ArrayList<>();
        CityComparator comp = new CityComparator();
        Collections.sort(hotels, comp);
        int index = Collections.binarySearch(hotels, needed, comp);
        //System.out.println(index);
        if(index > -1)
        {
            a.add(hotels.get(index));
            int i = index + 1;
            while(i < hotels.size())
            {
                if(hotels.get(i).getCity().equals(needed.getCity()))
                {
                    a.add(hotels.get(i));
                    i++;
                }
                else break;
            }
        }
        return a;
    }


    public ArrayList<Hotel> SameName(String b)
    {
        Hotel needed = new Hotel("", b, 0);
        ArrayList<Hotel> a = new ArrayList<>();
        NameComparator comp = new NameComparator();
        Collections.sort(hotels, comp);
        int index = Collections.binarySearch(hotels, needed, comp);
        //System.out.println(index);
        if(index > -1)
        {
            a.add(hotels.get(index));
            int i = index + 1;
            while(i < hotels.size())
            {
                if(hotels.get(i).getName().equals(needed.getName()))
                {
                    a.add(hotels.get(i));
                    i++;
                }
                else break;
            }
        }
        return a;
    }
}
