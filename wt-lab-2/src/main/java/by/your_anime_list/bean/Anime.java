package by.your_anime_list.bean;

public class Anime {
    public static final int ID_STUB = -1;
    public static final float RATING_STUB = -1.0f;
    public static final String IMAGE_STUB = null;

    private int id;
    private String name;
    private String authorName;
    private float rating;
    private String imagePath;
    private int year;

    public Anime(int id, String name, String authorName, float rating, String imagePath, int year) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.rating = rating;
        this.imagePath = imagePath;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public float getRating() {
        return rating;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "name='" + name + '\'' +
                '}';
    }
}
