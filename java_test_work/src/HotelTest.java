import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @org.junit.jupiter.api.Test
    void sameCity1() {
        Hotel a = new Hotel("Minsk", " ", 0);
        assertTrue(a.SameCity("Minsk"));

    }

    @org.junit.jupiter.api.Test
    void sameCity2() {
        Hotel a = new Hotel("Minsk", " ", 0);
        assertFalse(a.SameCity("Soligorsk"));

    }

    @org.junit.jupiter.api.Test
    void sameName1() {
        Hotel a = new Hotel(" ", "Mariot", 0);
        assertTrue(a.SameName("Mariot"));
    }

    @org.junit.jupiter.api.Test
    void sameName2() {
        Hotel a = new Hotel(" ", "Mariot", 0);
        assertFalse(a.SameName("Ubileana"));
    }
}