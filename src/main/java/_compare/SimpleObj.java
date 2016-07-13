package _compare;

public class SimpleObj implements Comparable<SimpleObj> {
    private long id;
    private String firstName;
    private String lastName;
    private float weight;
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleObj)) return false;

        SimpleObj simpleObj = (SimpleObj) o;

        if (getId() != simpleObj.getId()) return false;
        if (getAge() != simpleObj.getAge()) return false;
        if (Float.compare(getWeight(), simpleObj.getWeight()) != 0) return false;
        if (getFirstName() != null ? !getFirstName().equals(simpleObj.getFirstName()) : simpleObj.getFirstName() != null)
            return false;
        return getLastName() != null ? getLastName().equals(simpleObj.getLastName()) : simpleObj.getLastName() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + (getWeight() != +0.0f ? Float.floatToIntBits(getWeight()) : 0);
        return result;
    }

    @Override
    public int compareTo(SimpleObj o) {
        /** create constant not strictly required */
        final int LESS = -1;
        final int EQUAL = 0;
        final int MORE = 1;

        if (this == o) return EQUAL;

        /** String compare */
        int comparison = getLastName().compareTo(o.getLastName());
        if (comparison != EQUAL) return comparison;
        comparison = getFirstName().compareTo(o.getFirstName());
        if (comparison != EQUAL) return comparison;

        /** Float and Double compare  */
        comparison = Float.compare(getWeight(), o.getWeight());
        if (comparison != EQUAL) return comparison;

        /** byte, short, int, long and char compare */
        if (getAge() < o.getAge()) return LESS;
        if (getAge() > o.getAge()) return MORE;
        if (getId() < o.getId()) return LESS;
        if (getId() > o.getId()) return MORE;
        return EQUAL;

        /**
         * Note that since Java 7 static int compare method have been added to all primitive
         * object wrapper classes: Byte, Short, Integer, Long, Float, Double, Boolean, Character
         */
    }
}
