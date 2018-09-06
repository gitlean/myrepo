package com.isoft.crawler;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpVisitor {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String requestUrl = null;
		String dataHtml = null;

		requestUrl = "https://free-ss.site/ss.php";

		dataHtml = getHtmlbyGet(requestUrl);

		System.out.println(dataHtml);

	}

	public static String getHtmlbyGet(String requestUrl) {
		String dataHtml = null;
		CloseableHttpClient httpclient = null;
		try {

			httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(requestUrl);
			httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			httpGet.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0");
			HttpResponse httpResponse = httpclient.execute(httpGet);

			System.out.println("状态码：" + httpResponse.getStatusLine().getStatusCode());

			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				dataHtml = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
			}

		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			if (null != httpclient) {
				try {
					httpclient.close();
				} catch (Exception e) {

				}
			}

		}
		return dataHtml;
	}

	public static String getHtmlbyPost(String requestUrl) {
		String dataHtml = null;
		CloseableHttpClient httpclient = null;
		try {
			httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(requestUrl);
			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
			httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("touser", "@all"));
			formparams.add(new BasicNameValuePair("toparty", "@all"));

			UrlEncodedFormEntity uefEntity;
			uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
			httpPost.setEntity(uefEntity);

			HttpResponse httpResponse = httpclient.execute(httpPost);
			System.out.println("状态码：" + httpResponse.getStatusLine().getStatusCode());
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				dataHtml = EntityUtils.toString(httpResponse.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != httpclient) {
				try {
					httpclient.close();
				} catch (Exception e) {

				}
			}

		}
		return dataHtml;
	}

	// 使用HttpClient只传字符串，不以k-v形式传
	public static String getHtmlbyPurePost(String requestUrl) {
		String dataHtml = null;
		CloseableHttpClient httpclient = null;
		try {
			httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(requestUrl);
			httpPost.setHeader("Content-type", "application/xml"); // 发送的MSG
																	// TYPE
			httpPost.setHeader("Accept", "application/json");

			httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

			String tRequestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><USER><AGE>27</AGE><NAME>SAM-SHO</NAME><PhoneList><UserPhone><num>13612345678</num><type>移动</type></UserPhone><UserPhone><num>13798765432</num><type>联通</type></UserPhone></PhoneList><UserAddress><homeAddress>苏州高新区</homeAddress><workAddress>苏州园区</workAddress></UserAddress></USER>";

			// String postParam="";
			// System.out.println(tRequestXml);

			StringEntity s = new StringEntity(tRequestXml);
			s.setContentEncoding("utf-8");
			// s.setContentType("application/json");
			httpPost.setEntity(s);

			HttpResponse httpResponse = httpclient.execute(httpPost);
			System.out.println("状态码是：" + httpResponse.getStatusLine().getStatusCode());
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				dataHtml = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != httpclient) {
				try {
					httpclient.close();
				} catch (Exception e) {

				}
			}

		}
		return dataHtml;
	}

}
