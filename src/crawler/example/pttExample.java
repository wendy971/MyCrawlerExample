package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;

/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class pttExample {
	// commit test
	// wendy test1
	public static void main(String[] args) {

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑
		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1491703516.A.E4F.html";

		System.out.println(
				CrawlerPack.start()
				
				// 參數設定
			    .addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼
				
				// 選擇資料格式 (三選一)
				//.getFromJson(uri)
			    .getFromHtml(uri)
			    //.getFromXml(uri)
			    
			    // 這兒開始是 Jsoup Document 物件操作
						.select("div.push>span.hl.push-tag , div.push>span.f3.push-content")

		);
	}
}
/*<div class="push">
<span class="hl push-tag">推 </span>
<span class="f3 hl push-userid">gginin007</span>
<span class="f3 push-content">: 不要扶他</span>
<span class="push-ipdatetime"> 04/09 10:18 </span>
</div>*/