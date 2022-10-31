import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowTimeList {
    private static List<ShowTime> showTimeList;
    private static List<String[]> showTimeCSV;

    private static void sortAfterAppend()
	{
        int position = showTimeList.size() - 1;
        Comparable key = showTimeList.get(showTimeList.size() -1);
        while (position > 0 && key.compareTo(showTimeList.get(position-1)) < 0)
        {
            Collections.swap(showTimeList, position, position-1);
            position--;
        }
	}

    public static List<ShowTime> getShowTimeList(){
        return showTimeList;
    }

    public static List<ShowTime> getShowTimeByID(String movieID){
        List<ShowTime> returnList = new ArrayList<ShowTime>();
        System.out.println(movieID);
        for(int i = 0;i<showTimeList.size();i++){
            if(movieID.compareTo(showTimeList.get(i).getMovieID()) == 0){
                while(i < showTimeList.size() && movieID.compareTo(showTimeList.get(i).getMovieID()) == 0){
                    returnList.add(showTimeList.get(i));
                    i++;
                }
                break;
            }
        }
        return returnList;
    }

    public static void add(ShowTime showTime){
        if(showTimeList == null){
            System.out.println("The showTimeList is empty");
            showTimeList = new ArrayList<ShowTime>();
        }
        showTimeList.add(showTime);
        sortAfterAppend();
    }

    public static void load(){
        if(showTimeList == null){
            System.out.println("The reviewList is empty");
            showTimeList = new ArrayList<ShowTime>();
        }
        showTimeCSV = File_IO.readFile("showTime");
        
        for(int i = 0;i<showTimeCSV.size();i++){
            String movieID = showTimeCSV.get(i)[0];
            String startTime = showTimeCSV.get(i)[1];
            String endTime = showTimeCSV.get(i)[2];
            ClassOfCinema classOfCinema = ClassOfCinema.valueOf(showTimeCSV.get(i)[3]);
            double price = Double.parseDouble(showTimeCSV.get(i)[4]);
            ShowTime showTime = new ShowTime(movieID,
                                        LocalDateTime.parse(startTime,_DateTimeFormatter.formatter),
                                        LocalDateTime.parse(endTime,_DateTimeFormatter.formatter),
                                        classOfCinema,
                                        price);
            showTimeList.add(showTime);
        }
    }

    public static void save(){
        List<String[]> writeBackCSV = File_IO.readFile("showTime");

        for(int i =0;i<showTimeList.size();i++){
            List<String> tempTimeList = new ArrayList<String>();

            tempTimeList.add(showTimeList.get(i).getMovieID());

            LocalDateTime startTime = showTimeList.get(i).getStartTime();
            tempTimeList.add(startTime.format(_DateTimeFormatter.formatter));

            LocalDateTime endTime = showTimeList.get(i).getEndTime();
            tempTimeList.add(endTime.format(_DateTimeFormatter.formatter));

            ClassOfCinema classOfCinema = showTimeList.get(i).getClassOfCinema();
            tempTimeList.add(classOfCinema.toString());

            double price = showTimeList.get(i).getPrice();
            tempTimeList.add(String.format("%.2f",price));

            writeBackCSV.add(tempTimeList.toArray(new String[0]));
        }

        File_IO.writeFile(writeBackCSV, "showTime");
    }
}
