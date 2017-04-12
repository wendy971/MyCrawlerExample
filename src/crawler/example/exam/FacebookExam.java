package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.8"
				+ "/s3beauty/feed?fields=id,link,message,created_time,likes.limit(0).summary(total_count),reactions.limit(0).summary(total_count)"
				+ "&access_token=228215314323382%7Cuf2dRNRFmZ-DfG5_Ui9vyJ-TKY8";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,連結,內容,創建時間,按讚數,總情緒數\n";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			String link = data.select("link").text();
			String message = data.select("message").text();
			String created_time = data.select("created_time").text();
			String likes = data.select("likes").text();
			String reactions = data.select("reactions").text();

			output += id+",\""+link+"\","+message+","+created_time+","+likes+","+reactions+"\n";
		}

		System.out.println( output );
	}
}
