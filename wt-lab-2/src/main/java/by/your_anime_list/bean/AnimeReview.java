package by.your_anime_list.bean;

public record AnimeReview(int id, int userId, String userLogin, int animeId, float rate, String comment) {
}
