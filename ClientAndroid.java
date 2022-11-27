import com.loopj.android.http.*;
import cz.msebera.android.httpclient.Header;

public class ClientAndroid {
    private static AsyncHttpClient client = new AsyncHttpClient();
    private static String BASE_URL = "http://10.12.12.35:5231/Student";
    public static void main(String[] args)
    {
        
        client.get(BASE_URL, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                // TODO Auto-generated method stub
                System.out.println(responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // TODO Auto-generated method stub
                System.out.println(statusCode);
            }
            
        });
    }
    // public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
    //     client.get(getAbsoluteUrl(url), params, responseHandler);
    // }
  
    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }
  
    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
