public class VideoGame {
    private String id;
    private String Category;
    private String name;
    private String releaseDate;
    private String rating;
    private String reviewscore;

    public VideoGame(String id, String Category, String releaseDate, String rating, String reviewscore, String name){
        this.id = id;
        this.Category = Category;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.reviewscore = reviewscore;
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getCategory ()
    {
        return Category;
    }

    public void setCategory (String category)
    {
        this.Category = category;
    }

    public String getReleaseDate ()
    {
        return releaseDate;
    }

    public void setReleaseDate (String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    public String getReviewScore ()
    {
        return reviewscore;
    }

    public void setReviewScore (String reviewScore)
    {
        this.reviewscore = reviewScore;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", category = "+Category+", releaseDate = "+releaseDate+", name = "+name+", rating = "+rating+", reviewScore = "+reviewscore+"]";
    }

}
