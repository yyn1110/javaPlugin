package project

const http_class = `
package $(package)$.utils;

import $(package)$.logger.YzLogger;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.NoHttpResponseException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;


import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by yangyanan on 2017/7/17.
 */
public class HttpClientUtil {

    private static PoolingHttpClientConnectionManager cm;
    private static String EMPTY_STR = "";
    private static String UTF_8 = "UTF-8";
    public static int MAX_RETRY_COUNT = 3;
    private static Integer default_connectTimeout = Integer.valueOf(10000);
    private static Integer default_socketTimeout = Integer.valueOf(10000);


    public HttpClientUtil() {
    }

    public static void setMaxRetryCount(int retryCount) {
        MAX_RETRY_COUNT = retryCount;
    }

    private static void init() {
        if(cm == null) {
            PlainConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
            SSLConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
            Registry registry = RegistryBuilder.create().register("http", plainsf).register("https", sslsf).build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(200);
            cm.setDefaultMaxPerRoute(20);
        }

    }

    private static CloseableHttpClient getHttpClient() {
        init();
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if(executionCount >= HttpClientUtil.MAX_RETRY_COUNT) {
                    return false;
                } else if(exception instanceof NoHttpResponseException) {
                    return true;
                } else if(exception instanceof SSLHandshakeException) {
                    return false;
                } else if(exception instanceof InterruptedIOException) {
                    return false;
                } else if(exception instanceof UnknownHostException) {
                    return false;
                } else if(exception instanceof ConnectTimeoutException) {
                    return false;
                } else if(exception instanceof SSLException) {
                    return false;
                } else {
                    HttpClientContext clientContext = HttpClientContext.adapt(context);
                    HttpRequest request = clientContext.getRequest();
                    return !(request instanceof HttpEntityEnclosingRequest);
                }
            }
        };
        return HttpClients.custom().setConnectionManager(cm).setRetryHandler(httpRequestRetryHandler).build();
    }

    public static String httpGetRequest(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        config(httpGet, default_connectTimeout, default_socketTimeout);
        return getResult(httpGet);
    }

    public static String httpGetRequest(String url, Map<String, String> params, Integer connectionTimeOut, Integer socketTimeOut) throws Exception {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        if(null != params) {
            ArrayList httpGet = covertParams2NVPS(params);
            ub.setParameters(httpGet);
        }

        HttpGet httpGet1 = new HttpGet(ub.build());
        config(httpGet1, connectionTimeOut, socketTimeOut);
        return getResult(httpGet1);
    }

    public static String httpGetRequest(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        ArrayList pairs = covertParams2NVPS(params);
        ub.setParameters(pairs);
        HttpGet httpGet = new HttpGet(ub.build());
        Iterator i$ = headers.entrySet().iterator();

        while(i$.hasNext()) {
            Entry param = (Entry)i$.next();
            httpGet.addHeader((String)param.getKey(), (String)param.getValue());
        }

        return getResult(httpGet);
    }

    public static String httpPostRequest(String url, Map<String, String> params) throws Exception {
      return httpPostRequest(url,params,default_connectTimeout,default_socketTimeout);
    }

    public static String httpPostRequest(String url, Map<String, String> params, Integer connectionTimeOut, Integer socketTimeOut) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        config(httpPost, connectionTimeOut, socketTimeOut);
        ArrayList pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        return getResult(httpPost);
    }

    public static String httpPutRequest(String url, Map<String, String> params, Integer connectionTimeOut, Integer socketTimeOut) throws Exception {
        HttpPut httpPut = new HttpPut(url);
        config(httpPut, connectionTimeOut, socketTimeOut);
        ArrayList pairs = covertParams2NVPS(params);
        httpPut.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        return getResult(httpPut);
    }

    public static String httpDeleteRequest(String url, Integer connectionTimeOut, Integer socketTimeOut) throws Exception {
        HttpDelete httpDelete = new HttpDelete(url);
        config(httpDelete, connectionTimeOut, socketTimeOut);
        return getResult(httpDelete);
    }

    public static String httpPostRequest(String url, Map<String, String> headers, Map<String, String> params) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        Iterator pairs = headers.entrySet().iterator();

        while(pairs.hasNext()) {
            Entry param = (Entry)pairs.next();
            httpPost.addHeader((String)param.getKey(), (String)param.getValue());
        }

        ArrayList pairs1 = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs1, UTF_8));
        return getResult(httpPost);
    }

    public static String executeBase(HttpRequestBase httpRequestBase) throws Exception {
        return getResult(httpRequestBase);
    }

    private static ArrayList<NameValuePair> covertParams2NVPS(Map<String, String> params) {
        ArrayList pairs = new ArrayList();
        if (params == null){
            return pairs;
        }
        Iterator i$ = params.entrySet().iterator();

        while(i$.hasNext()) {
            Entry param = (Entry)i$.next();
            pairs.add(new BasicNameValuePair((String)param.getKey(), (String)param.getValue()));
        }

        return pairs;
    }

    private static String getResult(HttpRequestBase request) throws Exception {
        CloseableHttpClient httpClient = getHttpClient();
        String result = EMPTY_STR;
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(request);
            YzLogger.info("CloseableHttpResponse proxy result 【{}】", response);
            HttpEntity e = response.getEntity();
            if(e != null) {
                result = EntityUtils.toString(e, UTF_8);
            }
        } finally {
            if(response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                } catch (IOException var10) {
                    var10.printStackTrace();
                }
            }

        }

        YzLogger.info("http request url[{}],result entity[{}]", request.getURI(), result);
        return result;
    }

    private static void config(HttpRequestBase httpRequestBase, Integer connectionTimeOut, Integer socketTimeOut) {
        if(connectionTimeOut == null) {
            connectionTimeOut = default_connectTimeout;
        }

        if(socketTimeOut == null) {
            socketTimeOut = default_socketTimeout;
        }

        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(connectionTimeOut.intValue()).setConnectTimeout(connectionTimeOut.intValue()).setSocketTimeout(socketTimeOut.intValue()).build();
        httpRequestBase.setConfig(requestConfig);
    }



}
`
