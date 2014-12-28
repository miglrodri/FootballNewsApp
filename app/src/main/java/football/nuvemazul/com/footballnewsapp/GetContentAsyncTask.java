package football.nuvemazul.com.footballnewsapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created by mjesus on 27/12/2014.
 */
public class GetContentAsyncTask extends AsyncTask<Void, Integer, String> {

    protected Activity context;

    public GetContentAsyncTask(Activity activity) {
        //super();
        context = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("onPreExecute", "On pre Exceute......");
    }

    @Override
    protected String doInBackground(Void... params) {
        Log.d("DoINBackGround","On doInBackground...");

        getNews();

        for(int i=0; i<10; i++){
            Integer in = new Integer(i);
            publishProgress(i);
        }
        return "You are at PostExecute";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
//        Log.d("onProgressUpdate", "You are in progress update ... " + values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.d("onPostExecute",""+result);
        TextView temp = (TextView) context.findViewById(R.id.text_result);
        temp.setText("finished");
        Log.d("onPostExecute","switched button text.");
    }

    protected void getNews() {
        Document doc;
        String url = "http://m.zerozero.pt/zapping.php";
        String category = "WORLD";

        try {
            doc = Jsoup.connect(url).get();

            //String title = doc.title();
            //Log.d("getNews", "Title is: " + title);

//            Element box = doc.getElementById("box");
//            Elements elements = box.getElementsByTag("jogo");

            Elements box = doc.select("#box");
            //Log.d("getNews", elements.text());

            Elements elements = box.select(".jogo, .title.bdr");

            Log.d("getNews", "size: " + elements.size());

            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).className().equals("jogo")) {
                    Log.d("###", "jogo: " + elements.get(i).text());

                    Log.d("cenas", "hora: " + elements.get(i).getElementsByClass("hora").text());
                } else {
                    Log.d("###", elements.get(i).className() + ": " + elements.get(i).text());
                }

            }

//            while (elements.get()) {
//                Log.d("###", "###");
//            }
//
//            for (Element item : elements) {
//                Log.d("###", "###");
////                Log.d("item.toString", item.toString());
//                Log.d("item.text", item.text());
//                Log.d("item.className", item.className());
//            }

//            Elements newsHeadlines = doc.select("#cnn_maintopt1 a[href]");
//
//            // Excluir links com "/Event/" ou "/gallery/" ou "facebook.com"
//
//            int temp = 1;
//
//            for (Element news_item : newsHeadlines) {
//
//                title = news_item.text();
//                url = news_item.attr("abs:href");
//
//                if (!title.equals("")
//                        && !url.toLowerCase().contains(
//                        "/gallery/".toLowerCase())
//                        && !url.toLowerCase().contains("/Event/".toLowerCase())
//
//                        && !url.toLowerCase().contains(
//                        "facebook.com/".toLowerCase())) {
//
//                    System.out.println(temp);
//                    System.out.println("news title:  ++" + title + "++");
//                    System.out.println("news: " + url);
//
//                    // if (temp == 2) {
//                    boolean file_exists = checkFileExistance(category,
//                            convertUrlToFilename(url));
//                    if (!file_exists) {
//                        fetchNewsItem(category, url);
//                    } else {
//                        System.out
//                                .println("> skipped this news item, because file/news item already exists.");
//                    }
//
//                    // }
//                    temp++;
//
//                    System.out.println();
//
//                }
//
//                /**
//                 * Convert the recent news to XML and send them to the JMS TOPIC
//                 * TODO convert html elements to XML
//                 */
//
//                /**
//                 * Save the webpage html to file TODO convert html to file
//                 */
//
//            }


        } catch (IOException e) {
            e.printStackTrace();
            Log.d("getNews", "$$ Error fetching from: http://edition.cnn.com/" + category + "/");
        }
    }
}
