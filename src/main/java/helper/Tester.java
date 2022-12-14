package src.main.java.helper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import src.main.java.ui.*;
import src.main.java.movie.*;
import src.main.java.payment.PromoCode;
import src.main.java.payment.PromoCodeList;
import src.main.java.enums.*;

public class Tester {
    public static void PaymentUITest(String[] args) {
        PromoCodeList.load();
        
        Payment_UI.display_UI("Guest", null);
    }
    public static void TestPromoRead(String[] args) {
        PromoCodeList.load();
        for(int j = 0;j < PromoCodeList.getPromoCodeList().size();j++){
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getPromoCode());
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getOffer());
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getStartTime());
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getEndTime());
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getPromoCodeStatus());
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getCount());
        }
    }
    public static void TestPromoWrite(String[] args) {
        
        while(true){
            
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter DiscountCode");
            String code = sc.nextLine();
            if(code.charAt(0) == '#'){
                break;
            }

            System.out.println("Enter offer");
            double offer = sc.nextDouble();

            sc.nextLine();
            System.out.println("Enter startTime");
            LocalDateTime startTime = ExceptionHandling.checkDateTime();
            
            System.out.println("Enter endTime");
            LocalDateTime endTime = ExceptionHandling.checkDateTime();

            System.out.println("Enter count");
            int count = sc.nextInt();

            sc.nextLine();
            System.out.println("Enter status");
            PromoCodeStatus status = PromoCodeStatus.valueOf(sc.nextLine());

            PromoCodeList.add(new PromoCode(code,
                                            offer,
                                            count,
                                            startTime,
                                            endTime,
                                            status));
        }
        for(int j = 0;j < PromoCodeList.getPromoCodeList().size();j++){
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getPromoCode());
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getOffer());
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getStartTime());
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getEndTime());
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getPromoCodeStatus());
            System.out.println(PromoCodeList.getPromoCodeList().get(j).getCount());
        }
        PromoCodeList.save();
    }
    public static void movielistRefreshTest(String[] args) {//refreshFunctionTest
        Main_UI.loadAllClass();
        ShowTimeController.refresh();
        List<Movie> movieList = MovieListing.getMovieList();
        for(int i =0;i<movieList.size();i++){
            System.out.println(movieList.get(i).getMovieID());
            System.out.println(movieList.get(i).getMovieTitle());
            System.out.println(movieList.get(i).getShowingStatus());
        }
    }

    public static void SalesManagerRead(String[] args) {
        SalesManager.load();
        for(int i =0;i<SalesManager.getSalesList().size();i++){
            System.out.println(SalesManager.getSalesList().get(i).getMovieID());
            System.out.println(SalesManager.getSalesList().get(i).getTotalSales());
        }
    }
    public static void SalesManagerWrite(String[] args) {
        while(true){
            System.out.println("Enter movieID");
            Scanner sc = new Scanner(System.in);   
            String movieID = sc.nextLine();
            if(movieID.charAt(0) == '#'){
                break;
            }
            SalesManager.addSalesByID(movieID);
        }
        SalesManager.save();
    }
    public static void PaymentUItest(String[] args) {
        //Payment_UI.display_UI();    
    }

    public static void RefreshTesting(String[] args) {
        ShowTimeList.load();
        MovieListing.load();
        ShowTimeController.refresh();

    }
    public static void ShowTimeReadTestByID(String[] args) {
        ShowTimeList.load();
        List<ShowTime> timeList = ShowTimeList.getShowTimeByID("S0001");
        for(int j = 0;j < timeList.size();j++){
            System.out.println(timeList.get(j).getMovieID());
            System.out.println(timeList.get(j).getCinemaID());
            System.out.println(timeList.get(j).getStartTime());
            System.out.println(timeList.get(j).getEndTime());
            System.out.println(timeList.get(j).getClassOfCinema());
        }
    }
    
    public static void ShowTimeReadTest(String[] args) {
        ShowTimeList.load();
        for(int j = 0;j < ShowTimeList.getShowTimeList().size();j++){
            System.out.println(ShowTimeList.getShowTimeList().get(j).getMovieID());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getStartTime());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getEndTime());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getClassOfCinema());
        }
    }
    public static void ShowTimeWriteTest(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter MovieID");
            String movieID = sc.nextLine();
            if(movieID.charAt(0) == '#'){
                break;
            }

            System.out.println("Enter cinemaID");
            String cinemaID = sc.nextLine();

            System.out.println("Enter startTime");
            String startTime = sc.nextLine();
            
            System.out.println("Enter endTime");
            String endTime = sc.nextLine();

            System.out.println("Enter classOfCinema");
            ClassOfCinema classOfCinema = ClassOfCinema.valueOf(sc.nextLine());

            ShowTimeList.add(new ShowTime(movieID, cinemaID,startTime, endTime, classOfCinema));
        }
        for(int j = 0;j < ShowTimeList.getShowTimeList().size();j++){
            System.out.println(ShowTimeList.getShowTimeList().get(j).getMovieID());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getCinemaID());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getStartTime());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getEndTime());
            System.out.println(ShowTimeList.getShowTimeList().get(j).getClassOfCinema());
        }
        ShowTimeList.save();
    }

    public static void RatingReviewReadTest(String[] args) {
        ReviewList.load();
        for(int j = 0;j < ReviewList.getReview().size();j++){
            System.out.println(ReviewList.getReview().get(j).getMovieID());
            System.out.println(ReviewList.getReview().get(j).getRating());
            System.out.println(ReviewList.getReview().get(j).getReview());
        }
    }
    public static void RatingReviewWriteTest(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter MovieID");
            String movieID = sc.nextLine();
            if(movieID.charAt(0) == '#'){
                break;
            }

            System.out.println("Enter review");
            String review = sc.nextLine();
            
            System.out.println("Enter rating");
            int rating = sc.nextInt();

            ReviewList.addRatingReview(movieID,review,rating);
        }
        for(int j = 0;j < ReviewList.getReview().size();j++){
            System.out.println(ReviewList.getReview().get(j).getMovieID());
            System.out.println(ReviewList.getReview().get(j).getRating());
            System.out.println(ReviewList.getReview().get(j).getReview());
        }
        ReviewList.save();
    }
    public static void testCaseForReadMovie(String[] args) throws Exception {
        MovieListing.load();
        List<Movie> movieList = MovieListing.getMovieList();
        for(int i =0;i<movieList.size();i++){
            System.out.println(movieList.get(i).getMovieTitle());
            System.out.println(movieList.get(i).getShowingStatus());
            System.out.println(movieList.get(i).getSynopsis());
            System.out.println(movieList.get(i).getType());
            System.out.println(movieList.get(i).getDirector());
            System.out.println(movieList.get(i).getCast());
            System.out.println(movieList.get(i).getRestriction());
            System.out.println(movieList.get(i).getMovieID());
        }
    }
    public static void testCaseForWriteMovie(String[] args) {
        while(true){
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Title");
            String movieTitle = sc.nextLine();
            if(movieTitle.charAt(0) == '#'){
                break;
            }

            System.out.println("Enter Sypnosis");
            String sypnosis = sc.nextLine();
            
            System.out.println("Enter type");
            String type = sc.nextLine();

            System.out.println("Enter director");
            String director = sc.nextLine();

            System.out.println("Enter cast (seperate by comma -> ',' )");
            String cast = sc.nextLine();

            System.out.println("Enter restriction");
            Restriction restriction = ExceptionHandling.checkRestriction();
            
            System.out.println("Enter movieID");
            String movieID = sc.nextLine();

            MovieListing.add(new Movie(movieTitle, sypnosis, type, director, cast, restriction, movieID));
        }
        MovieListing.save();
    }
}