import java.util.Objects;

public class Hotel implements Comparable<Hotel>
{
    private String city;
    private String name;
    private int stars;

    public Hotel(String city, String name, int stars)
    {
        this.city = city;
        this.name = name;
        this.stars = stars;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                '}';
    }

    @Override
    public int compareTo(Hotel o)
    {
        if(city.compareTo(o.city) != 0)
        {
            return city.compareTo(o.city);
        }
        else
        {
            return Integer.compare(o.stars, stars);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return stars == hotel.stars && Objects.equals(city, hotel.city) && Objects.equals(name, hotel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, name, stars);
    }


    public boolean SameCity(String b)
    {
        return city.equals(b);
    }

    public boolean SameName(String b)
    {
        return name.equals(b);
    }
}
